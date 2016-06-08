
package com.royalmailgroup.api.ship.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold array of serviceRanges
 * 
 * <p>Java class for serviceRanges complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serviceRanges">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="serviceRange" type="{http://www.royalmailgroup.com/api/ship/V2}serviceRange"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceRanges", propOrder = {
    "serviceRange"
})
public class ServiceRanges {

    @XmlElement(required = true)
    protected List<ServiceRange> serviceRange;

    /**
     * Gets the value of the serviceRange property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceRange property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceRange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceRange }
     * 
     * 
     */
    public List<ServiceRange> getServiceRange() {
        if (serviceRange == null) {
            serviceRange = new ArrayList<ServiceRange>();
        }
        return this.serviceRange;
    }

}
