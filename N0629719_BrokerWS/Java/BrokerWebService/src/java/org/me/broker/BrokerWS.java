/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.broker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;
import org.xml.sax.SAXException;
import shareOrder.Company;
import shareOrder.ShareList;

/**
 *
 * @author Ruairidh
 */
@WebService(serviceName = "BrokerWS")
@Stateless()
public class BrokerWS {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CurrencyConvertor/CurrencyConversionWSService.wsdl")

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "displayAll")
    public List<Company> displayAll() {

        File file = new File("C:\\Users\\Ruairidh\\Documents\\NetBeansProjects\\BrokerWebService\\src\\java\\CompanyInfo.txt");

        List<Company> todaysCompanies = null;
        ShareList newShareList = new ShareList();

        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(newShareList.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            newShareList = (ShareList) unmarshaller.unmarshal(file); //NOI18N

            todaysCompanies = newShareList.getSharesCollection();

        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

        return todaysCompanies;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buyShares")
    public synchronized boolean buyShares(@WebParam(name = "CompanySymbol") String CompanySymbol, @WebParam(name = "shareAmount") int shareAmount) {

        File file = new File("C:\\Users\\Ruairidh\\Documents\\NetBeansProjects\\BrokerWebService\\src\\java\\CompanyInfo.txt");

        ShareList newShareList = new ShareList();

        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(newShareList.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            newShareList = (ShareList) unmarshaller.unmarshal(file); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

        for (Company c : newShareList.getSharesCollection()) {
            if (c.getCompanySymbol().equals(CompanySymbol)) {
                c.setShareAvailability(c.getShareAvailability() - shareAmount);

                try {
                    javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(newShareList.getClass().getPackage().getName());
                    javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
                    marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
                    marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                    marshaller.marshal(newShareList, file);
                } catch (javax.xml.bind.JAXBException ex) {
                    // XXXTODO Handle exception
                    java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getServerInfo")
    public String getServerInfo() {
        String serverInfo = null;

        try {
            serverInfo = IPAPI.serverInfo();
        } catch (SAXException | FileNotFoundException ex) {
            Logger.getLogger(BrokerWS.class.getName()).log(Level.SEVERE, null, ex);
        }

        return serverInfo;
    }

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "updatedPrice")
    public synchronized boolean updatedPrice() {
        updateSPrice();
        return true;
    }

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "spAPI")
    public boolean spAPI() {

        try {
            priceAPI.PriceAPI();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(BrokerWS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void updateSPrice() {
        File file = new File("C:\\Users\\Ruairidh\\Documents\\NetBeansProjects\\BrokerWebService\\src\\java\\CompanyInfo.txt");

        ShareList newShareList = new ShareList();

        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(newShareList.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            newShareList = (ShareList) unmarshaller.unmarshal(file); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

        for (Company c : newShareList.getSharesCollection()) {
            float newPrice = priceAPI.GetConversion(c.getCompanyName());
            if (newPrice != -1) {
                c.getSharePrice().setValue(newPrice);

                try {
                    javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(newShareList.getClass().getPackage().getName());
                    javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
                    marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
                    marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                    marshaller.marshal(newShareList, file);
                } catch (javax.xml.bind.JAXBException ex) {
                    // XXXTODO Handle exception
                    java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
                }
            }
        }
    }

}
