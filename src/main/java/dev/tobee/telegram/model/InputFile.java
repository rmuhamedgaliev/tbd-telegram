package dev.tobee.telegram.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dev.tobee.telegram.util.InputFileSerializer;

@JsonSerialize(using = InputFileSerializer.class)
public record InputFile(String fileName, String mimeType, byte[] content){
}
