package com.itnovum.es;

import org.elasticsearch.client.Client;

import java.net.UnknownHostException;
import java.util.Map;

/**
 * Created by mbraun on 30.03.2016.
 */
public interface IEsConnector {
    public Client createClient(final String clusterName) throws UnknownHostException;
    public void addDocument (final Client client, final String indexName, final String docType, final String id, String source) throws UnknownHostException;
    public void addDocument (final Client client, final String indexName, final String docType, String source) throws UnknownHostException;
    public Map<String, Object> getDocument (Client client, final String indexName, final String docType, final String id);
    public void addDocument(Client client, String indexName, String docType, String id, Map<String, Object> source) throws UnknownHostException;
    public void addDocument(Client client, String indexName, String docType, Map<String, Object> source) throws UnknownHostException;
}
