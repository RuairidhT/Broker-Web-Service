
package org.me.broker;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.netbeans.xml.schema.companyinfo.Company;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BrokerWS", targetNamespace = "http://broker.me.org/")
@XmlSeeAlso({
    org.me.broker.ObjectFactory.class,
    org.netbeans.xml.schema.companyinfo.ObjectFactory.class
})
public interface BrokerWS {


    /**
     * 
     * @param companySymbol
     * @param shareAmount
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buyShares", targetNamespace = "http://broker.me.org/", className = "org.me.broker.BuyShares")
    @ResponseWrapper(localName = "buySharesResponse", targetNamespace = "http://broker.me.org/", className = "org.me.broker.BuySharesResponse")
    @Action(input = "http://broker.me.org/BrokerWS/buySharesRequest", output = "http://broker.me.org/BrokerWS/buySharesResponse")
    public boolean buyShares(
        @WebParam(name = "CompanySymbol", targetNamespace = "")
        String companySymbol,
        @WebParam(name = "shareAmount", targetNamespace = "")
        int shareAmount);

    /**
     * 
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updatedPrice", targetNamespace = "http://broker.me.org/", className = "org.me.broker.UpdatedPrice")
    @ResponseWrapper(localName = "updatedPriceResponse", targetNamespace = "http://broker.me.org/", className = "org.me.broker.UpdatedPriceResponse")
    @Action(input = "http://broker.me.org/BrokerWS/updatedPriceRequest", output = "http://broker.me.org/BrokerWS/updatedPriceResponse")
    public boolean updatedPrice();

    /**
     * 
     * @return
     *     returns java.util.List<org.netbeans.xml.schema.companyinfo.Company>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "displayAll", targetNamespace = "http://broker.me.org/", className = "org.me.broker.DisplayAll")
    @ResponseWrapper(localName = "displayAllResponse", targetNamespace = "http://broker.me.org/", className = "org.me.broker.DisplayAllResponse")
    @Action(input = "http://broker.me.org/BrokerWS/displayAllRequest", output = "http://broker.me.org/BrokerWS/displayAllResponse")
    public List<Company> displayAll();

    /**
     * 
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "spAPI", targetNamespace = "http://broker.me.org/", className = "org.me.broker.SpAPI")
    @ResponseWrapper(localName = "spAPIResponse", targetNamespace = "http://broker.me.org/", className = "org.me.broker.SpAPIResponse")
    @Action(input = "http://broker.me.org/BrokerWS/spAPIRequest", output = "http://broker.me.org/BrokerWS/spAPIResponse")
    public boolean spAPI();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getServerInfo", targetNamespace = "http://broker.me.org/", className = "org.me.broker.GetServerInfo")
    @ResponseWrapper(localName = "getServerInfoResponse", targetNamespace = "http://broker.me.org/", className = "org.me.broker.GetServerInfoResponse")
    @Action(input = "http://broker.me.org/BrokerWS/getServerInfoRequest", output = "http://broker.me.org/BrokerWS/getServerInfoResponse")
    public String getServerInfo();

}