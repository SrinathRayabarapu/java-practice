package com.dpattern.behavioural.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * Changing the object behaviour at runtime.
 *
 * Ref: https://www.youtube.com/watch?v=-y5gssAvE7E
 */
public class StrategyPatternEx2Main {

    public static void main(String[] args) {

        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubtraction());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiplication());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationDivide());
        System.out.println("10 / 5 = " + context.executeStrategy(10, 5));
    }

}

interface Strategy{
    int doOperation(int x, int y);
}

@Slf4j
class OperationAdd implements Strategy{
    @Override
    public int doOperation(int x, int y) {
        return x + y;
    }
}

@Slf4j
class OperationSubtraction implements Strategy{
    @Override
    public int doOperation(int x, int y) {
        return x - y;
    }
}

@Slf4j
class OperationMultiplication implements Strategy{
    @Override
    public int doOperation(int x, int y) {
        return x * y;
    }
}

@Slf4j
class OperationDivide implements Strategy{
    @Override
    public int doOperation(int x, int y) {
        return x / y;
    }
}

class Context{
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int x, int y){
        return strategy.doOperation(x, y);
    }

}