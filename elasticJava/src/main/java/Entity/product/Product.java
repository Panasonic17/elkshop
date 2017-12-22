package Entity.product;

import java.util.Date;


public class Product {
    Integer sku;
    String productId;
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
    String productClass;
    Integer classId;
    String subclass;
    Integer subclassId;
    String department;
    Integer departmentId;
    Integer bestBuyItemId;
}
