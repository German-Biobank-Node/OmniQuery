//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.25 um 03:52:12 PM CEST 
//


package org.i2b2.xsd.cell.crc.psm.querydefinition._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für queryJoinColumnType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="queryJoinColumnType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PATIENT"/>
 *     &lt;enumeration value="ENCOUNTER"/>
 *     &lt;enumeration value="INSTANCE"/>
 *     &lt;enumeration value="STARTDATE"/>
 *     &lt;enumeration value="ENDDATE"/>
 *     &lt;enumeration value="ENCOUNTER_STARTDATE"/>
 *     &lt;enumeration value="ENCOUNTER_ENDDATE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "queryJoinColumnType")
@XmlEnum
public enum QueryJoinColumnType {

    PATIENT,
    ENCOUNTER,
    INSTANCE,
    STARTDATE,
    ENDDATE,
    ENCOUNTER_STARTDATE,
    ENCOUNTER_ENDDATE;

    public String value() {
        return name();
    }

    public static QueryJoinColumnType fromValue(String v) {
        return valueOf(v);
    }

}
