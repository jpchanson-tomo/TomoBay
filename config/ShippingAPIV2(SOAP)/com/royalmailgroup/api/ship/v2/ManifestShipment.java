
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.cm.referencedata.v3.ServiceOfferingType;


/**
 * schema to hold shipments manifested and associated service offering
 * 
 * <p>Java class for manifestShipment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="manifestShipment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceOffering" type="{http://www.royalmailgroup.com/cm/referenceData/V3}serviceOfferingType" minOccurs="0"/>
 *         &lt;element name="shipmentNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "manifestShipment", propOrder = {
    "serviceOffering",
    "shipmentNumber"
})
public class ManifestShipment {

    protected ServiceOfferingType serviceOffering;
    @XmlElement(required = true)
    protected String shipmentNumber;

    /**
     * Gets the value of the serviceOffering property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceOfferingType }
     *     
     */
    public ServiceOfferingType getServiceOffering() {
        return serviceOffering;
    }

    /**
     * Sets the value of the serviceOffering property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceOfferingType }
     *     
     */
    public void setServiceOffering(ServiceOfferingType value) {
        this.serviceOffering = value;
    }

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

}
