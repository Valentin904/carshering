package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Newcars {
    public static void main(String[] args) throws IOException {
        ArrayList<Cer> carsi = new ArrayList<>();
        while (true) {

            System.out.println("1.Добавить новый автомобиль");
            System.out.println("2.Удалить существующий автомобиль по её гос. номеру");
            System.out.println("3.Показать список всех автомобилей");
            System.out.println("4.Показать список арендованных автомобилей");
            System.out.println("5.Показать список свободных автомобилей (не арендованные автомобили)");
            System.out.println("6.Обозначить автомобиль как арендованный");
            System.out.println("7.Обозначить автомобиль как свободный");
            System.out.println("8.Список авто по остатку топлива");
            System.out.println("9.Сохранить файл");
            System.out.println("10.Востановление из файла автомобили");
            System.out.println("11.Выйти из приложения");
            Scanner scanner = new Scanner(System.in);
            String vvod = scanner.nextLine();
            switch (vvod) {
                case "1": {
                    System.out.println("Введите гос номер");
                    Cer cer = new Cer();
                    cer.gosnomer = scanner.nextLine();
                    System.out.println("Количество саляры");
                    cer.salara = Integer.parseInt(scanner.nextLine());
                    cer.bron = false;
                    carsi.add(cer);
                    break;
                }
                case "2": {
                    System.out.println("Введите гос номер");
                    String del = scanner.nextLine();
                    for (Cer cer : carsi) {
                        if (del.equals(carsi)) ;
                        carsi.remove(cer);
                        break;
                    }
                }

                case "3": {
                    System.out.println(carsi);
                    break;
                }

                case "4": {
                    for (Cer cer : carsi) {
                        if (cer.bron) {
                            System.out.println(cer);
                        }
                    }
                    break;
                }

                case "5": {
                    for (Cer cer : carsi) {
                        if (!cer.bron)
                            System.out.println(!cer.bron);
                    }
                    break;
                }

                case "6": {
                    System.out.println("Введите гос номер");
                    String arendovan = scanner.nextLine();
                    for (Cer cer : carsi) {
                        if (arendovan.equals(cer.gosnomer)) {
                            cer.bron = true;
                            break;
                        }
                    }
                    break;
                }

                case "7": {
                    System.out.println("Введите гос номер");
                    String nearendovan = scanner.nextLine();
                    for (Cer cer : carsi) {
                        if (nearendovan.equals(cer.gosnomer)) {
                            cer.bron = false;
                            break;
                        }
                    }
                    break;
                }
                case "8": {
                    // 1 2 3
                    // 2 2 3
                    int[] benz = new int[carsi.size()];
                    int i = 0;
                    for (Cer cer : carsi) benz[i++] = cer.salara;
                    System.out.println(benz);
                    for (int w = 0; w < benz.length; w++) {
                        for (int j = w + 1; j < benz.length; j++) {
                            int tekyh = benz[w];
                            int sled = benz[j];
                            if (sled > tekyh) {
                                benz[w] = sled;
                                benz[j] = tekyh;
                            }
                        }
                    }
                    System.out.println(Arrays.toString(benz));
                }
                break;


                case "11": {
                    System.exit(0);
                }


            }
        }

    }
}
