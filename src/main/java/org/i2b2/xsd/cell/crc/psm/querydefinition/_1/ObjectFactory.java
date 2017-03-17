//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.25 um 03:52:12 PM CEST 
//


package org.i2b2.xsd.cell.crc.psm.querydefinition._1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.i2b2.xsd.cell.crc.psm.querydefinition._1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _QueryDefinition_QNAME = new QName("http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/", "query_definition");
    private final static QName _QueryConstraints_QNAME = new QName("http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/", "query_constraints");
    private final static QName _Panel_QNAME = new QName("http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/", "panel");
    private final static QName _QueryConstraint_QNAME = new QName("http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/", "query_constraint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.i2b2.xsd.cell.crc.psm.querydefinition._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ItemType }
     * 
     */
    public ItemType createItemType() {
        return new ItemType();
    }

    /**
     * Create an instance of {@link ItemType.ConstrainByModifier }
     * 
     */
    public ItemType.ConstrainByModifier createItemTypeConstrainByModifier() {
        return new ItemType.ConstrainByModifier();
    }

    /**
     * Create an instance of {@link PanelType }
     * 
     */
    public PanelType createPanelType() {
        return new PanelType();
    }

    /**
     * Create an instance of {@link QueryConstraintType }
     * 
     */
    public QueryConstraintType createQueryConstraintType() {
        return new QueryConstraintType();
    }

    /**
     * Create an instance of {@link QueryDefinitionType }
     * 
     */
    public QueryDefinitionType createQueryDefinitionType() {
        return new QueryDefinitionType();
    }

    /**
     * Create an instance of {@link QueryConstraintsType }
     * 
     */
    public QueryConstraintsType createQueryConstraintsType() {
        return new QueryConstraintsType();
    }

    /**
     * Create an instance of {@link QuerySpanConstraintType }
     * 
     */
    public QuerySpanConstraintType createQuerySpanConstraintType() {
        return new QuerySpanConstraintType();
    }

    /**
     * Create an instance of {@link MetadataxmlValueType }
     * 
     */
    public MetadataxmlValueType createMetadataxmlValueType() {
        return new MetadataxmlValueType();
    }

    /**
     * Create an instance of {@link ConstrainDateType }
     * 
     */
    public ConstrainDateType createConstrainDateType() {
        return new ConstrainDateType();
    }

    /**
     * Create an instance of {@link QueryJoinType }
     * 
     */
    public QueryJoinType createQueryJoinType() {
        return new QueryJoinType();
    }

    /**
     * Create an instance of {@link ItemType.ConstrainByValue }
     * 
     */
    public ItemType.ConstrainByValue createItemTypeConstrainByValue() {
        return new ItemType.ConstrainByValue();
    }

    /**
     * Create an instance of {@link ItemType.ConstrainByDate }
     * 
     */
    public ItemType.ConstrainByDate createItemTypeConstrainByDate() {
        return new ItemType.ConstrainByDate();
    }

    /**
     * Create an instance of {@link ItemType.ConstrainByModifier.ConstrainByValue }
     * 
     */
    public ItemType.ConstrainByModifier.ConstrainByValue createItemTypeConstrainByModifierConstrainByValue() {
        return new ItemType.ConstrainByModifier.ConstrainByValue();
    }

    /**
     * Create an instance of {@link PanelType.TotalItemOccurrences }
     * 
     */
    public PanelType.TotalItemOccurrences createPanelTypeTotalItemOccurrences() {
        return new PanelType.TotalItemOccurrences();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryDefinitionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/", name = "query_definition")
    public JAXBElement<QueryDefinitionType> createQueryDefinition(QueryDefinitionType value) {
        return new JAXBElement<QueryDefinitionType>(_QueryDefinition_QNAME, QueryDefinitionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryConstraintsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/", name = "query_constraints")
    public JAXBElement<QueryConstraintsType> createQueryConstraints(QueryConstraintsType value) {
        return new JAXBElement<QueryConstraintsType>(_QueryConstraints_QNAME, QueryConstraintsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PanelType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/", name = "panel")
    public JAXBElement<PanelType> createPanel(PanelType value) {
        return new JAXBElement<PanelType>(_Panel_QNAME, PanelType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryConstraintType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/", name = "query_constraint")
    public JAXBElement<QueryConstraintType> createQueryConstraint(QueryConstraintType value) {
        return new JAXBElement<QueryConstraintType>(_QueryConstraint_QNAME, QueryConstraintType.class, null, value);
    }

}
