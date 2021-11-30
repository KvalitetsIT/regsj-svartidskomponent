package dk.kvalitetsit.hello.controller;

import dk.kvalitetsit.hello.service.ResponseTimeService;
import dk.kvalitetsit.hello.service.model.ComplexResponse;
import dk.kvalitetsit.hello.service.model.SimpleResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

public class ResponseTimeControllerTest {
    private ResponseTimeController responseTimeController;
    private ResponseTimeService responseTimeService;

    @Before
    public void setup() {
        responseTimeService = Mockito.mock(ResponseTimeService.class);

        responseTimeController = new ResponseTimeController(responseTimeService);
    }

    @Test
    public void testSimpleControllerCall() {
        var expectedVersion = "1.0.0";

        Mockito.when(responseTimeService.getSimple()).then(x -> {
            var response = new SimpleResponse();
            response.setVersion(expectedVersion);

            return response;
        });

        var result = responseTimeController.restV1SimpleGet();

        assertNotNull(result);
        assertEquals(expectedVersion, result.getBody().getVersion());

        Mockito.verify(responseTimeService, times(1)).getSimple();
    }

    @Test
    public void testComplexControllerCall() throws IOException {
        var expectedVersion = "1.0.0";

        Mockito.when(responseTimeService.getComplex()).then(x -> {
            var response = new ComplexResponse();
            response.setVersion(expectedVersion);

            return response;
        });

        var result = responseTimeController.restV1ComplexGet();

        assertNotNull(result);
        assertEquals(expectedVersion, result.getBody().getVersion());

        Mockito.verify(responseTimeService, times(1)).getComplex();
    }
}
