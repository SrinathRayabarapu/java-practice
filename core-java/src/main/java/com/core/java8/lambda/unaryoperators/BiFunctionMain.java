package com.core.java8.lambda.unaryoperators;

import com.strings.random.RandomSentenses;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class BiFunctionMain {

    public static void main(String[] args) {

        BiFunction<String, String, Integer> lengthBiFunction = (s, s2) -> (s+s2).length();
        System.out.println("lengthBiFunction.apply(\"srinath\",\"rayabarapu\") = " + lengthBiFunction.apply("srinath", "rayabarapu"));

        List<String> randomNames = new RandomSentenses().getOf(10);
        System.out.println("randomNames = " + randomNames);
        List<Integer> lengths = getLengthOfTwoStrings(randomNames, lengthBiFunction);
        System.out.println("lengths = " + lengths);
    }

    private static <T, R> List<R> getLengthOfTwoStrings(List<T> randomNames, BiFunction<T, T, R> lengthBiFunction) {
        List<R> lengths = new ArrayList<>();
        randomNames.forEach(t -> lengths.add(lengthBiFunction.apply(t,t)));
        return lengths;
    }

}
