
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Defines the type of Functional Location such as Region, Network Hub, Delivery Hub etc.
 * 
 * <p>Java class for functionalLocationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="functionalLocationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="functionalLocationCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "functionalLocationType", propOrder = {
    "functionalLocationCode"
})
public class FunctionalLocationType {

    @XmlElement(required = true)
    protected ReferenceDataType functionalLocationCode;

    /**
     * Gets the value of the functionalLocationCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getFunctionalLocationCode() {
        return functionalLocationCode;
    }

    /**
     * Sets the value of the functionalLocationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setFunctionalLocationCode(ReferenceDataType value) {
        this.functionalLocationCode = value;
    }

}
