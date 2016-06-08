
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold details of 1D Barcodes and associated service references
 * 
 * <p>Java class for serviceRange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serviceRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceReference" type="{http://www.royalmailgroup.com/api/ship/V2}serviceReference"/>
 *         &lt;element name="barcode1DRange" type="{http://www.royalmailgroup.com/api/ship/V2}barcode1DRange"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceRange", propOrder = {
    "serviceReference",
    "barcode1DRange"
})
public class ServiceRange {

    @XmlElement(required = true)
    protected ServiceReference serviceReference;
    @XmlElement(required = true)
    protected Barcode1DRange barcode1DRange;

    /**
     * Gets the value of the serviceReference property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceReference }
     *     
     */
    public ServiceReference getServiceReference() {
        return serviceReference;
    }

    /**
     * Sets the value of the serviceReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceReference }
     *     
     */
    public void setServiceReference(ServiceReference value) {
        this.serviceReference = value;
    }

    /**
     * Gets the value of the barcode1DRange property.
     * 
     * @return
     *     possible object is
     *     {@link Barcode1DRange }
     *     
     */
    public Barcode1DRange getBarcode1DRange() {
        return barcode1DRange;
    }

    /**
     * Sets the value of the barcode1DRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link Barcode1DRange }
     *     
     */
    public void setBarcode1DRange(Barcode1DRange value) {
        this.barcode1DRange = value;
    }

}
