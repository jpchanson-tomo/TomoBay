
package com.royalmailgroup.cm.common.v4;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.cm.referencedata.v3.GeospatialPositionType;
import com.royalmailgroup.cm.referencedata.v3.SystemNameType;


/**
 * defines the exact position according to a geo spatial system  
 * 
 * <p>Java class for geoSpatialPosition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="geoSpatialPosition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="geoDeticSystem" type="{http://www.royalmailgroup.com/cm/referenceData/V3}systemNameType"/>
 *         &lt;element name="geoSpatialPositionType" type="{http://www.royalmailgroup.com/cm/referenceData/V3}geospatialPositionType" minOccurs="0"/>
 *         &lt;element name="altitude" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}decimal" minOccurs="0"/>
 *         &lt;element name="longitude" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}geoSpatial" minOccurs="0"/>
 *         &lt;element name="latitude" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}geoSpatial" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "geoSpatialPosition", propOrder = {
    "geoDeticSystem",
    "geoSpatialPositionType",
    "altitude",
    "longitude",
    "latitude"
})
public class GeoSpatialPosition {

    @XmlElement(required = true)
    protected SystemNameType geoDeticSystem;
    protected GeospatialPositionType geoSpatialPositionType;
    protected BigDecimal altitude;
    protected BigDecimal longitude;
    protected BigDecimal latitude;

    /**
     * Gets the value of the geoDeticSystem property.
     * 
     * @return
     *     possible object is
     *     {@link SystemNameType }
     *     
     */
    public SystemNameType getGeoDeticSystem() {
        return geoDeticSystem;
    }

    /**
     * Sets the value of the geoDeticSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemNameType }
     *     
     */
    public void setGeoDeticSystem(SystemNameType value) {
        this.geoDeticSystem = value;
    }

    /**
     * Gets the value of the geoSpatialPositionType property.
     * 
     * @return
     *     possible object is
     *     {@link GeospatialPositionType }
     *     
     */
    public GeospatialPositionType getGeoSpatialPositionType() {
        return geoSpatialPositionType;
    }

    /**
     * Sets the value of the geoSpatialPositionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeospatialPositionType }
     *     
     */
    public void setGeoSpatialPositionType(GeospatialPositionType value) {
        this.geoSpatialPositionType = value;
    }

    /**
     * Gets the value of the altitude property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAltitude() {
        return altitude;
    }

    /**
     * Sets the value of the altitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAltitude(BigDecimal value) {
        this.altitude = value;
    }

    /**
     * Gets the value of the longitude property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLongitude(BigDecimal value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the latitude property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLatitude(BigDecimal value) {
        this.latitude = value;
    }

}
