package DarkSideOfTheMoon.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

    public static ArrayList<String> getData(String filename) {
        ArrayList<String> data=new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                data.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
