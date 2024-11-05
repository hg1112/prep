package org.example;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LambdaFunctions {

    /***
     * Article :
     *  https://www.geeksforgeeks.org/lambda-expressions-java-8/
     *  https://stackoverflow.com/questions/25192108/what-is-the-breakdown-for-javas-lambda-syntax
     *
     */

    ArrayList<Integer> arr = new ArrayList<>();
    int factor = 5;

    LambdaFunctions() {
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
    }

    // System.out.print == stdout in c
    public void example1() {
        // in java, expressions are one whole statement which may(not) evalute to a return
        arr.forEach(a -> System.out.println("Expression :" + a*2));
    }

    public void example2() {
        arr.forEach(a -> {
            int b = a * factor;
            String s = "Code block " + b;
//          return s; // try this -> it will say compilation failure as foreach does not expect a return
        });
    }

    public void example3() {
        arr.forEach(a -> {
            int b = a + factor;
            String s = "Code block with foreach" + b;
            System.out.println(s);
            // return s throws compilation failure as foreach does not expect a return
        });
    }

    public void example4() {
        System.out.println(arr.stream().map(a -> {
            int b = a + factor;
            String s = "Code block with map " + b;
            return s; // remove of return as map expects a return type
        }).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        LambdaFunctions lbf = new LambdaFunctions();
        lbf.example1();
        lbf.example2();
        lbf.example3();
        lbf.example4();
    }
}
