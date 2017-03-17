//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.25 um 03:52:12 PM CEST 
//


package org.i2b2.xsd.cell.crc.psm._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für findBy_childType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="findBy_childType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="match_str" type="{http://www.i2b2.org/xsd/cell/crc/psm/1.1/}match_strType"/>
 *         &lt;element name="create_date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ascending" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *       &lt;attribute name="max" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="category" default="top">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="@"/>
 *             &lt;enumeration value="top"/>
 *             &lt;enumeration value="results"/>
 *             &lt;enumeration value="pdo"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findBy_childType", propOrder = {
    "matchStr",
    "createDate",
    "userId",
    "ascending"
})
public class FindByChildType {

    @XmlElement(name = "match_str", required = true)
    protected MatchStrType matchStr;
    @XmlElement(name = "create_date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createDate;
    @XmlElement(name = "user_id", required = true)
    protected String userId;
    @XmlElement(defaultValue = "false")
    protected boolean ascending;
    @XmlAttribute(name = "max", required = true)
    protected int max;
    @XmlAttribute(name = "category")
    protected String category;

    /**
     * Ruft den Wert der matchStr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MatchStrType }
     *     
     */
    public MatchStrType getMatchStr() {
        return matchStr;
    }

    /**
     * Legt den Wert der matchStr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MatchStrType }
     *     
     */
    public void setMatchStr(MatchStrType value) {
        this.matchStr = value;
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
     * Ruft den Wert der userId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Legt den Wert der userId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Ruft den Wert der ascending-Eigenschaft ab.
     * 
     */
    public boolean isAscending() {
        return ascending;
    }

    /**
     * Legt den Wert der ascending-Eigenschaft fest.
     * 
     */
    public void setAscending(boolean value) {
        this.ascending = value;
    }

    /**
     * Ruft den Wert der max-Eigenschaft ab.
     * 
     */
    public int getMax() {
        return max;
    }

    /**
     * Legt den Wert der max-Eigenschaft fest.
     * 
     */
    public void setMax(int value) {
        this.max = value;
    }

    /**
     * Ruft den Wert der category-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        if (category == null) {
            return "top";
        } else {
            return category;
        }
    }

    /**
     * Legt den Wert der category-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

}
