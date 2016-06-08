
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Defines the Functional Location at the lowest level in terms of airport, seaport, rail hub etc
 * 
 * <p>Java class for functionalLocationSubType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="functionalLocationSubType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="functionalLocationSubtypeCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "functionalLocationSubType", propOrder = {
    "functionalLocationSubtypeCode"
})
public class FunctionalLocationSubType {

    @XmlElement(required = true)
    protected ReferenceDataType functionalLocationSubtypeCode;

    /**
     * Gets the value of the functionalLocationSubtypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getFunctionalLocationSubtypeCode() {
        return functionalLocationSubtypeCode;
    }

    /**
     * Sets the value of the functionalLocationSubtypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setFunctionalLocationSubtypeCode(ReferenceDataType value) {
        this.functionalLocationSubtypeCode = value;
    }

}
