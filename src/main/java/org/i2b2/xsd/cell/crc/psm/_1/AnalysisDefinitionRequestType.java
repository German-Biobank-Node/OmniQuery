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
import javax.xml.bind.annotation.XmlType;
import org.i2b2.xsd.cell.crc.psm.analysisdefinition._1.AnalysisDefinitionType;


/**
 * <p>Java-Klasse für analysis_definition_requestType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="analysis_definition_requestType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.i2b2.org/xsd/cell/crc/psm/1.1/}requestType">
 *       &lt;sequence>
 *         &lt;element name="analysis_definition" type="{http://www.i2b2.org/xsd/cell/crc/psm/analysisdefinition/1.1/}analysis_definitionType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "analysis_definition_requestType", propOrder = {
    "analysisDefinition"
})
public class AnalysisDefinitionRequestType
    extends RequestType
{

    @XmlElement(name = "analysis_definition", required = true)
    protected AnalysisDefinitionType analysisDefinition;

    /**
     * Ruft den Wert der analysisDefinition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AnalysisDefinitionType }
     *     
     */
    public AnalysisDefinitionType getAnalysisDefinition() {
        return analysisDefinition;
    }

    /**
     * Legt den Wert der analysisDefinition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AnalysisDefinitionType }
     *     
     */
    public void setAnalysisDefinition(AnalysisDefinitionType value) {
        this.analysisDefinition = value;
    }

}
