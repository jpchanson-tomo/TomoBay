
package com.royalmailgroup.cm.referencedata.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A unitOfMeasure represents is a definite magnitude of a physical quantity, defined and adopted by convention or by law, that is used as a standard for measurement of the same physical quantity. Any other value of the physical quantity can be expressed as a simple multiple of the unit of measure. For example, length is a physical quantity. The metre is a unit of length that represents a definite predetermined length. When we say 10 metres, we actually mean 10 times the definite predetermined length called “metre”.  
 * 
 * <p>Java class for unitOfMeasureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="unitOfMeasureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="unitOfMeasureCode" type="{http://www.royalmailgroup.com/cm/referenceData/V3}referenceDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unitOfMeasureType", propOrder = {
    "unitOfMeasureCode"
})
public class UnitOfMeasureType {

    @XmlElement(required = true)
    protected ReferenceDataType unitOfMeasureCode;

    /**
     * Gets the value of the unitOfMeasureCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataType }
     *     
     */
    public ReferenceDataType getUnitOfMeasureCode() {
        return unitOfMeasureCode;
    }

    /**
     * Sets the value of the unitOfMeasureCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataType }
     *     
     */
    public void setUnitOfMeasureCode(ReferenceDataType value) {
        this.unitOfMeasureCode = value;
    }

}
