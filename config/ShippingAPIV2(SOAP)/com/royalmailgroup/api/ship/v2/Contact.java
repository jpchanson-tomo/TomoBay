
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.cm.common.v4.DigitalAddress;
import com.royalmailgroup.cm.common.v4.TelephoneNumber;


/**
 * <p>Java class for contact complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contact">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}longName" minOccurs="0"/>
 *         &lt;element ref="{http://www.royalmailgroup.com/api/ship/V2}complementaryName" minOccurs="0"/>
 *         &lt;element name="telephoneNumber" type="{http://www.royalmailgroup.com/cm/common/V4}telephoneNumber" minOccurs="0"/>
 *         &lt;element name="electronicAddress" type="{http://www.royalmailgroup.com/cm/common/V4}digitalAddress" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contact", propOrder = {
    "name",
    "complementaryName",
    "telephoneNumber",
    "electronicAddress"
})
public class Contact {

    protected String name;
    protected String complementaryName;
    protected TelephoneNumber telephoneNumber;
    protected DigitalAddress electronicAddress;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the complementaryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplementaryName() {
        return complementaryName;
    }

    /**
     * Sets the value of the complementaryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplementaryName(String value) {
        this.complementaryName = value;
    }

    /**
     * Gets the value of the telephoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link TelephoneNumber }
     *     
     */
    public TelephoneNumber getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Sets the value of the telephoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link TelephoneNumber }
     *     
     */
    public void setTelephoneNumber(TelephoneNumber value) {
        this.telephoneNumber = value;
    }

    /**
     * Gets the value of the electronicAddress property.
     * 
     * @return
     *     possible object is
     *     {@link DigitalAddress }
     *     
     */
    public DigitalAddress getElectronicAddress() {
        return electronicAddress;
    }

    /**
     * Sets the value of the electronicAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link DigitalAddress }
     *     
     */
    public void setElectronicAddress(DigitalAddress value) {
        this.electronicAddress = value;
    }

}
