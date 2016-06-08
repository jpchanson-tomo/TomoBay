
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.cm.common.v4.Address;


/**
 * schema to hold native address and contact details for non-English countries
 * 
 * <p>Java class for localisedAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="localisedAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recipientContact" type="{http://www.royalmailgroup.com/api/ship/V2}contact" minOccurs="0"/>
 *         &lt;element name="recipientAddress" type="{http://www.royalmailgroup.com/cm/common/V4}address" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "localisedAddress", propOrder = {
    "recipientContact",
    "recipientAddress"
})
public class LocalisedAddress {

    protected Contact recipientContact;
    protected Address recipientAddress;

    /**
     * Gets the value of the recipientContact property.
     * 
     * @return
     *     possible object is
     *     {@link Contact }
     *     
     */
    public Contact getRecipientContact() {
        return recipientContact;
    }

    /**
     * Sets the value of the recipientContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contact }
     *     
     */
    public void setRecipientContact(Contact value) {
        this.recipientContact = value;
    }

    /**
     * Gets the value of the recipientAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getRecipientAddress() {
        return recipientAddress;
    }

    /**
     * Sets the value of the recipientAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setRecipientAddress(Address value) {
        this.recipientAddress = value;
    }

}
