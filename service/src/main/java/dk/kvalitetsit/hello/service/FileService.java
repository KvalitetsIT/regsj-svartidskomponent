package dk.kvalitetsit.hello.service;

import java.io.IOException;

public interface FileService {
    String createFile() throws IOException;

    void deleteFile(String fileName) throws IOException;
}
