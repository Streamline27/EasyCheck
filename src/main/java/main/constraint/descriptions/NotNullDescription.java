package main.constraint.descriptions;

public class NotNullDescription {

    private final boolean notNull;
    private final String exceptionCode;

    public boolean isNotNull() {
        return notNull;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    private NotNullDescription(Builder builder) {
        this.notNull = builder.notNull;
        this.exceptionCode = builder.exceptionCode;
    }

    public static Builder builder(ConstraintTypeDescription.Builder constraintTypeDescriptionBuilder) {
        return new Builder(constraintTypeDescriptionBuilder);
    }

    public static final class Builder extends SubDescriptionBuilder {
        private boolean notNull;
        private String exceptionCode;

        Builder(ConstraintTypeDescription.Builder constraintTypeDescriptionBuilder) {
            super(constraintTypeDescriptionBuilder);
            this.notNull = true;
        }

        public NotNullDescription build() {
            return new NotNullDescription(this);
        }

        public Builder notNull(boolean notNull) {
            this.notNull = notNull;
            return this;
        }

        public Builder elseReport(String exceptionCode) {
            this.exceptionCode = exceptionCode;
            return this;
        }
    }
}
