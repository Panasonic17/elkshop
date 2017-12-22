package utils;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;

public class ElasticCRUD {

    private static TransportClient client = Client.getInstance();

    public static IndexResponse put(String index, String type, String id, XContentBuilder xContentBuilder) {
        return client.prepareIndex(index, type, id).setSource(xContentBuilder).get();
    }

    public static IndexResponse put(String index, String type, Long id, XContentBuilder xContentBuilder) {
        return client.prepareIndex(index, type, id + "").setSource(xContentBuilder).get();
    }

    public static IndexResponse put(String index, String type, Integer id, XContentBuilder xContentBuilder) {
        return client.prepareIndex(index, type, id + "").setSource(xContentBuilder).get();
    }

    public static IndexResponse put(String index, String type, XContentBuilder xContentBuilder) {
        return client.prepareIndex(index, type).setSource(xContentBuilder).get();
    }

    public static GetResponse get(String index, String type, String id) {
        return client.prepareGet(index, type, id).get();
    }
}
