package Lambdas;

import java.util.List;
import java.util.function.*;

public class LambdasDemo {
    public static void main(String[] args) {
        //anonymous class
        // greet(new Printer() {
        //     @Override
        //     public void printMessage(String message) {
        //  System.out.println(message);
        //     }
        // });

        //the above done better
        greet((message)->{
            System.out.println(message);
        });
        greet(System.out::println);

        //consumers
        List<Integer> list  = List.of(1, 2,3, 4,5,6, 7,8,9,10);
        list.forEach((item)->{
            System.out.println(item);
        });

        List<String> list1 = List.of("a", "B", "c");
        Consumer<String> print = (String item)-> {
            System.out.println(item);
        };
        Consumer<String > printUpperCase = item->{
            System.out.println(item.toUpperCase());
        };

        list1.forEach(print.andThen(printUpperCase));

        //Suppliers
        Supplier<Double> getRandom = Math::random;

        //lazy evaluation (value not gen until we ask for it)
        var random = getRandom.get();
        System.out.println(random);

        DoubleSupplier getRandomNo = Math::random;
        System.out.println(getRandomNo.getAsDouble());



        //Functional interface
        //Composing functions
        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String , String > addBraces = str -> "{" + str + "}";

        var formatted = replaceColon
                .andThen(addBraces)
                .apply("key:value");

        var usingCompose = addBraces.compose(replaceColon).apply("Keyyy:vallll");
        System.out.println(formatted);
        System.out.println(usingCompose);


        //Predicate interface
        Predicate<String> isGraterThan5 = str -> str.length() > 5;
        Boolean res = isGraterThan5.test("good");
        System.out.println(res);

        //combining Predicates
        Predicate<String> hasLeftBrace = s -> s.startsWith("{");
        Predicate<String> hasRightBrace = s -> s.endsWith("}}");
        System.out.println(hasLeftBrace.and(hasRightBrace.negate()).test(formatted));
    }




    public static void greet(Printer printer) {
        printer.printMessage("Hello World");
    }
}
