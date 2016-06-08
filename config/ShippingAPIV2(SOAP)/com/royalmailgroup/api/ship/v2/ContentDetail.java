
package com.royalmailgroup.api.ship.v2;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.cm.common.v4.Dimension;
import com.royalmailgroup.cm.referencedata.v3.CountryType;
import com.royalmailgroup.cm.referencedata.v3.ReferenceDataType;


/**
 * schema to hold details of a parcel contents
 * 
 * <p>Java class for contentDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contentDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="countryOfManufacture" type="{http://www.royalmailgroup.com/cm/referenceData/V3}countryType" minOccurs="0"/>
 *         &lt;element name="manufacturersName" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}shortDescription"/>
 *         &lt;element name="unitWeight" type="{http://www.royalmailgroup.com/cm/common/V4}dimension"/>
 *         &lt;element name="unitQuantity" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}integer"/>
 *         &lt;element name="unitValue" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}decimal"/>
 *         &lt;element name="currencyCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType" minOccurs="0"/>
 *         &lt;element name="tariffCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType" minOccurs="0"/>
 *         &lt;element name="tariffDescription" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType" minOccurs="0"/>
 *         &lt;element name="articleReference" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contentDetail", propOrder = {
    "countryOfManufacture",
    "manufacturersName",
    "description",
    "unitWeight",
    "unitQuantity",
    "unitValue",
    "currencyCode",
    "tariffCode",
    "tariffDescription",
    "articleReference"
})
public class ContentDetail {

    protected CountryType countryOfManufacture;
    protected String manufacturersName;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected Dimension unitWeight;
    @XmlElement(required = true)
    protected BigInteger unitQuantity;
    @XmlElement(required = true)
    protected BigDecimal unitValue;
    protected ReferenceDataType currencyCode;
    protected ReferenceDataType tariffCode;
    protected ReferenceDataType tariffDescription;
    protected String articleReference;

    /**
     * Gets the value of the countryOfManufacture property.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getCountryOfManufacture() {
        return countryOfManufacture;
    }

    /**
     * Sets the value of the countryOfManufacture property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setCountryOfManufacture(CountryType value) {
        this.countryOfManufacture = value;
    }

    /**
     * Gets the value of the manufacturersName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturersName() {
        return manufacturersName;
    }

    /**
     * Sets the value of the manufacturersName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturersName(String value) {
        this.manufacturersName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the unitWeight property.
     * 
     * @return
     *     possible object is
     *     {@link Dimension }
     *     
     */
    public Dimension getUnitWeight() {
        return unitWeight;
    }

    /**
     * Sets the value of the unitWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dimension }
     *     
     */
    public void setUnitWeight(Dimension value) {
        this.unitWeight = value;
    }

    /**
     * Gets the value of the unitQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUnitQuantity() {
        return unitQuantity;
    }

    /**
     * Sets the value of the unitQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUnitQuantity(BigInteger value) {
        this.unitQuantity = value;
    }

    /**
     * Gets the value of the unitValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitValue() {
        return unitValue;
    }

    /**
     * Sets the value of the unitValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitValue(BigDecimal value) {
        this.unitValue = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setCurrencyCode(ReferenceDataType value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the tariffCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getTariffCode() {
        return tariffCode;
    }

    /**
     * Sets the value of the tariffCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setTariffCode(ReferenceDataType value) {
        this.tariffCode = value;
    }

    /**
     * Gets the value of the tariffDescription property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getTariffDescription() {
        return tariffDescription;
    }

    /**
     * Sets the value of the tariffDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setTariffDescription(ReferenceDataType value) {
        this.tariffDescription = value;
    }

    /**
     * Gets the value of the articleReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleReference() {
        return articleReference;
    }

    /**
     * Sets the value of the articleReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleReference(String value) {
        this.articleReference = value;
    }

}
