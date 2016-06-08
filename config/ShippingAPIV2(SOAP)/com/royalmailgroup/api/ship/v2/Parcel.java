
package com.royalmailgroup.api.ship.v2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.cm.common.v4.Dimension;
import com.royalmailgroup.cm.referencedata.v3.ReferenceDataType;


/**
 * schema to hold details of a single parcel
 * 
 * <p>Java class for parcel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="parcel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="weight" type="{http://www.royalmailgroup.com/cm/common/V4}dimension" minOccurs="0"/>
 *         &lt;element name="length" type="{http://www.royalmailgroup.com/cm/common/V4}dimension" minOccurs="0"/>
 *         &lt;element name="height" type="{http://www.royalmailgroup.com/cm/common/V4}dimension" minOccurs="0"/>
 *         &lt;element name="width" type="{http://www.royalmailgroup.com/cm/common/V4}dimension" minOccurs="0"/>
 *         &lt;element name="purposeOfShipment" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType" minOccurs="0"/>
 *         &lt;element name="explanation" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}description" minOccurs="0"/>
 *         &lt;element name="invoiceNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="exportLicenseNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="certificateNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="contentDetails" type="{http://www.royalmailgroup.com/api/ship/V2}contentDetails" minOccurs="0"/>
 *         &lt;element name="fees" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}decimal" minOccurs="0"/>
 *         &lt;element name="offlineShipments" type="{http://www.royalmailgroup.com/api/ship/V2}shipment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parcel", propOrder = {
    "weight",
    "length",
    "height",
    "width",
    "purposeOfShipment",
    "explanation",
    "invoiceNumber",
    "exportLicenseNumber",
    "certificateNumber",
    "contentDetails",
    "fees",
    "offlineShipments"
})
public class Parcel {

    protected Dimension weight;
    protected Dimension length;
    protected Dimension height;
    protected Dimension width;
    protected ReferenceDataType purposeOfShipment;
    protected String explanation;
    protected String invoiceNumber;
    protected String exportLicenseNumber;
    protected String certificateNumber;
    protected ContentDetails contentDetails;
    protected BigDecimal fees;
    protected List<Shipment> offlineShipments;

    /**
     * Gets the value of the weight property.
     * 
     * @return
     *     possible object is
     *     {@link Dimension }
     *     
     */
    public Dimension getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dimension }
     *     
     */
    public void setWeight(Dimension value) {
        this.weight = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link Dimension }
     *     
     */
    public Dimension getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dimension }
     *     
     */
    public void setLength(Dimension value) {
        this.length = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link Dimension }
     *     
     */
    public Dimension getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dimension }
     *     
     */
    public void setHeight(Dimension value) {
        this.height = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link Dimension }
     *     
     */
    public Dimension getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dimension }
     *     
     */
    public void setWidth(Dimension value) {
        this.width = value;
    }

    /**
     * Gets the value of the purposeOfShipment property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getPurposeOfShipment() {
        return purposeOfShipment;
    }

    /**
     * Sets the value of the purposeOfShipment property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setPurposeOfShipment(ReferenceDataType value) {
        this.purposeOfShipment = value;
    }

    /**
     * Gets the value of the explanation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * Sets the value of the explanation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExplanation(String value) {
        this.explanation = value;
    }

    /**
     * Gets the value of the invoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Sets the value of the invoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceNumber(String value) {
        this.invoiceNumber = value;
    }

    /**
     * Gets the value of the exportLicenseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExportLicenseNumber() {
        return exportLicenseNumber;
    }

    /**
     * Sets the value of the exportLicenseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExportLicenseNumber(String value) {
        this.exportLicenseNumber = value;
    }

    /**
     * Gets the value of the certificateNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateNumber() {
        return certificateNumber;
    }

    /**
     * Sets the value of the certificateNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateNumber(String value) {
        this.certificateNumber = value;
    }

    /**
     * Gets the value of the contentDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ContentDetails }
     *     
     */
    public ContentDetails getContentDetails() {
        return contentDetails;
    }

    /**
     * Sets the value of the contentDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentDetails }
     *     
     */
    public void setContentDetails(ContentDetails value) {
        this.contentDetails = value;
    }

    /**
     * Gets the value of the fees property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFees() {
        return fees;
    }

    /**
     * Sets the value of the fees property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFees(BigDecimal value) {
        this.fees = value;
    }

    /**
     * Gets the value of the offlineShipments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offlineShipments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOfflineShipments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Shipment }
     * 
     * 
     */
    public List<Shipment> getOfflineShipments() {
        if (offlineShipments == null) {
            offlineShipments = new ArrayList<Shipment>();
        }
        return this.offlineShipments;
    }

}
