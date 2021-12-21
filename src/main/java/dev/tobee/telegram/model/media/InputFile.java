package dev.tobee.telegram.model.media;

public record InputFile(String fileName, String mimeType, byte[] content) {
}
