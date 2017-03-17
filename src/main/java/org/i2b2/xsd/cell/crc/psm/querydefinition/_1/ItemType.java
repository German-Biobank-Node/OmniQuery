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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für itemType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="itemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hlevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="item_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="item_key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="item_icon" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tooltip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="constrain_by_value" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="value_operator" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainOperatorType"/>
 *                   &lt;element name="value_constraint" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="value_unit_of_measure" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="value_type" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainValueType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="constrain_by_date" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="date_from" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainDateType"/>
 *                   &lt;element name="date_to" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainDateType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="constrain_by_modifier">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="modifier_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="modifier_key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="applied_path" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="constrain_by_value" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="value_operator" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainOperatorType"/>
 *                             &lt;element name="value_constraint" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="value_unit_of_measure" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="value_type" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainValueType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="dim_tablename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="dim_columnname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="dim_dimcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="dim_columndatatype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="dim_operator" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="facttablecolumn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="modifier_visualattributes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="modifier_synonym_cd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="modifier_tooltip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="modifier_class" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="dim_tablename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dim_columnname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dim_dimcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dim_columndatatype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dim_operator" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="facttablecolumn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="item_color" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="item_shape" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="item_row_number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="item_is_synonym" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="metadataxml" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}metadataxml_valueType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemType", propOrder = {
    "hlevel",
    "itemName",
    "itemKey",
    "itemIcon",
    "tooltip",
    "clazz",
    "constrainByValue",
    "constrainByDate",
    "constrainByModifier",
    "dimTablename",
    "dimColumnname",
    "dimDimcode",
    "dimColumndatatype",
    "dimOperator",
    "facttablecolumn",
    "itemColor",
    "itemShape",
    "itemRowNumber",
    "itemIsSynonym",
    "metadataxml"
})
public class ItemType {

    protected int hlevel;
    @XmlElement(name = "item_name", required = true)
    protected String itemName;
    @XmlElement(name = "item_key", required = true)
    protected String itemKey;
    @XmlElement(name = "item_icon", required = true)
    protected String itemIcon;
    @XmlElement(required = true)
    protected String tooltip;
    @XmlElement(name = "class", required = true)
    protected String clazz;
    @XmlElement(name = "constrain_by_value")
    protected List<ItemType.ConstrainByValue> constrainByValue;
    @XmlElement(name = "constrain_by_date")
    protected List<ItemType.ConstrainByDate> constrainByDate;
    @XmlElement(name = "constrain_by_modifier", required = true)
    protected ItemType.ConstrainByModifier constrainByModifier;
    @XmlElement(name = "dim_tablename", required = true)
    protected String dimTablename;
    @XmlElement(name = "dim_columnname", required = true)
    protected String dimColumnname;
    @XmlElement(name = "dim_dimcode", required = true)
    protected String dimDimcode;
    @XmlElement(name = "dim_columndatatype", required = true)
    protected String dimColumndatatype;
    @XmlElement(name = "dim_operator", required = true)
    protected String dimOperator;
    @XmlElement(required = true)
    protected String facttablecolumn;
    @XmlElement(name = "item_color", required = true)
    protected String itemColor;
    @XmlElement(name = "item_shape", required = true)
    protected String itemShape;
    @XmlElement(name = "item_row_number", required = true)
    protected String itemRowNumber;
    @XmlElement(name = "item_is_synonym")
    protected boolean itemIsSynonym;
    @XmlElement(required = true)
    protected MetadataxmlValueType metadataxml;

    /**
     * Ruft den Wert der hlevel-Eigenschaft ab.
     * 
     */
    public int getHlevel() {
        return hlevel;
    }

    /**
     * Legt den Wert der hlevel-Eigenschaft fest.
     * 
     */
    public void setHlevel(int value) {
        this.hlevel = value;
    }

