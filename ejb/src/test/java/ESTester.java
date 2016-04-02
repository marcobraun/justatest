import com.itnovum.es.EsConnector;
import com.itnovum.es.IEsConnector;
import org.elasticsearch.client.Client;
import org.junit.Test;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mbraun on 31.03.2016.
 */
public class ESTester {

    @Test
    public void testAddDocument() throws UnknownHostException {
        Map<String, Object> document = new HashMap<String, Object>();
        document.put("title","My name is roger");
        IEsConnector esConnector = new EsConnector();
        Client client = esConnector.createClient("myESCluster");
        esConnector.addDocument(client,"Books", "Book", document);
        //esConnector.getDocument(client,"Books", "Book", "1");
    }
}
