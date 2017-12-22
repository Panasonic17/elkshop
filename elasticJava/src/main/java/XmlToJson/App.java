package XmlToJson;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;


public class App {


    public static void main(String[] args) throws IOException {
        File folder = new File("../data");
        File[] files = folder.listFiles();
        for (File f : files) {
            String xml = readFile(f);
            String json = convert(xml);
            writeFile(json);
        }
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

    static int nom = 1;

    private static void writeFile(String json) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("../dataJson/file" + nom++ + ".json"))) {
            bw.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convert(String xml) {
        String jsonPrettyPrintString = "";
        int PRETTY_PRINT_INDENT_FACTOR = 4;
        String TEST_XML_STRING = xml;
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
            jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
        } catch (JSONException je) {
            System.out.println(je.toString());
        }
        return jsonPrettyPrintString.toString();
    }

}
