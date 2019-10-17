package main.java.ca.jrvs.challenges;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Testing {

    public static void printWithMsg(Object o){
        System.out.println("Result is: " + o.toString());
    }


    public static void main(String[] args) {

        /*
        2 types of functions
        -intermediate
            ex: map, filter, sorted, match, flatMap
        -terminal: consumes the stream (ends it)
            ex: count, forEach, collect, reduce
         */

//        IntStream ints = IntStream.rangeClosed(1,10);
//        IntStream evens = ints.filter(i -> i % 2 == 0);
//        IntStream half = evens.map(i -> i/2);
//        half.forEach(System.out::println);

//        IntStream.rangeClosed(1,10).filter(i -> i%2 == 0).map(i -> i/2).forEach(System.out::println);

        //1
//        Stream<Integer> streamInt = Stream.of(1,2,3,4,5);
        //2
//        IntStream intStream = IntStream.rangeClosed(1,10);
        //3
        //IntStream returns a primitive int stream vs Stream<Integer> creates a Integer Object stream
        //4
//        IntStream.rangeClosed(1,10).mapToDouble(Double::new).map(i -> Math.sqrt(i)).forEach(System.out::println);
        //5
//        IntStream.rangeClosed(1,10).filter(i -> i%2 != 0).forEach(System.out::println);
        //6
//        System.out.println(IntStream.rangeClosed(1,10).filter(i -> i%2 != 0).count());
        //7
//        Consumer<Object> printWithMsgLambda = (obj) ->
//                System.out.println("result is: " + obj.toString());
//        printWithMsgLambda.accept(123);
        //8
//        IntStream.rangeClosed(1,10).filter(i -> i%2 == 0).forEach(printWithMsgLambda::accept);
        //9
//        Stream<List<String>> listStream = Stream.of(Arrays.asList("Andre","Antunes"), Arrays.asList("Bob", "Saget"));
//
//        listStream.flatMap(Collection::stream).map(String::toUpperCase).forEach(printWithMsgLambda);
    }
}
