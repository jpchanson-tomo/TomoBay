
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Working Day Type contains the set of Types of working days. 
 * 
 * <p>Java class for workingDayType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="workingDayType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="workingDayCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workingDayType", propOrder = {
    "workingDayCode"
})
public class WorkingDayType {

    @XmlElement(required = true)
    protected ReferenceDataType workingDayCode;

    /**
     * Gets the value of the workingDayCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getWorkingDayCode() {
        return workingDayCode;
    }

    /**
     * Sets the value of the workingDayCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setWorkingDayCode(ReferenceDataType value) {
        this.workingDayCode = value;
    }

}
