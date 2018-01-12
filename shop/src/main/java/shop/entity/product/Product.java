package shop.entity.product;

import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@Getter
@Setter
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
    public String image;

    @Override
    public String toString() {
        return "Product{" +
                "sku=" + sku +
                ", productId=" + productId +
                '}';
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Boolean getNew() {
        return IsNew;
    }

    public void setNew(Boolean aNew) {
        IsNew = aNew;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getLowPriceGuarantee() {
        return lowPriceGuarantee;
    }

    public void setLowPriceGuarantee(Boolean lowPriceGuarantee) {
        this.lowPriceGuarantee = lowPriceGuarantee;
    }

    public String getActiveUpdateDate() {
        return activeUpdateDate;
    }

    public void setActiveUpdateDate(String activeUpdateDate) {
        this.activeUpdateDate = activeUpdateDate;
    }

    public Double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(Double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public Date getPriceUpdateDate() {
        return priceUpdateDate;
    }

    public void setPriceUpdateDate(Date priceUpdateDate) {
        this.priceUpdateDate = priceUpdateDate;
    }

    public Boolean getDigital() {
        return digital;
    }

    public void setDigital(Boolean digital) {
        this.digital = digital;
    }

    public Boolean getPreowned() {
        return preowned;
    }

    public void setPreowned(Boolean preowned) {
        this.preowned = preowned;
    }

    public Integer[] getFrequentlyPurchasedWith() {
        return frequentlyPurchasedWith;
    }

    public void setFrequentlyPurchasedWith(Integer[] frequentlyPurchasedWith) {
        this.frequentlyPurchasedWith = frequentlyPurchasedWith;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer[] getRelatedProducts() {
        return relatedProducts;
    }

    public void setRelatedProducts(Integer[] relatedProducts) {
        this.relatedProducts = relatedProducts;
    }

    public Integer getSalesRankShortTerm() {
        return salesRankShortTerm;
    }

    public void setSalesRankShortTerm(Integer salesRankShortTerm) {
        this.salesRankShortTerm = salesRankShortTerm;
    }

    public Integer getSalesRankMediumTerm() {
        return salesRankMediumTerm;
    }

    public void setSalesRankMediumTerm(Integer salesRankMediumTerm) {
        this.salesRankMediumTerm = salesRankMediumTerm;
    }

    public Integer getSalesRankLongTerm() {
        return salesRankLongTerm;
    }

    public void setSalesRankLongTerm(Integer salesRankLongTerm) {
        this.salesRankLongTerm = salesRankLongTerm;
    }

    public Integer getBestSellingRank() {
        return bestSellingRank;
    }

    public void setBestSellingRank(Integer bestSellingRank) {
        this.bestSellingRank = bestSellingRank;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public String getAddToCartUrl() {
        return addToCartUrl;
    }

    public void setAddToCartUrl(String addToCartUrl) {
        this.addToCartUrl = addToCartUrl;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getProductTemplate() {
        return productTemplate;
    }

    public void setProductTemplate(String productTemplate) {
        this.productTemplate = productTemplate;
    }

    public Category[] getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(Category[] categoryPath) {
        this.categoryPath = categoryPath;
    }

    public Integer getCustomerReviewCount() {
        return customerReviewCount;
    }

    public void setCustomerReviewCount(Integer customerReviewCount) {
        this.customerReviewCount = customerReviewCount;
    }

    public Double getCustomerReviewAverage() {
        return customerReviewAverage;
    }

    public void setCustomerReviewAverage(Double customerReviewAverage) {
        this.customerReviewAverage = customerReviewAverage;
    }

    public Boolean getCustomerTopRated() {
        return customerTopRated;
    }

    public void setCustomerTopRated(Boolean customerTopRated) {
        this.customerTopRated = customerTopRated;
    }

    public Boolean getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public Boolean getFreeShippingEligible() {
        return freeShippingEligible;
    }

    public void setFreeShippingEligible(Boolean freeShippingEligible) {
        this.freeShippingEligible = freeShippingEligible;
    }

    public Boolean getInStoreAvailability() {
        return inStoreAvailability;
    }

    public void setInStoreAvailability(Boolean inStoreAvailability) {
        this.inStoreAvailability = inStoreAvailability;
    }

    public String getInStoreAvailabilityText() {
        return inStoreAvailabilityText;
    }

    public void setInStoreAvailabilityText(String inStoreAvailabilityText) {
        this.inStoreAvailabilityText = inStoreAvailabilityText;
    }

    public String getInStoreAvailabilityTextHtml() {
        return inStoreAvailabilityTextHtml;
    }

    public void setInStoreAvailabilityTextHtml(String inStoreAvailabilityTextHtml) {
        this.inStoreAvailabilityTextHtml = inStoreAvailabilityTextHtml;
    }

    public Date getInStoreAvailabilityUpdateDate() {
        return inStoreAvailabilityUpdateDate;
    }

    public void setInStoreAvailabilityUpdateDate(Date inStoreAvailabilityUpdateDate) {
        this.inStoreAvailabilityUpdateDate = inStoreAvailabilityUpdateDate;
    }

    public Date getItemUpdateDate() {
        return itemUpdateDate;
    }

    public void setItemUpdateDate(Date itemUpdateDate) {
        this.itemUpdateDate = itemUpdateDate;
    }

    public Boolean getOnlineAvailability() {
        return onlineAvailability;
    }

    public void setOnlineAvailability(Boolean onlineAvailability) {
        this.onlineAvailability = onlineAvailability;
    }

    public String getOnlineAvailabilityText() {
        return onlineAvailabilityText;
    }

    public void setOnlineAvailabilityText(String onlineAvailabilityText) {
        this.onlineAvailabilityText = onlineAvailabilityText;
    }

    public String getOnlineAvailabilityTextHtml() {
        return onlineAvailabilityTextHtml;
    }

    public void setOnlineAvailabilityTextHtml(String onlineAvailabilityTextHtml) {
        this.onlineAvailabilityTextHtml = onlineAvailabilityTextHtml;
    }

    public Date getOnlineAvailabilityUpdateDate() {
        return onlineAvailabilityUpdateDate;
    }

    public void setOnlineAvailabilityUpdateDate(Date onlineAvailabilityUpdateDate) {
        this.onlineAvailabilityUpdateDate = onlineAvailabilityUpdateDate;
    }

    public Double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Boolean getSpecialOrder() {
        return specialOrder;
    }

    public void setSpecialOrder(Boolean specialOrder) {
        this.specialOrder = specialOrder;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getShortDescriptionHtml() {
        return shortDescriptionHtml;
    }

    public void setShortDescriptionHtml(String shortDescriptionHtml) {
        this.shortDescriptionHtml = shortDescriptionHtml;
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public Integer getSubclassId() {
        return subclassId;
    }

    public void setSubclassId(Integer subclassId) {
        this.subclassId = subclassId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getBestBuyItemId() {
        return bestBuyItemId;
    }

    public void setBestBuyItemId(Integer bestBuyItemId) {
        this.bestBuyItemId = bestBuyItemId;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

