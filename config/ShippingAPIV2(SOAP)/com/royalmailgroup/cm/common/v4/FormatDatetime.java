
package com.royalmailgroup.cm.common.v4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.royalmailgroup.cm.referencedata.v3.DateFormatType;


/**
 * Defines a primitive Date time with a specified format.
 * 
 * <p>Java class for formatDatetime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="formatDatetime">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateFormatType" type="{http://www.royalmailgroup.com/cm/referenceData/V3}dateFormatType"/>
 *         &lt;element name="dateTime" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "formatDatetime", propOrder = {
    "dateFormatType",
    "dateTime"
})
public class FormatDatetime {

    @XmlElement(required = true)
    protected DateFormatType dateFormatType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;

    /**
     * Gets the value of the dateFormatType property.
     * 
     * @return
     *     possible object is
     *     {@link DateFormatType }
     *     
     */
    public DateFormatType getDateFormatType() {
        return dateFormatType;
    }

    /**
     * Sets the value of the dateFormatType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateFormatType }
     *     
     */
    public void setDateFormatType(DateFormatType value) {
        this.dateFormatType = value;
    }

    /**
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTime(XMLGregorianCalendar value) {
        this.dateTime = value;
    }

}
