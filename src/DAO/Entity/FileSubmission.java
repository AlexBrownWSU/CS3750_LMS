package DAO.Entity;

import java.io.InputStream;
import java.sql.Blob;

public class FileSubmission {

    String filename;
    Blob file;
    InputStream fileInput;
    int fileLength;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }

    public InputStream getFileInput() {
        return fileInput;
    }

    public void setFileInput(InputStream fileInput) {
        this.fileInput = fileInput;
    }

    public int getFileLength() {
        return fileLength;
    }

    public void setFileLength(int fileLength) {
        this.fileLength = fileLength;
    }
}
