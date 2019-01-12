package main.constraint.descriptions;

public class LengthDescription {
    private final int length;
    private final String exceptionCode;

    private LengthDescription(Builder builder) {
        this.length = builder.length;
        this.exceptionCode = builder.exceptionCode;
    }

    public int getLength() {
        return length;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public static Builder builder(ConstraintTypeDescription.Builder constraintTypeDescriptionBuilder) {
        return new Builder(constraintTypeDescriptionBuilder);
    }

    public static final class Builder extends SubDescriptionBuilder {
        private int length;
        private String exceptionCode;
        private ConstraintTypeDescription.Builder constraintTypeDescriptionBuilder;

        Builder(ConstraintTypeDescription.Builder constraintTypeDescriptionBuilder) {
            super(constraintTypeDescriptionBuilder);
        }

        LengthDescription build() {
            return new LengthDescription(this);
        }

        public Builder shouldBe(int length) {
            this.length = length;
            return this;
        }

        public Builder elseReport(String exceptionCode) {
            this.exceptionCode = exceptionCode;
            return this;
        }
    }
}
