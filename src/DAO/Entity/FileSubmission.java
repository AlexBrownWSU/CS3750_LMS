package DAO.Entity;

import java.io.InputStream;
import java.sql.Blob;

public class FileSubmission {
    String fileName;
    Blob file;

    InputStream fileInput;
    int fileLength;

    public void setFilename(String fileName){this.fileName = fileName;}
    public String getFilename(){return fileName;}

    public Blob getFile() {
        return file;
    }
    public void setFile(Blob file) {
        this.file = file;
    }

    public void setFileInput(InputStream fileInput){this.fileInput = fileInput;}
    public InputStream getFileInput(){return fileInput;}

    public void setFileLength(int fileLength){this.fileLength = fileLength;}
    public int getFileLength(){return fileLength;}

}
