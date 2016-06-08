
package com.royalmailgroup.integration.core.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Common integration footer definition
 * 
 * <p>Java class for integrationFooter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="integrationFooter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errors" type="{http://www.royalmailgroup.com/integration/core/V1}errorStructure" minOccurs="0"/>
 *         &lt;element name="warnings" type="{http://www.royalmailgroup.com/integration/core/V1}warningStructure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "integrationFooter", propOrder = {
    "errors",
    "warnings"
})
public class IntegrationFooter {

    protected ErrorStructure errors;
    protected WarningStructure warnings;

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorStructure }
     *     
     */
    public ErrorStructure getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorStructure }
     *     
     */
    public void setErrors(ErrorStructure value) {
        this.errors = value;
    }

    /**
     * Gets the value of the warnings property.
     * 
     * @return
     *     possible object is
     *     {@link WarningStructure }
     *     
     */
    public WarningStructure getWarnings() {
        return warnings;
    }

    /**
     * Sets the value of the warnings property.
     * 
     * @param value
     *     allowed object is
     *     {@link WarningStructure }
     *     
     */
    public void setWarnings(WarningStructure value) {
        this.warnings = value;
    }

}
