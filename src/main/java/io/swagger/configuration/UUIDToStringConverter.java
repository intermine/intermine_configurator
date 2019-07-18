package io.swagger.configuration;

import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

import java.nio.ByteBuffer;
import java.util.UUID;

@Component
@WritingConverter
public class UUIDToStringConverter implements Converter<UUID, byte[]> {
    @Override
    public byte[] convert(final UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());

        return bb.array();
    }
}