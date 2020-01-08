/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.broker;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Ruairidh
 */
public class IPAPI {

    static File fout = new File("C:\\Users\\Ruairidh\\Documents\\NetBeansProjects\\BrokerWebService\\src\\java\\IPinfo.txt");

    //https://stackoverflow.com/questions/2939218/getting-the-external-ip-address-in-java
    public static String getIP() throws MalformedURLException, IOException {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                whatismyip.openStream()));

        String ip = in.readLine(); //you get the IP as a String
        return ip;
    }

    public static void ipAPI() throws FileNotFoundException {

        //https://now.ntu.ac.uk/d2l/le/content/556411/viewContent/2824930/View
        FileOutputStream fos = new FileOutputStream(fout);
        OutputStreamWriter osw = new OutputStreamWriter(fos);

        String IP = "";
        try {
            IP = getIP();
        } catch (IOException ex) {
            Logger.getLogger(IPAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            URL url = new URL("http://ip-api.com/xml/" + IP);
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

            System.out.println(sb.toString());

            conn.disconnect();
            ins.close();
        } catch (MalformedURLException me) {
            System.out.println("MalformedURLException: " + me);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe);
        }
    }

    public static String serverInfo() throws SAXException, FileNotFoundException {

        ipAPI();
        String sInfo = "";
        
        //https://www.youtube.com/watch?v=HfGWVy-eMRc
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fout);
            doc.getDocumentElement().normalize();
            doc.getElementsByTagName("query");

            String rName = doc.getElementsByTagName("regionName").item(0).getTextContent().trim();
            String cName = doc.getElementsByTagName("city").item(0).getTextContent();
            System.out.println(cName + ", " + rName);
            sInfo = (cName + ", " + rName);
        } catch (IOException | NumberFormatException | ParserConfigurationException | DOMException | SAXException e) {
        }

        return sInfo;
    }

}
