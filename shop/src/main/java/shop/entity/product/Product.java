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
    public String name;
    public String source;
    public String type;
    public Date startDate;
    public Boolean IsNew;
    public Boolean active;
    public Boolean lowPriceGuarantee;
    public String activeUpdateDate;
    public Double regularPrice;
    public Double salePrice;
    public Boolean onSale;
    public Date priceUpdateDate;
    public Boolean digital;
    public Boolean preowned;
    public Integer[] frequentlyPurchasedWith;
    public String manufacturer;
    public Integer[] relatedProducts;
    public Integer salesRankShortTerm;
    public Integer salesRankMediumTerm;
    public Integer salesRankLongTerm;
    public Integer bestSellingRank;
    public String url;
    public String mobileUrl;
    public String addToCartUrl;
    public String upc;
    public String productTemplate;
    public Category[] categoryPath; // ???????????????????????????? mabye misstake
    public Integer customerReviewCount;
    public Double customerReviewAverage;
    public Boolean customerTopRated;
    public Boolean freeShipping;
    public Boolean freeShippingEligible;
    public Boolean inStoreAvailability;
    public String inStoreAvailabilityText;
    public String inStoreAvailabilityTextHtml;
    public Date inStoreAvailabilityUpdateDate;
    public Date itemUpdateDate;
    public Boolean onlineAvailability;
    public String onlineAvailabilityText;
    public String onlineAvailabilityTextHtml;
    public Date onlineAvailabilityUpdateDate;
    public Double shippingCost;
    public Shipping shipping;
    public Boolean specialOrder;
    public String shortDescription;
    public String shortDescriptionHtml;
    public String productClass; //class
    public Integer classId;
    public String subclass;
    public Integer subclassId;
    public String department;
    public Integer departmentId;
    public Integer bestBuyItemId;
    public String longDescription;

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
