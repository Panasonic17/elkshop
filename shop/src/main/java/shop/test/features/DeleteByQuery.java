package shop.test.features;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import shop.test.features.utils.Client;


public class DeleteByQuery {
    public static void main(String[] args) {
        BulkByScrollResponse response =
                DeleteByQueryAction.INSTANCE.newRequestBuilder(Client.getInstance())
                        .filter(QueryBuilders.matchQuery("shortDescription","OEM"))
                        .filter(QueryBuilders.matchQuery("shortDescription", ""))
                        .source("products")
                        .get();
        long deleted = response.getDeleted();
        System.out.println(deleted);
    }
}
