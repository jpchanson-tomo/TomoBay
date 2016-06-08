
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold request details for updateShipment operation
 * 
 * <p>Java class for updateShipmentRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateShipmentRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.royalmailgroup.com/api/ship/V2}baseRequest">
 *       &lt;sequence>
 *         &lt;element name="shipmentNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="requestedShipment" type="{http://www.royalmailgroup.com/api/ship/V2}requestedShipment" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateShipmentRequest", propOrder = {
    "shipmentNumber",
    "requestedShipment"
})
public class UpdateShipmentRequest
    extends BaseRequest
{

    protected String shipmentNumber;
    protected RequestedShipment requestedShipment;

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
     * Gets the value of the requestedShipment property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedShipment }
     *     
     */
    public RequestedShipment getRequestedShipment() {
        return requestedShipment;
    }

    /**
     * Sets the value of the requestedShipment property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedShipment }
     *     
     */
    public void setRequestedShipment(RequestedShipment value) {
        this.requestedShipment = value;
    }

}
