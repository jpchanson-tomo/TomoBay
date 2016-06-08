
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies if the type  of Functional Location group
 * 
 * <p>Java class for functionalLocationGroupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="functionalLocationGroupType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="functionalLocationGroupCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "functionalLocationGroupType", propOrder = {
    "functionalLocationGroupCode"
})
public class FunctionalLocationGroupType {

    @XmlElement(required = true)
    protected ReferenceDataType functionalLocationGroupCode;

    /**
     * Gets the value of the functionalLocationGroupCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getFunctionalLocationGroupCode() {
        return functionalLocationGroupCode;
    }

    /**
     * Sets the value of the functionalLocationGroupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setFunctionalLocationGroupCode(ReferenceDataType value) {
        this.functionalLocationGroupCode = value;
    }

}
