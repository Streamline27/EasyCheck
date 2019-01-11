package main.constraint.descriptions;

import java.util.regex.Pattern;

public class RegexDescription extends SubDescription {
    private Pattern pattern;
    private String exceptionCode;

    protected RegexDescription(ConstraintTypeDescription constraintTypeDescription) {
        super(constraintTypeDescription);
    }

    public RegexDescription shouldMatch(String pattern) {
        this.pattern = Pattern.compile(pattern);
        return this;
    }

    public RegexDescription elseReport(String exceptionCode) {
        this.exceptionCode = exceptionCode;
        return this;
    }
}
