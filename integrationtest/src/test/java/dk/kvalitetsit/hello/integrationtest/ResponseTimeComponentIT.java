package dk.kvalitetsit.hello.integrationtest;

import org.junit.Test;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.SvartidskomponentApi;

import static org.junit.Assert.assertNotNull;

public class ResponseTimeComponentIT extends AbstractIntegrationTest {

    private final SvartidskomponentApi svartidskomponentApi;

    public ResponseTimeComponentIT() {
        var apiClient = new ApiClient();
        apiClient.setBasePath(getApiBasePath());

        svartidskomponentApi = new SvartidskomponentApi(apiClient);
    }

    @Test
    public void testSimpleCall() throws ApiException {
        var result = svartidskomponentApi.restV1SimpleGet();

        assertNotNull(result);
        assertNotNull(result.getVersion());
    }

    @Test
    public void testComplexCall() throws ApiException {
        var result = svartidskomponentApi.restV1ComplexGet();

        assertNotNull(result);
        assertNotNull(result.getVersion());
    }

}
