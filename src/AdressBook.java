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
    private Address[] Fman = new Address[10];
    private int count = 0;
    private int seccount=0;
    public static void Dobav(AdressList book, String Ima1, String Famil1, String Ph1, int God1) {
        book.list[book.count] = new Address(Ima1, Famil1, Ph1, God1);
        book.count++;
    }

    public static void Izm(AdressList book, int nInd, String Ima1, String Famil1, String Ph1, int God1) {
        book.list[nInd] = new Address(Ima1, Famil1, Ph1, God1);
    }

    public static void FindMan(AdressList book, String search) {
        int x = 0;
        for (int i = 0; i < book.count; i++) {
            Address a = book.list[i];
            if (a.name.equals(search)) {
            book.Fman[x]=book.list[i];
// System.out.println(book.Fman[i].name + " " + book.Fman[i].fam + " " + book.Fman[i].phone + " " + book.Fman[i].year);
                book.seccount++;
                x++;
            }
        }
        if (x == 0) {
            System.out.println("Совпадений не Найдено");
        }
    }

    public static void Vuvod(AdressList book) {
        if (book.count == 0) {
            System.out.println("В Адресной Кониге Нет Записей");
        } else {
            for (int i = 0; i < book.count; i++) {
                System.out.println(book.list[i].name + " " + book.list[i].fam + " " + book.list[i].phone + " " + book.list[i].year);
            }
        }
    }

    public static void VuvodVse(AdressList book) {
        if (book.count == 0) {
            System.out.println("В Адресной Кониге Нет Записей");
        } else {
            System.out.println("Количество Записей =" + book.count);
        }
    }

    public static void DeleteZap(AdressList book, int VvodDel) {
        for (int i = VvodDel; i <= book.count - 2; i++) {
            book.list[i] = book.list[i + 1];
        }
        book.count--;
    }

    public static boolean Check(AdressList book, int Chk) {
        return !(Chk < 0 || Chk >= book.count);
    }

    public static void VuvodOne(AdressList book) {
        for (int i = 0; i < book.seccount; i++) {
           System.out.println(book.Fman[i].name + " " + book.Fman[i].fam + " " + book.Fman[i].phone + " " + book.Fman[i].year);
          }
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
            System.out.println("Введите 5 Для Вывода Найденных Записей");
            System.out.println("Введите 6 Для Вывода Всех Записей");
            System.out.println("Введите 7 Для Вывода Количества Записей");
            System.out.println("Введите 8 Для Выхода");

            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            int Vvod = Integer.parseInt(line);

            switch (Vvod)

            {
                case 1:
                    System.out.println("Введите Имя");
                    String Ima1 = in.nextLine();
                    System.out.println("Введите Фамилию");
                    String Famil1 = in.nextLine();
                    System.out.println("Введите Телефон");
                    String Ph1 = in.nextLine();
                    System.out.println("Введите Год Рождения");
                    String God01 = in.nextLine();
                    int God1 = Integer.parseInt(God01);
                    AdressList.Dobav(book, Ima1, Famil1, Ph1, God1);
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
                    boolean x1 = AdressList.Check(book, nInd - 1);
                    if (!x1) {
                        System.out.println("Совпадений не Найдено");
                    } else {
                        System.out.println("Введите Имя");
                        String Ima2 = in.nextLine();
                        System.out.println("Введите Фамилию");
                        String Famil2 = in.nextLine();
                        System.out.println("Введите Телефон");
                        String Ph2 = in.nextLine();
                        System.out.println("Введите Год Рождения");
                        String God02 = in.nextLine();
                        int God2 = Integer.parseInt(God02);
                        AdressList.Izm(book, nInd - 1, Ima2, Famil2, Ph2, God2);
                    }
                    break;
                case 4:
                    System.out.println("Введите Индекс");
                    String Del = in.nextLine();
                    int VvodDel = Integer.parseInt(Del);
                    boolean x2 = AdressList.Check(book, VvodDel - 1);
                    if (!x2) {
                        System.out.println("Совпадений не Найдено");
                    } else {
                        AdressList.DeleteZap(book, VvodDel - 1);
                    }
                    break;
                case 5:
                AdressList.VuvodOne(book);
                    break;
                case 6:
                    AdressList.Vuvod(book);
                    break;
                case 7:
                    AdressList.VuvodVse(book);
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
}
