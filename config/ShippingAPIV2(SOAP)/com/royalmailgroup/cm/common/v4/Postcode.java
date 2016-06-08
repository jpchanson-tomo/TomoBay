
package com.royalmailgroup.cm.common.v4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * A geospatial categorization of a geographical area.
 * 
 * <p>Java class for postcode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="postcode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="postcodeIdentifier" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="postcode" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.royalmailgroup.com/cm/common/V4}status" minOccurs="0"/>
 *         &lt;element name="audit" type="{http://www.royalmailgroup.com/cm/common/V4}audit" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "postcode", propOrder = {
    "postcodeIdentifier",
    "postcode",
    "status",
    "audit"
})
public class Postcode {

    protected String postcodeIdentifier;
    protected String postcode;
    protected Status status;
    protected Audit audit;

    /**
     * Gets the value of the postcodeIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostcodeIdentifier() {
        return postcodeIdentifier;
    }

    /**
     * Sets the value of the postcodeIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostcodeIdentifier(String value) {
        this.postcodeIdentifier = value;
    }

    /**
     * Gets the value of the postcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets the value of the postcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostcode(String value) {
        this.postcode = value;
    }

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
     * Gets the value of the audit property.
     * 
     * @return
     *     possible object is
     *     {@link Audit }
     *     
     */
    public Audit getAudit() {
        return audit;
    }

    /**
     * Sets the value of the audit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Audit }
     *     
     */
    public void setAudit(Audit value) {
        this.audit = value;
    }

}
