/*
 * TODO: This License should be changed. 2016.
 */
package de.gbn.querytranslator;

import de.gbn.querytranslator.omniquery.OmniQuery;

/**
 * This is the base class for Translators already implementing a function for 
 * translating to another query format.
 * 
 * The generic type defines the targeted translator.
 * 
 * @author German Biobank Node (GBN)
 * @param <T> The targeted translator
 */
public abstract class AbstractTranslator<T extends IQueryTranslator> 
        implements IQueryTranslator {
    
    /**
     * This holds the class of the targeted translator
     */
    Class<T> targetTranslator;
    
    /**
     * Empty constructor
     */
    public AbstractTranslator() {
    }
    
    /**
     * Defines the targeted translator.
     * 
     * @param targetTranslator The class of the targeted translator
     */
    public AbstractTranslator(Class<T> targetTranslator) {
        this.targetTranslator = targetTranslator;
    }
    
    /**
     * Creates a new instance of the targeted translator.
     * 
     * @return The new instance
     */
    public T getNewInstance()
    {
        try {
            return targetTranslator.newInstance();
        }
        catch (Exception ex) {
            ex.printStackTrace(); // TODO
        }

        return null;
    }
    
    /**
     * Translates an input Xml to a translated output Xml.
     * 
     * @param xml The input Xml
     * @return The translated Xml as string
     */
    public String translate(String xml) {
        T target = getNewInstance();      
        OmniQuery tempResult = translateXmlToOmni(xml);
        return target.translateOmniToXml(tempResult);
    }
}
