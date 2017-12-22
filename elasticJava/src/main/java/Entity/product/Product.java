package Entity.product;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;


public class Product {
    Integer sku;
    Integer productId;
    String name;
    String source;
    String type;
    Date startDate;
    Boolean IsNew;
    Boolean active;
    Boolean lowPriceGuarantee;
    String activeUpdateDate;
    Double regularPrice;
    Double salePrice;
    Boolean onSale;
    Date priceUpdateDate;
    Boolean digital;
    Boolean preowned;
    Integer[] frequentlyPurchasedWith;
    Integer[] relatedProducts;
    Integer salesRankShortTerm;
    Integer salesRankMediumTerm;
    Integer salesRankLongTerm;
    Integer bestSellingRank;
    String url;
    String mobileUrl;
    String addToCartUrl;
    String upc;
    String productTemplate;
    Category[] categoryPath; // ???????????????????????????? mabye misstake
    Integer customerReviewCount;
    Double customerReviewAverage;
    Boolean customerTopRated;
    Boolean freeShipping;
    Boolean freeShippingEligible;
    Boolean inStoreAvailability;
    String inStoreAvailabilityText;
    String inStoreAvailabilityTextHtml;
    Date inStoreAvailabilityUpdateDate;
    Date itemUpdateDate;
    Boolean onlineAvailability;
    String onlineAvailabilityText;
    String onlineAvailabilityTextHtml;
    Date onlineAvailabilityUpdateDate;
    Double shippingCost;
    Shipping shipping;
    Boolean specialOrder;
    String shortDescription;
    String shortDescriptionHtml;
    String productClass; //class
    Integer classId;
    String subclass;
    Integer subclassId;
    String department;
    Integer departmentId;
    Integer bestBuyItemId;

    public void populateObject(JSONObject jsonObject) {
        sku = jsonObject.getInt("sku");
        productId = jsonObject.getInt("productId");
        shortDescription = jsonObject.getString("shortDescription");
        productClass=jsonObject.getString("class");
        subclass=jsonObject.getString("subclass");
    }

    public XContentBuilder getXContent() {
        XContentBuilder content = null;
        try {
            content = jsonBuilder()
                    .startObject()
                    .field("sku", sku)
                    .field("productId", productId)
                    .field("shortDescription", shortDescription)
                    .field("class", productClass)
                    .field("subclass",subclass)
                    .endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku=" + sku +
                ", productId=" + productId +
                '}';
    }

    public Integer getProductId() {
        return productId;
    }
}
