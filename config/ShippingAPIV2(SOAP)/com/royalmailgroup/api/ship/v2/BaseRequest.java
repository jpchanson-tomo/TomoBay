
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.integration.core.v1.IntegrationHeader;


/**
 * schema to hold static elements in ComplexContents
 * 
 * <p>Java class for baseRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="baseRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="integrationHeader" type="{http://www.royalmailgroup.com/integration/core/V1}integrationHeader"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseRequest", propOrder = {
    "integrationHeader"
})
@XmlSeeAlso({
    PrintManifestRequest.class,
    Request1DRangesRequest.class,
    Request2DItemIDRangeRequest.class,
    PrintLabelRequest.class,
    CreateManifestRequest.class,
    CancelShipmentRequest.class,
    CreateShipmentRequest.class,
    UpdateShipmentRequest.class,
    PrintDocumentRequest.class
})
public class BaseRequest {

    @XmlElement(required = true)
    protected IntegrationHeader integrationHeader;

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

}
