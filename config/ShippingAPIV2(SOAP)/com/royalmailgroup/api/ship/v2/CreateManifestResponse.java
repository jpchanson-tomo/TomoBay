
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.integration.core.v1.IntegrationFooter;
import com.royalmailgroup.integration.core.v1.IntegrationHeader;


/**
 * schema to hold response details for createManifest operation
 * 
 * <p>Java class for createManifestResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createManifestResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="integrationHeader" type="{http://www.royalmailgroup.com/integration/core/V1}integrationHeader"/>
 *         &lt;element name="completedManifests" type="{http://www.royalmailgroup.com/api/ship/V2}completedManifests" minOccurs="0"/>
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
@XmlType(name = "createManifestResponse", propOrder = {
    "integrationHeader",
    "completedManifests",
    "integrationFooter"
})
public class CreateManifestResponse {

    @XmlElement(required = true)
    protected IntegrationHeader integrationHeader;
    protected CompletedManifests completedManifests;
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
     * Gets the value of the completedManifests property.
     * 
     * @return
     *     possible object is
     *     {@link CompletedManifests }
     *     
     */
    public CompletedManifests getCompletedManifests() {
        return completedManifests;
    }

    /**
     * Sets the value of the completedManifests property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletedManifests }
     *     
     */
    public void setCompletedManifests(CompletedManifests value) {
        this.completedManifests = value;
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
