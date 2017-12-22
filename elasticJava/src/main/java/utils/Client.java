package utils;


import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client {
    private static TransportClient client;

    private Client() {
    }

    public static TransportClient getInstance() {
        if (client == null) {
            try {
                client = new PreBuiltTransportClient(Settings.EMPTY)
                        .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return client;
    }
}