    /**
     * Ruft den Wert der itemName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Legt den Wert der itemName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemName(String value) {
        this.itemName = value;
    }

    /**
     * Ruft den Wert der itemKey-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemKey() {
        return itemKey;
    }

    /**
     * Legt den Wert der itemKey-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemKey(String value) {
        this.itemKey = value;
    }

    /**
     * Ruft den Wert der itemIcon-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemIcon() {
        return itemIcon;
    }

    /**
     * Legt den Wert der itemIcon-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemIcon(String value) {
        this.itemIcon = value;
    }

    /**
     * Ruft den Wert der tooltip-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTooltip() {
        return tooltip;
    }

    /**
     * Legt den Wert der tooltip-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTooltip(String value) {
        this.tooltip = value;
    }

    /**
     * Ruft den Wert der clazz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Legt den Wert der clazz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the constrainByValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the constrainByValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConstrainByValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemType.ConstrainByValue }
     * 
     * 
     */
    public List<ItemType.ConstrainByValue> getConstrainByValue() {
        if (constrainByValue == null) {
            constrainByValue = new ArrayList<ItemType.ConstrainByValue>();
        }
        return this.constrainByValue;
    }

    /**
     * Gets the value of the constrainByDate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the constrainByDate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConstrainByDate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemType.ConstrainByDate }
     * 
     * 
     */
    public List<ItemType.ConstrainByDate> getConstrainByDate() {
        if (constrainByDate == null) {
            constrainByDate = new ArrayList<ItemType.ConstrainByDate>();
        }
        return this.constrainByDate;
    }

    /**
     * Ruft den Wert der constrainByModifier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ItemType.ConstrainByModifier }
     *     
     */
    public ItemType.ConstrainByModifier getConstrainByModifier() {
        return constrainByModifier;
    }

    /**
     * Legt den Wert der constrainByModifier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemType.ConstrainByModifier }
     *     
     */
    public void setConstrainByModifier(ItemType.ConstrainByModifier value) {
        this.constrainByModifier = value;
    }

    /**
     * Ruft den Wert der dimTablename-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDimTablename() {
        return dimTablename;
    }

    /**
     * Legt den Wert der dimTablename-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDimTablename(String value) {
        this.dimTablename = value;
    }

    /**
     * Ruft den Wert der dimColumnname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDimColumnname() {
        return dimColumnname;
    }

    /**
     * Legt den Wert der dimColumnname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDimColumnname(String value) {
        this.dimColumnname = value;
    }

    /**
     * Ruft den Wert der dimDimcode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDimDimcode() {
        return dimDimcode;
    }

    /**
     * Legt den Wert der dimDimcode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDimDimcode(String value) {
        this.dimDimcode = value;
    }

    /**
     * Ruft den Wert der dimColumndatatype-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDimColumndatatype() {
        return dimColumndatatype;
    }

    /**
     * Legt den Wert der dimColumndatatype-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDimColumndatatype(String value) {
        this.dimColumndatatype = value;
    }

    /**
     * Ruft den Wert der dimOperator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDimOperator() {
        return dimOperator;
    }

    /**
     * Legt den Wert der dimOperator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDimOperator(String value) {
        this.dimOperator = value;
    }

    /**
     * Ruft den Wert der facttablecolumn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacttablecolumn() {
        return facttablecolumn;
    }

    /**
     * Legt den Wert der facttablecolumn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacttablecolumn(String value) {
        this.facttablecolumn = value;
    }

    /**
     * Ruft den Wert der itemColor-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemColor() {
        return itemColor;
    }

    /**
     * Legt den Wert der itemColor-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemColor(String value) {
        this.itemColor = value;
    }

    /**
     * Ruft den Wert der itemShape-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemShape() {
        return itemShape;
    }

    /**
     * Legt den Wert der itemShape-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemShape(String value) {
        this.itemShape = value;
    }

    /**
     * Ruft den Wert der itemRowNumber-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemRowNumber() {
        return itemRowNumber;
    }

    /**
     * Legt den Wert der itemRowNumber-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemRowNumber(String value) {
        this.itemRowNumber = value;
    }

    /**
     * Ruft den Wert der itemIsSynonym-Eigenschaft ab.
     * 
     */
    public boolean isItemIsSynonym() {
        return itemIsSynonym;
    }

