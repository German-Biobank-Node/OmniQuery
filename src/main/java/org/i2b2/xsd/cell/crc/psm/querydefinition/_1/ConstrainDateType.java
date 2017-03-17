//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.25 um 03:52:12 PM CEST 
//


package org.i2b2.xsd.cell.crc.psm.querydefinition._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für constrainDateType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="constrainDateType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>dateTime">
 *       &lt;attribute name="time" use="required" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainDateTimeType" />
 *       &lt;attribute name="inclusive" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}inclusiveType" default="YES" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "constrainDateType", propOrder = {
    "value"
})
public class ConstrainDateType {

    @XmlValue
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar value;
    @XmlAttribute(name = "time", required = true)
    protected ConstrainDateTimeType time;
    @XmlAttribute(name = "inclusive")
    protected InclusiveType inclusive;

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValue(XMLGregorianCalendar value) {
        this.value = value;
    }

    /**
     * Ruft den Wert der time-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConstrainDateTimeType }
     *     
     */
    public ConstrainDateTimeType getTime() {
        return time;
    }

    /**
     * Legt den Wert der time-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConstrainDateTimeType }
     *     
     */
    public void setTime(ConstrainDateTimeType value) {
        this.time = value;
    }

    /**
     * Ruft den Wert der inclusive-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link InclusiveType }
     *     
     */
    public InclusiveType getInclusive() {
        if (inclusive == null) {
            return InclusiveType.YES;
        } else {
            return inclusive;
        }
    }

    /**
     * Legt den Wert der inclusive-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link InclusiveType }
     *     
     */
    public void setInclusive(InclusiveType value) {
        this.inclusive = value;
    }

}
