package com.codecool;

public class Timer extends Thread {

    private long time;

    public Timer(String name, long time) {
        this.time = time;
        setName(name);
    }

    public Timer(String name) {
        setName(name);
    }

    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                time++;
            } catch (InterruptedException e) {
                System.out.println(getName() + " received interrupt while sleeping");
                break;
            }
        }
    }

    public String getTimerInfo(){
        return "Name: " + getName() + ", Thread id: " + getId() + ", time: " + time;
    }

    public long getTime() {
        return time;
    }
}
