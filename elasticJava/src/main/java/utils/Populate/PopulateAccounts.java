package utils.Populate;


import Entity.accounts.Account;
import utils.ElasticCRUD;
import utils.ReadFile;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PopulateAccounts {
    private static final String FILENAME = "filterAccounts.json";

    public static void populateAccounts() {
        ArrayList<String> data=new ArrayList<>();
        data= ReadFile.getData(FILENAME);
        data.stream().map(json->new Account(json)).forEach(account-> ElasticCRUD.put("accounts","account",account.getAccount_number(),account.getXContent()));
    }

}
