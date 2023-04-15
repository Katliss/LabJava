import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

/** @author Kate @version 1.1 */
public class Main {
    public static void main(String[] args)
    {
        quest1();
        quest2();
        quest3();
        quest4();
        quest5();

    }

    /**
     * Задание 1
     * Программа, в которой перебираются числа от 1 до 500 и выводятся на экран. Если
     * число делится на 5, то вместо него выводится слово fizz, если на 7, то buzz. Если число
     * делится на 5 и на 7, то выводить слово fizzbuzz. Примечание: остаток от деления в Java
     * обозначается через символ %. */
    private static void quest1()
    {

        System.out.println("Задание 1");
        for (int i=1; i<501; i++)
        {
            if (i%5!=0 && i%7!=0)
            {
                System.out.println(i);
            }
            if (i%5==0)
            {
                if (i%7==0)
                {
                    System.out.println("fizzbuzz");
                    continue;
                }
                else
                {
                    System.out.println("fizz");
                    continue;
                }
            }
            if (i%7==0)
            {
                System.out.println("buzz");
            }
        }
    }
    /**
     * Задание 2
     * Программа, в которой все переданные во входную строку аргументы выводятся
     * на экран в обратной порядке. Например, если было передано 2 аргумента – make install, то
     * на экран должно вывестись llatsni ekam. Примечание*: для разбора слова по буквам
     * необходимо использовать функцию charAt(). Например, str.charAt(i) вернет символ с
     * позиции i в слове, записанном в строковую переменную str. Команда str.length() возвращает
     * длину слова str. */
    private static void quest2()
    {
        System.out.println();
        System.out.println("Задание 2");
        System.out.println("Введите слово: ");
        Scanner a = new Scanner(System.in);
        String str1;
        str1 = a.nextLine();

        for (int i=str1.length()-1; i>=0; i--)
        {
            System.out.print(str1.charAt(i));
        }
    }
    /**
     * Задание 3
     * Создайте программу, вычисляющую числа Фибоначчи. Числа Фибоначчи –
     * последовательность чисел, в котором каждое следующее число равно сумме двух
     * предыдущих. Начало этой последовательности – числа 1, 1, 2, 3, 5, 8, 13… */
    private static void quest3()
    {
        System.out.println();
        System.out.println();
        System.out.println("Задание 3");
        ArrayList<Integer> mas = new ArrayList<>();
        mas.add(1);
        mas.add(1);
        System.out.print(mas.get(0) + " " + mas.get(1));
        for (int i = 0; i<20; i++)
        {
            mas.add(mas.get(0)+mas.get(1));
            System.out.print(" " + mas.get(2));
            mas.remove(0);
        }
    }
    /**Задание 4
     * Создайте программу, вычисляющую факториал целого числа.*/
    private static void quest4()
    {
        System.out.println();
        System.out.println();
        System.out.println("Задание 4");
        System.out.println("Введите число, которому необходимо рассчитать факториал: ");
        Scanner a = new Scanner(System.in);
        int num = a.nextInt();
        int fact=1;
        for (int i=1; i<=num; i++)
        {
            fact *=i;
        }
        System.out.println(fact);
    }
    /**Задание 5
     * Дано целое число. Вывести его строку-описание вида «отрицательное четное
     число», «нулевое число», «положительное нечетное число».*/
    private static void quest5() {
        System.out.println();
        System.out.println("Задание 5");
        System.out.println("Введите число, которому необходимо дать описание: ");
        Scanner a = new Scanner(System.in);
        int s;
        s = a.nextInt();
        if (s==0) {
            System.out.println("Нулевое число");
        }
        else {
            if (s % 2 == 0) {
                System.out.print("Четное ");
            }
            else {
                System.out.print("Нечетное ");
            }
            if (s>0) {
                System.out.print("положительное число");
            }
            else {
                System.out.print("отрицательное число");
            }
        }
    }
}




