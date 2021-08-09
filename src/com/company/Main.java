package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final ArrayList<Car> cars = new ArrayList<>();
        while (true) {
            System.out.println("1.Добавить новый автомобиль");
            System.out.println("2.Удалить существующий автомобиль по её гос. номеру");
            System.out.println("3.Показать список всех автомобилей");
            System.out.println("4.Показать список арендованных автомобилей");
            System.out.println("5.Показать список свободных автомобилей (неарендованные автомобили)");
            System.out.println("6.Обозначить автомобиль как арендованный");
            System.out.println("7.Обозначить автомобиль как свободный");
            System.out.println("8.Выйти из приложения");
            Scanner scanner = new Scanner(System.in);
            String vvodSClaviatyry = scanner.nextLine();
            if (vvodSClaviatyry.equals("1")) {
                System.out.println("Введите номер авто");
                Car car = new Car();
                car.nomer = scanner.nextLine();
                System.out.println("Введите остаток топлива");
                car.benz = Integer.parseInt(scanner.nextLine());
                car.isArendovan = false;

                cars.add(car);
            }
            if (vvodSClaviatyry.equals("2")) {
                System.out.println("Введите номер авто");
                String delete = scanner.nextLine();
                for (Car car : cars) {
                    if (delete.equals(car.nomer)) {
                        cars.remove(car);
                        break;
//                   Iterator<Car> iterator = cars.iterator();
//                   while (iterator.hasNext()){
//                       Car car = iterator.next();
//                       if (delete.equals(car.nomer)){
//                           cars.remove(car);(2 способ удаления обьекта)
//                       }
                    }

                }

            }
            if (vvodSClaviatyry.equals("3")) {
                System.out.println(cars);
            }
            if (vvodSClaviatyry.equals("4")) {
                for (Car car : cars) {
                    if (car.isArendovan) {
                        System.out.println(car);

                    }
                }
            }
            if (vvodSClaviatyry.equals("5")){
                for (Car car : cars) {
                    if (!car.isArendovan){

                    }
                }
            }
            if (vvodSClaviatyry.equals("6")) {
                System.out.println("Введите номер авто");
                String bron = scanner.nextLine();
                for (Car car : cars) {
                    if (bron.equals(car.nomer)) {
                        car.isArendovan = true;
                    }

                }
            }
            if (vvodSClaviatyry.equals("7")){
                System.out.println("Введите номер авто");
                String nobron = scanner.nextLine();
                for (Car car : cars){
                    if (nobron.equals(car.nomer)){
                        car.isArendovan = false;
                    }
                }
            }
            if (vvodSClaviatyry.equals("8")) {
                break;
            }
        }

    }
}
