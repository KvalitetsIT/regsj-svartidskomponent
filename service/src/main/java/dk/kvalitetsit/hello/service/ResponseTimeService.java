package dk.kvalitetsit.hello.service;

import dk.kvalitetsit.hello.service.model.ComplexResponse;
import dk.kvalitetsit.hello.service.model.SimpleResponse;

import java.io.IOException;

public interface ResponseTimeService {
    SimpleResponse getSimple();
    ComplexResponse getComplex() throws IOException;
}
