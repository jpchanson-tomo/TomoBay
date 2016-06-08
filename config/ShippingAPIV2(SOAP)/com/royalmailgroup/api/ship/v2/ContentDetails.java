
package com.royalmailgroup.api.ship.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold array of single parcel structures
 * 
 * <p>Java class for contentDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contentDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contentDetail" type="{http://www.royalmailgroup.com/api/ship/V2}contentDetail" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contentDetails", propOrder = {
    "contentDetail"
})
public class ContentDetails {

    @XmlElement(required = true)
    protected List<ContentDetail> contentDetail;

    /**
     * Gets the value of the contentDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentDetail }
     * 
     * 
     */
    public List<ContentDetail> getContentDetail() {
        if (contentDetail == null) {
            contentDetail = new ArrayList<ContentDetail>();
        }
        return this.contentDetail;
    }

}
