package shop.entity.product;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;


public class Product {
   public Integer sku;
   public Integer productId;
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
    String manufacturer;
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
    String longDescription;

    public void populateObject(JSONObject jsonObject) {
//        System.out.println(jsonObject.toString());
        sku = jsonObject.getInt("sku");
        productId = jsonObject.getInt("productId");
        shortDescription = jsonObject.getString("shortDescription");
        productClass = jsonObject.getString("class");
        subclass = jsonObject.getString("subclass");
        startDate = dateCreator(jsonObject.getString("startDate"));
        regularPrice = jsonObject.getDouble("regularPrice");
        try {
            String revAvg = "" + jsonObject.get("customerReviewAverage");
            if (!revAvg.equals(""))
                customerReviewAverage = jsonObject.getDouble("customerReviewAverage");
        } finally {
            try {
                String revCount = "" + jsonObject.get("customerReviewCount");
                if (!revCount.equals(""))
                    customerReviewCount = jsonObject.getInt("customerReviewCount");
            } finally {
                try {
                    longDescription = jsonObject.getString("longDescription");
                } catch (JSONException ex) {
                } finally {
                    try {
                        manufacturer = jsonObject.getString("manufacturer");
                    } catch (JSONException ex) {
                    }
                }
            }
        }
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
                    .field("subclass", subclass)
                    .field("manufacturer", manufacturer)
                    .field("longDescription", longDescription)
                    .field("customerReviewCount", customerReviewCount)
                    .field("customerReviewAverage", customerReviewAverage)
                    .field("regularPrice", regularPrice)
                    .field("startDate",startDate)
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

    private Date dateCreator(String date) {
//        2001-04-30
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public String getType() {
        return type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Boolean getNew() {
        return IsNew;
    }

    public Boolean getActive() {
        return active;
    }

    public Boolean getLowPriceGuarantee() {
        return lowPriceGuarantee;
    }

    public String getActiveUpdateDate() {
        return activeUpdateDate;
    }

    public Double getRegularPrice() {
        return regularPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public Date getPriceUpdateDate() {
        return priceUpdateDate;
    }

    public Boolean getDigital() {
        return digital;
    }

    public Boolean getPreowned() {
        return preowned;
    }

    public Integer[] getFrequentlyPurchasedWith() {
        return frequentlyPurchasedWith;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Integer[] getRelatedProducts() {
        return relatedProducts;
    }

    public Integer getSalesRankShortTerm() {
        return salesRankShortTerm;
    }

    public Integer getSalesRankMediumTerm() {
        return salesRankMediumTerm;
    }

    public Integer getSalesRankLongTerm() {
        return salesRankLongTerm;
    }

    public Integer getBestSellingRank() {
        return bestSellingRank;
    }

    public String getUrl() {
        return url;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public String getAddToCartUrl() {
        return addToCartUrl;
    }

    public String getUpc() {
        return upc;
    }

    public String getProductTemplate() {
        return productTemplate;
    }

    public Category[] getCategoryPath() {
        return categoryPath;
    }

    public Integer getCustomerReviewCount() {
        return customerReviewCount;
    }

    public Double getCustomerReviewAverage() {
        return customerReviewAverage;
    }

    public Boolean getCustomerTopRated() {
        return customerTopRated;
    }

    public Boolean getFreeShipping() {
        return freeShipping;
    }

    public Boolean getFreeShippingEligible() {
        return freeShippingEligible;
    }

    public Boolean getInStoreAvailability() {
        return inStoreAvailability;
    }

    public String getInStoreAvailabilityText() {
        return inStoreAvailabilityText;
    }

    public String getInStoreAvailabilityTextHtml() {
        return inStoreAvailabilityTextHtml;
    }

    public Date getInStoreAvailabilityUpdateDate() {
        return inStoreAvailabilityUpdateDate;
    }

    public Date getItemUpdateDate() {
        return itemUpdateDate;
    }

    public Boolean getOnlineAvailability() {
        return onlineAvailability;
    }

    public String getOnlineAvailabilityText() {
        return onlineAvailabilityText;
    }

    public String getOnlineAvailabilityTextHtml() {
        return onlineAvailabilityTextHtml;
    }

    public Date getOnlineAvailabilityUpdateDate() {
        return onlineAvailabilityUpdateDate;
    }

    public Double getShippingCost() {
        return shippingCost;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public Boolean getSpecialOrder() {
        return specialOrder;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getShortDescriptionHtml() {
        return shortDescriptionHtml;
    }

    public String getProductClass() {
        return productClass;
    }

    public Integer getClassId() {
        return classId;
    }

    public String getSubclass() {
        return subclass;
    }

    public Integer getSubclassId() {
        return subclassId;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public Integer getBestBuyItemId() {
        return bestBuyItemId;
    }

    public String getLongDescription() {
        return longDescription;
    }
}
