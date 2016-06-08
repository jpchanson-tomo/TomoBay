
package com.royalmailgroup.cm.common.v4;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Standard Format for a telephone number
 * 
 * <p>Java class for telephoneNumber complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="telephoneNumber">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.royalmailgroup.com/cm/common/V4}contactMechanism">
 *       &lt;sequence>
 *         &lt;element name="countryCode" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}integer" minOccurs="0"/>
 *         &lt;element name="areaCode" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}integer" minOccurs="0"/>
 *         &lt;element name="telephoneNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}integer" minOccurs="0"/>
 *         &lt;element name="extensionNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}integer" minOccurs="0"/>
 *         &lt;element name="speedDialNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "telephoneNumber", propOrder = {
    "countryCode",
    "areaCode",
    "telephoneNumber",
    "extensionNumber",
    "speedDialNumber"
})
public class TelephoneNumber
    extends ContactMechanism
{

    protected BigInteger countryCode;
    protected BigInteger areaCode;
    protected BigInteger telephoneNumber;
    protected BigInteger extensionNumber;
    protected BigInteger speedDialNumber;

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCountryCode(BigInteger value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the areaCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAreaCode() {
        return areaCode;
    }

    /**
     * Sets the value of the areaCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAreaCode(BigInteger value) {
        this.areaCode = value;
    }

    /**
     * Gets the value of the telephoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Sets the value of the telephoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTelephoneNumber(BigInteger value) {
        this.telephoneNumber = value;
    }

    /**
     * Gets the value of the extensionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getExtensionNumber() {
        return extensionNumber;
    }

    /**
     * Sets the value of the extensionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setExtensionNumber(BigInteger value) {
        this.extensionNumber = value;
    }

    /**
     * Gets the value of the speedDialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSpeedDialNumber() {
        return speedDialNumber;
    }

    /**
     * Sets the value of the speedDialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSpeedDialNumber(BigInteger value) {
        this.speedDialNumber = value;
    }

}
