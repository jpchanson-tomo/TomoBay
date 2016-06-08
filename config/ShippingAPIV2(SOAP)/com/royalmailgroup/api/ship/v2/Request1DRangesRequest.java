
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold request details for request1DRangeRequest operation
 * 
 * <p>Java class for request1DRangesRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="request1DRangesRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.royalmailgroup.com/api/ship/V2}baseRequest">
 *       &lt;sequence>
 *         &lt;element name="serviceReferences" type="{http://www.royalmailgroup.com/api/ship/V2}serviceReferences"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "request1DRangesRequest", propOrder = {
    "serviceReferences"
})
public class Request1DRangesRequest
    extends BaseRequest
{

    @XmlElement(required = true)
    protected ServiceReferences serviceReferences;

    /**
     * Gets the value of the serviceReferences property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceReferences }
     *     
     */
    public ServiceReferences getServiceReferences() {
        return serviceReferences;
    }

    /**
     * Sets the value of the serviceReferences property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceReferences }
     *     
     */
    public void setServiceReferences(ServiceReferences value) {
        this.serviceReferences = value;
    }

}
