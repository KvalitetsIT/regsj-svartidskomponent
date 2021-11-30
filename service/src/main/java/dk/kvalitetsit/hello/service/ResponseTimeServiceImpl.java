package dk.kvalitetsit.hello.service;

import dk.kvalitetsit.hello.service.model.ComplexResponse;
import dk.kvalitetsit.hello.service.model.SimpleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ResponseTimeServiceImpl implements ResponseTimeService {
    private final Logger logger = LoggerFactory.getLogger(ResponseTimeServiceImpl.class);
    private final String expectedVersion;
    private final FileService fileService;

    public ResponseTimeServiceImpl(String expectedVersion, FileService fileService) {
        this.expectedVersion = expectedVersion;

        this.fileService = fileService;
    }

    @Override
    public SimpleResponse getSimple() {
        var result = new SimpleResponse();
        result.setVersion(expectedVersion);

        return result;
    }

    @Override
    public ComplexResponse getComplex() throws IOException {
        logger.info("Complex business logic.");

        var fileName = fileService.createFile();
        fileService.deleteFile(fileName);

        var result = new ComplexResponse();
        result.setVersion(expectedVersion);
        return result;
    }
}
