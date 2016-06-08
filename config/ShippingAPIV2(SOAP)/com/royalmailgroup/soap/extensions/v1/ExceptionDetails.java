
package com.royalmailgroup.soap.extensions.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Used to hold the RMG defined data elements associated with the SOAP fault
 * 
 * <p>Java class for exceptionDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exceptionDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exceptionTransactionId" type="{http://www.royalmailgroup.com/integration/core/V1}transactionId"/>
 *         &lt;element name="exceptionCode" type="{http://www.royalmailgroup.com/integration/core/V1}errorCode"/>
 *         &lt;element name="exceptionText" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}description"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exceptionDetails", propOrder = {
    "exceptionTransactionId",
    "exceptionCode",
    "exceptionText"
})
public class ExceptionDetails {

    @XmlElement(required = true)
    protected String exceptionTransactionId;
    @XmlElement(required = true)
    protected String exceptionCode;
    @XmlElement(required = true)
    protected String exceptionText;

    /**
     * Gets the value of the exceptionTransactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionTransactionId() {
        return exceptionTransactionId;
    }

    /**
     * Sets the value of the exceptionTransactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionTransactionId(String value) {
        this.exceptionTransactionId = value;
    }

    /**
     * Gets the value of the exceptionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionCode() {
        return exceptionCode;
    }

    /**
     * Sets the value of the exceptionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionCode(String value) {
        this.exceptionCode = value;
    }

    /**
     * Gets the value of the exceptionText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionText() {
        return exceptionText;
    }

    /**
     * Sets the value of the exceptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionText(String value) {
        this.exceptionText = value;
    }

}
