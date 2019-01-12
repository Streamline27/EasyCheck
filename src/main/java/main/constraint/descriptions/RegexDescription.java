package main.constraint.descriptions;

import java.util.regex.Pattern;

public class RegexDescription {
    private final Pattern pattern;
    private final String exceptionCode;

    private RegexDescription(Builder builder) {
        this.pattern = builder.pattern;
        this.exceptionCode = builder.exceptionCode;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public static Builder builder(ConstraintTypeDescription.Builder constraintTypeDescriptionBuilder) {
        return new Builder(constraintTypeDescriptionBuilder);
    }

    public static final class Builder extends SubDescriptionBuilder {
        private Pattern pattern;
        private String exceptionCode;
        private ConstraintTypeDescription.Builder constraintTypeDescriptionBuilder;

        Builder(ConstraintTypeDescription.Builder constraintTypeDescriptionBuilder) {
            super(constraintTypeDescriptionBuilder);
        }

        RegexDescription build() {
            return new RegexDescription(this);
        }

        public Builder shouldMatch(String pattern) {
            this.pattern = Pattern.compile(pattern);
            return this;
        }

        public Builder elseReport(String exceptionCode) {
            this.exceptionCode = exceptionCode;
            return this;
        }
    }
}
