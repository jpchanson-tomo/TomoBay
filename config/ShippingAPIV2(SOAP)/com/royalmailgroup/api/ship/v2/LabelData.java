
package com.royalmailgroup.api.ship.v2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.royalmailgroup.cm.common.v4.Address;


/**
 * schema to hold details for the 2D Data Matrix
 * 
 * <p>Java class for labelData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="labelData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="upuCode" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *         &lt;element name="informationTypeID" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *         &lt;element name="versionID" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}integer"/>
 *         &lt;element name="format" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *         &lt;element name="class" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="mailType" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *         &lt;element name="itemID" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *         &lt;element name="checkDigit" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}integer"/>
 *         &lt;element name="itemWeight" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}integer"/>
 *         &lt;element name="weightType" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *         &lt;element name="product" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *         &lt;element name="typeOfItem" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="trackingNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="destinationPostcodeDPS" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="returnToSenderPostcode" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="requiredAtDelivery" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="reservedBIV" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="reservedBIVK" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="spareCapacity" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}shortDescription" minOccurs="0"/>
 *         &lt;element name="buildingNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}integer" minOccurs="0"/>
 *         &lt;element name="buildingName" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}name" minOccurs="0"/>
 *         &lt;element name="dateOfShipment" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}date"/>
 *         &lt;element name="recipientContact" type="{http://www.royalmailgroup.com/api/ship/V2}contact" minOccurs="0"/>
 *         &lt;element name="recipientAddress" type="{http://www.royalmailgroup.com/cm/common/V4}address" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "labelData", propOrder = {
    "upuCode",
    "informationTypeID",
    "versionID",
    "format",
    "clazz",
    "mailType",
    "itemID",
    "checkDigit",
    "itemWeight",
    "weightType",
    "product",
    "typeOfItem",
    "trackingNumber",
    "destinationPostcodeDPS",
    "returnToSenderPostcode",
    "requiredAtDelivery",
    "reservedBIV",
    "reservedBIVK",
    "spareCapacity",
    "buildingNumber",
    "buildingName",
    "dateOfShipment",
    "recipientContact",
    "recipientAddress"
})
public class LabelData {

    @XmlElement(required = true)
    protected String upuCode;
    @XmlElement(required = true)
    protected String informationTypeID;
    @XmlElement(required = true)
    protected BigInteger versionID;
    @XmlElement(required = true)
    protected String format;
    @XmlElement(name = "class")
    protected String clazz;
    @XmlElement(required = true)
    protected String mailType;
    @XmlElement(required = true)
    protected String itemID;
    @XmlElement(required = true)
    protected BigInteger checkDigit;
    @XmlElement(required = true)
    protected BigInteger itemWeight;
    @XmlElement(required = true)
    protected String weightType;
    @XmlElement(required = true)
    protected String product;
    protected String typeOfItem;
    protected String trackingNumber;
    protected String destinationPostcodeDPS;
    protected String returnToSenderPostcode;
    protected String requiredAtDelivery;
    protected String reservedBIV;
    protected String reservedBIVK;
    protected String spareCapacity;
    protected BigInteger buildingNumber;
    protected String buildingName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfShipment;
    protected Contact recipientContact;
    protected Address recipientAddress;

    /**
     * Gets the value of the upuCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpuCode() {
        return upuCode;
    }

    /**
     * Sets the value of the upuCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpuCode(String value) {
        this.upuCode = value;
    }

    /**
     * Gets the value of the informationTypeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInformationTypeID() {
        return informationTypeID;
    }

    /**
     * Sets the value of the informationTypeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInformationTypeID(String value) {
        this.informationTypeID = value;
    }

    /**
     * Gets the value of the versionID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVersionID() {
        return versionID;
    }

    /**
     * Sets the value of the versionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVersionID(BigInteger value) {
        this.versionID = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the mailType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailType() {
        return mailType;
    }

    /**
     * Sets the value of the mailType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailType(String value) {
        this.mailType = value;
    }

    /**
     * Gets the value of the itemID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * Sets the value of the itemID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemID(String value) {
        this.itemID = value;
    }

    /**
     * Gets the value of the checkDigit property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCheckDigit() {
        return checkDigit;
    }

    /**
     * Sets the value of the checkDigit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCheckDigit(BigInteger value) {
        this.checkDigit = value;
    }

    /**
     * Gets the value of the itemWeight property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getItemWeight() {
        return itemWeight;
    }

    /**
     * Sets the value of the itemWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setItemWeight(BigInteger value) {
        this.itemWeight = value;
    }

    /**
     * Gets the value of the weightType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeightType() {
        return weightType;
    }

    /**
     * Sets the value of the weightType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeightType(String value) {
        this.weightType = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduct(String value) {
        this.product = value;
    }

    /**
     * Gets the value of the typeOfItem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeOfItem() {
        return typeOfItem;
    }

    /**
     * Sets the value of the typeOfItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeOfItem(String value) {
        this.typeOfItem = value;
    }

    /**
     * Gets the value of the trackingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * Sets the value of the trackingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackingNumber(String value) {
        this.trackingNumber = value;
    }

    /**
     * Gets the value of the destinationPostcodeDPS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationPostcodeDPS() {
        return destinationPostcodeDPS;
    }

    /**
     * Sets the value of the destinationPostcodeDPS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationPostcodeDPS(String value) {
        this.destinationPostcodeDPS = value;
    }

    /**
     * Gets the value of the returnToSenderPostcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnToSenderPostcode() {
        return returnToSenderPostcode;
    }

    /**
     * Sets the value of the returnToSenderPostcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnToSenderPostcode(String value) {
        this.returnToSenderPostcode = value;
    }

    /**
     * Gets the value of the requiredAtDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequiredAtDelivery() {
        return requiredAtDelivery;
    }

    /**
     * Sets the value of the requiredAtDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequiredAtDelivery(String value) {
        this.requiredAtDelivery = value;
    }

    /**
     * Gets the value of the reservedBIV property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservedBIV() {
        return reservedBIV;
    }

    /**
     * Sets the value of the reservedBIV property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservedBIV(String value) {
        this.reservedBIV = value;
    }

    /**
     * Gets the value of the reservedBIVK property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservedBIVK() {
        return reservedBIVK;
    }

    /**
     * Sets the value of the reservedBIVK property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservedBIVK(String value) {
        this.reservedBIVK = value;
    }

    /**
     * Gets the value of the spareCapacity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpareCapacity() {
        return spareCapacity;
    }

    /**
     * Sets the value of the spareCapacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpareCapacity(String value) {
        this.spareCapacity = value;
    }

    /**
     * Gets the value of the buildingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBuildingNumber() {
        return buildingNumber;
    }

    /**
     * Sets the value of the buildingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBuildingNumber(BigInteger value) {
        this.buildingNumber = value;
    }

    /**
     * Gets the value of the buildingName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * Sets the value of the buildingName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuildingName(String value) {
        this.buildingName = value;
    }

    /**
     * Gets the value of the dateOfShipment property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfShipment() {
        return dateOfShipment;
    }

    /**
     * Sets the value of the dateOfShipment property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfShipment(XMLGregorianCalendar value) {
        this.dateOfShipment = value;
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

}
