//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.25 um 03:53:29 PM CEST 
//


package org.i2b2.xsd.hive.msg._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für message_control_idType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="message_control_idType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="session_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="message_num" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="instance_num" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "message_control_idType", propOrder = {
    "sessionId",
    "messageNum",
    "instanceNum"
})
public class MessageControlIdType {

    @XmlElement(name = "session_id", required = true)
    protected String sessionId;
    @XmlElement(name = "message_num", required = true)
    protected String messageNum;
    @XmlElement(name = "instance_num")
    protected int instanceNum;

    /**
     * Ruft den Wert der sessionId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Legt den Wert der sessionId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

    /**
     * Ruft den Wert der messageNum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageNum() {
        return messageNum;
    }

    /**
     * Legt den Wert der messageNum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageNum(String value) {
        this.messageNum = value;
    }

    /**
     * Ruft den Wert der instanceNum-Eigenschaft ab.
     * 
     */
    public int getInstanceNum() {
        return instanceNum;
    }

    /**
     * Legt den Wert der instanceNum-Eigenschaft fest.
     * 
     */
    public void setInstanceNum(int value) {
        this.instanceNum = value;
    }

}
