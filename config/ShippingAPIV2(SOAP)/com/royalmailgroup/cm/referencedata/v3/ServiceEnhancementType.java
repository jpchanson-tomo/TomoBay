
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Defines the type of enhancement used to add to an offering/product (with specific parameters) which may be sold to a customer.
 * 
 * <p>Java class for serviceEnhancementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serviceEnhancementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceEnhancementCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceEnhancementType", propOrder = {
    "serviceEnhancementCode"
})
public class ServiceEnhancementType {

    @XmlElement(required = true)
    protected ReferenceDataType serviceEnhancementCode;

    /**
     * Gets the value of the serviceEnhancementCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getServiceEnhancementCode() {
        return serviceEnhancementCode;
    }

    /**
     * Sets the value of the serviceEnhancementCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setServiceEnhancementCode(ReferenceDataType value) {
        this.serviceEnhancementCode = value;
    }

}
