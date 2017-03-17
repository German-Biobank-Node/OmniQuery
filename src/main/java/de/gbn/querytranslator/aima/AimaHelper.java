/*
 * TODO: This License should be changed. 2016.
 */
package de.gbn.querytranslator.aima;

import aima.core.logic.propositional.parsing.ast.ComplexSentence;
import aima.core.logic.propositional.parsing.ast.Connective;
import aima.core.logic.propositional.parsing.ast.PropositionSymbol;
import aima.core.logic.propositional.parsing.ast.Sentence;
import aima.core.logic.propositional.visitors.ConvertToCNF;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Contains helper methods to work with the aima library.
 * 
 * @author German Biobank Node (GBN)
 */
public class AimaHelper {
    
    /**
     * Generates recursively a complex sentence by using a relation mapping
     * and the current used key.
     * 
     * @param relations The relation mapping
     * @param currentKey The current key of the mapping
     * @return The final sentence
     */
    public static Sentence createSentence(Map relations, String currentKey) {          
        // Check the values of the associated key
        String[] values = (String[]) relations.get(currentKey);
        
        // If the starting key is a constraint
        if(currentKey.toLowerCase().startsWith("constraint")) {
            return new PropositionSymbolWithID(PropositionSymbol.TRUE_SYMBOL, currentKey);
        }
        // If there is only 1 children we do not need to continue the whole method
        else if(values.length == 1) {
            if(values[0].toLowerCase().startsWith("and") || values[0].toLowerCase().startsWith("or")) {
                return createSentence(relations, values[0]);
            }
            
            return new PropositionSymbolWithID(PropositionSymbol.TRUE_SYMBOL, values[0]);
        } 
        
        Queue<Sentence> sentence = new LinkedList<>();
        
        for(String value : values) {
            // If it is a constraint, add it to the sentence list
            if(value.toLowerCase().startsWith("constraint")) {
                sentence.add(new PropositionSymbolWithID(PropositionSymbol.TRUE_SYMBOL, value));
            }
            // If it is a logical type, resolve the underlying sentences first
            else {
                String nextKey = value;
                
                // Recursive iteration
                sentence.add(createSentence(relations, nextKey));
            }
        }
        
        // Set the connective
        Connective connective;
        
        if(currentKey.toLowerCase().startsWith("and")) {
            connective = Connective.AND;
        }
        else {
            connective = Connective.OR;
        }
        
        // Only 2 sentences at one time
        boolean wasBiggerThan2 = sentence.size() > 2;
        
        while(sentence.size() > 2) {
            Sentence A = sentence.poll();
            Sentence B = sentence.poll();
            
            sentence.add(new ComplexSentence(A, connective, B));
        }
        
        // Preserve the order
        if(wasBiggerThan2) {
            sentence.add(sentence.poll());
        }
        
        // Prepare the creation of a new sentence
        Sentence[] sentenceArray = new Sentence[sentence.size()];
        sentenceArray = sentence.toArray(sentenceArray);
                
        // Create the new sentece
        return new ComplexSentence(connective, sentenceArray);
    }
    
    /**
     * Converts a relational mapping into conjunctive normal form (CNF).
     * 
     * @param relations The relational mapping
     * @param startKey The key to be started with
     * @return The conjunctive normal form as string
     */
    public static String convertToCNF(Map relations, String startKey) {
        Sentence sentence = createSentence(relations, startKey);
        
        return ConvertToCNF.convert(sentence).toString();
    }
}
