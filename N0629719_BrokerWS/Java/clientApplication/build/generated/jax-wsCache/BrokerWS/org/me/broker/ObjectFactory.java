
package org.me.broker;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.me.broker package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BuyShares_QNAME = new QName("http://broker.me.org/", "buyShares");
    private final static QName _DisplayAllResponse_QNAME = new QName("http://broker.me.org/", "displayAllResponse");
    private final static QName _SpAPI_QNAME = new QName("http://broker.me.org/", "spAPI");
    private final static QName _UpdatedPriceResponse_QNAME = new QName("http://broker.me.org/", "updatedPriceResponse");
    private final static QName _BuySharesResponse_QNAME = new QName("http://broker.me.org/", "buySharesResponse");
    private final static QName _DisplayAll_QNAME = new QName("http://broker.me.org/", "displayAll");
    private final static QName _UpdatedPrice_QNAME = new QName("http://broker.me.org/", "updatedPrice");
    private final static QName _GetServerInfoResponse_QNAME = new QName("http://broker.me.org/", "getServerInfoResponse");
    private final static QName _SpAPIResponse_QNAME = new QName("http://broker.me.org/", "spAPIResponse");
    private final static QName _GetServerInfo_QNAME = new QName("http://broker.me.org/", "getServerInfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.me.broker
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetServerInfoResponse }
     * 
     */
    public GetServerInfoResponse createGetServerInfoResponse() {
        return new GetServerInfoResponse();
    }

    /**
     * Create an instance of {@link SpAPIResponse }
     * 
     */
    public SpAPIResponse createSpAPIResponse() {
        return new SpAPIResponse();
    }

    /**
     * Create an instance of {@link GetServerInfo }
     * 
     */
    public GetServerInfo createGetServerInfo() {
        return new GetServerInfo();
    }

    /**
     * Create an instance of {@link BuySharesResponse }
     * 
     */
    public BuySharesResponse createBuySharesResponse() {
        return new BuySharesResponse();
    }

    /**
     * Create an instance of {@link DisplayAll }
     * 
     */
    public DisplayAll createDisplayAll() {
        return new DisplayAll();
    }

    /**
     * Create an instance of {@link UpdatedPrice }
     * 
     */
    public UpdatedPrice createUpdatedPrice() {
        return new UpdatedPrice();
    }

    /**
     * Create an instance of {@link SpAPI }
     * 
     */
    public SpAPI createSpAPI() {
        return new SpAPI();
    }

    /**
     * Create an instance of {@link UpdatedPriceResponse }
     * 
     */
    public UpdatedPriceResponse createUpdatedPriceResponse() {
        return new UpdatedPriceResponse();
    }

    /**
     * Create an instance of {@link DisplayAllResponse }
     * 
     */
    public DisplayAllResponse createDisplayAllResponse() {
        return new DisplayAllResponse();
    }

    /**
     * Create an instance of {@link BuyShares }
     * 
     */
    public BuyShares createBuyShares() {
        return new BuyShares();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuyShares }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://broker.me.org/", name = "buyShares")
    public JAXBElement<BuyShares> createBuyShares(BuyShares value) {
        return new JAXBElement<BuyShares>(_BuyShares_QNAME, BuyShares.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://broker.me.org/", name = "displayAllResponse")
    public JAXBElement<DisplayAllResponse> createDisplayAllResponse(DisplayAllResponse value) {
        return new JAXBElement<DisplayAllResponse>(_DisplayAllResponse_QNAME, DisplayAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpAPI }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://broker.me.org/", name = "spAPI")
    public JAXBElement<SpAPI> createSpAPI(SpAPI value) {
        return new JAXBElement<SpAPI>(_SpAPI_QNAME, SpAPI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatedPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://broker.me.org/", name = "updatedPriceResponse")
    public JAXBElement<UpdatedPriceResponse> createUpdatedPriceResponse(UpdatedPriceResponse value) {
        return new JAXBElement<UpdatedPriceResponse>(_UpdatedPriceResponse_QNAME, UpdatedPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuySharesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://broker.me.org/", name = "buySharesResponse")
    public JAXBElement<BuySharesResponse> createBuySharesResponse(BuySharesResponse value) {
        return new JAXBElement<BuySharesResponse>(_BuySharesResponse_QNAME, BuySharesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://broker.me.org/", name = "displayAll")
    public JAXBElement<DisplayAll> createDisplayAll(DisplayAll value) {
        return new JAXBElement<DisplayAll>(_DisplayAll_QNAME, DisplayAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatedPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://broker.me.org/", name = "updatedPrice")
    public JAXBElement<UpdatedPrice> createUpdatedPrice(UpdatedPrice value) {
        return new JAXBElement<UpdatedPrice>(_UpdatedPrice_QNAME, UpdatedPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServerInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://broker.me.org/", name = "getServerInfoResponse")
    public JAXBElement<GetServerInfoResponse> createGetServerInfoResponse(GetServerInfoResponse value) {
        return new JAXBElement<GetServerInfoResponse>(_GetServerInfoResponse_QNAME, GetServerInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpAPIResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://broker.me.org/", name = "spAPIResponse")
    public JAXBElement<SpAPIResponse> createSpAPIResponse(SpAPIResponse value) {
        return new JAXBElement<SpAPIResponse>(_SpAPIResponse_QNAME, SpAPIResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServerInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://broker.me.org/", name = "getServerInfo")
    public JAXBElement<GetServerInfo> createGetServerInfo(GetServerInfo value) {
        return new JAXBElement<GetServerInfo>(_GetServerInfo_QNAME, GetServerInfo.class, null, value);
    }

}
