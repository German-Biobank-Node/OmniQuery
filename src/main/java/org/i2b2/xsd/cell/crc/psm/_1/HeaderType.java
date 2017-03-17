//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.25 um 03:52:12 PM CEST 
//


package org.i2b2.xsd.cell.crc.psm._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für headerType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="headerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user" type="{http://www.i2b2.org/xsd/cell/crc/psm/1.1/}userType"/>
 *         &lt;element name="data_source" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="patient_set_limit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estimated_time" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="create_date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="submit_date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="complete_date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="query_mode" type="{http://www.i2b2.org/xsd/cell/crc/psm/1.1/}queryModeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "headerType", propOrder = {
    "user",
    "dataSource",
    "patientSetLimit",
    "estimatedTime",
    "createDate",
    "submitDate",
    "completeDate",
    "queryMode"
})
public class HeaderType {

    @XmlElement(required = true)
    protected UserType user;
    @XmlElement(name = "data_source", required = true)
    protected String dataSource;
    @XmlElement(name = "patient_set_limit")
    protected int patientSetLimit;
    @XmlElement(name = "estimated_time")
    protected int estimatedTime;
    @XmlElement(name = "create_date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createDate;
    @XmlElement(name = "submit_date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar submitDate;
    @XmlElement(name = "complete_date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar completeDate;
    @XmlElement(name = "query_mode", required = true)
    @XmlSchemaType(name = "string")
    protected QueryModeType queryMode;

    /**
     * Ruft den Wert der user-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UserType }
     *     
     */
    public UserType getUser() {
        return user;
    }

    /**
     * Legt den Wert der user-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UserType }
     *     
     */
    public void setUser(UserType value) {
        this.user = value;
    }

    /**
     * Ruft den Wert der dataSource-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * Legt den Wert der dataSource-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataSource(String value) {
        this.dataSource = value;
    }

    /**
     * Ruft den Wert der patientSetLimit-Eigenschaft ab.
     * 
     */
    public int getPatientSetLimit() {
        return patientSetLimit;
    }

    /**
     * Legt den Wert der patientSetLimit-Eigenschaft fest.
     * 
     */
    public void setPatientSetLimit(int value) {
        this.patientSetLimit = value;
    }

    /**
     * Ruft den Wert der estimatedTime-Eigenschaft ab.
     * 
     */
    public int getEstimatedTime() {
        return estimatedTime;
    }

    /**
     * Legt den Wert der estimatedTime-Eigenschaft fest.
     * 
     */
    public void setEstimatedTime(int value) {
        this.estimatedTime = value;
    }

    /**
     * Ruft den Wert der createDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateDate() {
        return createDate;
    }

    /**
     * Legt den Wert der createDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateDate(XMLGregorianCalendar value) {
        this.createDate = value;
    }

    /**
     * Ruft den Wert der submitDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSubmitDate() {
        return submitDate;
    }

    /**
     * Legt den Wert der submitDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSubmitDate(XMLGregorianCalendar value) {
        this.submitDate = value;
    }

    /**
     * Ruft den Wert der completeDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCompleteDate() {
        return completeDate;
    }

    /**
     * Legt den Wert der completeDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCompleteDate(XMLGregorianCalendar value) {
        this.completeDate = value;
    }

    /**
     * Ruft den Wert der queryMode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QueryModeType }
     *     
     */
    public QueryModeType getQueryMode() {
        return queryMode;
    }

    /**
     * Legt den Wert der queryMode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryModeType }
     *     
     */
    public void setQueryMode(QueryModeType value) {
        this.queryMode = value;
    }

}
