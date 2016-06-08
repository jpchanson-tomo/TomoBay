
package com.royalmailgroup.api.ship.v2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.cm.referencedata.v3.ReferenceDataType;
import com.royalmailgroup.cm.referencedata.v3.ServiceOfferingType;


/**
 * schema to hold details for service occurrence, service offering, service enhancements combinations
 * 
 * <p>Java class for serviceReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serviceReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceOccurrence" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}ordinal" minOccurs="0"/>
 *         &lt;element name="serviceOffering" type="{http://www.royalmailgroup.com/cm/referenceData/V3}serviceOfferingType" minOccurs="0"/>
 *         &lt;element name="serviceEnhancements" type="{http://www.royalmailgroup.com/api/ship/V2}serviceEnhancements" minOccurs="0"/>
 *         &lt;element name="signature" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}boolean" minOccurs="0"/>
 *         &lt;element name="serviceType" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceReference", propOrder = {
    "serviceOccurrence",
    "serviceOffering",
    "serviceEnhancements",
    "signature",
    "serviceType"
})
public class ServiceReference {

    protected BigInteger serviceOccurrence;
    protected ServiceOfferingType serviceOffering;
    protected ServiceEnhancements serviceEnhancements;
    protected Boolean signature;
    protected ReferenceDataType serviceType;

    /**
     * Gets the value of the serviceOccurrence property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getServiceOccurrence() {
        return serviceOccurrence;
    }

    /**
     * Sets the value of the serviceOccurrence property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setServiceOccurrence(BigInteger value) {
        this.serviceOccurrence = value;
    }

    /**
     * Gets the value of the serviceOffering property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceOfferingType }
     *     
     */
    public ServiceOfferingType getServiceOffering() {
        return serviceOffering;
    }

    /**
     * Sets the value of the serviceOffering property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceOfferingType }
     *     
     */
    public void setServiceOffering(ServiceOfferingType value) {
        this.serviceOffering = value;
    }

    /**
     * Gets the value of the serviceEnhancements property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceEnhancements }
     *     
     */
    public ServiceEnhancements getServiceEnhancements() {
        return serviceEnhancements;
    }

    /**
     * Sets the value of the serviceEnhancements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceEnhancements }
     *     
     */
    public void setServiceEnhancements(ServiceEnhancements value) {
        this.serviceEnhancements = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSignature(Boolean value) {
        this.signature = value;
    }

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setServiceType(ReferenceDataType value) {
        this.serviceType = value;
    }

}
