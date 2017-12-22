package Transform;

import Entity.accounts.Account;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Oleksandr_Shainoga on 12/6/2017.
 */
public class AccountTransformers {
    public static ArrayList<Account> getAccounts(String json) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(json);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject hits1 = (JSONObject) jsonObject.get("hits");
        JSONArray accountsArray = (JSONArray) hits1.get("hits");
        ArrayList<Account> accounts = new ArrayList<>();
        Iterator<JSONObject> iterator = accountsArray.iterator();
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
            accounts.add(new Account(iterator.next()));
        }
        return accounts;
    }
}
