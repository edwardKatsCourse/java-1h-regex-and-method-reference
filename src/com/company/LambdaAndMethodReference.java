package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaAndMethodReference {

    public static void main(String[] args) {
	    //1. Method reference
        //2. Regex

        List<Integer> ints = new ArrayList<>();

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        //NO LAMBDA
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
                System.out.println(1 == 1);
            }
        });

        ints.forEach(/*единственный метод интерфейса*/(x) -> System.out.println(x));

        list.forEach(/*parameter*/variable ->
        //method body
        {
            System.out.println(variable);
        });
        //   iterable + что с ним делать
        list.forEach(x -> System.out.println(x));
        list.forEach(System.out::println);

        //a, b, c, d
        //sout + tab

        //x -> Main.print(x)
        list.forEach(/*x -> */LambdaAndMethodReference::print/*(x)*/);


        Runnable r = /*run*/() -> System.out.println("Hello");

//        Stream API
//        list.stream()
//
//                .map(x -> x.getFirstName())
//                .filter(x -> x.contains("a") || x.contains("b"))
//                .findAny()
//                .map(x -> x.trim())
//                .orElse(null);
    }

    public static void print(String value) {
        System.out.println(value);
    }
}

