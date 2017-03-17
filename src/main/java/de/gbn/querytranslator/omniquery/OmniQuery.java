/*
 * TODO: This License should be changed. 2016.
 */
package de.gbn.querytranslator.omniquery;

import de.gbn.querytranslator.aima.AimaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * The OmniQuery Exchange Format is represented by a tree structure.
 * This class represents the root of the tree which contains informations
 * about the ordering as well as the grouping parameter.
 * The root must have a child node.
 * 
 *  ==>  GB - o - OB  (root --> OmniQuery.class, with GroupBy (GB) and OrderBy (OB))
 *            |
 *            o       (child --> LogicNode.class)
 *          / | \
 *         o  o  o    (leaves --> ConstraintNode.class)
 * 
 * 
 * @author German Biobank Node (GBN)
 */
public class OmniQuery {
    
    /**
     * The (first) child of the tree.
     */
    AbstractNode node;
    
    /**
     * List of encoded keys regarding the ordering of the query result.
     * Example of an encoded key: "A|urn:dktk:dataelement:10:3"
     */
    List<String> orderBy;
    
    /**
     * The grouping key for the query result.
     */
    String groupBy;
    
    /**
     * A "look up table" for the relations of all nodes
     */
    Map<String, String[]> relations;
     
    /**
     * The constructor instantiates the order-by list and the group-by string
     */
    public OmniQuery() { 
        this.orderBy = new ArrayList();
        this.groupBy = "";
    }
        
    /**
     * A constructor for instantiating the order-by list and setting
     * the group-by-string.
     * 
     * @param groupBy The key for grouping the query results.
     */
    public OmniQuery(String groupBy) {
        this.orderBy = new ArrayList();
        this.groupBy = groupBy;
    }
        
    /**
     * A constructor for instantiating the order-by list and the group-by string
     * as well as defining the child of the root node.
     * 
     * @param node The child of the root node.
     */
    public OmniQuery(AbstractNode node) { 
        this.node = node;
        
        this.orderBy = new ArrayList();
        this.groupBy = "";
    }

    /**
     * Returns the child of the root node as AbstractNode.
     * 
     * @return The child node.
     */
    public AbstractNode getNode() {
        return node;
    }

    /**
     * Sets the child of the root node.
     * 
     * @param node The new child node.
     */
    public void setNode(AbstractNode node) {
        this.node = node;
    }

    /**
     * This adds a new order to the list of order-by.
     * The order must be encoded by the type of ordering (Ascending, Descending)
     * and the key.
     * 
     * Example for ascending: "A|urn:dktk:dataelement:10:3"
     * Example for descending: "D|urn:dktk:dataelement:7:1"
     * 
     * @param order The encoded order string
     */
    public void addOrder(String order) {
        if(orderBy != null) {
            orderBy.add(order);
        }
    }
    
    /**
     * Adds an order by the given params. 
     *
     * @param isAscending Is the order ascending (true, false)
     * @param key The order key
     */
    public void addOrder(boolean isAscending, String key) {
        String orderString = "";
        
        // Create the encoded string by order type
        if(isAscending) {
            orderString += "A|";
        }
        else {
            orderString += "D|";
        }
        
        orderString += key;
        
        // Add to order-by list
        if(orderBy != null) {
            orderBy.add(orderString);
        }
    }
    
    /**
     * Returns a specific order from the order-by list.
     * The returned order is an encoded string.
     * 
     * Example: "D|urn:dktk:dataelement:7:1"
     * 
     * @param index The index of the order
     * @return The specific order or null if index is out of bounds.
     */
    public String getOrder(int index) {
        
        if(index >= orderBy.size())
            return null;
        
        return orderBy.get(index);
    }
    
    /**
     * Returns the key of a specific order in the encoded string format.
     * 
     * 
     * @param index The index of the order
     * @return The key of the specific order or null if index is out of bounds.
     */
    public String getOrderKey(int index) {
        
        if(index < orderBy.size()) {
            String fullOrder = orderBy.get(index);
            String[] splittedOrder = fullOrder.split("\\|");

            if(splittedOrder.length > 1) {
                return splittedOrder[1];
            }
        }
                
        return null;
    }
    
    /**
     * Returns whether the specific order is ascending or not.
     * 
     * @param index The index of the order
     * @return true if the specific order is ascending, false if not.
     */
    public boolean isOrderAscending(int index) {
        String fullOrder = orderBy.get(index);
        String[] splittedOrder = fullOrder.split("\\|");
        
        return splittedOrder[0].equals("A");
    }

    /**
     * Returns whether the specific order is descending or not.
     * 
     * @param index The index of the order
     * @return true if the specific order is descending, false if not.
     */
    public boolean isOrderDescending(int index) {
        String fullOrder = orderBy.get(index);
        String[] splittedOrder = fullOrder.split("\\|");
        
        return splittedOrder[0].equals("D");
    }
    
    /**
     * Returns the order-by list.
     * 
     * @return The order-by list
     */
    public List<String> getOrderBy() {
        return orderBy;
    }

    /**
     * Replaces the order-by list by a new list.
     * 
     * @param orderBy The new list
     */
    public void setOrderBy(List<String> orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * Returns the string for grouping the query result.
     * 
     * @return The group-by string
     */
    public String getGroupBy() {
        return groupBy;
    }

    /**
     * Sets the group-by string.
     * 
     * @param groupBy The new group-by string.
     */
    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }
    
