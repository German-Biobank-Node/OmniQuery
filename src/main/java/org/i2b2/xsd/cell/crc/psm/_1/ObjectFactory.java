//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.25 um 03:52:12 PM CEST 
//


package org.i2b2.xsd.cell.crc.psm._1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.i2b2.xsd.cell.crc.psm._1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetNameInfo_QNAME = new QName("http://www.i2b2.org/xsd/cell/crc/psm/1.1/", "get_name_info");
    private final static QName _Sql_QNAME = new QName("http://www.i2b2.org/xsd/cell/crc/psm/1.1/", "sql");
    private final static QName _Request_QNAME = new QName("http://www.i2b2.org/xsd/cell/crc/psm/1.1/", "request");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.i2b2.xsd.cell.crc.psm._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindByChildType }
     * 
     */
    public FindByChildType createFindByChildType() {
        return new FindByChildType();
    }

    /**
     * Create an instance of {@link MasterDeleteRequestType }
     * 
     */
    public MasterDeleteRequestType createMasterDeleteRequestType() {
        return new MasterDeleteRequestType();
    }

    /**
     * Create an instance of {@link AnalysisPluginMetadataRequestType }
     * 
     */
    public AnalysisPluginMetadataRequestType createAnalysisPluginMetadataRequestType() {
        return new AnalysisPluginMetadataRequestType();
    }

    /**
     * Create an instance of {@link ResultTypeRequestType }
     * 
     */
    public ResultTypeRequestType createResultTypeRequestType() {
        return new ResultTypeRequestType();
    }

    /**
     * Create an instance of {@link InstanceRequestType }
     * 
     */
    public InstanceRequestType createInstanceRequestType() {
        return new InstanceRequestType();
    }

    /**
     * Create an instance of {@link ResultOutputOptionType }
     * 
     */
    public ResultOutputOptionType createResultOutputOptionType() {
        return new ResultOutputOptionType();
    }

    /**
     * Create an instance of {@link MasterRequestType }
     * 
     */
    public MasterRequestType createMasterRequestType() {
        return new MasterRequestType();
    }

    /**
     * Create an instance of {@link AnalysisDefinitionRequestType }
     * 
     */
    public AnalysisDefinitionRequestType createAnalysisDefinitionRequestType() {
        return new AnalysisDefinitionRequestType();
    }

    /**
     * Create an instance of {@link ResultRequestType }
     * 
     */
    public ResultRequestType createResultRequestType() {
        return new ResultRequestType();
    }

    /**
     * Create an instance of {@link MasterRenameRequestType }
     * 
     */
    public MasterRenameRequestType createMasterRenameRequestType() {
        return new MasterRenameRequestType();
    }

    /**
     * Create an instance of {@link HeaderType }
     * 
     */
    public HeaderType createHeaderType() {
        return new HeaderType();
    }

    /**
     * Create an instance of {@link MatchStrType }
     * 
     */
    public MatchStrType createMatchStrType() {
        return new MatchStrType();
    }

    /**
     * Create an instance of {@link UserType }
     * 
     */
    public UserType createUserType() {
        return new UserType();
    }

    /**
     * Create an instance of {@link UserRequestType }
     * 
     */
    public UserRequestType createUserRequestType() {
        return new UserRequestType();
    }

    /**
     * Create an instance of {@link ResultOutputOptionListType }
     * 
     */
    public ResultOutputOptionListType createResultOutputOptionListType() {
        return new ResultOutputOptionListType();
    }

    /**
     * Create an instance of {@link QueryDefinitionRequestType }
     * 
     */
    public QueryDefinitionRequestType createQueryDefinitionRequestType() {
        return new QueryDefinitionRequestType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByChildType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/crc/psm/1.1/", name = "get_name_info")
    public JAXBElement<FindByChildType> createGetNameInfo(FindByChildType value) {
        return new JAXBElement<FindByChildType>(_GetNameInfo_QNAME, FindByChildType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/crc/psm/1.1/", name = "sql")
    public JAXBElement<String> createSql(String value) {
        return new JAXBElement<String>(_Sql_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/crc/psm/1.1/", name = "request")
    public JAXBElement<RequestType> createRequest(RequestType value) {
        return new JAXBElement<RequestType>(_Request_QNAME, RequestType.class, null, value);
    }

}
