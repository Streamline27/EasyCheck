package main.constraint;

import main.constraint.descriptions.ConstraintTypeDescription;
import main.constraint.descriptions.LengthDescription;
import main.constraint.descriptions.RegexDescription;

public enum  ConstrainType {

    PHONE_NUMBER(
            description()
                    .maxLength()
                        .shouldBe(15)
                        .elseReport(MapExceptions.EXC_TEXT_TO_LONG)
                .and()
                    .minLength()
                        .shouldBe(5)
                        .elseReport(MapExceptions.EXC_TEXT_TO_SHORT)
                .and()
                    .regex()
                        .shouldMatch("[0-9]+")
                        .elseReport(MapExceptions.EXC_PHONE_NUMBER_INCORRECT)
                .and()
                    .notNull()
                    .notEmpty()
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

    public boolean isNotNull() {
        return config.notNull;
    }

    public boolean isNotEmpty() {
        return config.notEmpty;
    }
}
