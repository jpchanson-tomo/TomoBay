
package com.royalmailgroup.api.ship.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold details of cancelled shipments and their associated status
 * 
 * <p>Java class for completedCancelShipments complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="completedCancelShipments">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="shipmentNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "completedCancelShipments", propOrder = {
    "shipmentNumber"
})
public class CompletedCancelShipments {

    @XmlElement(required = true)
    protected List<String> shipmentNumber;

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

}
