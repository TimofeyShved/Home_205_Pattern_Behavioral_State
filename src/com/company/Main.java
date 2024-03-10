package com.company;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
	    // Паттерн (Состояния) меняет действия в зависимости от ситуации

        // мы передали состояние и текст, получили маленький
        Context context = new Context(new LoverCaseStat(), "Text One");
        context.doAction();
        // поменяли состояние, получили большой текст
        context.setState(new UpperCaseStat());
        context.doAction();
    }
}

interface State{
    void doAction(Context context);
}

class LoverCaseStat implements State{
    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toLowerCase());
    }
}

class UpperCaseStat implements State{
    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toUpperCase());
    }
}

// обёртка для взаимодействия с тестом в зависимости от состояния
class Context{
    State state;
    String name;

    public Context(State state, String name) {
        this.state = state;
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }

    // вызывает действия прописанные от состояния
    void doAction(){
        state.doAction(this);
    }

}
