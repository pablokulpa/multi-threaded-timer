package com.codecool;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        List<Timer> timers = new LinkedList<>();

        String command;
        Scanner scanner = new Scanner(System.in);

        while (true){
            command = scanner.next();
            if(command.equals("start")){
                String name = scanner.next();
                Timer timer = timers.stream().filter(timero -> timero.getName().equals(name)).findFirst().orElse(null);
                if(timer == null){
                    timer = new Timer(name);
                    timer.start();
                    timers.add(timer);
                } else {
                    timers.remove(timer);
                    timer = new Timer(timer.getName(),timer.getTime());
                    timer.start();
                    timers.add(timer);
                }
            }
            if(command.equals("check")){
                timers.stream().map(Timer::getTimerInfo).forEach(System.out::println);
            }

            if(command.equals("stop")){
                String finalName = scanner.next();
                timers.stream().filter(timer -> timer.getName().equals(finalName)).forEach(timer -> timer.interrupt());
            }

            if(command.equals("exit")){
                System.exit(0);
            }
        }
    }
}
