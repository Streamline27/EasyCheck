package main.constraint.descriptions;

public class ConstraintTypeDescription {

    public final LengthDescription maxLengthDescription;
    public final LengthDescription minLengthDescription;
    public final RegexDescription regexDescription;
    public final boolean notNull;
    public final boolean notEmpty;

    private ConstraintTypeDescription(Builder builder) {
        this.maxLengthDescription = builder.maxLengthDescriptionBuider.build();
        this.minLengthDescription = builder.minLengthDescriptionBuilder.build();
        this.regexDescription = builder.regexDescriptionBuilder.build();
        this.notEmpty = builder.notEmpty;
        this.notNull = builder.notNull;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private LengthDescription.Builder maxLengthDescriptionBuider;
        private LengthDescription.Builder minLengthDescriptionBuilder;
        private RegexDescription.Builder regexDescriptionBuilder;
        private boolean notNull;
        private boolean notEmpty;

        public LengthDescription.Builder maxLength() {
            this.maxLengthDescriptionBuider = LengthDescription.builder(this);
            return maxLengthDescriptionBuider;
        }

        public LengthDescription.Builder minLength() {
            this.minLengthDescriptionBuilder = LengthDescription.builder(this);
            return minLengthDescriptionBuilder;
        }

        public RegexDescription.Builder regex() {
            this.regexDescriptionBuilder = RegexDescription.builder(this);
            return regexDescriptionBuilder;
        }

        public ConstraintTypeDescription.Builder notNull() {
            this.notNull = true;
            return this;
        }

        public ConstraintTypeDescription.Builder notEmpty() {
            this.notEmpty = true;
            return this;
        }

        public ConstraintTypeDescription build() {
            return new ConstraintTypeDescription(this);
        }

        public ConstraintTypeDescription end() {
            return new ConstraintTypeDescription(this);
        }
    }

}
