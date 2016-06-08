
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Only for international shipments
 * 
 * <p>Java class for internationalInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="internationalInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parcels" type="{http://www.royalmailgroup.com/api/ship/V2}parcels" minOccurs="0"/>
 *         &lt;element name="shipperExporterVatNo" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="recipientImporterVatNo" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="originalExportShipmentNo" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="documentsOnly" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}boolean" minOccurs="0"/>
 *         &lt;element name="documentsDescription" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}shortDescription" minOccurs="0"/>
 *         &lt;element name="shipmentDescription" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}shortDescription" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}longDescription" minOccurs="0"/>
 *         &lt;element name="invoiceDate" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}date" minOccurs="0"/>
 *         &lt;element name="termsOfDelivery" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}longDescription" minOccurs="0"/>
 *         &lt;element name="purchaseOrderRef" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "internationalInfo", propOrder = {
    "parcels",
    "shipperExporterVatNo",
    "recipientImporterVatNo",
    "originalExportShipmentNo",
    "documentsOnly",
    "documentsDescription",
    "shipmentDescription",
    "comments",
    "invoiceDate",
    "termsOfDelivery",
    "purchaseOrderRef"
})
public class InternationalInfo {

    protected Parcels parcels;
    protected String shipperExporterVatNo;
    protected String recipientImporterVatNo;
    protected String originalExportShipmentNo;
    protected Boolean documentsOnly;
    protected String documentsDescription;
    protected String shipmentDescription;
    protected String comments;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar invoiceDate;
    protected String termsOfDelivery;
    protected String purchaseOrderRef;

    /**
     * Gets the value of the parcels property.
     * 
     * @return
     *     possible object is
     *     {@link Parcels }
     *     
     */
    public Parcels getParcels() {
        return parcels;
    }

    /**
     * Sets the value of the parcels property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parcels }
     *     
     */
    public void setParcels(Parcels value) {
        this.parcels = value;
    }

    /**
     * Gets the value of the shipperExporterVatNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipperExporterVatNo() {
        return shipperExporterVatNo;
    }

    /**
     * Sets the value of the shipperExporterVatNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipperExporterVatNo(String value) {
        this.shipperExporterVatNo = value;
    }

    /**
     * Gets the value of the recipientImporterVatNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientImporterVatNo() {
        return recipientImporterVatNo;
    }

    /**
     * Sets the value of the recipientImporterVatNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientImporterVatNo(String value) {
        this.recipientImporterVatNo = value;
    }

    /**
     * Gets the value of the originalExportShipmentNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalExportShipmentNo() {
        return originalExportShipmentNo;
    }

    /**
     * Sets the value of the originalExportShipmentNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalExportShipmentNo(String value) {
        this.originalExportShipmentNo = value;
    }

    /**
     * Gets the value of the documentsOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDocumentsOnly() {
        return documentsOnly;
    }

    /**
     * Sets the value of the documentsOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDocumentsOnly(Boolean value) {
        this.documentsOnly = value;
    }

    /**
     * Gets the value of the documentsDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentsDescription() {
        return documentsDescription;
    }

    /**
     * Sets the value of the documentsDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentsDescription(String value) {
        this.documentsDescription = value;
    }

    /**
     * Gets the value of the shipmentDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipmentDescription() {
        return shipmentDescription;
    }

    /**
     * Sets the value of the shipmentDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipmentDescription(String value) {
        this.shipmentDescription = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the invoiceDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * Sets the value of the invoiceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInvoiceDate(XMLGregorianCalendar value) {
        this.invoiceDate = value;
    }

    /**
     * Gets the value of the termsOfDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermsOfDelivery() {
        return termsOfDelivery;
    }

    /**
     * Sets the value of the termsOfDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermsOfDelivery(String value) {
        this.termsOfDelivery = value;
    }

    /**
     * Gets the value of the purchaseOrderRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseOrderRef() {
        return purchaseOrderRef;
    }

    /**
     * Sets the value of the purchaseOrderRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseOrderRef(String value) {
        this.purchaseOrderRef = value;
    }

}
