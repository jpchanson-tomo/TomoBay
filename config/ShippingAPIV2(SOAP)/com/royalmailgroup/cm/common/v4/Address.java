
package com.royalmailgroup.cm.common.v4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.cm.referencedata.v3.AddressUsageType;
import com.royalmailgroup.cm.referencedata.v3.CountryType;
import com.royalmailgroup.cm.referencedata.v3.CountyType;
import com.royalmailgroup.cm.referencedata.v3.StateOrProvinceType;


/**
 * A postal address is a method of identifying a deliverable Location to the postal service.
 * 
 * <p>Java class for address complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="address">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addressUsageType" type="{http://www.royalmailgroup.com/cm/referenceData/V3}addressUsageType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="domesticIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="buildingName" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}name" minOccurs="0"/>
 *         &lt;element name="buildingNumber" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}integer" minOccurs="0"/>
 *         &lt;element name="addressLine1" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}description" minOccurs="0"/>
 *         &lt;element name="addressLine2" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}description" minOccurs="0"/>
 *         &lt;element name="addressLine3" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}description" minOccurs="0"/>
 *         &lt;element name="addressLine4" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}description" minOccurs="0"/>
 *         &lt;element name="stateOrProvince" type="{http://www.royalmailgroup.com/cm/referenceData/V3}stateOrProvinceType" minOccurs="0"/>
 *         &lt;element name="postTown" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}name" minOccurs="0"/>
 *         &lt;element name="county" type="{http://www.royalmailgroup.com/cm/referenceData/V3}countyType" minOccurs="0"/>
 *         &lt;element name="postcode" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="country" type="{http://www.royalmailgroup.com/cm/referenceData/V3}countryType" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.royalmailgroup.com/cm/common/V4}status" minOccurs="0"/>
 *         &lt;element name="audit" type="{http://www.royalmailgroup.com/cm/common/V4}audit" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address", propOrder = {
    "addressUsageType",
    "domesticIndicator",
    "buildingName",
    "buildingNumber",
    "addressLine1",
    "addressLine2",
    "addressLine3",
    "addressLine4",
    "stateOrProvince",
    "postTown",
    "county",
    "postcode",
    "country",
    "status",
    "audit"
})
public class Address {

    protected List<AddressUsageType> addressUsageType;
    protected Boolean domesticIndicator;
    protected String buildingName;
    protected BigInteger buildingNumber;
    protected String addressLine1;
    protected String addressLine2;
    protected String addressLine3;
    protected String addressLine4;
    protected StateOrProvinceType stateOrProvince;
    protected String postTown;
    protected CountyType county;
    protected String postcode;
    protected CountryType country;
    protected Status status;
    protected Audit audit;

    /**
     * Gets the value of the addressUsageType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressUsageType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressUsageType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressUsageType }
     * 
     * 
     */
    public List<AddressUsageType> getAddressUsageType() {
        if (addressUsageType == null) {
            addressUsageType = new ArrayList<AddressUsageType>();
        }
        return this.addressUsageType;
    }

    /**
     * Gets the value of the domesticIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDomesticIndicator() {
        return domesticIndicator;
    }

    /**
     * Sets the value of the domesticIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDomesticIndicator(Boolean value) {
        this.domesticIndicator = value;
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
     * Gets the value of the addressLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Sets the value of the addressLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine1(String value) {
        this.addressLine1 = value;
    }

    /**
     * Gets the value of the addressLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the value of the addressLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine2(String value) {
        this.addressLine2 = value;
    }

    /**
     * Gets the value of the addressLine3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine3() {
        return addressLine3;
    }

    /**
     * Sets the value of the addressLine3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine3(String value) {
        this.addressLine3 = value;
    }

    /**
     * Gets the value of the addressLine4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine4() {
        return addressLine4;
    }

    /**
     * Sets the value of the addressLine4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine4(String value) {
        this.addressLine4 = value;
    }

    /**
     * Gets the value of the stateOrProvince property.
     * 
     * @return
     *     possible object is
     *     {@link StateOrProvinceType }
     *     
     */
    public StateOrProvinceType getStateOrProvince() {
        return stateOrProvince;
    }

    /**
     * Sets the value of the stateOrProvince property.
     * 
     * @param value
     *     allowed object is
     *     {@link StateOrProvinceType }
     *     
     */
    public void setStateOrProvince(StateOrProvinceType value) {
        this.stateOrProvince = value;
    }

    /**
     * Gets the value of the postTown property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostTown() {
        return postTown;
    }

    /**
     * Sets the value of the postTown property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostTown(String value) {
        this.postTown = value;
    }

    /**
     * Gets the value of the county property.
     * 
     * @return
     *     possible object is
     *     {@link CountyType }
     *     
     */
    public CountyType getCounty() {
        return county;
    }

    /**
     * Sets the value of the county property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountyType }
     *     
     */
    public void setCounty(CountyType value) {
        this.county = value;
    }

    /**
     * Gets the value of the postcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets the value of the postcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostcode(String value) {
        this.postcode = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setCountry(CountryType value) {
        this.country = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the audit property.
     * 
     * @return
     *     possible object is
     *     {@link Audit }
     *     
     */
    public Audit getAudit() {
        return audit;
    }

    /**
     * Sets the value of the audit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Audit }
     *     
     */
    public void setAudit(Audit value) {
        this.audit = value;
    }

}
