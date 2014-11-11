/**
 * Created by Devil Trigger S on 03.11.2014.
 */

import java.util.Scanner;

class Address {
    public String name;
    public String fam;
    public String phone;
    public int year;

    public Address(String n, String f, String p, int y) {
        name = n;
        fam = f;
        phone = p;
        year = y;
    }
}

class AdressList {

    private Address[] list = new Address[10];
    private int count = 0;

    public static int Dobav(AdressList book, String n1, String n2, String n3, int n4) {
        book.list[book.count] = new Address(n1, n2, n3, n4);
        book.count++;
        return 0;
    }

    public static int Izm(AdressList book, int nInd, String n1, String n2, String n3, int n4) {
        book.list[nInd] = new Address(n1, n2, n3, n4);
        return 0;
    }

    public static int FindMan(AdressList book, String search) {
        int x = 0;
        for (int i = 0; i < book.count; i++) {
            Address a = book.list[i];
            if (a.name.equals(search)) {
                System.out.println(book.list[i].name + " " + book.list[i].fam + " " + book.list[i].phone + " " + book.list[i].year);
                x++;
            }
        }
        if (x == 0) {
            System.out.println("Совпадений не Найдено");
        }
        return 0;
    }

    public static int Vuvod(AdressList book) {
        if (book.count == 0) {
            System.out.println("В Адресной Кониге Нет Записей");
        } else {
            for (int i = 0; i < book.count; i++) {
                System.out.println(book.list[i].name + " " + book.list[i].fam + " " + book.list[i].phone + " " + book.list[i].year);
            }
        }
        return 0;
    }

    public static int VuvodVse(AdressList book) {
        if (book.count == 0) {
            System.out.println("В Адресной Кониге Нет Записей");
        } else {
            System.out.println("Количество Записей =" + book.count);
        }
        return 0;
    }

    public static int DeleteZap(AdressList book, int VvodDel) {
            for (int i = VvodDel; i <= book.count - 2; i++) {
                book.list[i] = book.list[i + 1];
            }
            book.count--;
        return 0;
    }

    public static int Check(AdressList book, int Chk){
        if (Chk < 0 || Chk >= book.count) {
            return 0;}
        else {
            return 1;}
    }
}

public class AdressBook {
    public static void main(String[] args) {
        AdressList book = new AdressList();

        while (true) {
            System.out.println("Введите 1 Для Добавления");
            System.out.println("Введите 2 Для Поиска По Имени");
            System.out.println("Введите 3 Для Изменения");
            System.out.println("Введите 4 Для Удаления");
            System.out.println("Введите 5 Для Вывода Всех Записей");
            System.out.println("Введите 6 Для Вывода Количества Записей");
            System.out.println("Введите 7 Для Выхода");

            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            int Vvod = Integer.parseInt(line);

            switch (Vvod)

            {
                case 1:
                    System.out.println("Введите Имя");
                    String n1 = in.nextLine();
                    System.out.println("Введите Фамилию");
                    String n2 = in.nextLine();
                    System.out.println("Введите Телефон");
                    String n3 = in.nextLine();
                    System.out.println("Введите Год Рождения");
                    String n04 = in.nextLine();
                    int n4 = Integer.parseInt(n04);
                    AdressList.Dobav(book,n1,n2,n3,n4);
                    break;
                case 2:
                    System.out.println("Введите Имя");
                    String search = in.nextLine();
                    AdressList.FindMan(book, search);
                    break;
                case 3:
                    System.out.println("Введите Индекс");
                    String p0 = in.nextLine();
                    int nInd = Integer.parseInt(p0);
                    int x1=AdressList.Check(book, nInd-1);
                    if (x1==0) {
                        System.out.println("Совпадений не Найдено");
                    } else {
                        System.out.println("Введите Имя");
                        String n11 = in.nextLine();
                        System.out.println("Введите Фамилию");
                        String n22 = in.nextLine();
                        System.out.println("Введите Телефон");
                        String n33 = in.nextLine();
                        System.out.println("Введите Год Рождения");
                        String n044 = in.nextLine();
                        int n44 = Integer.parseInt(n044);
                        AdressList.Izm(book,nInd-1,n11,n22,n33,n44);}
                    break;
                case 4:
                    System.out.println("Введите Индекс");
                    String Del = in.nextLine();
                    int VvodDel = Integer.parseInt(Del);
                    int x2=AdressList.Check(book, VvodDel-1);
                    if (x2==0) {
                        System.out.println("Совпадений не Найдено");
                    } else {
                        AdressList.DeleteZap(book, VvodDel-1);}
                    break;
                case 5:
                    AdressList.Vuvod(book);
                    break;
                case 6:
                    AdressList.VuvodVse(book);
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }
}
