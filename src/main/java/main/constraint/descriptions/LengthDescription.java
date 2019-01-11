package main.constraint.descriptions;

public class LengthDescription extends SubDescription {
    private int length;
    private String exceptionCode;

    protected LengthDescription(ConstraintTypeDescription constraintTypeDescription) {
        super(constraintTypeDescription);
    }

    public LengthDescription shouldBe(int length) {
        this.length = length;
        return this;
    }

    public LengthDescription elseReport(String exceptionCode) {
        this.exceptionCode = exceptionCode;
        return this;
    }
}
