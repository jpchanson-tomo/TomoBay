
package com.royalmailgroup.integration.core.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Common integration header definition
 * 
 * <p>Java class for integrationHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="integrationHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateTime" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}dateTime" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}decimal" minOccurs="0"/>
 *         &lt;element name="identification" type="{http://www.royalmailgroup.com/integration/core/V1}identificationStructure"/>
 *         &lt;element name="testFlag" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}boolean" minOccurs="0"/>
 *         &lt;element name="debugFlag" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}boolean" minOccurs="0"/>
 *         &lt;element name="performanceFlag" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "integrationHeader", propOrder = {
    "dateTime",
    "version",
    "identification",
    "testFlag",
    "debugFlag",
    "performanceFlag"
})
public class IntegrationHeader {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;
    protected BigDecimal version;
    @XmlElement(required = true)
    protected IdentificationStructure identification;
    protected Boolean testFlag;
    protected Boolean debugFlag;
    protected Boolean performanceFlag;

    /**
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTime(XMLGregorianCalendar value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVersion(BigDecimal value) {
        this.version = value;
    }

    /**
     * Gets the value of the identification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationStructure }
     *     
     */
    public IdentificationStructure getIdentification() {
        return identification;
    }

    /**
     * Sets the value of the identification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationStructure }
     *     
     */
    public void setIdentification(IdentificationStructure value) {
        this.identification = value;
    }

    /**
     * Gets the value of the testFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTestFlag() {
        return testFlag;
    }

    /**
     * Sets the value of the testFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTestFlag(Boolean value) {
        this.testFlag = value;
    }

    /**
     * Gets the value of the debugFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugFlag() {
        return debugFlag;
    }

    /**
     * Sets the value of the debugFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugFlag(Boolean value) {
        this.debugFlag = value;
    }

    /**
     * Gets the value of the performanceFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPerformanceFlag() {
        return performanceFlag;
    }

    /**
     * Sets the value of the performanceFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPerformanceFlag(Boolean value) {
        this.performanceFlag = value;
    }

}
