
package com.royalmailgroup.api.ship.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.cm.common.v4.Dimension;


/**
 * schema to hold the details for 1D barcoded items
 * 
 * <p>Java class for completedShipments complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="completedShipments">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="weight" type="{http://www.royalmailgroup.com/cm/common/V4}dimension" minOccurs="0"/>
 *         &lt;element name="shipments" type="{http://www.royalmailgroup.com/api/ship/V2}shipments" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "completedShipments", propOrder = {
    "weight",
    "shipments"
})
public class CompletedShipments {

    protected Dimension weight;
    @XmlElement(required = true)
    protected List<Shipments> shipments;

    /**
     * Gets the value of the weight property.
     * 
     * @return
     *     possible object is
     *     {@link Dimension }
     *     
     */
    public Dimension getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dimension }
     *     
     */
    public void setWeight(Dimension value) {
        this.weight = value;
    }

    /**
     * Gets the value of the shipments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Shipments }
     * 
     * 
     */
    public List<Shipments> getShipments() {
        if (shipments == null) {
            shipments = new ArrayList<Shipments>();
        }
        return this.shipments;
    }

}
