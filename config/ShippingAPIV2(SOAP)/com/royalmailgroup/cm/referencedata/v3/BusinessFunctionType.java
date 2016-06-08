
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A categorization of processes, people and resources organized in such a way as to produce a business outcome
 * 
 * <p>Java class for businessFunctionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="businessFunctionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="businessFunctionCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "businessFunctionType", propOrder = {
    "businessFunctionCode"
})
public class BusinessFunctionType {

    @XmlElement(required = true)
    protected ReferenceDataType businessFunctionCode;

    /**
     * Gets the value of the businessFunctionCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getBusinessFunctionCode() {
        return businessFunctionCode;
    }

    /**
     * Sets the value of the businessFunctionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setBusinessFunctionCode(ReferenceDataType value) {
        this.businessFunctionCode = value;
    }

}
