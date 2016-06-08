
package com.royalmailgroup.api.ship.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * schema to hold array of manifest details
 * 
 * <p>Java class for completedManifests complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="completedManifests">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="completedManifestInfo" type="{http://www.royalmailgroup.com/api/ship/V2}completedManifestInfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "completedManifests", propOrder = {
    "completedManifestInfo"
})
public class CompletedManifests {

    @XmlElement(required = true)
    protected List<CompletedManifestInfo> completedManifestInfo;

    /**
     * Gets the value of the completedManifestInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the completedManifestInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompletedManifestInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompletedManifestInfo }
     * 
     * 
     */
    public List<CompletedManifestInfo> getCompletedManifestInfo() {
        if (completedManifestInfo == null) {
            completedManifestInfo = new ArrayList<CompletedManifestInfo>();
        }
        return this.completedManifestInfo;
    }

}
