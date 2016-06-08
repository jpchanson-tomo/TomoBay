
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.integration.core.v1.IntegrationFooter;
import com.royalmailgroup.integration.core.v1.IntegrationHeader;


/**
 * schema to hold request details for cancelShipmentResponse operation
 * 
 * <p>Java class for cancelShipmentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cancelShipmentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="integrationHeader" type="{http://www.royalmailgroup.com/integration/core/V1}integrationHeader"/>
 *         &lt;element name="completedCancelInfo" type="{http://www.royalmailgroup.com/api/ship/V2}completedCancelInfo" minOccurs="0"/>
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
@XmlType(name = "cancelShipmentResponse", propOrder = {
    "integrationHeader",
    "completedCancelInfo",
    "integrationFooter"
})
public class CancelShipmentResponse {

    @XmlElement(required = true)
    protected IntegrationHeader integrationHeader;
    protected CompletedCancelInfo completedCancelInfo;
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
     * Gets the value of the completedCancelInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CompletedCancelInfo }
     *     
     */
    public CompletedCancelInfo getCompletedCancelInfo() {
        return completedCancelInfo;
    }

    /**
     * Sets the value of the completedCancelInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletedCancelInfo }
     *     
     */
    public void setCompletedCancelInfo(CompletedCancelInfo value) {
        this.completedCancelInfo = value;
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
