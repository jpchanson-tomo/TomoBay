
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
 * <p>Java class for parcels complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="parcels">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parcel" type="{http://www.royalmailgroup.com/api/ship/V2}parcel" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parcels", propOrder = {
    "parcel"
})
public class Parcels {

    @XmlElement(required = true)
    protected List<Parcel> parcel;

    /**
     * Gets the value of the parcel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parcel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParcel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Parcel }
     * 
     * 
     */
    public List<Parcel> getParcel() {
        if (parcel == null) {
            parcel = new ArrayList<Parcel>();
        }
        return this.parcel;
    }

}
