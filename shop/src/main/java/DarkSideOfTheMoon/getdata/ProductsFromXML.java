package DarkSideOfTheMoon.getdata;


import DarkSideOfTheMoon.utils.ElasticCRUD;
import org.json.*;
import shop.entity.product.Product;
import shop.services.transformer.ProductTransformer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductsFromXML {
    static ProductTransformer pt = new ProductTransformer();
    public ArrayList<Product> GetProductAndSend() {
//        File folder = new File("testData");
        File folder = new File("../data");
        File[] files = folder.listFiles();
        ArrayList<Product> products = new ArrayList<>();
        for (File f : files) {
            String xml = readFile(f);
            JSONObject xmlJSONObj = XML.toJSONObject(xml);
            JSONObject productArray = xmlJSONObj.getJSONObject("products");
            JSONArray array = productArray.getJSONArray("product");
            for (int i = 0; i < array.length(); i++) {

                ProductTransformer tp = new ProductTransformer();
                Product p = tp.jsonObjToProduct((JSONObject) array.get(i));
//                products.add(p);
                ElasticCRUD.put("products", "product", p.getProductId(), pt.getXContent(p));
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


                ProductTransformer tp = new ProductTransformer();
                p = tp.jsonObjToProduct((JSONObject) array.get(i));

            }

        } catch (JSONException je) {
            System.out.println(je.toString());
        }
        return null;
    }

}
