//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.25 um 03:52:12 PM CEST 
//


package org.i2b2.xsd.cell.crc.psm.querydefinition._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für queryJoinType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="queryJoinType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="query_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="join_column" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}queryJoinColumnType"/>
 *         &lt;element name="aggregate_operator" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}queryAggregateOperatorType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryJoinType", propOrder = {
    "queryId",
    "joinColumn",
    "aggregateOperator"
})
public class QueryJoinType {

    @XmlElement(name = "query_id", required = true)
    protected String queryId;
    @XmlElement(name = "join_column", required = true)
    @XmlSchemaType(name = "string")
    protected QueryJoinColumnType joinColumn;
    @XmlElement(name = "aggregate_operator", required = true)
    @XmlSchemaType(name = "string")
    protected QueryAggregateOperatorType aggregateOperator;

    /**
     * Ruft den Wert der queryId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryId() {
        return queryId;
    }

    /**
     * Legt den Wert der queryId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryId(String value) {
        this.queryId = value;
    }

    /**
     * Ruft den Wert der joinColumn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QueryJoinColumnType }
     *     
     */
    public QueryJoinColumnType getJoinColumn() {
        return joinColumn;
    }

    /**
     * Legt den Wert der joinColumn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryJoinColumnType }
     *     
     */
    public void setJoinColumn(QueryJoinColumnType value) {
        this.joinColumn = value;
    }

    /**
     * Ruft den Wert der aggregateOperator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QueryAggregateOperatorType }
     *     
     */
    public QueryAggregateOperatorType getAggregateOperator() {
        return aggregateOperator;
    }

    /**
     * Legt den Wert der aggregateOperator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryAggregateOperatorType }
     *     
     */
    public void setAggregateOperator(QueryAggregateOperatorType value) {
        this.aggregateOperator = value;
    }

}
