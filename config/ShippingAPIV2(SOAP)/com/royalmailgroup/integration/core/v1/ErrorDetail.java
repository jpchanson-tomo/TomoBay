
package com.royalmailgroup.integration.core.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for errorDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="errorDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorCode" type="{http://www.royalmailgroup.com/integration/core/V1}errorCode"/>
 *         &lt;element name="errorDescription" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}description"/>
 *         &lt;element name="errorCause" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}description" minOccurs="0"/>
 *         &lt;element name="errorResolution" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}description" minOccurs="0"/>
 *         &lt;element name="errorContext" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}description" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "errorDetail", propOrder = {
    "errorCode",
    "errorDescription",
    "errorCause",
    "errorResolution",
    "errorContext"
})
public class ErrorDetail {

    @XmlElement(required = true)
    protected String errorCode;
    @XmlElement(required = true)
    protected String errorDescription;
    protected String errorCause;
    protected String errorResolution;
    @XmlElementRef(name = "errorContext", namespace = "http://www.royalmailgroup.com/integration/core/V1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errorContext;

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the errorDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorDescription() {
        return errorDescription;
    }

    /**
     * Sets the value of the errorDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorDescription(String value) {
        this.errorDescription = value;
    }

    /**
     * Gets the value of the errorCause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCause() {
        return errorCause;
    }

    /**
     * Sets the value of the errorCause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCause(String value) {
        this.errorCause = value;
    }

    /**
     * Gets the value of the errorResolution property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorResolution() {
        return errorResolution;
    }

    /**
     * Sets the value of the errorResolution property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorResolution(String value) {
        this.errorResolution = value;
    }

    /**
     * Gets the value of the errorContext property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrorContext() {
        return errorContext;
    }

    /**
     * Sets the value of the errorContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrorContext(JAXBElement<String> value) {
        this.errorContext = value;
    }

}
