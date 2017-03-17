/*
 * TODO: This License should be changed. 2016.
 */
package de.gbn.querytranslator;

import de.gbn.querytranslator.omniquery.AbstractNode;
import de.gbn.querytranslator.omniquery.ConstraintNode;
import de.gbn.querytranslator.omniquery.ConstraintType;
import de.gbn.querytranslator.omniquery.LogicNode;
import de.gbn.querytranslator.omniquery.LogicType;
import de.gbn.querytranslator.omniquery.OmniQuery;
import de.samply.share.model.osse.And;
import de.samply.share.model.osse.Attribute;
import de.samply.share.model.osse.Between;
import de.samply.share.model.osse.ConditionType;
import de.samply.share.model.osse.Eq;
import de.samply.share.model.osse.Geq;
import de.samply.share.model.osse.GroupBy;
import de.samply.share.model.osse.Gt;
import de.samply.share.model.osse.In;
import de.samply.share.model.osse.IsNotNull;
import de.samply.share.model.osse.IsNull;
import de.samply.share.model.osse.Leq;
import de.samply.share.model.osse.Like;
import de.samply.share.model.osse.Lt;
import de.samply.share.model.osse.MultivalueAttribute;
import de.samply.share.model.osse.Neq;
import de.samply.share.model.osse.Or;
import de.samply.share.model.osse.Order;
import de.samply.share.model.osse.OrderBy;
import de.samply.share.model.osse.Query;
import de.samply.share.model.osse.RangeAttribute;
import de.samply.share.model.osse.Where;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

/**
 * Translator for translating DKTK queries into OmniQuery and vice versa.
 * @author German Biobank Node (GBN)
 * @param <T> The targeted translator
 */
