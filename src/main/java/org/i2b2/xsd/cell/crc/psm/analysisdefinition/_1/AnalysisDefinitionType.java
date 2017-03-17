//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.25 um 03:52:12 PM CEST 
//


package org.i2b2.xsd.cell.crc.psm.analysisdefinition._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für analysis_definitionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="analysis_definitionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="analysis_plugin_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="crc_analysis_input_param" type="{http://www.i2b2.org/xsd/cell/crc/psm/analysisdefinition/1.1/}crc_analysis_input_paramType"/>
 *         &lt;element name="crc_analysis_result_list" type="{http://www.i2b2.org/xsd/cell/crc/psm/analysisdefinition/1.1/}analysis_result_optionListType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "analysis_definitionType", propOrder = {
    "analysisPluginName",
    "version",
    "crcAnalysisInputParam",
    "crcAnalysisResultList"
})
public class AnalysisDefinitionType {

    @XmlElement(name = "analysis_plugin_name", required = true)
    protected String analysisPluginName;
    @XmlElement(required = true)
    protected String version;
    @XmlElement(name = "crc_analysis_input_param", required = true)
    protected CrcAnalysisInputParamType crcAnalysisInputParam;
    @XmlElement(name = "crc_analysis_result_list", required = true)
    protected AnalysisResultOptionListType crcAnalysisResultList;

    /**
     * Ruft den Wert der analysisPluginName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnalysisPluginName() {
        return analysisPluginName;
    }

    /**
     * Legt den Wert der analysisPluginName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnalysisPluginName(String value) {
        this.analysisPluginName = value;
    }

    /**
     * Ruft den Wert der version-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Legt den Wert der version-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Ruft den Wert der crcAnalysisInputParam-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CrcAnalysisInputParamType }
     *     
     */
    public CrcAnalysisInputParamType getCrcAnalysisInputParam() {
        return crcAnalysisInputParam;
    }

    /**
     * Legt den Wert der crcAnalysisInputParam-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CrcAnalysisInputParamType }
     *     
     */
    public void setCrcAnalysisInputParam(CrcAnalysisInputParamType value) {
        this.crcAnalysisInputParam = value;
    }

    /**
     * Ruft den Wert der crcAnalysisResultList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AnalysisResultOptionListType }
     *     
     */
    public AnalysisResultOptionListType getCrcAnalysisResultList() {
        return crcAnalysisResultList;
    }

    /**
     * Legt den Wert der crcAnalysisResultList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AnalysisResultOptionListType }
     *     
     */
    public void setCrcAnalysisResultList(AnalysisResultOptionListType value) {
        this.crcAnalysisResultList = value;
    }

}
