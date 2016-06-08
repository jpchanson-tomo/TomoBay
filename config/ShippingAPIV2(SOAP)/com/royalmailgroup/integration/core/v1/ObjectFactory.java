
package com.royalmailgroup.integration.core.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.royalmailgroup.integration.core.v1 package. 
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

    private final static QName _IntegrationFooter_QNAME = new QName("http://www.royalmailgroup.com/integration/core/V1", "integrationFooter");
    private final static QName _IntegrationHeader_QNAME = new QName("http://www.royalmailgroup.com/integration/core/V1", "integrationHeader");
    private final static QName _ErrorDetailErrorContext_QNAME = new QName("http://www.royalmailgroup.com/integration/core/V1", "errorContext");
    private final static QName _WarningDetailWarningContext_QNAME = new QName("http://www.royalmailgroup.com/integration/core/V1", "warningContext");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.royalmailgroup.integration.core.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IntegrationHeader }
     * 
     */
    public IntegrationHeader createIntegrationHeader() {
        return new IntegrationHeader();
    }

    /**
     * Create an instance of {@link IntegrationFooter }
     * 
     */
    public IntegrationFooter createIntegrationFooter() {
        return new IntegrationFooter();
    }

    /**
     * Create an instance of {@link WarningStructure }
     * 
     */
    public WarningStructure createWarningStructure() {
        return new WarningStructure();
    }

    /**
     * Create an instance of {@link ErrorDetail }
     * 
     */
    public ErrorDetail createErrorDetail() {
        return new ErrorDetail();
    }

    /**
     * Create an instance of {@link ErrorStructure }
     * 
     */
    public ErrorStructure createErrorStructure() {
        return new ErrorStructure();
    }

    /**
     * Create an instance of {@link WarningDetail }
     * 
     */
    public WarningDetail createWarningDetail() {
        return new WarningDetail();
    }

    /**
     * Create an instance of {@link IdentificationStructure }
     * 
     */
    public IdentificationStructure createIdentificationStructure() {
        return new IdentificationStructure();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntegrationFooter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/integration/core/V1", name = "integrationFooter")
    public JAXBElement<IntegrationFooter> createIntegrationFooter(IntegrationFooter value) {
        return new JAXBElement<IntegrationFooter>(_IntegrationFooter_QNAME, IntegrationFooter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntegrationHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/integration/core/V1", name = "integrationHeader")
    public JAXBElement<IntegrationHeader> createIntegrationHeader(IntegrationHeader value) {
        return new JAXBElement<IntegrationHeader>(_IntegrationHeader_QNAME, IntegrationHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/integration/core/V1", name = "errorContext", scope = ErrorDetail.class)
    public JAXBElement<String> createErrorDetailErrorContext(String value) {
        return new JAXBElement<String>(_ErrorDetailErrorContext_QNAME, String.class, ErrorDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/integration/core/V1", name = "warningContext", scope = WarningDetail.class)
    public JAXBElement<String> createWarningDetailWarningContext(String value) {
        return new JAXBElement<String>(_WarningDetailWarningContext_QNAME, String.class, WarningDetail.class, value);
    }

}
