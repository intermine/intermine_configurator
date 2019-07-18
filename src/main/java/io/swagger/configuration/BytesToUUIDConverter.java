package io.swagger.configuration;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

import java.nio.ByteBuffer;
import java.util.UUID;

@Component
@ReadingConverter
public class BytesToUUIDConverter implements Converter<byte[], UUID> {
    @Override
    public UUID convert(final byte[] b) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(b);
        Long high = byteBuffer.getLong();
        Long low = byteBuffer.getLong();

        return new UUID(high, low);
    }
}