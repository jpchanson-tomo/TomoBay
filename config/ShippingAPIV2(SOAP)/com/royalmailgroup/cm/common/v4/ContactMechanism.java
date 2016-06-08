
package com.royalmailgroup.cm.common.v4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.cm.referencedata.v3.ContactMethodType;
import com.royalmailgroup.cm.referencedata.v3.ContactUsageType;


/**
 * The Contact Mechanism object contains the methods and usage for contacting a Party.
 * 
 * <p>Java class for contactMechanism complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contactMechanism">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contactMechanismIdentifier" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="contactMethod" type="{http://www.royalmailgroup.com/cm/referenceData/V3}contactMethodType" minOccurs="0"/>
 *         &lt;element name="contactUsage" type="{http://www.royalmailgroup.com/cm/referenceData/V3}contactUsageType" minOccurs="0"/>
 *         &lt;element name="audit" type="{http://www.royalmailgroup.com/cm/common/V4}audit" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contactMechanism", propOrder = {
    "contactMechanismIdentifier",
    "contactMethod",
    "contactUsage",
    "audit"
})
@XmlSeeAlso({
    TelephoneNumber.class,
    DigitalAddress.class
})
public class ContactMechanism {

    protected String contactMechanismIdentifier;
    protected ContactMethodType contactMethod;
    protected ContactUsageType contactUsage;
    protected Audit audit;

    /**
     * Gets the value of the contactMechanismIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactMechanismIdentifier() {
        return contactMechanismIdentifier;
    }

    /**
     * Sets the value of the contactMechanismIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactMechanismIdentifier(String value) {
        this.contactMechanismIdentifier = value;
    }

    /**
     * Gets the value of the contactMethod property.
     * 
     * @return
     *     possible object is
     *     {@link ContactMethodType }
     *     
     */
    public ContactMethodType getContactMethod() {
        return contactMethod;
    }

    /**
     * Sets the value of the contactMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactMethodType }
     *     
     */
    public void setContactMethod(ContactMethodType value) {
        this.contactMethod = value;
    }

    /**
     * Gets the value of the contactUsage property.
     * 
     * @return
     *     possible object is
     *     {@link ContactUsageType }
     *     
     */
    public ContactUsageType getContactUsage() {
        return contactUsage;
    }

    /**
     * Sets the value of the contactUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactUsageType }
     *     
     */
    public void setContactUsage(ContactUsageType value) {
        this.contactUsage = value;
    }

    /**
     * Gets the value of the audit property.
     * 
     * @return
     *     possible object is
     *     {@link Audit }
     *     
     */
    public Audit getAudit() {
        return audit;
    }

    /**
     * Sets the value of the audit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Audit }
     *     
     */
    public void setAudit(Audit value) {
        this.audit = value;
    }

}