public class DKTKTranslator<T extends IQueryTranslator>
        extends AbstractTranslator<T> {
    
    static String VALUE_NAMESPACE_URI = "http://schema.samply.de/osse/Value";
    static String VALUE_LOCAL_NAME = "Value";
    
    /**
     * Empty constructor
     */
    public DKTKTranslator() {
    }
    
    /**
     * Defines the targeted translator
     * 
     * @param targetTranslator
     */
    public DKTKTranslator(Class<T> targetTranslator) {
        this.targetTranslator = targetTranslator;
    }
    
    /**
     * Translates a given Xml into the OmniQuery transmission format.
     * 
     * This is achieved by following the following steps:
     *   1. Convert the Xml string into java instances of the DKTK Xsd
     *   2. Convert every element into a OmniQuery equivalent (using Breadth-First-Search)
     *     2.1 Extract the "Order By" informations into the OmniQuery
     *     2.2 Extract the "Group By" informations into the OmniQuery
     *     2.3 Select every element and convert it into OmniQuery until there is no node left
     *        2.3.1 If the DKTK element is a logic element, create a logic node
     *        2.3.2 If the DKTK element is a constraint element, create a logic node
     * 
     * @param xml The given Xml as string
     * @return The translated OmniQuery
     */
    @Override
    public OmniQuery translateXmlToOmni(String xml) {
       
        OmniQuery result = new OmniQuery();
        
        try {
            // Step 1 -- Convert Xml to java objects
            // Read Xml and convert to Object
            JAXBContext context = JAXBContext.newInstance(Query.class); // TODO: Handle also Views
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            StringReader reader = new StringReader(xml);
            Query dktkQuery = (Query) unmarshaller.unmarshal(reader);
            
            // Step 2 -- Visit every DKTK element
            // Translate to Omni via BFS
            Queue<Serializable> queueDKTK = new LinkedList();
            Queue<AbstractNode> queueOmni = new LinkedList();

            // Step 2.1 -- Extract the "Order By" informations
            // Order by
            if(dktkQuery.getOrderBy() != null) {
                for(Order order : dktkQuery.getOrderBy().getOrder()) {                    
                    result.addOrder(order.isAscending(), order.getMdrKey());
                }
            }
            
            // Step 2.2 -- Extract the "Group By" informations
            // Group By
            if(dktkQuery.getGroupBy() != null) {
                result.setGroupBy(dktkQuery.getGroupBy().getMdrKey());
            }
            
            // Step 2.3 -- Select every element and convert it into OmniQuery
            // Where
            for(Serializable node : dktkQuery.getWhere().getAndOrEqOrLike()) {
                // Add the node to Queue
                queueDKTK.add(node);
                
                // Add the equivalent Node to OmniQuery
                AbstractNode equivalent = createEquivalentOmniNode(node);
                
                // Start Node
                result.setNode(equivalent);
                queueOmni.add(equivalent);
            }
                        
            // Execute Breadth First "Search" (BFS) on the xml graph
            do {
                                
                // Step 2.3.1 -- Check if it is a logic node
                // There are 2 ways to be handled. If the current node is a logic type or a constraint.
                // Is it a logic node?
                if(queueDKTK.peek().getClass() == And.class || queueDKTK.peek().getClass() == Or.class) {
                    // Poll
                    ConditionType currentDKTKNode = (ConditionType) queueDKTK.poll();
                    LogicNode currentOmniNode = (LogicNode) queueOmni.poll();
                            
                    // Now expand the current Node
                    for(Serializable node : currentDKTKNode.getAndOrEqOrLike()) {
                        // Add the child to queue
                        queueDKTK.add(node);
                        
                        // Add the equivalent Node to OmniQuery and add to queue
                        AbstractNode equivalent = createEquivalentOmniNode(node);
                        queueOmni.add(equivalent);
                        
                        // Recast the current Omni Node and add the child                        
                        if (currentOmniNode != null) {
                            currentOmniNode.getNodes().add(equivalent);
                        }     
                    }
                }
                // Step 2.3.2 -- Check if it is a constraint node
                // Handle it as constraint else
                else {
                    // Remove nodes from queues
                    Serializable currentDKTKNode = queueDKTK.poll();   
                    ConstraintNode currentOmniNode = (ConstraintNode) queueOmni.poll();
                    
                    // Create the constraint node depending on the DKTK element type
                    switch(currentOmniNode.getType()) {
                        case Like:
                            Like likeDKTK = (Like) currentDKTKNode;
                            defineNode(currentOmniNode, likeDKTK.getAttribute().getMdrKey(), likeDKTK.getAttribute().getValue().getValue()); break;
                        case Equals:
                            Eq eqDKTK = (Eq) currentDKTKNode;
                            defineNode(currentOmniNode, eqDKTK.getAttribute().getMdrKey(), eqDKTK.getAttribute().getValue().getValue()); break;                           
                        case NotEquals:
                            Neq neqDKTK = (Neq) currentDKTKNode;
                            defineNode(currentOmniNode, neqDKTK.getAttribute().getMdrKey(), neqDKTK.getAttribute().getValue().getValue()); break;
                        case Greater:
                            Gt gtDKTK = (Gt) currentDKTKNode;
                            defineNode(currentOmniNode, gtDKTK.getAttribute().getMdrKey(), gtDKTK.getAttribute().getValue().getValue()); break;
                        case GreaterEquals:
                            Geq geqDKTK = (Geq) currentDKTKNode;
                            defineNode(currentOmniNode, geqDKTK.getAttribute().getMdrKey(), geqDKTK.getAttribute().getValue().getValue()); break;
                        case Less:
                            Lt ltDKTK = (Lt) currentDKTKNode;
                            defineNode(currentOmniNode, ltDKTK.getAttribute().getMdrKey(), ltDKTK.getAttribute().getValue().getValue()); break;
                        case LessEquals:
                            Leq leqDKTK = (Leq) currentDKTKNode;
                            defineNode(currentOmniNode, leqDKTK.getAttribute().getMdrKey(), leqDKTK.getAttribute().getValue().getValue()); break;
                        case IsNull:
                            IsNull isNullDKTK = (IsNull) currentDKTKNode;
                            defineNode(currentOmniNode, isNullDKTK.getMdrKey()); break;
                        case IsNotNull:
                            IsNotNull isNotNullDKTK = (IsNotNull) currentDKTKNode;
                            defineNode(currentOmniNode, isNotNullDKTK.getMdrKey()); break;
                        case Between:
                            Between betweenDKTK = (Between) currentDKTKNode;
                            List<String> betweenValuesList = new ArrayList();
                            betweenValuesList.add(betweenDKTK.getRangeAttribute().getLowerBound());
                            betweenValuesList.add(betweenDKTK.getRangeAttribute().getUpperBound());
                            defineMultivalueNode(currentOmniNode, betweenDKTK.getRangeAttribute().getMdrKey(), betweenValuesList); break;
                        case In:
                            In inDKTK = (In) currentDKTKNode;
                            List<String> inValuesList = new ArrayList();
                            for(JAXBElement<String> element : inDKTK.getMultivalueAttribute().getValue()) {
                                inValuesList.add(element.getValue());
                            }
                            defineMultivalueNode(currentOmniNode, inDKTK.getMultivalueAttribute().getMdrKey(), inValuesList); break;
                            
                    }
                   
                }
 
            } while(!queueDKTK.isEmpty());
        }
        catch(Exception ex) {
            ex.printStackTrace(); // TODO
        }
        
        
        return result;
    }
    
    /**
     * Translates a given OmniQuery into DKTK query format.
     * 
     * Works equivalent to {@link #translateXmlToOmni(java.lang.String)}.
     * 
     * @param omniQuery The given OmniQuery
     * @return The translated Xml as string
     * @see #translateXmlToOmni(java.lang.String) 
     */
    @Override
    public String translateOmniToXml(OmniQuery omniQuery) {
        StringWriter result = new StringWriter();
        
        try {
            // Prepare Query
            Query dktkQuery = new Query();
            
            // OrderBy
            if(!omniQuery.getOrderBy().isEmpty()) {
                OrderBy dktkOrderBy = new OrderBy();
                
                for(int i = 0; i < omniQuery.getOrderBy().size(); ++i) {
                    Order dktkOrder = new Order();
                    
                    dktkOrder.setAscending(omniQuery.isOrderAscending(i));
                    dktkOrder.setMdrKey(omniQuery.getOrderKey(i));
                    
                    dktkOrderBy.getOrder().add(dktkOrder);
                }
                
                dktkQuery.setOrderBy(dktkOrderBy);
            } 
            
            // GroupBy
            if(omniQuery.getGroupBy() != null && !omniQuery.getGroupBy().equals("")) {
                GroupBy dktkGroupBy = new GroupBy();
                
                dktkGroupBy.setMdrKey(omniQuery.getGroupBy());
                
                dktkQuery.setGroupBy(dktkGroupBy);
            }
            
            // Start query with where
            Where where = new Where();
            dktkQuery.setWhere(where);
            
            // Begin Queues
            Queue<AbstractNode> omniQueue = new LinkedList();
            Queue<Serializable> dktkQueue = new LinkedList();
            
            // Create the first equivalent and add to DKTK Query
            Serializable equivalent = createEquivalentXmlNode(omniQuery.getNode());
            where.getAndOrEqOrLike().add(equivalent);
            
            // Add to queues
            omniQueue.add(omniQuery.getNode());
            dktkQueue.add(equivalent);
            
            do {
                if(omniQueue.peek().getClass() == LogicNode.class) {
                    LogicNode currentOmni = (LogicNode) omniQueue.poll();
                    ConditionType currentDktk = (ConditionType) dktkQueue.poll();
                    
                    // Iterate over all children
                    for(AbstractNode node : currentOmni.getNodes()) {
                        // Add child to queue
                        omniQueue.add(node);
                        
                        // Find DKTK equivalent
                        Serializable dktkElement = createEquivalentXmlNode(node);
                        dktkQueue.add(dktkElement);
                        
                        // Add to current DKTK node
                        if(currentDktk.getAndOrEqOrLike() != null) {
                            currentDktk.getAndOrEqOrLike().add(dktkElement);
                        }
                    }
                }
                else {
                    ConstraintNode currentOmni = (ConstraintNode) omniQueue.poll();
                    Serializable currentDktk = dktkQueue.poll();
                    
                    switch(currentOmni.getType()) {
                        case Equals:
                            Eq eq = (Eq) currentDktk;
                            eq.setAttribute(defineAttribute(currentOmni)); break;
                        case NotEquals:
                            Neq neq = (Neq) currentDktk;
                            neq.setAttribute(defineAttribute(currentOmni)); break;
                        case Greater:
                            Gt gt = (Gt) currentDktk;   
                            gt.setAttribute(defineAttribute(currentOmni)); break;
                        case GreaterEquals:
                            Geq geq = (Geq) currentDktk;
                            geq.setAttribute(defineAttribute(currentOmni)); break;
                        case Less:
                            Lt lt = (Lt) currentDktk;
                            lt.setAttribute(defineAttribute(currentOmni)); break;
                        case LessEquals:
                            Leq leq = (Leq) currentDktk;
                            leq.setAttribute(defineAttribute(currentOmni)); break;
                        case IsNull:
                            IsNull isNull = (IsNull) currentDktk;
                            isNull.setMdrKey(currentOmni.getKey()); break;
                        case IsNotNull:
                            IsNotNull isNotNull = (IsNotNull) currentDktk;
                            isNotNull.setMdrKey(currentOmni.getKey()); break;
                        case In:
                            In in = (In) currentDktk;
                            in.setMultivalueAttribute(defineMultivalueAttribute(currentOmni)); break;
                        case Between:
                            Between between = (Between) currentDktk;
                            between.setRangeAttribute(defineRangeAttribute(currentOmni)); break;
                        case Like:
                            Like like = (Like) currentDktk;
                            like.setAttribute(defineAttribute(currentOmni)); break;
                    }
                }
                
            } while(!omniQueue.isEmpty());
            
            // Convert to String
            JAXBContext context = JAXBContext.newInstance(Query.class);
            Marshaller marshaller = context.createMarshaller();
            //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(dktkQuery, result);
        }
        catch(Exception ex) {
            ex.printStackTrace(); // TODO
        }
        
        return result.toString();
    }
    
    /**
     * Creates an equivalent OmniQuery node to a given DKTK query object.
     * 
     * @param obj The given DKTK query object (e.g. instance of and, or, equals, ...)
     * @return The equivalent OmniQuery node
     */
    public AbstractNode createEquivalentOmniNode(Object obj) {
        if(obj.getClass() == And.class)
            return new LogicNode(LogicType.And);
        else if(obj.getClass() == Or.class)
            return new LogicNode(LogicType.Or);
        else if(obj.getClass() == Like.class)
            return new ConstraintNode(ConstraintType.Like);
        else if(obj.getClass() == Eq.class)
            return new ConstraintNode(ConstraintType.Equals);
        else if(obj.getClass() == Neq.class)
            return new ConstraintNode(ConstraintType.NotEquals);
        else if(obj.getClass() == Gt.class)
            return new ConstraintNode(ConstraintType.Greater);
        else if(obj.getClass() == Geq.class)
            return new ConstraintNode(ConstraintType.GreaterEquals);
        else if(obj.getClass() == Lt.class)
            return new ConstraintNode(ConstraintType.Less);
        else if(obj.getClass() == Leq.class)
            return new ConstraintNode(ConstraintType.LessEquals);
        else if(obj.getClass() == IsNull.class)
            return new ConstraintNode(ConstraintType.IsNull);
        else if(obj.getClass() == IsNotNull.class)
            return new ConstraintNode(ConstraintType.IsNotNull);
        else if(obj.getClass() == In.class)
            return new ConstraintNode(ConstraintType.In);
        else if(obj.getClass() == Between.class)
            return new ConstraintNode(ConstraintType.Between);
        
        return null;
    }
    
    /**
     * Creates an equivalent DKTK query object from a given OmniQuery node
     * 
     * @param node The given OmniQuery node
     * @return The equivalent DKTK query object
     */
    public Serializable createEquivalentXmlNode(AbstractNode node) {
        
        // If the node is a logic node
        if(node.getClass() == LogicNode.class) {
            LogicNode logicNode = (LogicNode) node;
            
            switch(logicNode.getType()) {
                case And:
                    return new And();
                case Or:
                    return new Or();
            }
        }
        // else: (Constraint Node)
        else {
            ConstraintNode constraintNode = (ConstraintNode) node;
            
            switch(constraintNode.getType()) {
                case Equals:
                    return new Eq();
                case NotEquals:
                    return new Neq();
                case Greater:
                    return new Gt();
                case GreaterEquals:
                    return new Geq();
                case Less:
                    return new Lt();
                case LessEquals:
                    return new Leq();
                case IsNull:
                    return new IsNull();
                case IsNotNull:
                    return new IsNotNull();
                case In:
                    return new In();
                case Between:
                    return new Between();
                case Like:
                    return new Like();
            }
        }
        
        
        return null;
    }
    
    /**
     * Defines the key of a given node.
     * 
     * @param node The given node
     * @param key The key
     */
    private void defineNode(ConstraintNode node, String key) {
        node.setKey(key);
    }
    
    /**
     * Defines the key and value of a given node.
     * 
     * @param node The given node
     * @param key The key
     * @param value The value
     */
    private void defineNode(ConstraintNode node, String key, String value) {
        node.setKey(key);
        node.addValue(value);
    }
    
    /**
     * Defines the key and a list of values of a given node.
     * 
     * @param node The given node
     * @param key The key
     * @param values The list of values
     */
    private void defineMultivalueNode(ConstraintNode node, String key, List<String> values) {
        node.setKey(key);
        node.setValues(values);
    }
    
    /**
     * Defines a DKTK Xml attribute.
     * 
     * @param node The node containing the informations
     * @return The DKTK Xml attribute
     */
    private Attribute defineAttribute(ConstraintNode node) {
        Attribute attr = new Attribute();
        attr.setMdrKey(node.getKey());
        attr.setValue(new JAXBElement<>(new QName(VALUE_NAMESPACE_URI, VALUE_LOCAL_NAME), String.class, node.getValue()));
        
        return attr;
    }
    
    /**
     * Defines a DKTK Xmk multivalue attribute.
     * 
     * @param node The node contatining the informations
     * @return The DKTK Xml multivalue attribute
     */
    private MultivalueAttribute defineMultivalueAttribute(ConstraintNode node) {
        MultivalueAttribute mAttr = new MultivalueAttribute();
        mAttr.setMdrKey(node.getKey());
        
        for(String value : node.getValues()) {
            mAttr.getValue().add(new JAXBElement<>(new QName(VALUE_NAMESPACE_URI, VALUE_LOCAL_NAME), String.class, value));
        }
        
        return mAttr;
    }
    
    /**
     * Defines a DKTK Xml range attribute.
     * 
     * @param node The node containing the informations
     * @return The DKTK Xml range attribute
     */
    private RangeAttribute defineRangeAttribute(ConstraintNode node) {
        RangeAttribute rAttr = new RangeAttribute();
        rAttr.setMdrKey(node.getKey());
        rAttr.setLowerBound(node.getLowerBound());
        rAttr.setUpperBound(node.getUpperBound());
        
        return rAttr;
    }
}
