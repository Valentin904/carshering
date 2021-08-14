package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Path filepath = Paths.get("Cars.txt");

    public static void main(String[] args) throws IOException {
         ArrayList<Car> cars = new ArrayList<>();
        while (true) {
            System.out.println("1.Добавить новый автомобиль");
            System.out.println("2.Удалить существующий автомобиль по её гос. номеру");
            System.out.println("3.Показать список всех автомобилей");
            System.out.println("4.Показать список арендованных автомобилей");
            System.out.println("5.Показать список свободных автомобилей (неарендованные автомобили)");
            System.out.println("6.Обозначить автомобиль как арендованный");
            System.out.println("7.Обозначить автомобиль как свободный");
            System.out.println("8.Список авто по остатку топлива");
            System.out.println("9.Сохранить файл");
            System.out.println("10.Востановление из файла автомобили");
            System.out.println("11.Выйти из приложения");

            String vvodSClaviatyry = scanner.nextLine();
            if (vvodSClaviatyry.equals("1")) {
                Car car = new Car();
                car.nomer = read("Введите номер авто");
                System.out.println("Введите остаток топлива");
                car.benz = Integer.parseInt(scanner.nextLine());
                car.isArendovan = false;

                cars.add(car);
            }
            if (vvodSClaviatyry.equals("2")) {
                String delete = read("Введите номер авто");
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
            if (vvodSClaviatyry.equals("5")) {
                for (Car car : cars) {
                    if (!car.isArendovan) {
                        System.out.println(car);

                    }
                }
            }
            if (vvodSClaviatyry.equals("6")) {
                String bron = read("Введите номер авто");
                for (Car car : cars) {
                    if (bron.equals(car.nomer)) {
                       if (car.isArendovan){
                           System.out.println("Авто уже арендован");
                           break;
                       }
                        car.isArendovan = true;

                    }

                }
            }
            if (vvodSClaviatyry.equals("7")) {
//                System.out.println("Введите номер авто");
                String nobron = read("Введите номер авто");
                for (Car car : cars) {
                    if (nobron.equals(car.nomer)) {
                        if (!car.isArendovan){
                            System.out.println("Автомобиль уже свободный");
                            break;
                        }
                        car.isArendovan = false;
                    }
                }
            }
            if (vvodSClaviatyry.equals("8")) {
                List<Car> sort = cars.stream()
                        .sorted(Comparator.comparing(Car::getFuelAmount).reversed())
                        .collect(Collectors.toList());
                System.out.println(sort);
//                int[] ostatok = new int[cars.size()];
//                for (int a = 0; a < cars.size(); a++){
//                    ostatok[a] = cars.get(a).benz;
//                }
//                int max = -1;
//                for (int a = 0; a < cars.size(); a++){
//                    int benz = ostatok[a] ;
//                    if (benz > max){
//                        max = benz;
//                    }
//                    ostatok[a]
//                }
//
//                System.out.println(max);
            }
            if (vvodSClaviatyry.equals("9")) {
                createfileifnotexist();
                try (final BufferedWriter writer = Files.newBufferedWriter(filepath)) {
                    writer.write("");
                    writer.flush();
                }
                for (Car car : cars) {
                    Files.write(filepath, getCarBytes(car), StandardOpenOption.APPEND);


                }
            }
            if (vvodSClaviatyry.equals("10")){
                createfileifnotexist();
                List<String> lines = Files.readAllLines(filepath);
                cars.clear();

                for (String line: lines){
                    String[] elements = line.split(",");
                    Car car = new Car();
                    car.nomer = elements[0];
                    car.benz = Integer.parseInt(elements[1]);
                    car.isArendovan = Boolean.parseBoolean(elements[2]);
                    cars.add(car);

                }
            }


            if (vvodSClaviatyry.equals("11")) {
                break;
            }
        }

    }

    static String read(String help) {
        System.out.println(help + ":");
        return scanner.nextLine();
    }

    static void createfileifnotexist() throws IOException {
        boolean notExist = Files.notExists(filepath);
        if (notExist) {
            Files.createFile(filepath);
        }


    }

    static byte[] getCarBytes(Car car) {
        String file = car.nomer + "," + car.benz + "," + car.isArendovan + "\n";
        byte[] bytes = file.getBytes(StandardCharsets.UTF_8);
        return bytes;
    }
}
