
package com.royalmailgroup.api.ship.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * schema containing the choice of 1D or 2D structures
 * 
 * <p>Java class for allCompletedShipments complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="allCompletedShipments">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="completedShipments" type="{http://www.royalmailgroup.com/api/ship/V2}completedShipments" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "allCompletedShipments", propOrder = {
    "completedShipments"
})
public class AllCompletedShipments {

    @XmlElement(required = true)
    protected List<CompletedShipments> completedShipments;

    /**
     * Gets the value of the completedShipments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the completedShipments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompletedShipments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompletedShipments }
     * 
     * 
     */
    public List<CompletedShipments> getCompletedShipments() {
        if (completedShipments == null) {
            completedShipments = new ArrayList<CompletedShipments>();
        }
        return this.completedShipments;
    }

}
