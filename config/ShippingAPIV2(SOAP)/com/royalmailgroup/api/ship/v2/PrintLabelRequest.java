
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold request details for printLabel operation
 * 
 * <p>Java class for printLabelRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="printLabelRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.royalmailgroup.com/api/ship/V2}baseRequest">
 *       &lt;sequence>
 *         &lt;element name="shipmentNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *         &lt;element name="outputFormat" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="localisedAddress" type="{http://www.royalmailgroup.com/api/ship/V2}localisedAddress" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "printLabelRequest", propOrder = {
    "shipmentNumber",
    "outputFormat",
    "localisedAddress"
})
public class PrintLabelRequest
    extends BaseRequest
{

    @XmlElement(required = true)
    protected String shipmentNumber;
    protected String outputFormat;
    protected LocalisedAddress localisedAddress;

    /**
     * Gets the value of the shipmentNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipmentNumber() {
        return shipmentNumber;
    }

    /**
     * Sets the value of the shipmentNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipmentNumber(String value) {
        this.shipmentNumber = value;
    }

    /**
     * Gets the value of the outputFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputFormat() {
        return outputFormat;
    }

    /**
     * Sets the value of the outputFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputFormat(String value) {
        this.outputFormat = value;
    }

    /**
     * Gets the value of the localisedAddress property.
     * 
     * @return
     *     possible object is
     *     {@link LocalisedAddress }
     *     
     */
    public LocalisedAddress getLocalisedAddress() {
        return localisedAddress;
    }

    /**
     * Sets the value of the localisedAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalisedAddress }
     *     
     */
    public void setLocalisedAddress(LocalisedAddress value) {
        this.localisedAddress = value;
    }

}
