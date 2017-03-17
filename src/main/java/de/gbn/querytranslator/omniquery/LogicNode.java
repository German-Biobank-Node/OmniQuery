/*
 * TODO: This License should be changed. 2016.
 */
package de.gbn.querytranslator.omniquery;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The OmniQuery Exchange Format is represented by a tree structure.
 * This class defines the logic type (And or Or) of the query part and contains at least
 * one more child. So it serves essentially as a link between the root node and
 * the leaves with information about their relation.
 * 
 *       GB - o - OB  (root --> OmniQuery.class, with GroupBy (GB) and OrderBy (OB))
 *            |
 *  ==>       o       (child --> LogicNode.class)
 *          / | \
 *         o  o  o    (leaves --> ConstraintNode.class)
 * 
 * 
 * 
 * @author German Biobank Node (GBN)
 */
public class LogicNode extends AbstractNode<LogicType> {
    
    /**
     * This list contains the children of this node.
     */
    List<AbstractNode> nodes;
     
    /**
     * Initializes the LogicType (And or Or) and the children list of this node.
     * 
     * @param type The logic type of this node
     */
    public LogicNode(LogicType type) {
        super(type);
        
        nodes = new ArrayList();
    }
    
    /**
     * Generates an id using the pattern: "(And|Or):*UUID*"
     * 
     * @return The new id
     */
    @Override
    protected String generateId() {
        String newId = "";
        
        switch(getType()) {
            case And:
                newId += "And:"; break;
            case Or:
                newId += "Or:"; break;
        }
        
        return newId + UUID.randomUUID().toString();
    }

    /**
     * Returns the list of children of this node
     * 
     * @return The list of children
     */
    public List<AbstractNode> getNodes() {
        return nodes;
    }
    
    /**
     * Adds a child to the list of children.
     * 
     * @param node The new child
     */
    public void addNode(AbstractNode node) {
        nodes.add(node);
    }
    
}
