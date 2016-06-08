
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This denotes the function the address plays (i.e. it is a primary address, seasonal, etc). 
 * 
 * <p>Java class for addressUsageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addressUsageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addressUsageCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addressUsageType", propOrder = {
    "addressUsageCode"
})
public class AddressUsageType {

    @XmlElement(required = true)
    protected ReferenceDataType addressUsageCode;

    /**
     * Gets the value of the addressUsageCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getAddressUsageCode() {
        return addressUsageCode;
    }

    /**
     * Sets the value of the addressUsageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setAddressUsageCode(ReferenceDataType value) {
        this.addressUsageCode = value;
    }

}
