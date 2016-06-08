
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This is used specifically for international items only and is applicable for the US, Canada, Australia, etc. 
 * 
 * <p>Java class for stateOrProvinceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stateOrProvinceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stateOrProvinceCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stateOrProvinceType", propOrder = {
    "stateOrProvinceCode"
})
public class StateOrProvinceType {

    @XmlElement(required = true)
    protected ReferenceDataType stateOrProvinceCode;

    /**
     * Gets the value of the stateOrProvinceCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getStateOrProvinceCode() {
        return stateOrProvinceCode;
    }

    /**
     * Sets the value of the stateOrProvinceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setStateOrProvinceCode(ReferenceDataType value) {
        this.stateOrProvinceCode = value;
    }

}
