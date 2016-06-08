
package com.royalmailgroup.api.ship.v2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.cm.referencedata.v3.ServiceOfferingType;


/**
 * schema to hold request details for createManifest operation
 * 
 * <p>Java class for createManifestRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createManifestRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.royalmailgroup.com/api/ship/V2}baseRequest">
 *       &lt;sequence>
 *         &lt;element name="serviceOccurrence" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}ordinal" minOccurs="0"/>
 *         &lt;element name="serviceOffering" type="{http://www.royalmailgroup.com/cm/referenceData/V3}serviceOfferingType" minOccurs="0"/>
 *         &lt;element name="yourDescription" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}comment" minOccurs="0"/>
 *         &lt;element name="yourReference" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createManifestRequest", propOrder = {
    "serviceOccurrence",
    "serviceOffering",
    "yourDescription",
    "yourReference"
})
public class CreateManifestRequest
    extends BaseRequest
{

    protected BigInteger serviceOccurrence;
    protected ServiceOfferingType serviceOffering;
    protected String yourDescription;
    protected String yourReference;

    /**
     * Gets the value of the serviceOccurrence property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getServiceOccurrence() {
        return serviceOccurrence;
    }

    /**
     * Sets the value of the serviceOccurrence property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setServiceOccurrence(BigInteger value) {
        this.serviceOccurrence = value;
    }

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
     * Gets the value of the yourDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYourDescription() {
        return yourDescription;
    }

    /**
     * Sets the value of the yourDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYourDescription(String value) {
        this.yourDescription = value;
    }

    /**
     * Gets the value of the yourReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYourReference() {
        return yourReference;
    }

    /**
     * Sets the value of the yourReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYourReference(String value) {
        this.yourReference = value;
    }

}
