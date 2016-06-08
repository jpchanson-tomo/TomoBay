
package com.royalmailgroup.api.ship.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold array of shipments manifested
 * 
 * <p>Java class for manifestShipments complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="manifestShipments">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="manifestShipment" type="{http://www.royalmailgroup.com/api/ship/V2}manifestShipment" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "manifestShipments", propOrder = {
    "manifestShipment"
})
public class ManifestShipments {

    @XmlElement(required = true)
    protected List<ManifestShipment> manifestShipment;

    /**
     * Gets the value of the manifestShipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the manifestShipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getManifestShipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ManifestShipment }
     * 
     * 
     */
    public List<ManifestShipment> getManifestShipment() {
        if (manifestShipment == null) {
            manifestShipment = new ArrayList<ManifestShipment>();
        }
        return this.manifestShipment;
    }

}
