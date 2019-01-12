package main.constraint.descriptions;

abstract class SubDescriptionBuilder {

    private final ConstraintTypeDescription.Builder constraintTypeDescriptionBuilder;

    SubDescriptionBuilder(ConstraintTypeDescription.Builder constraintTypeDescriptionBuilder) {
        this.constraintTypeDescriptionBuilder = constraintTypeDescriptionBuilder;
    }

    public ConstraintTypeDescription.Builder and() {
        return constraintTypeDescriptionBuilder;
    }

    public ConstraintTypeDescription end() {
        return constraintTypeDescriptionBuilder.build();
    }
}
