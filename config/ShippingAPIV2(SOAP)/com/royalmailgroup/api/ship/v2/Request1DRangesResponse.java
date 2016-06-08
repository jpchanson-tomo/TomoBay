
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.integration.core.v1.IntegrationFooter;
import com.royalmailgroup.integration.core.v1.IntegrationHeader;


/**
 * schema to hold response details for request1DRangeRequest operation
 * 
 * <p>Java class for request1DRangesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="request1DRangesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="integrationHeader" type="{http://www.royalmailgroup.com/integration/core/V1}integrationHeader"/>
 *         &lt;element name="serviceRanges" type="{http://www.royalmailgroup.com/api/ship/V2}serviceRanges" minOccurs="0"/>
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
@XmlType(name = "request1DRangesResponse", propOrder = {
    "integrationHeader",
    "serviceRanges",
    "integrationFooter"
})
public class Request1DRangesResponse {

    @XmlElement(required = true)
    protected IntegrationHeader integrationHeader;
    protected ServiceRanges serviceRanges;
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
     * Gets the value of the serviceRanges property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceRanges }
     *     
     */
    public ServiceRanges getServiceRanges() {
        return serviceRanges;
    }

    /**
     * Sets the value of the serviceRanges property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceRanges }
     *     
     */
    public void setServiceRanges(ServiceRanges value) {
        this.serviceRanges = value;
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
