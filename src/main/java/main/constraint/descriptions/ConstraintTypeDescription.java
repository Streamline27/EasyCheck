package main.constraint.descriptions;

import main.constraint.MapExceptions;

public class ConstraintTypeDescription {

    public final LengthDescription maxLengthDescription;
    public final LengthDescription minLengthDescription;
    public final RegexDescription regexDescription;
    public final NotNullDescription notNullDescription;
    public final NotEmptyDescription notEmptyDescription;

    private ConstraintTypeDescription(Builder builder) {
        this.maxLengthDescription = builder.maxLengthBuilder.build();
        this.minLengthDescription = builder.minLengthBuilder.build();
        this.regexDescription = builder.regexBuilder.build();
        this.notEmptyDescription = builder.notEmptyBuilder.build();
        this.notNullDescription = builder.notNullBuilder.build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private LengthDescription.Builder maxLengthBuilder;
        private LengthDescription.Builder minLengthBuilder;
        private RegexDescription.Builder regexBuilder;
        private NotNullDescription.Builder notNullBuilder;
        private NotEmptyDescription.Builder notEmptyBuilder;

        public LengthDescription.Builder maxLength() {
            this.maxLengthBuilder = LengthDescription.builder(this);
            return maxLengthBuilder;
        }

        public LengthDescription.Builder maxLength(int length) {
            this.maxLengthBuilder = LengthDescription.builder(this)
                    .shouldBe(length);

            return maxLengthBuilder;
        }

        public LengthDescription.Builder minLength() {
            this.minLengthBuilder = LengthDescription.builder(this);
            return minLengthBuilder;
        }

        public LengthDescription.Builder minLength(int length) {
            this.minLengthBuilder = LengthDescription.builder(this)
                    .shouldBe(length)
                    .elseReport(MapExceptions.EXC_TEXT_TO_SHORT);

            return minLengthBuilder;
        }

        public RegexDescription.Builder regex() {
            this.regexBuilder = RegexDescription.builder(this);
            return regexBuilder;
        }

        public RegexDescription.Builder regex(String pattern) {
            this.regexBuilder = RegexDescription.builder(this)
                    .shouldMatch(pattern)
                    .elseReport(MapExceptions.EXC_FORMAT_MISMATCH);

            return regexBuilder;
        }

        public NotNullDescription.Builder notNull() {
            this.notNullBuilder = NotNullDescription.builder(this)
                .elseReport(MapExceptions.EXC_TEXT_IS_NULL);
            return notNullBuilder;
        }

        public NotEmptyDescription.Builder notEmpty() {
            this.notEmptyBuilder = NotEmptyDescription.builder(this)
                    .elseReport(MapExceptions.EXC_TEXT_IS_EMPTY);

            return notEmptyBuilder;
        }

        public ConstraintTypeDescription build() {
            return new ConstraintTypeDescription(this);
        }
    }

}
