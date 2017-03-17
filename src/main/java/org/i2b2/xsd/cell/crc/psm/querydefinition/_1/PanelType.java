//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.25 um 03:52:12 PM CEST 
//


package org.i2b2.xsd.cell.crc.psm.querydefinition._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java-Klasse für panelType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="panelType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="panel_number" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="panel_timing" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="panel_date_from" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainDateType"/>
 *         &lt;element name="panel_date_to" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainDateType"/>
 *         &lt;element name="panel_accuracy_scale" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="invert" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="total_item_occurrences">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>int">
 *                 &lt;attribute name="operator" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}totOccuranceOperatorType" default="GE" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="item" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}itemType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "panelType", propOrder = {
    "panelNumber",
    "panelTiming",
    "panelDateFrom",
    "panelDateTo",
    "panelAccuracyScale",
    "invert",
    "totalItemOccurrences",
    "item"
})
public class PanelType {

    @XmlElement(name = "panel_number")
    protected int panelNumber;
    @XmlElement(name = "panel_timing", required = true, defaultValue = "ANY")
    protected String panelTiming;
    @XmlElement(name = "panel_date_from", required = true)
    protected ConstrainDateType panelDateFrom;
    @XmlElement(name = "panel_date_to", required = true)
    protected ConstrainDateType panelDateTo;
    @XmlElement(name = "panel_accuracy_scale")
    protected int panelAccuracyScale;
    @XmlElement(defaultValue = "0")
    protected int invert;
    @XmlElement(name = "total_item_occurrences", required = true, defaultValue = "1")
    protected PanelType.TotalItemOccurrences totalItemOccurrences;
    @XmlElement(required = true)
    protected List<ItemType> item;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Ruft den Wert der panelNumber-Eigenschaft ab.
     * 
     */
    public int getPanelNumber() {
        return panelNumber;
    }

    /**
     * Legt den Wert der panelNumber-Eigenschaft fest.
     * 
     */
    public void setPanelNumber(int value) {
        this.panelNumber = value;
    }

    /**
     * Ruft den Wert der panelTiming-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPanelTiming() {
        return panelTiming;
    }

    /**
     * Legt den Wert der panelTiming-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPanelTiming(String value) {
        this.panelTiming = value;
    }

    /**
     * Ruft den Wert der panelDateFrom-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConstrainDateType }
     *     
     */
    public ConstrainDateType getPanelDateFrom() {
        return panelDateFrom;
    }

    /**
     * Legt den Wert der panelDateFrom-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConstrainDateType }
     *     
     */
    public void setPanelDateFrom(ConstrainDateType value) {
        this.panelDateFrom = value;
    }

    /**
     * Ruft den Wert der panelDateTo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConstrainDateType }
     *     
     */
    public ConstrainDateType getPanelDateTo() {
        return panelDateTo;
    }

    /**
     * Legt den Wert der panelDateTo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConstrainDateType }
     *     
     */
    public void setPanelDateTo(ConstrainDateType value) {
        this.panelDateTo = value;
    }

    /**
     * Ruft den Wert der panelAccuracyScale-Eigenschaft ab.
     * 
     */
    public int getPanelAccuracyScale() {
        return panelAccuracyScale;
    }

    /**
     * Legt den Wert der panelAccuracyScale-Eigenschaft fest.
     * 
     */
    public void setPanelAccuracyScale(int value) {
        this.panelAccuracyScale = value;
    }

    /**
     * Ruft den Wert der invert-Eigenschaft ab.
     * 
     */
    public int getInvert() {
        return invert;
    }

    /**
     * Legt den Wert der invert-Eigenschaft fest.
     * 
     */
    public void setInvert(int value) {
        this.invert = value;
    }

    /**
     * Ruft den Wert der totalItemOccurrences-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PanelType.TotalItemOccurrences }
     *     
     */
    public PanelType.TotalItemOccurrences getTotalItemOccurrences() {
        return totalItemOccurrences;
    }

    /**
     * Legt den Wert der totalItemOccurrences-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PanelType.TotalItemOccurrences }
     *     
     */
    public void setTotalItemOccurrences(PanelType.TotalItemOccurrences value) {
        this.totalItemOccurrences = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemType }
     * 
     * 
     */
    public List<ItemType> getItem() {
        if (item == null) {
            item = new ArrayList<ItemType>();
        }
        return this.item;
    }

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>int">
     *       &lt;attribute name="operator" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}totOccuranceOperatorType" default="GE" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class TotalItemOccurrences {

        @XmlValue
        protected int value;
        @XmlAttribute(name = "operator")
        protected TotOccuranceOperatorType operator;

        /**
         * Ruft den Wert der value-Eigenschaft ab.
         * 
         */
        public int getValue() {
            return value;
        }

        /**
         * Legt den Wert der value-Eigenschaft fest.
         * 
         */
        public void setValue(int value) {
            this.value = value;
        }

        /**
         * Ruft den Wert der operator-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link TotOccuranceOperatorType }
         *     
         */
        public TotOccuranceOperatorType getOperator() {
            if (operator == null) {
                return TotOccuranceOperatorType.GE;
            } else {
                return operator;
            }
        }

        /**
         * Legt den Wert der operator-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link TotOccuranceOperatorType }
         *     
         */
        public void setOperator(TotOccuranceOperatorType value) {
            this.operator = value;
        }

    }

}
