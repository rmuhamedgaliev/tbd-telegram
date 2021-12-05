package dev.tobee.telegram.model;

public record InputFile(String fileName, String mimeType, byte[] content){
}
