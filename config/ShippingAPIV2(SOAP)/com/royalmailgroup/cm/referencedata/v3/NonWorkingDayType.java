
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Non Working Day object contains all the planned non-working days. 
 * 
 * <p>Java class for nonWorkingDayType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nonWorkingDayType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nonWorkingDayCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nonWorkingDayType", propOrder = {
    "nonWorkingDayCode"
})
public class NonWorkingDayType {

    @XmlElement(required = true)
    protected ReferenceDataType nonWorkingDayCode;

    /**
     * Gets the value of the nonWorkingDayCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getNonWorkingDayCode() {
        return nonWorkingDayCode;
    }

    /**
     * Sets the value of the nonWorkingDayCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setNonWorkingDayCode(ReferenceDataType value) {
        this.nonWorkingDayCode = value;
    }

}
