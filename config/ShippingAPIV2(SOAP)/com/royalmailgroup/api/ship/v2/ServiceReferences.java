
package com.royalmailgroup.api.ship.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold array of service references
 * 
 * <p>Java class for serviceReferences complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serviceReferences">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="serviceReference" type="{http://www.royalmailgroup.com/api/ship/V2}serviceReference"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceReferences", propOrder = {
    "serviceReference"
})
public class ServiceReferences {

    @XmlElement(required = true)
    protected List<ServiceReference> serviceReference;

    /**
     * Gets the value of the serviceReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceReference }
     * 
     * 
     */
    public List<ServiceReference> getServiceReference() {
        if (serviceReference == null) {
            serviceReference = new ArrayList<ServiceReference>();
        }
        return this.serviceReference;
    }

}
