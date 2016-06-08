
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold request details for cancelShipmentRequest operation
 * 
 * <p>Java class for cancelShipmentRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cancelShipmentRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.royalmailgroup.com/api/ship/V2}baseRequest">
 *       &lt;sequence>
 *         &lt;element name="cancelShipments" type="{http://www.royalmailgroup.com/api/ship/V2}cancelShipments" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelShipmentRequest", propOrder = {
    "cancelShipments"
})
public class CancelShipmentRequest
    extends BaseRequest
{

    protected CancelShipments cancelShipments;

    /**
     * Gets the value of the cancelShipments property.
     * 
     * @return
     *     possible object is
     *     {@link CancelShipments }
     *     
     */
    public CancelShipments getCancelShipments() {
        return cancelShipments;
    }

    /**
     * Sets the value of the cancelShipments property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelShipments }
     *     
     */
    public void setCancelShipments(CancelShipments value) {
        this.cancelShipments = value;
    }

}
