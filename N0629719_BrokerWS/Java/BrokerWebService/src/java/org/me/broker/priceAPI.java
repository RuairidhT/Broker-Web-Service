/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.broker;

import java.io.*;
import static java.lang.Float.parseFloat;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Ruairidh
 */
public class priceAPI {

    static File fout = new File("C:\\Users\\Ruairidh\\Documents\\NetBeansProjects\\BrokerWebService\\src\\java\\sharePrice.txt");
    static List<updatedPrices> upList = new ArrayList<updatedPrices>();

       
    public static void PriceAPI() throws Exception {

        //https://now.ntu.ac.uk/d2l/le/content/556411/viewContent/2824930/View
        FileOutputStream fos = new FileOutputStream(fout);
        OutputStreamWriter osw = new OutputStreamWriter(fos);

        URL url = new URL("https://spreadsheets.google.com/feeds/list/0AhySzEddwIC1dEtpWF9hQUhCWURZNEViUmpUeVgwdGc/1/public/basic");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // Check for successful response code or throw error
        if (conn.getResponseCode() != 200) {
            throw new IOException(conn.getResponseMessage());
        }
        BufferedReader ins = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inString;
        StringBuilder sb = new StringBuilder();

        while ((inString = ins.readLine()) != null) {
            sb.append(inString).append("\n");
        }
        String x = sb.toString();
        osw.write(x);
        osw.close();

        conn.disconnect();
        ins.close();
        
        priceList();
    }
    
    public static List<updatedPrices> priceList() throws Exception { 
          
        //https://www.youtube.com/watch?v=HfGWVy-eMRc
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fout);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("entry");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String content = eElement.getElementsByTagName("content").item(0).getTextContent(); 
                    String[] contentList = content.split(",");
                    
                    String companyName = contentList[0].replace("name: ", "").trim();
                    String sharePrice = contentList[1].replace("price: ", "").trim();

                    if (!"#N/A".equals(sharePrice)){
                         Float sPrice = parseFloat(sharePrice);
                         upList.add(new updatedPrices(companyName, sPrice));
                    } 
                }
            }
        } catch (IOException | NumberFormatException | ParserConfigurationException | DOMException | SAXException e) {
        }  
        
        return upList;
    }
    
    public static float GetConversion(String cName) {

        try {
            priceList();
        } catch (Exception ex) {
            Logger.getLogger(priceAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        float price = -1;

        for (int i = 0; i < upList.size(); i++) {
             if (upList.get(i).companyName.equals(cName)) {
                price = upList.get(i).sharePrice;
            }
        }

        System.out.println(price);
        return price;
    }
    
     public static class updatedPrices {

        String companyName;
        Float sharePrice;

        updatedPrices(String CompanyName, Float SharePrice) {
            this.companyName = CompanyName;
            this.sharePrice = SharePrice;
        }
    }
    
}
