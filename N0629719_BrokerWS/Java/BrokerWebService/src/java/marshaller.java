/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import shareOrder.Company;
import shareOrder.ShareList;
import shareOrder.SharePrice;

/**
 *
 * @author Ruairidh
 */
public class marshaller {

//    public static void main(String[] args) throws DatatypeConfigurationException {
//
//        File file = new File("C:\\Users\\Ruairidh\\Documents\\NetBeansProjects\\BrokerWebService\\src\\java\\CompanyInfo.txt");
//
//        Company newCompany = new Company();
//        ShareList newShareList = new ShareList();
//        SharePrice newSharePrice = new SharePrice();
//        
//        newSharePrice.setCurrency("£");
//        newSharePrice.setValue(200);
//        newSharePrice.setLastUpdate(DatatypeFactory.newInstance().newXMLGregorianCalendar("2019-01-15"));
//        newCompany.setCompanyName("Google");
//        newCompany.setShareAvailability(1000);
//        newCompany.setSharePrice(newSharePrice);
//        newCompany.setCompanySymbol("GOOGL");
//
//
//        newShareList.getSharesCollection().add(newCompany);
//
//        try {
//            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(newShareList.getClass().getPackage().getName());
//            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
//            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
//            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            marshaller.marshal(newShareList, file);
//        } catch (javax.xml.bind.JAXBException ex) {
//            // XXXTODO Handle exception
//            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
//        }
//    }
}
