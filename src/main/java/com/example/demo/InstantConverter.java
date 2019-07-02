package com.example.demo;

import javax.persistence.AttributeConverter;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * @author peter
 * date: 2019-07-02 11:23
 **/
public class InstantConverter implements AttributeConverter<Instant, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(Instant attribute) {
        return Timestamp.from(attribute);
    }

    @Override
    public Instant convertToEntityAttribute(Timestamp dbData) {
        return dbData.toInstant();
    }
}
