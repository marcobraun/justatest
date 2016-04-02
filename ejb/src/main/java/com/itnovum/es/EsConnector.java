package com.itnovum.es;

import org.apache.log4j.Logger;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;

import java.net.UnknownHostException;
import java.util.Map;

/**
 * Created by mbraun on 30.03.2016.
 */
public class EsConnector implements IEsConnector {
    private final static Logger LOG = Logger.getLogger(EsConnector.class);

    public Client createClient(String clusterName) throws UnknownHostException {
        Settings settings = Settings.settingsBuilder()
                .put("cluster.name", clusterName)
                .put("node.name", "itnovum_Node_1")
                .put("path.home", "C:\\Development\\es")
                .build();
        /*Client client = TransportClient.builder().build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getLocalHost(), 9200))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getLocalHost(), 9300));
        */


        Client client = NodeBuilder.nodeBuilder()
                .settings(settings)
                .clusterName(clusterName)
                .client(true)
                .node()
                .client();
        LOG.debug("");

        return client;
    }

    public void addDocument(Client client, String indexName, String docType, String id, String source) throws UnknownHostException {

        IndexRequestBuilder irb = client.prepareIndex(indexName, docType, id);
        irb.setSource(source);
    }

    public void addDocument(Client client, String indexName, String docType, String source) throws UnknownHostException {
        IndexRequestBuilder irb = client.prepareIndex(indexName, docType);
        irb.setSource(source);
    }

    public void addDocument(Client client, String indexName, String docType, String id, Map<String, Object> source) throws UnknownHostException {
        IndexRequestBuilder irb = client.prepareIndex(indexName, docType, id);
        irb.setSource(source);
    }

    public void addDocument(Client client, String indexName, String docType, Map<String, Object> source) throws UnknownHostException {
        //IndexRequestBuilder irb = client.prepareIndex(indexName, docType);
        //irb.setSource(source);
        IndexResponse resp = client.prepareIndex(indexName, docType)
                .setSource(source)
                .execute()
                .actionGet();
        output(resp);
    }

    public Map<String, Object> getDocument(Client client, String indexName, String docType, String id) {
        GetResponse resp = client.prepareGet(indexName, docType, id).execute().actionGet();
        return resp.getSource();
    }

    private void output(IndexResponse resp) {
        String formatted = "Index: %s, Type: %s, Version %s";
        String msg = String.format(formatted, resp.getIndex(), resp.getType(), resp.getId());
        LOG.debug(msg);
    }
}
