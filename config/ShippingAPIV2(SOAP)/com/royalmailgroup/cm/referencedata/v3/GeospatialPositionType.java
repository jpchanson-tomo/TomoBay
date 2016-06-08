
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Gives context to a Geo Spatial Position i.e. front door, back door, Post Box.
 * 
 * <p>Java class for geospatialPositionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="geospatialPositionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="geospatialPositionCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "geospatialPositionType", propOrder = {
    "geospatialPositionCode"
})
public class GeospatialPositionType {

    @XmlElement(required = true)
    protected ReferenceDataType geospatialPositionCode;

    /**
     * Gets the value of the geospatialPositionCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getGeospatialPositionCode() {
        return geospatialPositionCode;
    }

    /**
     * Sets the value of the geospatialPositionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setGeospatialPositionCode(ReferenceDataType value) {
        this.geospatialPositionCode = value;
    }

}