    /**
     * Returns the relations of the nodes as a look up table.
     * If the map containing the relations is empty, it will create a new one.
     * 
     * @return The look up table of the realtions
     */
    public Map<String, String[]> getRelations() {
        // Create a new HashMap if there does not exist one
        if(relations == null)
            relations = new HashMap<>();
        
        // If the relations map is empty, fill it
        if(relations.isEmpty()) {
            // Create a stack for visiting the nodes and add the first child node
            Stack<AbstractNode> nodes = new Stack<>();
            nodes.add(node);
            
            do {
                // Get the first node from stack
                AbstractNode currentNode = nodes.pop();
                
                // If it is a logical node, save all the ids from its children
                if(currentNode.getClass() == LogicNode.class) {
                    LogicNode currentLogicNode = (LogicNode) currentNode;
                    List<String> childNodesIds = new ArrayList<>();
                    
                    // Get the ids from the children and add them to the stack
                    for(AbstractNode childNode : currentLogicNode.getNodes()) {
                        childNodesIds.add(childNode.getId());
                        
                        nodes.add(childNode);
                    }
                    
                    // Add the relations to the map
                    String[] finalChildNodesIds = new String[childNodesIds.size()];
                    finalChildNodesIds = childNodesIds.toArray(finalChildNodesIds);
                    relations.put(currentNode.getId(), finalChildNodesIds);
                }
                // else: Save the data from the constraint nodes into the look up table
                else {
                    ConstraintNode currentConstraintNode = (ConstraintNode) currentNode;
                    List<String> nodeData = new ArrayList<>();
                    
                    // First add the key
                    nodeData.add(currentConstraintNode.getKey());
                    
                    // Now every value
                    for(String data : currentConstraintNode.getValues()) {
                        nodeData.add(data);
                    }
                    
                    // Add it to the map
                    String[] finalNodeData = new String[nodeData.size()];
                    finalNodeData = nodeData.toArray(finalNodeData);
                    relations.put(currentConstraintNode.getId(), finalNodeData);
                }
                
            } while(!nodes.isEmpty());
        }
        
        return relations;
    }
    
    /**
     * Converts the OmniQuery into conjunctive normal form (CNF).
     * 
     * @return The OmniQuery in conjunctive normal form
     */
    public OmniQuery convertToCNF() {
        // Create the cnf schema built out of ids
        // The pattern looks like: "(c:like:1 | c:eq:2) & (c:neq:3 | c:isnull:4)"
        String cnf = AimaHelper.convertToCNF(getRelations(), node.getId());
        
        // The result will be a new OmniQuery
        OmniQuery cnfQuery = new OmniQuery();
        
        // Copy order by
        if(getOrderBy() != null) {
            cnfQuery.setOrderBy(getOrderBy());
        }
        
        // Copy group by
        if(getGroupBy() != null || !getGroupBy().equals("")) {
            cnfQuery.setGroupBy(getGroupBy());
        }
        
        // Create the "root and"
        LogicNode andNode = new LogicNode(LogicType.And);
        cnfQuery.node = andNode;
        
        // Split the string using the &-delimiter
        String[] andElements = cnf.split("&");
        
        // Handle the and's subelements
        for(String andElement : andElements) {
            String[] orElements = andElement.split("\\|");
            
            // If there are or-combined elements
            if(orElements.length > 0) {
                LogicNode orNode = new LogicNode(LogicType.Or);
                andNode.addNode(orNode);
                
                for(String orElement : orElements) {
                    ConstraintNode constraint = createConstraintNodeFromId(orElement);
                    
                    orNode.addNode(constraint);
                }
            }
            else {
                ConstraintNode constraint = createConstraintNodeFromId(orElements[0]);
                
                andNode.addNode(constraint);
            }
        }
        
        
        return cnfQuery;
    }
    
    /**
     * Creates a ConstraintNode from a given id.
     * 
     * @param id The given id
     * @return A new ConstraintNode containing all data
     */
    private ConstraintNode createConstraintNodeFromId(String id) {
        // Clean up the id
        id = normalizeId(id);
        
        // The second part from the id is the type
        // e.q. "Constraint:Like:*UUID* -> Like
        String type = id.split(":")[1].toLowerCase();
        
        // The result
        ConstraintNode constraint;
               
        // Create the correct constraint
        switch(type) {
            case "equals":
                constraint = new ConstraintNode(ConstraintType.Equals); break;
            case "notequals":
                constraint = new ConstraintNode(ConstraintType.NotEquals); break;
            case "greater":
                constraint = new ConstraintNode(ConstraintType.Greater); break;
            case "greaterequals":
                constraint = new ConstraintNode(ConstraintType.GreaterEquals); break;
            case "less":
                constraint = new ConstraintNode(ConstraintType.Less); break;
            case "lessequals":
                constraint = new ConstraintNode(ConstraintType.LessEquals); break;
            case "isnull":
                constraint = new ConstraintNode(ConstraintType.IsNull); break;
            case "isnotnull":
                constraint = new ConstraintNode(ConstraintType.IsNotNull); break;
            case "in":
                constraint = new ConstraintNode(ConstraintType.In); break;
            case "between":
                constraint = new ConstraintNode(ConstraintType.Between); break;
            case "like":
                constraint = new ConstraintNode(ConstraintType.Like); break;
            default:
                constraint = new ConstraintNode(ConstraintType.IsNotNull); // TODO: Error handling
        }

        // Fill the key and values
        String[] data = getRelations().get(id);
        
        // Set key
        constraint.setKey(data[0]);
        
        // Set values if existent
        for(int i = 1; i < data.length; ++i) {
            constraint.addValue(data[i]);
        }
        
        return constraint;
    }
    
    /**
     * Normalizes the id by removing braces and trimming the string
     * 
     * @param id The id to be normalized
     * @return The normalized id
     */
    private String normalizeId(String id) {
        if(id.contains("(")) {
            id = id.replace('(', ' ');
        }
        else if(id.contains(")")) {
            id = id.replace(')', ' ');
        }
        
        return id.trim();
    }
}
