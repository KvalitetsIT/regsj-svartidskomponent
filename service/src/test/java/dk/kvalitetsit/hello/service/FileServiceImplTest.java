package dk.kvalitetsit.hello.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FileServiceImplTest {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void testAndDelete() throws IOException {
        var service = new FileServiceImpl(temporaryFolder.getRoot().getAbsolutePath());

        var fileName = service.createFile();

        var fileContent = Files.readAllLines(Path.of(temporaryFolder.getRoot().getAbsolutePath(), fileName));
        assertEquals(1, fileContent.size());

        service.deleteFile(fileName);

        assertFalse(Files.exists(Path.of(temporaryFolder.getRoot().getAbsolutePath(), fileName)));
    }
}
