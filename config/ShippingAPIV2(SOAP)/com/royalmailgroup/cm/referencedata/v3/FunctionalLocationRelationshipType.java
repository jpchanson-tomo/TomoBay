
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Defines the Functional Location Group Relationship in terms of PCA, Parent, Operational, Management etc
 * 
 * <p>Java class for functionalLocationRelationshipType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="functionalLocationRelationshipType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="functionalLocationRelationCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "functionalLocationRelationshipType", propOrder = {
    "functionalLocationRelationCode"
})
public class FunctionalLocationRelationshipType {

    @XmlElement(required = true)
    protected ReferenceDataType functionalLocationRelationCode;

    /**
     * Gets the value of the functionalLocationRelationCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getFunctionalLocationRelationCode() {
        return functionalLocationRelationCode;
    }

    /**
     * Sets the value of the functionalLocationRelationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setFunctionalLocationRelationCode(ReferenceDataType value) {
        this.functionalLocationRelationCode = value;
    }

}
