package dev.tobee.telegram.model.media;

public class FileEntity {
    private String fileName;
    private String mimeType;
    private byte[] content;

    public FileEntity() {
    }

    public FileEntity(String fileName, String mimeType, byte[] content) {
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public String getMimeType() {
        return mimeType;
    }

    public byte[] getContent() {
        return content;
    }
}
