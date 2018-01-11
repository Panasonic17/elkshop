package previousProject.java.getdata;

import Entity.product.Product;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ProductsFromXML {

    public ArrayList<Product> GetProducts() {
        File folder = new File("../testData");
        File[] files = folder.listFiles();
        ArrayList<Product> products = new ArrayList<>();
        for (File f : files) {
            String xml = readFile(f);
            JSONObject xmlJSONObj = XML.toJSONObject(xml);
            JSONObject productArray = xmlJSONObj.getJSONObject("products");
            JSONArray array = productArray.getJSONArray("product");
            for (int i = 0; i < array.length(); i++) {
                Product p = new Product();
                p.populateObject((JSONObject) array.get(i));
                products.add(p);
            }
        }
        return products;
    }

    private static String readFile(File f) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
//                System.out.println(sCurrentLine);
                sb.append(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }

    private static Product convert(String xml) {
        String jsonPrettyPrintString = "";
        Product p = new Product();
        String TEST_XML_STRING = xml;
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
            JSONObject products = xmlJSONObj.getJSONObject("products");
            JSONArray array = products.getJSONArray("product");
            for (int i = 0; i < 1; i++) {
                p.populateObject((JSONObject) array.get(i));
            }

        } catch (JSONException je) {
            System.out.println(je.toString());
        }
        return null;
    }

}
