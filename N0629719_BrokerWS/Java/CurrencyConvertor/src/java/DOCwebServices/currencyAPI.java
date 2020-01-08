/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOCwebServices;

import java.io.*;
import java.net.*;
import java.io.File;
import static java.lang.Float.parseFloat;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Ruairidh
 */
public class currencyAPI {

    static File fout = new File("C:\\Users\\Ruairidh\\Documents\\NetBeansProjects\\CurrencyConvertor\\src\\java\\currency.txt");
    static List<updatedCurrencies> ucList = new ArrayList<updatedCurrencies>();

    public static void API() throws Exception {
        
        //https://now.ntu.ac.uk/d2l/le/content/556411/viewContent/2824930/View
        FileOutputStream fos = new FileOutputStream(fout);
        OutputStreamWriter osw = new OutputStreamWriter(fos);

        try {
            URL url = new URL("http://www.floatrates.com/daily/gbp.xml");
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
            ins.close();
        } catch (MalformedURLException me) {
            System.out.println("MalformedURLException: " + me);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe);
        }

        currencyList();
    }

    public static List<updatedCurrencies> currencyList() throws Exception {

        //https://www.youtube.com/watch?v=HfGWVy-eMRc
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fout);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("item");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String tc = eElement.getElementsByTagName("targetCurrency").item(0).getTextContent().trim();
                    String ser = eElement.getElementsByTagName("inverseRate").item(0).getTextContent();
                    ser = ser.replace(",", "");
                    Float er = parseFloat(ser);

                    ucList.add(new updatedCurrencies(tc, er));
                }
            }
            float f = 1;
            ucList.add(new updatedCurrencies("GBP", f));

        } catch (IOException e) {
        } catch (NumberFormatException e) {
        } catch (ParserConfigurationException e) {
        } catch (DOMException e) {
        } catch (SAXException e) {
        }

        return ucList;
    }

    public static class updatedCurrencies {

        String currency;
        Float exchangeRate;

        updatedCurrencies(String Currency, Float ExchnageRate) {
            this.currency = Currency;
            this.exchangeRate = ExchnageRate;
        }
    }

    public static double GetConversion(String cur) {
        try {
            currencyAPI.currencyList();
        } catch (Exception e) {
        }

        double conversion = -1;

        for (int i = 0; i < ucList.size(); i++) {
            if (ucList.get(i).currency.equals(cur)) {
                conversion = ucList.get(i).exchangeRate;
            }
        }

        System.out.println(conversion);
        return conversion;
    }

}
