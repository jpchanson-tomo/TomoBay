
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold an array of shipment numbers
 * 
 * <p>Java class for labelImages complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="labelImages">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="image1DBarcode" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}document"/>
 *         &lt;element name="image2DMatrix" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}twoDBarcode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "labelImages", propOrder = {
    "image1DBarcode",
    "image2DMatrix"
})
public class LabelImages {

    @XmlElement(required = true)
    protected byte[] image1DBarcode;
    @XmlElement(required = true)
    protected byte[] image2DMatrix;

    /**
     * Gets the value of the image1DBarcode property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getImage1DBarcode() {
        return image1DBarcode;
    }

    /**
     * Sets the value of the image1DBarcode property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setImage1DBarcode(byte[] value) {
        this.image1DBarcode = value;
    }

    /**
     * Gets the value of the image2DMatrix property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getImage2DMatrix() {
        return image2DMatrix;
    }

    /**
     * Sets the value of the image2DMatrix property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setImage2DMatrix(byte[] value) {
        this.image2DMatrix = value;
    }

}
