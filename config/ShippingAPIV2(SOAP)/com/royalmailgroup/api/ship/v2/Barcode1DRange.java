
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold start and end 1D barcode range
 * 
 * <p>Java class for barcode1DRange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="barcode1DRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="barcode1DRangeStart" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *         &lt;element name="barcode1DRangeEnd" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "barcode1DRange", propOrder = {
    "barcode1DRangeStart",
    "barcode1DRangeEnd"
})
public class Barcode1DRange {

    @XmlElement(required = true)
    protected String barcode1DRangeStart;
    @XmlElement(required = true)
    protected String barcode1DRangeEnd;

    /**
     * Gets the value of the barcode1DRangeStart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarcode1DRangeStart() {
        return barcode1DRangeStart;
    }

    /**
     * Sets the value of the barcode1DRangeStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarcode1DRangeStart(String value) {
        this.barcode1DRangeStart = value;
    }

    /**
     * Gets the value of the barcode1DRangeEnd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarcode1DRangeEnd() {
        return barcode1DRangeEnd;
    }

    /**
     * Sets the value of the barcode1DRangeEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarcode1DRangeEnd(String value) {
        this.barcode1DRangeEnd = value;
    }

}
