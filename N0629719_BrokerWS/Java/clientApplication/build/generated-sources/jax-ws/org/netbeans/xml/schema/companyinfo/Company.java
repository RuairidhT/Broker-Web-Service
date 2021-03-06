
package org.netbeans.xml.schema.companyinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for company complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="company">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="share_availability" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="share_price" type="{http://xml.netbeans.org/schema/CompanyInfo}share_price"/>
 *         &lt;element name="company_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="company_symbol" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "company", propOrder = {
    "shareAvailability",
    "sharePrice",
    "companyName",
    "companySymbol"
})
public class Company {

    @XmlElement(name = "share_availability")
    protected int shareAvailability;
    @XmlElement(name = "share_price", required = true)
    protected SharePrice sharePrice;
    @XmlElement(name = "company_name", required = true)
    protected String companyName;
    @XmlElement(name = "company_symbol", required = true)
    protected String companySymbol;

    /**
     * Gets the value of the shareAvailability property.
     * 
     */
    public int getShareAvailability() {
        return shareAvailability;
    }

    /**
     * Sets the value of the shareAvailability property.
     * 
     */
    public void setShareAvailability(int value) {
        this.shareAvailability = value;
    }

    /**
     * Gets the value of the sharePrice property.
     * 
     * @return
     *     possible object is
     *     {@link SharePrice }
     *     
     */
    public SharePrice getSharePrice() {
        return sharePrice;
    }

    /**
     * Sets the value of the sharePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link SharePrice }
     *     
     */
    public void setSharePrice(SharePrice value) {
        this.sharePrice = value;
    }

    /**
     * Gets the value of the companyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * Gets the value of the companySymbol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanySymbol() {
        return companySymbol;
    }

    /**
     * Sets the value of the companySymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanySymbol(String value) {
        this.companySymbol = value;
    }

}
