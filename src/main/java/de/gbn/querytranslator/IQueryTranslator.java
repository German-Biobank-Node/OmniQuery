/*
 * TODO: This License should be changed. 2016.
 */
package de.gbn.querytranslator;

import de.gbn.querytranslator.omniquery.OmniQuery;

/**
 * This interface provides the functionality for translating Xml to OmniQuery
 * and vice versa.
 * @author German Biobank Node (GBN)
 */
public interface IQueryTranslator {
    
    /**
     * Translates a given Xml string into the OmniQuery Exchange format.
     * 
     * @param xml The xml as a string
     * @return The translated Xml as OmniQuery
     */
    public OmniQuery translateXmlToOmni(String xml);
    
    /**
     * Translates a given OmniQuery into a Xml string.
     * 
     * @param omniQuery The OmniQuery
     * @return The translated OmniQuery as Xml
     */
    public String translateOmniToXml(OmniQuery omniQuery);
}
