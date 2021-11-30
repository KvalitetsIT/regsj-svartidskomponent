package dk.kvalitetsit.hello.controller;

import dk.kvalitetsit.hello.service.ResponseTimeService;
import org.openapitools.api.SvartidskomponentApi;
import org.openapitools.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseTimeController implements SvartidskomponentApi {
    private final ResponseTimeService helloService;

    public ResponseTimeController(ResponseTimeService responseTimeService) {
        this.helloService = responseTimeService;
    }

    @Override
    public ResponseEntity<Response> restV1ComplexGet() {
        var responseBody = new Response();
        try {
            responseBody.setVersion(helloService.getComplex().getVersion());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity
                .ok(responseBody);
    }

    @Override
    public ResponseEntity<Response> restV1SimpleGet() {
        var responseBody = new Response();
        responseBody.setVersion(helloService.getSimple().getVersion());

        return ResponseEntity
                .ok(responseBody);
    }
}
