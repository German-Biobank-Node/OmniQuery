/*
 * TODO: This License should be changed. 2016.
 */
package de.gbn.querytranslator.omniquery;

/**
 * The OmniQuery Exchange Format is represented by a tree structure.
 * This abstract class defines the children of the tree. They can consist of one
 * of two types: Logic or Constraint.
 * 
 * A LogicNode serves as link between the root and the leaves.
 * A ConstraintNode is a leaf of the tree.
 * 
 *       GB - o - OB  (root --> OmniQuery.class, with GroupBy (GB) and OrderBy (OB))
 *            |
 *  ==>       o       (child --> LogicNode.class)
 *          / | \
 *  ==>    o  o  o    (leaves --> ConstraintNode.class)
 * 
 * 
 * @author German Biobank Node (GBN)
 * @param <E> The enum type of the class (LogicType or ConstraintType)
 */
public abstract class AbstractNode<E extends Enum<E>> {
    
    /**
     * The unique id
     */
    private String id;
    
    /**
     * The type of the node.
     */
    private E type;
    
    /**
     * This constructor defines the exact type of a node.
     * 
     * @param e The type of the node
     */
    public AbstractNode(E e) {
        type = e;
    }
    
    /**
     * Generates a unique id based on its type.
     * 
     * @return A gnerated unique id
     */
    protected abstract String generateId();
    
    /**
     * Returns the unique id. If there is no id, it will create one.
     * 
     * @return The unique id
     */
    public String getId() {
        if(id == null || id.equals("")) {
            id = generateId();
        }
        
        return id;
    }
    
    /**
     * Returns the exact type of the node.
     * 
     * @return
     */
    public E getType() {
        return type;
    }
}
