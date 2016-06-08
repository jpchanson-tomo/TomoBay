
package com.royalmailgroup.api.ship.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.cm.referencedata.v3.ServiceEnhancementType;


/**
 * schema to hold service enhancements
 * 
 * <p>Java class for serviceEnhancements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serviceEnhancements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enhancementType" type="{http://www.royalmailgroup.com/cm/referenceData/V3}serviceEnhancementType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceEnhancements", propOrder = {
    "enhancementType"
})
public class ServiceEnhancements {

    protected List<ServiceEnhancementType> enhancementType;

    /**
     * Gets the value of the enhancementType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enhancementType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnhancementType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceEnhancementType }
     * 
     * 
     */
    public List<ServiceEnhancementType> getEnhancementType() {
        if (enhancementType == null) {
            enhancementType = new ArrayList<ServiceEnhancementType>();
        }
        return this.enhancementType;
    }

}
