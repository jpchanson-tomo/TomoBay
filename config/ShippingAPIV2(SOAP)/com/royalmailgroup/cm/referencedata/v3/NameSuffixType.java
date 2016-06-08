
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Defines the suffix of a name i.e. Jnr, Esq etc.
 * 
 * <p>Java class for nameSuffixType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nameSuffixType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nameSuffixCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nameSuffixType", propOrder = {
    "nameSuffixCode"
})
public class NameSuffixType {

    @XmlElement(required = true)
    protected ReferenceDataType nameSuffixCode;

    /**
     * Gets the value of the nameSuffixCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getNameSuffixCode() {
        return nameSuffixCode;
    }

    /**
     * Sets the value of the nameSuffixCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setNameSuffixCode(ReferenceDataType value) {
        this.nameSuffixCode = value;
    }

}
