package shop.services.transformer;

import org.elasticsearch.common.xcontent.XContent;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.search.SearchHit;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import shop.entity.product.Product;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;


@Service
public class ProductTransformer {
    public Product hitnToProduct(SearchHit hit) {
        JSONObject jsonObject = new JSONObject(hit.getSourceAsString());
        ProductTransformer tp = new ProductTransformer();
        Product product = tp.jsonObjToProduct(jsonObject);
        return product;
    }

    public Product jsonObjToProduct(JSONObject jsonObject) {
        Product product = new Product();
        product.sku = jsonObject.getInt("sku");
        product.productId = jsonObject.getInt("productId");
        product.shortDescription = jsonObject.optString("shortDescription");
        product.productClass = jsonObject.optString("class");
        product.subclass = jsonObject.optString("subclass");
        product.startDate = dateCreator(jsonObject.optString("startDate"));
        product.regularPrice = jsonObject.getDouble("regularPrice");

        product.image = jsonObject.optString("image");
        product.name = jsonObject.optString("name");
//        product
        try {
            String revAvg = "" + jsonObject.get("customerReviewAverage");
            if (!(revAvg.equals("") || (revAvg == null) || revAvg.equals("null")))
                product.customerReviewAverage = jsonObject.getDouble("customerReviewAverage");
        } finally {
            try {
                String revCount = "" + jsonObject.get("customerReviewCount");
                if (!(revCount.equals("") || (revCount == null) || revCount.equals("null")))
                    product.customerReviewCount = jsonObject.getInt("customerReviewCount");
            } finally {
                try {
                    product.longDescription = jsonObject.getString("longDescription");
                } catch (JSONException ex) {
                } finally {
                    try {
                        product.manufacturer  = jsonObject.getString("manufacturer");
                    } catch (JSONException ex) {
                    }
                }
            }
        }
        return product;
    }

    private Date dateCreator(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
//            e.printStackTrace();
        }
        return null;
    }

    public XContentBuilder getXContent(Product product) {
        XContentBuilder content = null;
        try {
            content = jsonBuilder()
                    .startObject()
                    .field("sku", product.sku)
                    .field("productId", product.productId)
                    .field("shortDescription", product.shortDescription)
                    .field("class", product.productClass)
                    .field("subclass", product.subclass)
                    .field("manufacturer", product.manufacturer)
                    .field("longDescription", product.longDescription)
                    .field("customerReviewCount", product.customerReviewCount)
                    .field("customerReviewAverage", product.customerReviewAverage)
                    .field("regularPrice", product.regularPrice)
                    .field("startDate", product.startDate)
                    .field("image",product.image)
                    .field("name",product.name)
                    .endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}
