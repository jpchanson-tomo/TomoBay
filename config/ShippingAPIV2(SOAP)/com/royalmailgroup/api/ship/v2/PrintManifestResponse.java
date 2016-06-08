
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.integration.core.v1.IntegrationFooter;
import com.royalmailgroup.integration.core.v1.IntegrationHeader;


/**
 * schema to hold response details for printManifest operation. 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;manifest xmlns:com="http://www.royalmailgroup.com/cm/common/V4" xmlns:dt="http://www.royalmailgroup.com/cm/rmDatatypes/V1" xmlns:int="http://www.royalmailgroup.com/integration/core/V1" xmlns:ns="http://www.royalmailgroup.com/api/ship/V2" xmlns:rd="http://www.royalmailgroup.com/cm/referenceData/V3" xmlns:soapext="http://www.royalmailgroup.com/soap/extensions/V1" xmlns:xs="http://www.w3.org/2001/XMLSchema"/&gt;
 * </pre>
 *  is a Base64 encoded PDF Document
 * 			
 * 
 * <p>Java class for printManifestResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="printManifestResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="integrationHeader" type="{http://www.royalmailgroup.com/integration/core/V1}integrationHeader"/>
 *         &lt;element name="manifest" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}document" minOccurs="0"/>
 *         &lt;element name="integrationFooter" type="{http://www.royalmailgroup.com/integration/core/V1}integrationFooter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "printManifestResponse", propOrder = {
    "integrationHeader",
    "manifest",
    "integrationFooter"
})
public class PrintManifestResponse {

    @XmlElement(required = true)
    protected IntegrationHeader integrationHeader;
    protected byte[] manifest;
    protected IntegrationFooter integrationFooter;

    /**
     * Gets the value of the integrationHeader property.
     * 
     * @return
     *     possible object is
     *     {@link IntegrationHeader }
     *     
     */
    public IntegrationHeader getIntegrationHeader() {
        return integrationHeader;
    }

    /**
     * Sets the value of the integrationHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegrationHeader }
     *     
     */
    public void setIntegrationHeader(IntegrationHeader value) {
        this.integrationHeader = value;
    }

    /**
     * Gets the value of the manifest property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getManifest() {
        return manifest;
    }

    /**
     * Sets the value of the manifest property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setManifest(byte[] value) {
        this.manifest = value;
    }

    /**
     * Gets the value of the integrationFooter property.
     * 
     * @return
     *     possible object is
     *     {@link IntegrationFooter }
     *     
     */
    public IntegrationFooter getIntegrationFooter() {
        return integrationFooter;
    }

    /**
     * Sets the value of the integrationFooter property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegrationFooter }
     *     
     */
    public void setIntegrationFooter(IntegrationFooter value) {
        this.integrationFooter = value;
    }

}
