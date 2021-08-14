package com.company;

public class Car {
    String nomer;
    int benz;
    boolean isArendovan;
    public int getFuelAmount(){
        return benz;
    }

    @Override
    public String toString() {
        return "Car{" +
                "nomer='" + nomer + '\'' +
                ", benz=" + benz +
                ", isArendovan=" + isArendovan +
                '}';
    }
}
