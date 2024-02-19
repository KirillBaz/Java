package homework_6;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Laptop lap1 = new Laptop();
        lap1.id = 1;
        lap1.brand = "Huawei";
        lap1.ram = 8;
        lap1.operation_system = "Windows 10";
        lap1.colour = "grey";
        lap1.hdd = 256;

        Laptop lap2 = new Laptop();
        lap2.id = 2;
        lap2.brand = "Acer";
        lap2.ram = 8;
        lap2.operation_system = "Windows 10";
        lap2.colour = "black";
        lap2.hdd = 256;

        Laptop lap3 = new Laptop();
        lap3.id = 3;
        lap3.brand = "Lenovo";
        lap3.ram = 16;
        lap3.operation_system = "Windows 11";
        lap3.colour = "green";
        lap3.hdd = 512;

        Laptop lap4 = new Laptop();
        lap4.id = 4;
        lap4.brand = "MacBook";
        lap4.ram = 16;
        lap4.operation_system = "MacOS";
        lap4.colour = "white";
        lap4.hdd = 512;

        Laptop lap5 = new Laptop();
        lap5.id = 5;
        lap5.brand = "HP";
        lap5.ram = 32;
        lap5.operation_system = "Windows 11";
        lap5.colour = "black";
        lap5.hdd = 1024;

        Set<Laptop> laptops = new HashSet<>();
        laptops.add(lap1);
        laptops.add(lap2);
        laptops.add(lap3);
        laptops.add(lap4);
        laptops.add(lap5);
        Map<Integer, String> searchButtons = new HashMap<>(4);
        searchButtons.put(1, "Введите минимальный объем ОЗУ:");
        searchButtons.put(2, "Введите минимальный объем накопителя:");
        searchButtons.put(3, "Введите операционную систему(Windows 10/Windows 11/MacOs)");
        searchButtons.put(4, "Выберите наименование цвета (grey/black/green/white)");
        Map<Integer, String> conditions = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int parameter = 0;
        while (parameter != 5) {
            System.out.println("Введите цифру, соответствующую необходимому критерию:\n" +
                    "        1 - ОЗУ\n" +
                    "        2 - Объем ЖД\n" +
                    "        3 - Операционная система\n" +
                    "        4 - Цвет …\n" +
                    "        5 - поиск\n");
            parameter = Integer.parseInt(scanner.nextLine());
            if (searchButtons.containsKey(parameter)) {
                System.out.println(searchButtons.get(parameter));
                conditions.put(parameter, scanner.nextLine());
            } else if (parameter != 5) System.out.println("Ввод некорректный");
        }
        scanner.close();
        System.out.println(conditions);
        Set<Laptop> result = new HashSet<>();
        Set<Integer> keys = conditions.keySet();
        for (Laptop laptop : laptops) {
            boolean match1 = true;
            boolean match2 = true;
            boolean match3 = true;
            boolean match4 = true;
            for (Integer key : keys) {
                switch (key) {
                    case 1:
                        if (laptop.ram < Integer.parseInt(conditions.get(key))) match1 = false;
                        break;
                    case 2:
                        if (laptop.hdd < Integer.parseInt(conditions.get(key))) match2 = false;
                        break;
                    case 3:
                        if (!laptop.operation_system.equals(conditions.get(key))) match3 = false;
                        break;
                    case 4:
                        if (!laptop.colour.equals(conditions.get(key))) match4 = false;
                        break;
                }
            }
            if ((match1 & match2 & match3 & match4) == true) result.add(laptop);
        }
        if (result.size() == 0) System.out.println("По данному запросу ничего не можем Вам предложить");
        else {
            System.out.println("Вам могут подойти следующие устройства: ");
            for (Laptop res : result)
                System.out.println(res);
        }
    }
}
