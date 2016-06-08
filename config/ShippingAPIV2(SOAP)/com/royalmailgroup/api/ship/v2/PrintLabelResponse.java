
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.royalmailgroup.integration.core.v1.IntegrationFooter;
import com.royalmailgroup.integration.core.v1.IntegrationHeader;


/**
 * schema to hold response details for printLabel operation
 * 
 * <p>Java class for printLabelResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="printLabelResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="integrationHeader" type="{http://www.royalmailgroup.com/integration/core/V1}integrationHeader"/>
 *         &lt;element name="label" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}document" minOccurs="0"/>
 *         &lt;element name="labelImages" type="{http://www.royalmailgroup.com/api/ship/V2}labelImages" minOccurs="0"/>
 *         &lt;element name="labelData" type="{http://www.royalmailgroup.com/api/ship/V2}labelData" minOccurs="0"/>
 *         &lt;element name="outputFormat" type="{http://www.royalmailgroup.com/cm/rmDatatypes/V1}identifier" minOccurs="0"/>
 *         &lt;element name="integrationFooter" type="{http://www.royalmailgroup.com/integration/core/V1}integrationFooter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "printLabelResponse", propOrder = {
    "integrationHeader",
    "label",
    "labelImages",
    "labelData",
    "outputFormat",
    "integrationFooter"
})
public class PrintLabelResponse {

    @XmlElement(required = true)
    protected IntegrationHeader integrationHeader;
    protected byte[] label;
    protected LabelImages labelImages;
    protected LabelData labelData;
    protected String outputFormat;
    protected IntegrationFooter integrationFooter;

    /**
     * Gets the value of the integrationHeader property.
     * 
     * @return
     *     possible object is
     *     {@link IntegrationHeader }
     *     
     */
    public IntegrationHeader getIntegrationHeader() {
        return integrationHeader;
    }

    /**
     * Sets the value of the integrationHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegrationHeader }
     *     
     */
    public void setIntegrationHeader(IntegrationHeader value) {
        this.integrationHeader = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setLabel(byte[] value) {
        this.label = value;
    }

    /**
     * Gets the value of the labelImages property.
     * 
     * @return
     *     possible object is
     *     {@link LabelImages }
     *     
     */
    public LabelImages getLabelImages() {
        return labelImages;
    }

    /**
     * Sets the value of the labelImages property.
     * 
     * @param value
     *     allowed object is
     *     {@link LabelImages }
     *     
     */
    public void setLabelImages(LabelImages value) {
        this.labelImages = value;
    }

    /**
     * Gets the value of the labelData property.
     * 
     * @return
     *     possible object is
     *     {@link LabelData }
     *     
     */
    public LabelData getLabelData() {
        return labelData;
    }

    /**
     * Sets the value of the labelData property.
     * 
     * @param value
     *     allowed object is
     *     {@link LabelData }
     *     
     */
    public void setLabelData(LabelData value) {
        this.labelData = value;
    }

    /**
     * Gets the value of the outputFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputFormat() {
        return outputFormat;
    }

    /**
     * Sets the value of the outputFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputFormat(String value) {
        this.outputFormat = value;
    }

    /**
     * Gets the value of the integrationFooter property.
     * 
     * @return
     *     possible object is
     *     {@link IntegrationFooter }
     *     
     */
    public IntegrationFooter getIntegrationFooter() {
        return integrationFooter;
    }

    /**
     * Sets the value of the integrationFooter property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegrationFooter }
     *     
     */
    public void setIntegrationFooter(IntegrationFooter value) {
        this.integrationFooter = value;
    }

}
