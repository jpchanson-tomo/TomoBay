
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The official RMG system name is the commonly used name for a system and will be more business oriented than a numerical identifier. An example would the Traffic and Revenue Reporting System.  
 * 
 * <p>Java class for systemNameType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="systemNameType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="systemNameCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "systemNameType", propOrder = {
    "systemNameCode"
})
public class SystemNameType {

    @XmlElement(required = true)
    protected ReferenceDataType systemNameCode;

    /**
     * Gets the value of the systemNameCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getSystemNameCode() {
        return systemNameCode;
    }

    /**
     * Sets the value of the systemNameCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setSystemNameCode(ReferenceDataType value) {
        this.systemNameCode = value;
    }

}
