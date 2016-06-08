
package com.royalmailgroup.cm.common.v4;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.cm.referencedata.v3.CurrencyType;


/**
 * An amount is the total or two or more quantities; the aggregate. 
 * 
 * <p>Java class for amount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="amount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="creditIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="currency" type="{http://www.royalmailgroup.com/cm/referenceData/V3}currencyType"/>
 *         &lt;element name="value" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "amount", propOrder = {
    "creditIndicator",
    "currency",
    "value"
})
public class Amount {

    protected boolean creditIndicator;
    @XmlElement(required = true)
    protected CurrencyType currency;
    @XmlElement(required = true)
    protected BigDecimal value;

    /**
     * Gets the value of the creditIndicator property.
     * 
     */
    public boolean isCreditIndicator() {
        return creditIndicator;
    }

    /**
     * Sets the value of the creditIndicator property.
     * 
     */
    public void setCreditIndicator(boolean value) {
        this.creditIndicator = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyType }
     *     
     */
    public CurrencyType getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyType }
     *     
     */
    public void setCurrency(CurrencyType value) {
        this.currency = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
