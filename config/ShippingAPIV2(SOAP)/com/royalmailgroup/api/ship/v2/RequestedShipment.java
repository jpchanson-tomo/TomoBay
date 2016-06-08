
package com.royalmailgroup.api.ship.v2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.royalmailgroup.cm.common.v4.Address;
import com.royalmailgroup.cm.referencedata.v3.BFPOFormatType;
import com.royalmailgroup.cm.referencedata.v3.ReferenceDataType;
import com.royalmailgroup.cm.referencedata.v3.ServiceFormatType;
import com.royalmailgroup.cm.referencedata.v3.ServiceOfferingType;


/**
 * schema to hold the details for the shipment
 * 
 * <p>Java class for requestedShipment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestedShipment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="shipmentType" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType" minOccurs="0"/>
 *         &lt;element name="serviceOccurrence" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}ordinal" minOccurs="0"/>
 *         &lt;element name="serviceType" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType" minOccurs="0"/>
 *         &lt;element name="serviceOffering" type="{http://www.royalmailgroup.com/cm/referenceData/V3}serviceOfferingType" minOccurs="0"/>
 *         &lt;element name="serviceFormat" type="{http://www.royalmailgroup.com/cm/referenceData/V3}serviceFormatType" minOccurs="0"/>
 *         &lt;element name="bfpoFormat" type="{http://www.royalmailgroup.com/cm/referenceData/V3}bFPOFormatType" minOccurs="0"/>
 *         &lt;element name="serviceEnhancements" type="{http://www.royalmailgroup.com/api/ship/V2}serviceEnhancements" minOccurs="0"/>
 *         &lt;element name="signature" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}boolean" minOccurs="0"/>
 *         &lt;element name="shippingDate" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}date" minOccurs="0"/>
 *         &lt;element name="recipientContact" type="{http://www.royalmailgroup.com/api/ship/V2}contact" minOccurs="0"/>
 *         &lt;element name="recipientAddress" type="{http://www.royalmailgroup.com/cm/common/V4}address" minOccurs="0"/>
 *         &lt;element name="items" type="{http://www.royalmailgroup.com/api/ship/V2}items" minOccurs="0"/>
 *         &lt;element name="departmentReference" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="customerReference" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="senderReference" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="safePlace" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}comment" minOccurs="0"/>
 *         &lt;element name="importerContact" type="{http://www.royalmailgroup.com/api/ship/V2}contact" minOccurs="0"/>
 *         &lt;element name="importerAddress" type="{http://www.royalmailgroup.com/cm/common/V4}address" minOccurs="0"/>
 *         &lt;element name="exporterContact" type="{http://www.royalmailgroup.com/api/ship/V2}contact" minOccurs="0"/>
 *         &lt;element name="exporterAddress" type="{http://www.royalmailgroup.com/cm/common/V4}address" minOccurs="0"/>
 *         &lt;element name="internationalInfo" type="{http://www.royalmailgroup.com/api/ship/V2}internationalInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestedShipment", propOrder = {
    "shipmentType",
    "serviceOccurrence",
    "serviceType",
    "serviceOffering",
    "serviceFormat",
    "bfpoFormat",
    "serviceEnhancements",
    "signature",
    "shippingDate",
    "recipientContact",
    "recipientAddress",
    "items",
    "departmentReference",
    "customerReference",
    "senderReference",
    "safePlace",
    "importerContact",
    "importerAddress",
    "exporterContact",
    "exporterAddress",
    "internationalInfo"
})
public class RequestedShipment {

    protected ReferenceDataType shipmentType;
    protected BigInteger serviceOccurrence;
    protected ReferenceDataType serviceType;
    protected ServiceOfferingType serviceOffering;
    protected ServiceFormatType serviceFormat;
    protected BFPOFormatType bfpoFormat;
    protected ServiceEnhancements serviceEnhancements;
    protected Boolean signature;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar shippingDate;
    protected Contact recipientContact;
    protected Address recipientAddress;
    protected Items items;
    protected String departmentReference;
    protected String customerReference;
    protected String senderReference;
    protected String safePlace;
    protected Contact importerContact;
    protected Address importerAddress;
    protected Contact exporterContact;
    protected Address exporterAddress;
    protected InternationalInfo internationalInfo;

    /**
     * Gets the value of the shipmentType property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getShipmentType() {
        return shipmentType;
    }

    /**
     * Sets the value of the shipmentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setShipmentType(ReferenceDataType value) {
        this.shipmentType = value;
    }

    /**
     * Gets the value of the serviceOccurrence property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getServiceOccurrence() {
        return serviceOccurrence;
    }

    /**
     * Sets the value of the serviceOccurrence property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setServiceOccurrence(BigInteger value) {
        this.serviceOccurrence = value;
    }

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setServiceType(ReferenceDataType value) {
        this.serviceType = value;
    }

    /**
     * Gets the value of the serviceOffering property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceOfferingType }
     *     
     */
    public ServiceOfferingType getServiceOffering() {
        return serviceOffering;
    }

    /**
     * Sets the value of the serviceOffering property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceOfferingType }
     *     
     */
    public void setServiceOffering(ServiceOfferingType value) {
        this.serviceOffering = value;
    }

    /**
     * Gets the value of the serviceFormat property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceFormatType }
     *     
     */
    public ServiceFormatType getServiceFormat() {
        return serviceFormat;
    }

    /**
     * Sets the value of the serviceFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceFormatType }
     *     
     */
    public void setServiceFormat(ServiceFormatType value) {
        this.serviceFormat = value;
    }

    /**
     * Gets the value of the bfpoFormat property.
     * 
     * @return
     *     possible object is
     *     {@link BFPOFormatType }
     *     
     */
    public BFPOFormatType getBfpoFormat() {
        return bfpoFormat;
    }

    /**
     * Sets the value of the bfpoFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BFPOFormatType }
     *     
     */
    public void setBfpoFormat(BFPOFormatType value) {
        this.bfpoFormat = value;
    }

    /**
     * Gets the value of the serviceEnhancements property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceEnhancements }
     *     
     */
    public ServiceEnhancements getServiceEnhancements() {
        return serviceEnhancements;
    }

    /**
     * Sets the value of the serviceEnhancements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceEnhancements }
     *     
     */
    public void setServiceEnhancements(ServiceEnhancements value) {
        this.serviceEnhancements = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSignature(Boolean value) {
        this.signature = value;
    }

    /**
     * Gets the value of the shippingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getShippingDate() {
        return shippingDate;
    }

    /**
     * Sets the value of the shippingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setShippingDate(XMLGregorianCalendar value) {
        this.shippingDate = value;
    }

    /**
     * Gets the value of the recipientContact property.
     * 
     * @return
     *     possible object is
     *     {@link Contact }
     *     
     */
    public Contact getRecipientContact() {
        return recipientContact;
    }

    /**
     * Sets the value of the recipientContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contact }
     *     
     */
    public void setRecipientContact(Contact value) {
        this.recipientContact = value;
    }

    /**
     * Gets the value of the recipientAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getRecipientAddress() {
        return recipientAddress;
    }

    /**
     * Sets the value of the recipientAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setRecipientAddress(Address value) {
        this.recipientAddress = value;
    }

    /**
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link Items }
     *     
     */
    public Items getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link Items }
     *     
     */
    public void setItems(Items value) {
        this.items = value;
    }

    /**
     * Gets the value of the departmentReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartmentReference() {
        return departmentReference;
    }

    /**
     * Sets the value of the departmentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartmentReference(String value) {
        this.departmentReference = value;
    }

    /**
     * Gets the value of the customerReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerReference() {
        return customerReference;
    }

    /**
     * Sets the value of the customerReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerReference(String value) {
        this.customerReference = value;
    }

    /**
     * Gets the value of the senderReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderReference() {
        return senderReference;
    }

    /**
     * Sets the value of the senderReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderReference(String value) {
        this.senderReference = value;
    }

    /**
     * Gets the value of the safePlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSafePlace() {
        return safePlace;
    }

    /**
     * Sets the value of the safePlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSafePlace(String value) {
        this.safePlace = value;
    }

    /**
     * Gets the value of the importerContact property.
     * 
     * @return
     *     possible object is
     *     {@link Contact }
     *     
     */
    public Contact getImporterContact() {
        return importerContact;
    }

    /**
     * Sets the value of the importerContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contact }
     *     
     */
    public void setImporterContact(Contact value) {
        this.importerContact = value;
    }

    /**
     * Gets the value of the importerAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getImporterAddress() {
        return importerAddress;
    }

    /**
     * Sets the value of the importerAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setImporterAddress(Address value) {
        this.importerAddress = value;
    }

    /**
     * Gets the value of the exporterContact property.
     * 
     * @return
     *     possible object is
     *     {@link Contact }
     *     
     */
    public Contact getExporterContact() {
        return exporterContact;
    }

    /**
     * Sets the value of the exporterContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contact }
     *     
     */
    public void setExporterContact(Contact value) {
        this.exporterContact = value;
    }

    /**
     * Gets the value of the exporterAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getExporterAddress() {
        return exporterAddress;
    }

    /**
     * Sets the value of the exporterAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setExporterAddress(Address value) {
        this.exporterAddress = value;
    }

    /**
     * Gets the value of the internationalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link InternationalInfo }
     *     
     */
    public InternationalInfo getInternationalInfo() {
        return internationalInfo;
    }

    /**
     * Sets the value of the internationalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link InternationalInfo }
     *     
     */
    public void setInternationalInfo(InternationalInfo value) {
        this.internationalInfo = value;
    }

}
