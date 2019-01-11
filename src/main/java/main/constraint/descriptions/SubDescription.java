package main.constraint.descriptions;

public abstract class SubDescription {

    private final ConstraintTypeDescription constraintTypeDescription;

    protected SubDescription(ConstraintTypeDescription constraintTypeDescription) {
        this.constraintTypeDescription = constraintTypeDescription;
    }

    public ConstraintTypeDescription and() {
        return constraintTypeDescription;
    }

    public ConstraintTypeDescription build() {
        return constraintTypeDescription;
    }
}
