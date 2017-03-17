//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.25 um 03:52:12 PM CEST 
//


package org.i2b2.xsd.cell.crc.psm.querydefinition._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r query_definitionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="query_definitionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="query_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="query_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="query_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="query_description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="query_timing" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="specificity_scale" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="panel" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}panelType" maxOccurs="unbounded"/>
 *         &lt;element name="subquery_constraint" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}queryConstraintType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subquery" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}query_definitionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "query_definitionType", propOrder = {
    "queryId",
    "queryType",
    "queryName",
    "queryDescription",
    "queryTiming",
    "specificityScale",
    "panel",
    "subqueryConstraint",
    "subquery"
})
public class QueryDefinitionType {

    @XmlElement(name = "query_id")
    protected String queryId;
    @XmlElement(name = "query_type")
    protected String queryType;
    @XmlElement(name = "query_name", required = true)
    protected String queryName;
    @XmlElement(name = "query_description", required = true)
    protected String queryDescription;
    @XmlElement(name = "query_timing", required = true, defaultValue = "ANY")
    protected String queryTiming;
    @XmlElement(name = "specificity_scale")
    protected int specificityScale;
    @XmlElement(required = true)
    protected List<PanelType> panel;
    @XmlElement(name = "subquery_constraint")
    protected List<QueryConstraintType> subqueryConstraint;
    protected List<QueryDefinitionType> subquery;

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
     * Ruft den Wert der queryType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryType() {
        return queryType;
    }

    /**
     * Legt den Wert der queryType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryType(String value) {
        this.queryType = value;
    }

    /**
     * Ruft den Wert der queryName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryName() {
        return queryName;
    }

    /**
     * Legt den Wert der queryName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryName(String value) {
        this.queryName = value;
    }

    /**
     * Ruft den Wert der queryDescription-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryDescription() {
        return queryDescription;
    }

    /**
     * Legt den Wert der queryDescription-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryDescription(String value) {
        this.queryDescription = value;
    }

    /**
     * Ruft den Wert der queryTiming-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryTiming() {
        return queryTiming;
    }

    /**
     * Legt den Wert der queryTiming-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryTiming(String value) {
        this.queryTiming = value;
    }

    /**
     * Ruft den Wert der specificityScale-Eigenschaft ab.
     * 
     */
    public int getSpecificityScale() {
        return specificityScale;
    }

    /**
     * Legt den Wert der specificityScale-Eigenschaft fest.
     * 
     */
    public void setSpecificityScale(int value) {
        this.specificityScale = value;
    }

    /**
     * Gets the value of the panel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the panel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPanel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PanelType }
     * 
     * 
     */
    public List<PanelType> getPanel() {
        if (panel == null) {
            panel = new ArrayList<PanelType>();
        }
        return this.panel;
    }

    /**
     * Gets the value of the subqueryConstraint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subqueryConstraint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubqueryConstraint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QueryConstraintType }
     * 
     * 
     */
    public List<QueryConstraintType> getSubqueryConstraint() {
        if (subqueryConstraint == null) {
            subqueryConstraint = new ArrayList<QueryConstraintType>();
        }
        return this.subqueryConstraint;
    }

    /**
     * Gets the value of the subquery property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subquery property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubquery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QueryDefinitionType }
     * 
     * 
     */
    public List<QueryDefinitionType> getSubquery() {
        if (subquery == null) {
            subquery = new ArrayList<QueryDefinitionType>();
        }
        return this.subquery;
    }

}
