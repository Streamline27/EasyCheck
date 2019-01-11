package main.constraint.descriptions;

public class ConstraintTypeDescription {

    private LengthDescription maxLengthDescription;
    private LengthDescription minLengthDescription;
    private RegexDescription regexDescription;

    public LengthDescription maxLength() {
        this.maxLengthDescription = new LengthDescription(this);
        return maxLengthDescription;
    }

    public LengthDescription minLength() {
        this.minLengthDescription = new LengthDescription(this);
        return minLengthDescription;
    }

    public RegexDescription regex() {
        this.regexDescription = new RegexDescription(this);
        return regexDescription;
    }
}
