
package com.royalmailgroup.api.ship.v2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold request details for printDocument operation
 * 
 * <p>Java class for printDocumentRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="printDocumentRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.royalmailgroup.com/api/ship/V2}baseRequest">
 *       &lt;sequence>
 *         &lt;element name="shipmentNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *         &lt;element name="documentName" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *         &lt;element name="documentFormat" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="documentCopies" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "printDocumentRequest", propOrder = {
    "shipmentNumber",
    "documentName",
    "documentFormat",
    "documentCopies"
})
public class PrintDocumentRequest
    extends BaseRequest
{

    @XmlElement(required = true)
    protected String shipmentNumber;
    @XmlElement(required = true)
    protected String documentName;
    protected String documentFormat;
    protected BigInteger documentCopies;

    /**
     * Gets the value of the shipmentNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipmentNumber() {
        return shipmentNumber;
    }

    /**
     * Sets the value of the shipmentNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipmentNumber(String value) {
        this.shipmentNumber = value;
    }

    /**
     * Gets the value of the documentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentName() {
        return documentName;
    }

    /**
     * Sets the value of the documentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentName(String value) {
        this.documentName = value;
    }

    /**
     * Gets the value of the documentFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentFormat() {
        return documentFormat;
    }

    /**
     * Sets the value of the documentFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentFormat(String value) {
        this.documentFormat = value;
    }

    /**
     * Gets the value of the documentCopies property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDocumentCopies() {
        return documentCopies;
    }

    /**
     * Sets the value of the documentCopies property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDocumentCopies(BigInteger value) {
        this.documentCopies = value;
    }

}
