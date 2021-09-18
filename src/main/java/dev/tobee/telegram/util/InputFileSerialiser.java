package dev.tobee.telegram.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import dev.tobee.telegram.model.InputFile;

import java.io.IOException;

public class InputFileSerialiser extends JsonSerializer<Object> {

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

        gen.writeObjectField("photo", (InputFile) value);

        System.out.println();
    }
}
