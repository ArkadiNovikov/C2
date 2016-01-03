/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.dataaccess.converter;

import java.nio.ByteBuffer;
import java.util.UUID;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Novikov {@link java.util.UUID} &lt;=&gt; {@code byte[]}変換を行うJPAコンバーター
 */
@Converter(autoApply = false)
public class UUIDToBytesConverter implements AttributeConverter<UUID, byte[]> {

    @Override
    public byte[] convertToDatabaseColumn(final UUID attribute) {
        if (attribute == null) {
            return null;
        }

        return ByteBuffer.allocate(16)
                .putLong(attribute.getMostSignificantBits())
                .putLong(attribute.getLeastSignificantBits())
                .array();
    }

    @Override
    public UUID convertToEntityAttribute(final byte[] dbData) {
        if (dbData == null) {
            return null;
        }

        final ByteBuffer buffer = ByteBuffer.wrap(dbData);
        final long most = buffer.getLong();
        final long least = buffer.getLong();
        return new UUID(most, least);
    }
}
