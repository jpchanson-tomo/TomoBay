
package com.royalmailgroup.soap.extensions.v1;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.royalmailgroup.soap.extensions.v1 package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.royalmailgroup.soap.extensions.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExceptionDetails }
     * 
     */
    public ExceptionDetails createExceptionDetails() {
        return new ExceptionDetails();
    }

    /**
     * Create an instance of {@link Detail }
     * 
     */
    public Detail createDetail() {
        return new Detail();
    }

}
