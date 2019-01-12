package main;

import main.constraint.ConstrainType;

public class Main {
    public static void main(String[] args) {

        System.out.println("Max length params:");
        System.out.println(ConstrainType.PHONE_NUMBER.maxLength().getLength());
        System.out.println(ConstrainType.PHONE_NUMBER.maxLength().getExceptionCode());

        System.out.println();

        System.out.println("Min length params:");
        System.out.println(ConstrainType.PHONE_NUMBER.minLength().getLength());
        System.out.println(ConstrainType.PHONE_NUMBER.minLength().getExceptionCode());

        System.out.println();

        System.out.println("Regex params:");
        System.out.println(ConstrainType.PHONE_NUMBER.regex().getPattern());
        System.out.println(ConstrainType.PHONE_NUMBER.regex().getExceptionCode());

        System.out.println();
        System.out.println("Is not empty: " + ConstrainType.PHONE_NUMBER.isNotEmpty());
        System.out.println("Is not null: "  + ConstrainType.PHONE_NUMBER.isNotNull());
    }
}
