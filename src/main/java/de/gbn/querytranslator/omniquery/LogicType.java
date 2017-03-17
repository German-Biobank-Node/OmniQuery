/*
 * TODO: This License should be changed. 2016.
 */
package de.gbn.querytranslator.omniquery;

/**
 * This enum name the different logic types
 * @author German Biobank Node (GBN)
 */
public enum LogicType {

    /**
     * And logic type: (true * true) = true // (true * false) = false
     */
    And,

    /**
     * Or logic type: (true + true) = true // (true + false) = true
     */
    Or
}
