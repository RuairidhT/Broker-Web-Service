
package docwebservices;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CurrencyConversionWS", targetNamespace = "http://DOCwebServices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CurrencyConversionWS {


    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod(operationName = "GetCurrencyCodes")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetCurrencyCodes", targetNamespace = "http://DOCwebServices/", className = "docwebservices.GetCurrencyCodes")
    @ResponseWrapper(localName = "GetCurrencyCodesResponse", targetNamespace = "http://DOCwebServices/", className = "docwebservices.GetCurrencyCodesResponse")
    @Action(input = "http://DOCwebServices/CurrencyConversionWS/GetCurrencyCodesRequest", output = "http://DOCwebServices/CurrencyConversionWS/GetCurrencyCodesResponse")
    public List<String> getCurrencyCodes();

    /**
     * 
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "runAPI", targetNamespace = "http://DOCwebServices/", className = "docwebservices.RunAPI")
    @ResponseWrapper(localName = "runAPIResponse", targetNamespace = "http://DOCwebServices/", className = "docwebservices.RunAPIResponse")
    @Action(input = "http://DOCwebServices/CurrencyConversionWS/runAPIRequest", output = "http://DOCwebServices/CurrencyConversionWS/runAPIResponse")
    public boolean runAPI();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod(operationName = "GetConversionRate")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetConversionRate", targetNamespace = "http://DOCwebServices/", className = "docwebservices.GetConversionRate")
    @ResponseWrapper(localName = "GetConversionRateResponse", targetNamespace = "http://DOCwebServices/", className = "docwebservices.GetConversionRateResponse")
    @Action(input = "http://DOCwebServices/CurrencyConversionWS/GetConversionRateRequest", output = "http://DOCwebServices/CurrencyConversionWS/GetConversionRateResponse")
    public double getConversionRate(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

}
