package main.constraint.descriptions;

public class NotEmptyDescription {

    private final boolean notEmpty;
    private final String exceptionCode;

    private NotEmptyDescription(Builder builder) {
        this.notEmpty = builder.notEmpty;
        this.exceptionCode = builder.exceptionCode;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public boolean isNotEmpty() {
        return notEmpty;
    }

    public static Builder builder(ConstraintTypeDescription.Builder constraintTypeDescriptionBuilder) {
        return new Builder(constraintTypeDescriptionBuilder);
    }

    public static final class Builder extends SubDescriptionBuilder{
        private boolean notEmpty;
        private String exceptionCode;

        private Builder(ConstraintTypeDescription.Builder constraintTypeDescriptionBuilder) {
            super(constraintTypeDescriptionBuilder);
            this.notEmpty = true;
        }

        public NotEmptyDescription build() {
            return new NotEmptyDescription(this);
        }

        public Builder elseReport(String exceptionCode) {
            this.exceptionCode = exceptionCode;
            return this;
        }
    }
}
