
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.integration.core.v1.IntegrationFooter;
import com.royalmailgroup.integration.core.v1.IntegrationHeader;


/**
 * <p>Java class for createShipmentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createShipmentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="integrationHeader" type="{http://www.royalmailgroup.com/integration/core/V1}integrationHeader"/>
 *         &lt;element name="completedShipmentInfo" type="{http://www.royalmailgroup.com/api/ship/V2}completedShipmentInfo" minOccurs="0"/>
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
@XmlType(name = "createShipmentResponse", propOrder = {
    "integrationHeader",
    "completedShipmentInfo",
    "integrationFooter"
})
public class CreateShipmentResponse {

    @XmlElement(required = true)
    protected IntegrationHeader integrationHeader;
    protected CompletedShipmentInfo completedShipmentInfo;
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
     * Gets the value of the completedShipmentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CompletedShipmentInfo }
     *     
     */
    public CompletedShipmentInfo getCompletedShipmentInfo() {
        return completedShipmentInfo;
    }

    /**
     * Sets the value of the completedShipmentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletedShipmentInfo }
     *     
     */
    public void setCompletedShipmentInfo(CompletedShipmentInfo value) {
        this.completedShipmentInfo = value;
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
