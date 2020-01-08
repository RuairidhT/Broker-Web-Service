
package org.me.broker;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BrokerWS", targetNamespace = "http://broker.me.org/", wsdlLocation = "http://localhost:8080/BrokerWS/BrokerWS?wsdl")
public class BrokerWS_Service
    extends Service
{

    private final static URL BROKERWS_WSDL_LOCATION;
    private final static WebServiceException BROKERWS_EXCEPTION;
    private final static QName BROKERWS_QNAME = new QName("http://broker.me.org/", "BrokerWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/BrokerWS/BrokerWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BROKERWS_WSDL_LOCATION = url;
        BROKERWS_EXCEPTION = e;
    }

    public BrokerWS_Service() {
        super(__getWsdlLocation(), BROKERWS_QNAME);
    }

    public BrokerWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), BROKERWS_QNAME, features);
    }

    public BrokerWS_Service(URL wsdlLocation) {
        super(wsdlLocation, BROKERWS_QNAME);
    }

    public BrokerWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BROKERWS_QNAME, features);
    }

    public BrokerWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BrokerWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BrokerWS
     */
    @WebEndpoint(name = "BrokerWSPort")
    public BrokerWS getBrokerWSPort() {
        return super.getPort(new QName("http://broker.me.org/", "BrokerWSPort"), BrokerWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BrokerWS
     */
    @WebEndpoint(name = "BrokerWSPort")
    public BrokerWS getBrokerWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://broker.me.org/", "BrokerWSPort"), BrokerWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BROKERWS_EXCEPTION!= null) {
            throw BROKERWS_EXCEPTION;
        }
        return BROKERWS_WSDL_LOCATION;
    }

}