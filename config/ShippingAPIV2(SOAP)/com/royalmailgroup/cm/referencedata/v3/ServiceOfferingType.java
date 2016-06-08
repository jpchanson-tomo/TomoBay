
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Defines the type of offering/product (with specific parameters) which may be sold to a customer.
 * 
 * <p>Java class for serviceOfferingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serviceOfferingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceOfferingCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceOfferingType", propOrder = {
    "serviceOfferingCode"
})
public class ServiceOfferingType {

    @XmlElement(required = true)
    protected ReferenceDataType serviceOfferingCode;

    /**
     * Gets the value of the serviceOfferingCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getServiceOfferingCode() {
        return serviceOfferingCode;
    }

    /**
     * Sets the value of the serviceOfferingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setServiceOfferingCode(ReferenceDataType value) {
        this.serviceOfferingCode = value;
    }

}
