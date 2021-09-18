package dev.tobee.telegram.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dev.tobee.telegram.util.InputFileSerialiser;

@JsonSerialize(using = InputFileSerialiser.class)
public record InputFile(String fileName, String mimeType, byte[] content){
}
