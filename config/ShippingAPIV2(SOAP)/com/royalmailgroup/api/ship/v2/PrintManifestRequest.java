
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold request details for printManifest operation
 * 
 * <p>Java class for printManifestRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="printManifestRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.royalmailgroup.com/api/ship/V2}baseRequest">
 *       &lt;choice>
 *         &lt;element name="manifestBatchNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *         &lt;element name="salesOrderNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "printManifestRequest", propOrder = {
    "manifestBatchNumber",
    "salesOrderNumber"
})
public class PrintManifestRequest
    extends BaseRequest
{

    protected String manifestBatchNumber;
    protected String salesOrderNumber;

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
     * Gets the value of the salesOrderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    /**
     * Sets the value of the salesOrderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesOrderNumber(String value) {
        this.salesOrderNumber = value;
    }

}
