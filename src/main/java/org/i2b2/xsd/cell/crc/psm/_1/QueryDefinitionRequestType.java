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
import org.i2b2.xsd.cell.crc.psm.querydefinition._1.QueryDefinitionType;


/**
 * <p>Java-Klasse für query_definition_requestType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="query_definition_requestType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.i2b2.org/xsd/cell/crc/psm/1.1/}requestType">
 *       &lt;sequence>
 *         &lt;element name="query_definition" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}query_definitionType"/>
 *         &lt;element name="result_output_list" type="{http://www.i2b2.org/xsd/cell/crc/psm/1.1/}result_output_optionListType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "query_definition_requestType", propOrder = {
    "queryDefinition",
    "resultOutputList"
})
public class QueryDefinitionRequestType
    extends RequestType
{

    @XmlElement(name = "query_definition", required = true)
    protected QueryDefinitionType queryDefinition;
    @XmlElement(name = "result_output_list", required = true)
    protected ResultOutputOptionListType resultOutputList;

    /**
     * Ruft den Wert der queryDefinition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QueryDefinitionType }
     *     
     */
    public QueryDefinitionType getQueryDefinition() {
        return queryDefinition;
    }

    /**
     * Legt den Wert der queryDefinition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryDefinitionType }
     *     
     */
    public void setQueryDefinition(QueryDefinitionType value) {
        this.queryDefinition = value;
    }

    /**
     * Ruft den Wert der resultOutputList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ResultOutputOptionListType }
     *     
     */
    public ResultOutputOptionListType getResultOutputList() {
        return resultOutputList;
    }

    /**
     * Legt den Wert der resultOutputList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultOutputOptionListType }
     *     
     */
    public void setResultOutputList(ResultOutputOptionListType value) {
        this.resultOutputList = value;
    }

}
