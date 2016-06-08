
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.cm.common.v4.Status;


/**
 * schema to hold details of the response to created shipments
 * 
 * <p>Java class for completedShipmentInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="completedShipmentInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://www.royalmailgroup.com/cm/common/V4}status"/>
 *         &lt;element name="allCompletedShipments" type="{http://www.royalmailgroup.com/api/ship/V2}allCompletedShipments"/>
 *         &lt;element name="requestedShipment" type="{http://www.royalmailgroup.com/api/ship/V2}requestedShipment"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "completedShipmentInfo", propOrder = {
    "status",
    "allCompletedShipments",
    "requestedShipment"
})
public class CompletedShipmentInfo {

    @XmlElement(required = true)
    protected Status status;
    @XmlElement(required = true)
    protected AllCompletedShipments allCompletedShipments;
    @XmlElement(required = true)
    protected RequestedShipment requestedShipment;

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
     * Gets the value of the allCompletedShipments property.
     * 
     * @return
     *     possible object is
     *     {@link AllCompletedShipments }
     *     
     */
    public AllCompletedShipments getAllCompletedShipments() {
        return allCompletedShipments;
    }

    /**
     * Sets the value of the allCompletedShipments property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllCompletedShipments }
     *     
     */
    public void setAllCompletedShipments(AllCompletedShipments value) {
        this.allCompletedShipments = value;
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
