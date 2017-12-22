package Entity.blogs;

import org.elasticsearch.common.xcontent.XContentBuilder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;


public class Tweet {
    String id;
    String user;
    Date postDate;
    String message;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");

    public static Tweet getTweetFromJson(String json) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(json);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean found = (boolean) jsonObject.get("found");
        if (found == false) return null;
        return new Tweet(jsonObject);
    }

    private Tweet(JSONObject jsonObject) {
        id = (String) jsonObject.get("_id");
        JSONObject source = (JSONObject) jsonObject.get("_source");
        user = (String) source.get("user");
        try {
            postDate = format.parse((String) source.get("postDate"));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        message = (String) source.get("message");

    }

    public Tweet(String user, Date postDate, String message) {
        this.user = user;
        this.postDate = postDate;
        this.message = message;
    }

    public XContentBuilder getXContent() {
        XContentBuilder content = null;
        try {
            content = jsonBuilder()
                    .startObject()
                    .field("user", user)
                    .field("postDate", postDate)
                    .field("message", message)
                    .endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", postDate=" + postDate +
                ", message='" + message + '\'' +
                '}';
    }
}
