
package com.royalmailgroup.integration.core.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for warningDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="warningDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="warningCode" type="{http://www.royalmailgroup.com/integration/core/V1}warningCode"/>
 *         &lt;element name="warningDescription" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}description"/>
 *         &lt;element name="warningCause" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}description" minOccurs="0"/>
 *         &lt;element name="warningResolution" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}description" minOccurs="0"/>
 *         &lt;element name="warningContext" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}description" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "warningDetail", propOrder = {
    "warningCode",
    "warningDescription",
    "warningCause",
    "warningResolution",
    "warningContext"
})
public class WarningDetail {

    @XmlElement(required = true)
    protected String warningCode;
    @XmlElement(required = true)
    protected String warningDescription;
    protected String warningCause;
    protected String warningResolution;
    @XmlElementRef(name = "warningContext", namespace = "http://www.royalmailgroup.com/integration/core/V1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> warningContext;

    /**
     * Gets the value of the warningCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWarningCode() {
        return warningCode;
    }

    /**
     * Sets the value of the warningCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWarningCode(String value) {
        this.warningCode = value;
    }

    /**
     * Gets the value of the warningDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWarningDescription() {
        return warningDescription;
    }

    /**
     * Sets the value of the warningDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWarningDescription(String value) {
        this.warningDescription = value;
    }

    /**
     * Gets the value of the warningCause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWarningCause() {
        return warningCause;
    }

    /**
     * Sets the value of the warningCause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWarningCause(String value) {
        this.warningCause = value;
    }

    /**
     * Gets the value of the warningResolution property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWarningResolution() {
        return warningResolution;
    }

    /**
     * Sets the value of the warningResolution property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWarningResolution(String value) {
        this.warningResolution = value;
    }

    /**
     * Gets the value of the warningContext property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWarningContext() {
        return warningContext;
    }

    /**
     * Sets the value of the warningContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWarningContext(JAXBElement<String> value) {
        this.warningContext = value;
    }

}
