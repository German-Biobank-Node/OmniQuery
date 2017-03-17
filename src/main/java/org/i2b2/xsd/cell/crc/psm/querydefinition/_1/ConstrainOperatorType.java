//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.25 um 03:52:12 PM CEST 
//


package org.i2b2.xsd.cell.crc.psm.querydefinition._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für constrainOperatorType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="constrainOperatorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EQ"/>
 *     &lt;enumeration value="NE"/>
 *     &lt;enumeration value="GT"/>
 *     &lt;enumeration value="LT"/>
 *     &lt;enumeration value="GE"/>
 *     &lt;enumeration value="LE"/>
 *     &lt;enumeration value="IN"/>
 *     &lt;enumeration value="LIKE"/>
 *     &lt;enumeration value="LIKE[begin]"/>
 *     &lt;enumeration value="LIKE[end]"/>
 *     &lt;enumeration value="LIKE[contains]"/>
 *     &lt;enumeration value="LIKE[exact]"/>
 *     &lt;enumeration value="BETWEEN"/>
 *     &lt;enumeration value="CONTAINS"/>
 *     &lt;enumeration value="CONTAINS[database]"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "constrainOperatorType")
@XmlEnum
public enum ConstrainOperatorType {

    EQ("EQ"),
    NE("NE"),
    GT("GT"),
    LT("LT"),
    GE("GE"),
    LE("LE"),
    IN("IN"),
    LIKE("LIKE"),
    @XmlEnumValue("LIKE[begin]")
    LIKE_BEGIN("LIKE[begin]"),
    @XmlEnumValue("LIKE[end]")
    LIKE_END("LIKE[end]"),
    @XmlEnumValue("LIKE[contains]")
    LIKE_CONTAINS("LIKE[contains]"),
    @XmlEnumValue("LIKE[exact]")
    LIKE_EXACT("LIKE[exact]"),
    BETWEEN("BETWEEN"),
    CONTAINS("CONTAINS"),
    @XmlEnumValue("CONTAINS[database]")
    CONTAINS_DATABASE("CONTAINS[database]");
    private final String value;

    ConstrainOperatorType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConstrainOperatorType fromValue(String v) {
        for (ConstrainOperatorType c: ConstrainOperatorType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
