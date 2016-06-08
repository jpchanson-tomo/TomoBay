
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The format (RM Letters or International) of the Mail Item.
 * 
 * <p>Java class for mailItemFormatType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mailItemFormatType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mailItemFormatCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mailItemFormatType", propOrder = {
    "mailItemFormatCode"
})
public class MailItemFormatType {

    @XmlElement(required = true)
    protected ReferenceDataType mailItemFormatCode;

    /**
     * Gets the value of the mailItemFormatCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getMailItemFormatCode() {
        return mailItemFormatCode;
    }

    /**
     * Sets the value of the mailItemFormatCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setMailItemFormatCode(ReferenceDataType value) {
        this.mailItemFormatCode = value;
    }

}
