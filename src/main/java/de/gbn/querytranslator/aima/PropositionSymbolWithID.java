/*
 * TODO: This License should be changed. 2016.
 */
package de.gbn.querytranslator.aima;

import aima.core.logic.propositional.parsing.ast.PropositionSymbol;

/**
 * An extension to aima's PropositionSymbol containing an id and a better
 * string representation of the object.
 * 
 * @author German Biobank Node (GBN)
 */
public class PropositionSymbolWithID extends PropositionSymbol {
    
    /**
     * The id of the proposition
     */
    String id;
    
    /**
     * Takes an additional id.
     * 
     * @param symbol The symbol of the proposition
     * @param id The id of the proposition
     */
    public PropositionSymbolWithID(String symbol, String id) {
        super(symbol);
        
        this.id = id;
    }
    
    /**
     * A improved string representation of the proposition object.
     * 
     * @return The object as string
     */
    @Override
    public String toString() {
        if(getSymbol().equals(PropositionSymbol.FALSE_SYMBOL))
            return "~"+id;
        
        return id;
    }
    
}
