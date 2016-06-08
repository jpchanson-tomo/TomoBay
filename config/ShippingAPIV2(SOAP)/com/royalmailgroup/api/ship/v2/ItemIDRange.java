
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold start and end itemID range
 * 
 * <p>Java class for itemIDRange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="itemIDRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itemIDRangeStart" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *         &lt;element name="itemIDRangeEnd" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemIDRange", propOrder = {
    "itemIDRangeStart",
    "itemIDRangeEnd"
})
public class ItemIDRange {

    @XmlElement(required = true)
    protected String itemIDRangeStart;
    @XmlElement(required = true)
    protected String itemIDRangeEnd;

    /**
     * Gets the value of the itemIDRangeStart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemIDRangeStart() {
        return itemIDRangeStart;
    }

    /**
     * Sets the value of the itemIDRangeStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemIDRangeStart(String value) {
        this.itemIDRangeStart = value;
    }

    /**
     * Gets the value of the itemIDRangeEnd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemIDRangeEnd() {
        return itemIDRangeEnd;
    }

    /**
     * Sets the value of the itemIDRangeEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemIDRangeEnd(String value) {
        this.itemIDRangeEnd = value;
    }

}
