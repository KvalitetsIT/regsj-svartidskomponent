package dk.kvalitetsit.hello.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class FileServiceImpl implements FileService {
    private final String folder;

    public FileServiceImpl(String folder) {
        this.folder = folder;
    }

    @Override
    public String createFile() throws IOException {
        var fileName = UUID.randomUUID().toString();

        var path = Path.of(folder, fileName);

        Files.writeString(path, UUID.randomUUID().toString(), Charset.defaultCharset());

        return fileName;
    }

    @Override
    public void deleteFile(String fileName) throws IOException {
        Files.delete(Path.of(folder, fileName));
    }
}
