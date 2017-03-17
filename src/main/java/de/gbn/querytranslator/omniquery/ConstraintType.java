/*
 * TODO: This License should be changed. 2016.
 */
package de.gbn.querytranslator.omniquery;

/**
 * This enum names the different constraint types.
 * @author German Biobank Node (GBN)
 */
public enum ConstraintType {

    /**
     * Key, Singlevalue
     */
    Equals,

    /**
     * Key, Singlevalue
     */
    NotEquals,

    /**
     * Key, Singlevalue
     */
    Greater,

    /**
     * Key, Singlevalue
     */
    GreaterEquals,

    /**
     * Key, Singlevalue
     */
    Less,

    /**
     * Key, Singlevalue
     */
    LessEquals,

    /**
     * Key
     */
    IsNull,

    /**
     * Key
     */
    IsNotNull,

    /**
     * Key, Multivalue
     */
    In,

    /**
     * Key, Rangevalue/Multivalue
     */
    Between,

    /**
     * Key, Singlevalue
     */
    Like
}
