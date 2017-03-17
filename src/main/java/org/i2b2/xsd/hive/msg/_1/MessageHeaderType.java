//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.25 um 03:53:29 PM CEST 
//


package org.i2b2.xsd.hive.msg._1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für message_headerType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="message_headerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="i2b2_version_compatible" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}decimal"/>
 *         &lt;element name="hl7_version_compatible" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}decimal"/>
 *         &lt;element name="sending_application" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}applicationType"/>
 *         &lt;element name="sending_facility" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}facilityType"/>
 *         &lt;element name="receiving_application" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}applicationType"/>
 *         &lt;element name="receiving_facility" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}facilityType"/>
 *         &lt;element name="datetime_of_message" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}dateTime"/>
 *         &lt;element name="security" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}securityType"/>
 *         &lt;element name="message_type" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}message_typeType"/>
 *         &lt;element name="message_control_id" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}message_control_idType"/>
 *         &lt;element name="processing_id" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}processing_idType"/>
 *         &lt;element name="accept_acknowledgement_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="application_acknowledgement_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="country_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="project_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "message_headerType", propOrder = {
    "i2B2VersionCompatible",
    "hl7VersionCompatible",
    "sendingApplication",
    "sendingFacility",
    "receivingApplication",
    "receivingFacility",
    "datetimeOfMessage",
    "security",
    "messageType",
    "messageControlId",
    "processingId",
    "acceptAcknowledgementType",
    "applicationAcknowledgementType",
    "countryCode",
    "projectId"
})
public class MessageHeaderType {

    @XmlElement(name = "i2b2_version_compatible", required = true)
    protected BigDecimal i2B2VersionCompatible;
    @XmlElement(name = "hl7_version_compatible", required = true)
    protected BigDecimal hl7VersionCompatible;
    @XmlElement(name = "sending_application", required = true)
    protected ApplicationType sendingApplication;
    @XmlElement(name = "sending_facility", required = true)
    protected FacilityType sendingFacility;
    @XmlElement(name = "receiving_application", required = true)
    protected ApplicationType receivingApplication;
    @XmlElement(name = "receiving_facility", required = true)
    protected FacilityType receivingFacility;
    @XmlElement(name = "datetime_of_message", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datetimeOfMessage;
    @XmlElement(required = true)
    protected SecurityType security;
    @XmlElement(name = "message_type", required = true)
    protected MessageTypeType messageType;
    @XmlElement(name = "message_control_id", required = true)
    protected MessageControlIdType messageControlId;
    @XmlElement(name = "processing_id", required = true)
    protected ProcessingIdType processingId;
    @XmlElement(name = "accept_acknowledgement_type", required = true)
    protected String acceptAcknowledgementType;
    @XmlElement(name = "application_acknowledgement_type", required = true)
    protected String applicationAcknowledgementType;
    @XmlElement(name = "country_code", required = true)
    protected String countryCode;
    @XmlElement(name = "project_id", required = true, nillable = true)
    protected String projectId;

    /**
     * Ruft den Wert der i2B2VersionCompatible-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getI2B2VersionCompatible() {
        return i2B2VersionCompatible;
    }

    /**
     * Legt den Wert der i2B2VersionCompatible-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setI2B2VersionCompatible(BigDecimal value) {
        this.i2B2VersionCompatible = value;
    }

    /**
     * Ruft den Wert der hl7VersionCompatible-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHl7VersionCompatible() {
        return hl7VersionCompatible;
    }

    /**
     * Legt den Wert der hl7VersionCompatible-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHl7VersionCompatible(BigDecimal value) {
        this.hl7VersionCompatible = value;
    }

    /**
     * Ruft den Wert der sendingApplication-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationType }
     *     
     */
    public ApplicationType getSendingApplication() {
        return sendingApplication;
    }

    /**
     * Legt den Wert der sendingApplication-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationType }
     *     
     */
    public void setSendingApplication(ApplicationType value) {
        this.sendingApplication = value;
    }

    /**
     * Ruft den Wert der sendingFacility-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FacilityType }
     *     
     */
    public FacilityType getSendingFacility() {
        return sendingFacility;
    }

    /**
     * Legt den Wert der sendingFacility-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityType }
     *     
     */
    public void setSendingFacility(FacilityType value) {
        this.sendingFacility = value;
    }

    /**
     * Ruft den Wert der receivingApplication-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationType }
     *     
     */
    public ApplicationType getReceivingApplication() {
        return receivingApplication;
    }

    /**
     * Legt den Wert der receivingApplication-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationType }
     *     
     */
    public void setReceivingApplication(ApplicationType value) {
        this.receivingApplication = value;
    }

    /**
     * Ruft den Wert der receivingFacility-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FacilityType }
     *     
     */
    public FacilityType getReceivingFacility() {
        return receivingFacility;
    }

    /**
     * Legt den Wert der receivingFacility-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityType }
     *     
     */
    public void setReceivingFacility(FacilityType value) {
        this.receivingFacility = value;
    }

    /**
     * Ruft den Wert der datetimeOfMessage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatetimeOfMessage() {
        return datetimeOfMessage;
    }

    /**
     * Legt den Wert der datetimeOfMessage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatetimeOfMessage(XMLGregorianCalendar value) {
        this.datetimeOfMessage = value;
    }

    /**
     * Ruft den Wert der security-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SecurityType }
     *     
     */
    public SecurityType getSecurity() {
        return security;
    }

    /**
     * Legt den Wert der security-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityType }
     *     
     */
    public void setSecurity(SecurityType value) {
        this.security = value;
    }

    /**
     * Ruft den Wert der messageType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MessageTypeType }
     *     
     */
    public MessageTypeType getMessageType() {
        return messageType;
    }

    /**
     * Legt den Wert der messageType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageTypeType }
     *     
     */
    public void setMessageType(MessageTypeType value) {
        this.messageType = value;
    }

    /**
     * Ruft den Wert der messageControlId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MessageControlIdType }
     *     
     */
    public MessageControlIdType getMessageControlId() {
        return messageControlId;
    }

    /**
     * Legt den Wert der messageControlId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageControlIdType }
     *     
     */
    public void setMessageControlId(MessageControlIdType value) {
        this.messageControlId = value;
    }

    /**
     * Ruft den Wert der processingId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProcessingIdType }
     *     
     */
    public ProcessingIdType getProcessingId() {
        return processingId;
    }

    /**
     * Legt den Wert der processingId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessingIdType }
     *     
     */
    public void setProcessingId(ProcessingIdType value) {
        this.processingId = value;
    }

    /**
     * Ruft den Wert der acceptAcknowledgementType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcceptAcknowledgementType() {
        return acceptAcknowledgementType;
    }

    /**
     * Legt den Wert der acceptAcknowledgementType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcceptAcknowledgementType(String value) {
        this.acceptAcknowledgementType = value;
    }

    /**
     * Ruft den Wert der applicationAcknowledgementType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationAcknowledgementType() {
        return applicationAcknowledgementType;
    }

    /**
     * Legt den Wert der applicationAcknowledgementType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationAcknowledgementType(String value) {
        this.applicationAcknowledgementType = value;
    }

    /**
     * Ruft den Wert der countryCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Legt den Wert der countryCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Ruft den Wert der projectId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * Legt den Wert der projectId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectId(String value) {
        this.projectId = value;
    }

}
