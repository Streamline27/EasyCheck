package main.constraint;

import main.constraint.descriptions.ConstraintTypeDescription;

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
                .build()
    )
    ;

    private final ConstraintTypeDescription config;

    ConstrainType(ConstraintTypeDescription config) {
        this.config = config;
    }

    private static ConstraintTypeDescription description() {
        return new ConstraintTypeDescription();
    }

    public ConstraintTypeDescription getConfig() {
        return config;
    }
}
