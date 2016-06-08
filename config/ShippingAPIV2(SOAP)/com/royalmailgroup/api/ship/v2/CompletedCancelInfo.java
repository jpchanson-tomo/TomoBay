
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.cm.common.v4.Status;


/**
 * schema to hold array of cancelled shipments
 * 
 * <p>Java class for completedCancelInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="completedCancelInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://www.royalmailgroup.com/cm/common/V4}status" minOccurs="0"/>
 *         &lt;element name="completedCancelShipments" type="{http://www.royalmailgroup.com/api/ship/V2}completedCancelShipments" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "completedCancelInfo", propOrder = {
    "status",
    "completedCancelShipments"
})
public class CompletedCancelInfo {

    protected Status status;
    protected CompletedCancelShipments completedCancelShipments;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the completedCancelShipments property.
     * 
     * @return
     *     possible object is
     *     {@link CompletedCancelShipments }
     *     
     */
    public CompletedCancelShipments getCompletedCancelShipments() {
        return completedCancelShipments;
    }

    /**
     * Sets the value of the completedCancelShipments property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletedCancelShipments }
     *     
     */
    public void setCompletedCancelShipments(CompletedCancelShipments value) {
        this.completedCancelShipments = value;
    }

}
