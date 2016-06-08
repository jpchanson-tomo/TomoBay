
package com.royalmailgroup.api.ship.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold an array of shipment numbers
 * 
 * <p>Java class for shipments complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shipments">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="shipmentNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" maxOccurs="99" minOccurs="0"/>
 *         &lt;element name="shipment" type="{http://www.royalmailgroup.com/api/ship/V2}shipment" maxOccurs="99"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shipments", propOrder = {
    "shipmentNumber",
    "shipment"
})
public class Shipments {

    protected List<String> shipmentNumber;
    @XmlElement(required = true)
    protected List<Shipment> shipment;

    /**
     * Gets the value of the shipmentNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipmentNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipmentNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getShipmentNumber() {
        if (shipmentNumber == null) {
            shipmentNumber = new ArrayList<String>();
        }
        return this.shipmentNumber;
    }

    /**
     * Gets the value of the shipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Shipment }
     * 
     * 
     */
    public List<Shipment> getShipment() {
        if (shipment == null) {
            shipment = new ArrayList<Shipment>();
        }
        return this.shipment;
    }

}
