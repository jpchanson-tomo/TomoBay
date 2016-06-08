
package com.royalmailgroup.cm.common.v4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Electronic address such as email or twitter. 
 * 
 * <p>Java class for digitalAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="digitalAddress">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.royalmailgroup.com/cm/common/V4}contactMechanism">
 *       &lt;sequence>
 *         &lt;element name="electronicAddress" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}description"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "digitalAddress", propOrder = {
    "electronicAddress"
})
public class DigitalAddress
    extends ContactMechanism
{

    @XmlElement(required = true)
    protected String electronicAddress;

    /**
     * Gets the value of the electronicAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElectronicAddress() {
        return electronicAddress;
    }

    /**
     * Sets the value of the electronicAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElectronicAddress(String value) {
        this.electronicAddress = value;
    }

}
