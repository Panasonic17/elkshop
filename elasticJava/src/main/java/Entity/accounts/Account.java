package Entity.accounts;

import Entity.blogs.Tweet;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class Account {
    Long account_number;
    Long balance;
    String firstname;
    String lastname;
    Long age;
    String gender;
    String addres;
    String employer;
    String city;
    String state;

    public Account(Long account_number, Long balance, String firstname, String lastname, Long age, String gender, String addres, String employer, String city, String state) {
        this.account_number = account_number;
        this.balance = balance;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.addres = addres;
        this.employer = employer;
        this.city = city;
        this.state = state;
    }

    public Account(JSONObject jsonObject) {
        // bug need to change when populate
        account_number = Long.parseLong((String) jsonObject.get("_id"));
//                account_number = (Long) jsonObject.get("_id");

        JSONObject source = (JSONObject) jsonObject.get("_source");
//        source=jsonObject;
        balance = (Long) source.get("balance");
        firstname = (String) source.get("firstname");
        lastname = (String) source.get("lastname");
        age = (Long) source.get("age");
        gender = (String) source.get("gender");
        addres = (String) source.get("addres");
        employer = (String) source.get("employer");
        city = (String) source.get("city");
        state = (String) source.get("state");
    }

    public Account(String json) {

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(json);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        new Account(jsonObject);

    }

    public XContentBuilder getXContent() {
        XContentBuilder content = null;
        try {
            content = jsonBuilder()
                    .startObject()
                    .field("balance", balance)
                    .field("firstname", firstname)
                    .field("age", age)
                    .field("gender", gender)
                    .field("addres", addres)
                    .field("employer", employer)
                    .field("city", city)
                    .field("state", state)
                    .endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public Long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(Long account_number) {
        this.account_number = account_number;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_number=" + account_number +
                ", balance=" + balance +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", addres='" + addres + '\'' +
                ", employer='" + employer + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
