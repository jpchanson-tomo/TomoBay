
package com.royalmailgroup.api.ship.v2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold details of manifest
 * 
 * <p>Java class for completedManifestInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="completedManifestInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="manifestBatchNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *         &lt;element name="totalItemCount" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}cardinal"/>
 *         &lt;element name="manifestShipments" type="{http://www.royalmailgroup.com/api/ship/V2}manifestShipments"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "completedManifestInfo", propOrder = {
    "manifestBatchNumber",
    "totalItemCount",
    "manifestShipments"
})
public class CompletedManifestInfo {

    @XmlElement(required = true)
    protected String manifestBatchNumber;
    @XmlElement(required = true)
    protected BigInteger totalItemCount;
    @XmlElement(required = true)
    protected ManifestShipments manifestShipments;

    /**
     * Gets the value of the manifestBatchNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManifestBatchNumber() {
        return manifestBatchNumber;
    }

    /**
     * Sets the value of the manifestBatchNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManifestBatchNumber(String value) {
        this.manifestBatchNumber = value;
    }

    /**
     * Gets the value of the totalItemCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalItemCount() {
        return totalItemCount;
    }

    /**
     * Sets the value of the totalItemCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalItemCount(BigInteger value) {
        this.totalItemCount = value;
    }

    /**
     * Gets the value of the manifestShipments property.
     * 
     * @return
     *     possible object is
     *     {@link ManifestShipments }
     *     
     */
    public ManifestShipments getManifestShipments() {
        return manifestShipments;
    }

    /**
     * Sets the value of the manifestShipments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManifestShipments }
     *     
     */
    public void setManifestShipments(ManifestShipments value) {
        this.manifestShipments = value;
    }

}
