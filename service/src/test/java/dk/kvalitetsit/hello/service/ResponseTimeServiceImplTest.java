package dk.kvalitetsit.hello.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;

public class ResponseTimeServiceImplTest {
    private ResponseTimeService responseTimeService;
    private final String expectedVersion = "1.0.0";
    private FileService fileService;

    @Before
    public void setup() {
        fileService = Mockito.mock(FileService.class);
        responseTimeService = new ResponseTimeServiceImpl(expectedVersion, fileService);
    }

    @Test
    public void testSimple() {
        var result = responseTimeService.getSimple();
        assertNotNull(result);
        assertEquals(expectedVersion, result.getVersion());

        Mockito.verifyNoInteractions(fileService);
    }

    @Test
    public void testComplex() throws IOException {
        var fileName = UUID.randomUUID().toString();
        Mockito.when(fileService.createFile()).thenReturn(fileName);

        var result = responseTimeService.getComplex();
        assertNotNull(result);
        assertEquals(expectedVersion, result.getVersion());

        Mockito.verify(fileService, times(1)).createFile();
        Mockito.verify(fileService, times(1)).deleteFile(fileName);
        Mockito.verifyNoMoreInteractions(fileService);
    }
}