    /**
     * Legt den Wert der itemIsSynonym-Eigenschaft fest.
     * 
     */
    public void setItemIsSynonym(boolean value) {
        this.itemIsSynonym = value;
    }

    /**
     * Ruft den Wert der metadataxml-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MetadataxmlValueType }
     *     
     */
    public MetadataxmlValueType getMetadataxml() {
        return metadataxml;
    }

    /**
     * Legt den Wert der metadataxml-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataxmlValueType }
     *     
     */
    public void setMetadataxml(MetadataxmlValueType value) {
        this.metadataxml = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="date_from" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainDateType"/>
     *         &lt;element name="date_to" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainDateType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dateFrom",
        "dateTo"
    })
    public static class ConstrainByDate {

        @XmlElement(name = "date_from", required = true)
        protected ConstrainDateType dateFrom;
        @XmlElement(name = "date_to", required = true)
        protected ConstrainDateType dateTo;

        /**
         * Ruft den Wert der dateFrom-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link ConstrainDateType }
         *     
         */
        public ConstrainDateType getDateFrom() {
            return dateFrom;
        }

        /**
         * Legt den Wert der dateFrom-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link ConstrainDateType }
         *     
         */
        public void setDateFrom(ConstrainDateType value) {
            this.dateFrom = value;
        }

        /**
         * Ruft den Wert der dateTo-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link ConstrainDateType }
         *     
         */
        public ConstrainDateType getDateTo() {
            return dateTo;
        }

        /**
         * Legt den Wert der dateTo-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link ConstrainDateType }
         *     
         */
        public void setDateTo(ConstrainDateType value) {
            this.dateTo = value;
        }

    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="modifier_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="modifier_key" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="applied_path" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="constrain_by_value" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="value_operator" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainOperatorType"/>
     *                   &lt;element name="value_constraint" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="value_unit_of_measure" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="value_type" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainValueType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="dim_tablename" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="dim_columnname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="dim_dimcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="dim_columndatatype" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="dim_operator" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="facttablecolumn" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="modifier_visualattributes" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="modifier_synonym_cd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="modifier_tooltip" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="modifier_class" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "modifierName",
        "modifierKey",
        "appliedPath",
        "constrainByValue",
        "dimTablename",
        "dimColumnname",
        "dimDimcode",
        "dimColumndatatype",
        "dimOperator",
        "facttablecolumn",
        "modifierVisualattributes",
        "modifierSynonymCd",
        "modifierTooltip",
        "modifierClass"
    })
    public static class ConstrainByModifier {

        @XmlElement(name = "modifier_name", required = true)
        protected String modifierName;
        @XmlElement(name = "modifier_key", required = true)
        protected String modifierKey;
        @XmlElement(name = "applied_path", required = true)
        protected String appliedPath;
        @XmlElement(name = "constrain_by_value")
        protected List<ItemType.ConstrainByModifier.ConstrainByValue> constrainByValue;
        @XmlElement(name = "dim_tablename", required = true)
        protected String dimTablename;
        @XmlElement(name = "dim_columnname", required = true)
        protected String dimColumnname;
        @XmlElement(name = "dim_dimcode", required = true)
        protected String dimDimcode;
        @XmlElement(name = "dim_columndatatype", required = true)
        protected String dimColumndatatype;
        @XmlElement(name = "dim_operator", required = true)
        protected String dimOperator;
        @XmlElement(required = true)
        protected String facttablecolumn;
        @XmlElement(name = "modifier_visualattributes", required = true)
        protected String modifierVisualattributes;
        @XmlElement(name = "modifier_synonym_cd", required = true)
        protected String modifierSynonymCd;
        @XmlElement(name = "modifier_tooltip", required = true)
        protected String modifierTooltip;
        @XmlElement(name = "modifier_class", required = true)
        protected String modifierClass;

        /**
         * Ruft den Wert der modifierName-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModifierName() {
            return modifierName;
        }

        /**
         * Legt den Wert der modifierName-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModifierName(String value) {
            this.modifierName = value;
        }

        /**
         * Ruft den Wert der modifierKey-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModifierKey() {
            return modifierKey;
        }

        /**
         * Legt den Wert der modifierKey-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModifierKey(String value) {
            this.modifierKey = value;
        }

        /**
         * Ruft den Wert der appliedPath-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAppliedPath() {
            return appliedPath;
        }

        /**
         * Legt den Wert der appliedPath-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAppliedPath(String value) {
            this.appliedPath = value;
        }

        /**
         * Gets the value of the constrainByValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the constrainByValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getConstrainByValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ItemType.ConstrainByModifier.ConstrainByValue }
         * 
         * 
         */
        public List<ItemType.ConstrainByModifier.ConstrainByValue> getConstrainByValue() {
            if (constrainByValue == null) {
                constrainByValue = new ArrayList<ItemType.ConstrainByModifier.ConstrainByValue>();
            }
            return this.constrainByValue;
        }

        /**
         * Ruft den Wert der dimTablename-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDimTablename() {
            return dimTablename;
        }

        /**
         * Legt den Wert der dimTablename-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDimTablename(String value) {
            this.dimTablename = value;
        }

        /**
         * Ruft den Wert der dimColumnname-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDimColumnname() {
            return dimColumnname;
        }

        /**
         * Legt den Wert der dimColumnname-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDimColumnname(String value) {
            this.dimColumnname = value;
        }

        /**
         * Ruft den Wert der dimDimcode-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDimDimcode() {
            return dimDimcode;
        }

        /**
         * Legt den Wert der dimDimcode-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDimDimcode(String value) {
            this.dimDimcode = value;
        }

        /**
         * Ruft den Wert der dimColumndatatype-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDimColumndatatype() {
            return dimColumndatatype;
        }

        /**
         * Legt den Wert der dimColumndatatype-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDimColumndatatype(String value) {
            this.dimColumndatatype = value;
        }

        /**
         * Ruft den Wert der dimOperator-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDimOperator() {
            return dimOperator;
        }

        /**
         * Legt den Wert der dimOperator-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDimOperator(String value) {
            this.dimOperator = value;
        }

        /**
         * Ruft den Wert der facttablecolumn-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFacttablecolumn() {
            return facttablecolumn;
        }

        /**
         * Legt den Wert der facttablecolumn-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFacttablecolumn(String value) {
            this.facttablecolumn = value;
        }

        /**
         * Ruft den Wert der modifierVisualattributes-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModifierVisualattributes() {
            return modifierVisualattributes;
        }

        /**
         * Legt den Wert der modifierVisualattributes-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModifierVisualattributes(String value) {
            this.modifierVisualattributes = value;
        }

        /**
         * Ruft den Wert der modifierSynonymCd-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModifierSynonymCd() {
            return modifierSynonymCd;
        }

        /**
         * Legt den Wert der modifierSynonymCd-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModifierSynonymCd(String value) {
            this.modifierSynonymCd = value;
        }

        /**
         * Ruft den Wert der modifierTooltip-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModifierTooltip() {
            return modifierTooltip;
        }

        /**
         * Legt den Wert der modifierTooltip-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModifierTooltip(String value) {
            this.modifierTooltip = value;
        }

        /**
         * Ruft den Wert der modifierClass-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModifierClass() {
            return modifierClass;
        }

        /**
         * Legt den Wert der modifierClass-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModifierClass(String value) {
            this.modifierClass = value;
        }


        /**
         * <p>Java-Klasse für anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="value_operator" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainOperatorType"/>
         *         &lt;element name="value_constraint" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="value_unit_of_measure" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="value_type" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainValueType"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "valueOperator",
            "valueConstraint",
            "valueUnitOfMeasure",
            "valueType"
        })
        public static class ConstrainByValue {

            @XmlElement(name = "value_operator", required = true)
            @XmlSchemaType(name = "string")
            protected ConstrainOperatorType valueOperator;
            @XmlElement(name = "value_constraint", required = true)
            protected String valueConstraint;
            @XmlElement(name = "value_unit_of_measure", required = true)
            protected String valueUnitOfMeasure;
            @XmlElement(name = "value_type", required = true)
            @XmlSchemaType(name = "string")
            protected ConstrainValueType valueType;

            /**
             * Ruft den Wert der valueOperator-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link ConstrainOperatorType }
             *     
             */
            public ConstrainOperatorType getValueOperator() {
                return valueOperator;
            }

            /**
             * Legt den Wert der valueOperator-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link ConstrainOperatorType }
             *     
             */
            public void setValueOperator(ConstrainOperatorType value) {
                this.valueOperator = value;
            }

            /**
             * Ruft den Wert der valueConstraint-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValueConstraint() {
                return valueConstraint;
            }

            /**
             * Legt den Wert der valueConstraint-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValueConstraint(String value) {
                this.valueConstraint = value;
            }

            /**
             * Ruft den Wert der valueUnitOfMeasure-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValueUnitOfMeasure() {
                return valueUnitOfMeasure;
            }

            /**
             * Legt den Wert der valueUnitOfMeasure-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValueUnitOfMeasure(String value) {
                this.valueUnitOfMeasure = value;
            }

            /**
             * Ruft den Wert der valueType-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link ConstrainValueType }
             *     
             */
            public ConstrainValueType getValueType() {
                return valueType;
            }

            /**
             * Legt den Wert der valueType-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link ConstrainValueType }
             *     
             */
            public void setValueType(ConstrainValueType value) {
                this.valueType = value;
            }

        }

    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="value_operator" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainOperatorType"/>
     *         &lt;element name="value_constraint" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="value_unit_of_measure" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="value_type" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainValueType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "valueOperator",
        "valueConstraint",
        "valueUnitOfMeasure",
        "valueType"
    })
    public static class ConstrainByValue {

        @XmlElement(name = "value_operator", required = true)
        @XmlSchemaType(name = "string")
        protected ConstrainOperatorType valueOperator;
        @XmlElement(name = "value_constraint", required = true)
        protected String valueConstraint;
        @XmlElement(name = "value_unit_of_measure", required = true)
        protected String valueUnitOfMeasure;
        @XmlElement(name = "value_type", required = true)
        @XmlSchemaType(name = "string")
        protected ConstrainValueType valueType;

        /**
         * Ruft den Wert der valueOperator-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link ConstrainOperatorType }
         *     
         */
        public ConstrainOperatorType getValueOperator() {
            return valueOperator;
        }

        /**
         * Legt den Wert der valueOperator-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link ConstrainOperatorType }
         *     
         */
        public void setValueOperator(ConstrainOperatorType value) {
            this.valueOperator = value;
        }

        /**
         * Ruft den Wert der valueConstraint-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValueConstraint() {
            return valueConstraint;
        }

        /**
         * Legt den Wert der valueConstraint-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValueConstraint(String value) {
            this.valueConstraint = value;
        }

        /**
         * Ruft den Wert der valueUnitOfMeasure-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValueUnitOfMeasure() {
            return valueUnitOfMeasure;
        }

        /**
         * Legt den Wert der valueUnitOfMeasure-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValueUnitOfMeasure(String value) {
            this.valueUnitOfMeasure = value;
        }

        /**
         * Ruft den Wert der valueType-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link ConstrainValueType }
         *     
         */
        public ConstrainValueType getValueType() {
            return valueType;
        }

        /**
         * Legt den Wert der valueType-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link ConstrainValueType }
         *     
         */
        public void setValueType(ConstrainValueType value) {
            this.valueType = value;
        }

    }

}
