/*
 * TODO: This License should be changed. 2016.
 */
package de.gbn.querytranslator.omniquery;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The OmniQuery Exchange Format is represented by a tree structure.
 * This class defines the constraints of the query and can have be one of various
 * available types.
 * 
 * A constraint consists at least of a key and can have optionally one or more values,
 * depending of its type.
 * 
 *       GB - o - OB  (root --> OmniQuery.class, with GroupBy (GB) and OrderBy (OB))
 *            |
 *            o       (child --> LogicNode.class)
 *          / | \
 *  ==>    o  o  o    (leaves --> ConstraintNode.class)
 * 
 * 
 * 
 * @author German Biobank Node (GBN)
 */
public class ConstraintNode extends AbstractNode<ConstraintType> {
    
    /**
     * The key of the constraint.
     */
    String key;
    
    /**
     * The list of values.
     * Singlevalue: Equals, NotEquals, Greater, GreaterEquals, Less, LessEquals, Like
     * Multivalues: In, Between
     * Not used for: IsNull, IsNotNull
     */
    List<String> values;

    /**
     * Initializes the type of this node and the list of values.
     * 
     * @param type The type of this node
     */
    public ConstraintNode(ConstraintType type) {
        super(type);
        
        this.values = new ArrayList();
    }
    
    /**
     * Initializes the type of this node, the key and the list of values.
     * 
     * @param type The type of this node
     * @param key The key
     */
    public ConstraintNode(ConstraintType type, String key) {
        super(type);
        
        this.key = key;
        this.values = new ArrayList();
    }
    
    /**
     * Initializes the type of this node, the key and the list of values including an initial value.
     * 
     * @param type The type of this node
     * @param key The key
     * @param value The initial value
     */
    public ConstraintNode(ConstraintType type, String key, String value) {
        super(type);
        
        this.key = key;
        this.values = new ArrayList();
        this.values.add(value);
    }
    
    /**
     * Initializes the type of this node, the key and a specific list of values.
     * 
     * @param type The type of this node
     * @param key The key
     * @param values A list of predefined values
     */
    public ConstraintNode(ConstraintType type, String key, List<String> values) {
        super(type);
        
        this.key = key;
        this.values = values;
    }
    
    /**
     * Genrerates an id using the pattern: "Constraint:*TYPE*:*UUID*".
     * 
     * @return The unique id
     */
    @Override
    protected String generateId() {
        String newId = "Constraint:";
        
        switch(getType()) {
            case Equals:
                newId += "Equals:"; break;
            case NotEquals:
                newId += "NotEquals:"; break;
            case Greater:
                newId += "Greater:"; break;
            case GreaterEquals:
                newId += "GreaterEquals:"; break;
            case Less:
                newId += "Less:"; break;
            case LessEquals:
                newId += "LessEquals:"; break;
            case IsNull:
                newId += "IsNull:"; break;
            case IsNotNull:
                newId += "IsNotNull:"; break;
            case In:
                newId += "In:"; break;
            case Between:
                newId += "Between:"; break;
            case Like:
                newId += "Like:"; break;
            default:
                newId += "UNKNOWN:"; break;
        }
        
        return newId + UUID.randomUUID().toString();
    }
 
    /**
     * Returns the key of this node.
     * 
     * @return The key
     */
    public String getKey() {
        return key;
    }
    
    /**
     * Sets the key of this node.
     * 
     * @param key The new key
     */
    public void setKey(String key) {
        this.key = key;
    }
    
    /**
     * Returns the first value. Suitable for singlevalues.
     * Singlevalue: Equals, NotEquals, Greater, GreaterEquals, Less, LessEquals, Like
     * 
     * @return The first value of the list
     */
    public String getValue() {
        if(values != null && values.size() > 0 && !isMultivalue()) {
            return values.get(0);
        }
        
        return null;
    }
    
    /**
     * Adds a value to the list of values.
     * 
     * @param value The new value to be added
     * @return true if value could be added, false if not
     */
    public boolean addValue(String value) {
        if(values != null) {
            values.add(value);
            return true;
        }
        
        return false;
    }

    /**
     * Returns the list of values.
     * 
     * @return The list of values
     */
    public List<String> getValues() {
        return values;
    }

    /**
     * Replaces the list of values.
     * 
     * @param values The new list of values
     */
    public void setValues(List<String> values) {
        this.values = values;
    }
    
    /**
     * Returns the first value as a lower bound. Suitable for range values.
     * Rangevalues (Multivalues): Between
     * 
     * @return The first value of the values list
     */
    public String getLowerBound() {
        if(isMultivalue())
            return values.get(0);
        
        return null;
    }
    
    /**
     * Returns the second value as a upper bound. Suitable for range values.
     * Rangevalues (Multivalues): Between
     * 
     * @return The second value of the values list
     */
    public String getUpperBound() {
        if(isMultivalue())
            return values.get(1);
        
        return null;
    }

    /**
     * Returns whether the constraint is a multivalue constraint or not.
     * 
     * @return true if the constraint is multivalue, false if not.
     */
    public boolean isMultivalue() {
        return values.size() > 1;
    }
  
}