package com.template.mongo;

import org.joda.time.DateTime;
import org.mongodb.morphia.converters.SimpleValueConverter;
import org.mongodb.morphia.converters.TypeConverter;
import org.mongodb.morphia.mapping.MappedField;
import org.mongodb.morphia.mapping.MappingException;


import java.util.Date;

import static org.joda.time.DateTimeZone.UTC;

public final class DateTimeConverter extends TypeConverter implements SimpleValueConverter {

    public DateTimeConverter() {
        super(DateTime.class);
    }

    @Override
    public final Object encode(Object value, MappedField optionalExtraInfo) throws MappingException {
        if (value == null) {
            return null;
        }
        if (!(value instanceof DateTime)) {
            throw new MappingException("Unable to convert " + value.getClass().getName());
        }
        return ((DateTime) value).toDate();
    }

    @Override
    @SuppressWarnings("rawtypes")
    public DateTime decode(Class targetClass, Object fromDBObject, MappedField optionalExtraInfo) throws MappingException {
        if (fromDBObject == null) {
            return null;
        }
        if (fromDBObject instanceof Number) {
            return new DateTime(new Date(((Number) fromDBObject).longValue()).getTime(), UTC);
        }
        if (fromDBObject instanceof Date) {
            return new DateTime(((Date) fromDBObject).getTime(), UTC);
        }
        throw new MappingException("Unable to convert " + fromDBObject.getClass().getName());
    }
}