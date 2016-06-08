
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Day of week i.e. Monday, Tuesday etc
 * 
 * <p>Java class for dayOfWeekType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dayOfWeekType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="dayOfWeekCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dayOfWeekType", propOrder = {
    "dayOfWeekCode"
})
public class DayOfWeekType {

    protected ReferenceDataType dayOfWeekCode;

    /**
     * Gets the value of the dayOfWeekCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getDayOfWeekCode() {
        return dayOfWeekCode;
    }

    /**
     * Sets the value of the dayOfWeekCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setDayOfWeekCode(ReferenceDataType value) {
        this.dayOfWeekCode = value;
    }

}
