package main.constraint;

import main.constraint.descriptions.*;

public enum  ConstrainType {

    PHONE_NUMBER(
            description()
                    .maxLength()
                        .shouldBe(15)
                        .elseReport(MapExceptions.EXC_PHONE_NUMBER_TO_LONG)
                .and()
                    .minLength()
                        .shouldBe(5)
                        .elseReport(MapExceptions.EXC_PHONE_NUMBER_TO_SHORT)
                .and()
                    .regex()
                        .shouldMatch("[0-9]+")
                        .elseReport(MapExceptions.EXC_PHONE_NUMBER_INCORRECT)
                .and()
                    .notEmpty()
                .and()
                    .notNull()
                .end()
    ),

    COMPANY_REGISTRATION_NUMBER(
            description()
                    .minLength(5).elseReport(MapExceptions.EXC_TEXT_TO_LONG)
                .and()
                    .maxLength(25)
                .and()
                    .regex("[0-9]+")
                .and()
                    .notEmpty().elseReport(MapExceptions.EXC_REGISTRATION_NUMBER_IS_EMPTY)
                .and()
                    .notNull().elseReport(MapExceptions.EXC_REGISTRATION_NUMBER_IS_NULL)
                .end()
    )
    ;

    private final ConstraintTypeDescription config;

    ConstrainType(ConstraintTypeDescription config) {
        this.config = config;
    }

    private static ConstraintTypeDescription.Builder description() {
        return ConstraintTypeDescription.builder();
    }

    public LengthDescription maxLength() {
        return config.maxLengthDescription;
    }

    public LengthDescription minLength() {
        return config.minLengthDescription;
    }

    public RegexDescription regex() {
        return config.regexDescription;
    }

    public NotNullDescription notNull() {
        return config.notNullDescription;
    }

    public NotEmptyDescription notEmpty() {
        return config.notEmptyDescription;
    }
}
