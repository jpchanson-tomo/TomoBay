
package com.royalmailgroup.api.ship.v2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.cm.common.v4.Dimension;


/**
 * schema to hold quantity and weight of items
 * 
 * <p>Java class for item complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="item">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numberOfItems" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}cardinal" minOccurs="0"/>
 *         &lt;element name="weight" type="{http://www.royalmailgroup.com/cm/common/V4}dimension"/>
 *         &lt;element name="offlineShipments" type="{http://www.royalmailgroup.com/api/ship/V2}shipment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "item", propOrder = {
    "numberOfItems",
    "weight",
    "offlineShipments"
})
public class Item {

    protected BigInteger numberOfItems;
    @XmlElement(required = true)
    protected Dimension weight;
    protected List<Shipment> offlineShipments;

    /**
     * Gets the value of the numberOfItems property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfItems() {
        return numberOfItems;
    }

    /**
     * Sets the value of the numberOfItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfItems(BigInteger value) {
        this.numberOfItems = value;
    }

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
     * Gets the value of the offlineShipments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offlineShipments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOfflineShipments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Shipment }
     * 
     * 
     */
    public List<Shipment> getOfflineShipments() {
        if (offlineShipments == null) {
            offlineShipments = new ArrayList<Shipment>();
        }
        return this.offlineShipments;
    }

}
