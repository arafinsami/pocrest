package com.poc.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import nablarch.core.message.Message;
import nablarch.core.message.StringResource;
import nablarch.core.util.StringUtil;
import nablarch.core.validation.ValidationResultMessage;
import nablarch.core.validation.ee.ConstraintViolationConverter;
import nablarch.core.validation.ee.ConstraintViolationConverterFactory;

import java.util.Locale;

public class SimpleConstraintViolationConverterFactory extends ConstraintViolationConverterFactory {

    @Override
    public ConstraintViolationConverter create() {
        return new SimpleConstraintViolationConverter("");
    }

    @Override
    public ConstraintViolationConverter create(String prefix) {
        return new SimpleConstraintViolationConverter(prefix);
    }

    private static class SimpleConstraintViolationConverter extends ConstraintViolationConverter {
        private final String prefix;

        public SimpleConstraintViolationConverter(String prefix) {
            this.prefix = StringUtil.hasValue(prefix) ? prefix + "." : "";
        }

        private static String getLeafPropertyName(ConstraintViolation<?> violation) {
            Path path = violation.getPropertyPath();
            String propertyName = null;
            for (Path.Node node : path) {
                propertyName = node.getName();
            }
            return propertyName;
        }

        @Override
        public Message convert(ConstraintViolation<?> violation) {
            String propertyName = getLeafPropertyName(violation);
            StringResource stringResource = new ViolationBasedStringResource(violation);

            return new ValidationResultMessage(
                    prefix + propertyName,
                    stringResource,
                    (Object[]) null
            );
        }
    }

    private static class ViolationBasedStringResource implements StringResource {
        private final String id;
        private final String message;

        public ViolationBasedStringResource(ConstraintViolation<?> violation) {
            this.id = violation.getConstraintDescriptor().getAnnotation().annotationType().getName();
            this.message = violation.getMessage();
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public String getValue(Locale locale) {
            return message;
        }
    }
}
