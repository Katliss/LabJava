import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import  org.apache.logging.log4j.*;
public class main {

    private static Logger logger = LogManager.getLogger(main.class.getName());
    public static void main(String[] args) throws FileNotFoundException {
        /** @author Kate @version 1.1 */
        final int ReadConsole = 1;
        final int ReadFile = 2;
        int resm = Menu();


        Scanner Scan = new Scanner(System.in);


        if (resm == ReadConsole)
        {
            try {

                File D = new File("Dan.txt");
                logger.info("Получена ссылка на файл");
                Scanner Scan1 = new Scanner(D);
                logger.info("Создался сканер по этому файлу");
                Task1(Scan1, resm);
                Task2(Scan1, resm);
                Task3(Scan1, resm);
                Task4(Scan1, resm);
                Task5(Scan1, resm);
                Task6(Scan1, resm);
                Task7(Scan1, resm);
            }
            catch(Exception e)
            {
                logger.fatal("Файл \"Dan.txt\" отсутствует");
            }

        }
        else if (resm == ReadFile)
        {
            Task1(Scan, resm);
            Task2(Scan, resm);
            Task3(Scan, resm);
            Task4(Scan, resm);
            Task5(Scan, resm);
            Task6(Scan, resm);
            Task7(Scan, resm);
        }
        Task8();
    }

    /**
     * Функция вызывает контекстное меню «Выбор режима работы»
     * @return Scan1.nextInt() - возвращает выбор сделаный пользователем в виде целого числа*/
    public static int Menu()
    {
        logger.info("Вызов функции Menu()");
        Scanner Scan1 = new Scanner(System.in);
        System.out.println("Введите 1, если хотите считать значение с файла или 2, если хотите ввести в консоль");
        return Scan1.nextInt();
    }

    /** Задание 1
     * Вычислить значения выражения по формуле:
     * @Param Scan - Основной сканер
     * @Param resm - Результат функции menu()
     */
    public static void Task1(Scanner Scan, int resm)
    {
        logger.info("Вызов функция Task1()");
        try {
            int x = Scan.nextInt();
            double res;

            if (resm==2)
                System.out.println("Задание 1. Введите целое число х: ");
            res = (2 * (1 / Math.tan(3 * x))) - ((Math.log(Math.cos(x))) / (Math.log(1 + Math.pow(x, 2))));
            System.out.println("Результат задания 1: " + "\n" + res);
        }
        catch (Exception e) {
            logger.fatal("Ошибка считывания данных");
        }
    }

    /** Задание 2
     * Дано а. Не используя никаких функций и никаких операций, кроме умножения,
     * получить а8 за три операции; а10 и а16 за четыре операции.
     * @Param Scan - Основной сканер
     * @Param resm - Результат функции menu()*/
    public static void Task2(Scanner Scan, int resm)
    {
        logger.info("Вызов функция Task2()");
        try
        {
            if (resm==2)
                System.out.println("\n Задание 2. Введите целое число a: ");
            int a = Scan.nextInt();
            long a2,a4,a8,a10, a16 = 0;

            a2 = a*a;
            a4 = a2*a2;
            a8 = a4*a4;
            a10 = a8*a2;
            a16 = a8*a8;
            System.out.println("\n Результат задания 2: ");
            System.out.println(a8);
            System.out.println(a10);
            System.out.println(a16);
        }
        catch (Exception e)
        {
            logger.fatal("Ошибка считывания данных");
        }

    }
    /** Задание 3
     * Программа-льстец. На экране появляется вопрос «Кто ты: мальчик или девочка? Введи Д или М».
     * В зависимости от ответа на экране должен появиться текст
     * «Мне нравятся девочки!» или «Мне нравятся мальчики!».
     * @Param Scan - Основной сканер
     * @Param resm - Результат функции menu() */
    public static void Task3(Scanner Scan, int resm)
    {
        logger.info("Вызов функция Task3()");
        try
        {
            if (resm==2)
                System.out.println("\n Задание 3. Кто ты: мальчик или девочка? Введи Д или М: ");
            char gender = Scan.next().charAt(0);
            System.out.println("\nРезультат задания 3: ");

            if (gender == 'Д' || gender == 'д') {
                System.out.println("Мне нравятся девочки!");
            } else
            if (gender == 'М' || gender == 'м') {
                System.out.println("Мне нравятся мальчики!");
            } else
                System.out.println("Ты кто?");
        }
        catch (Exception e)
        {
            logger.fatal("Ошибка считывания данных");
        }

    }

    /** Задание 4
     * Даны действительные числа a, b, с. Удвоить эти числа, если a<b<c,
     * и заменить их абсолютными значениями, если это не так.
     * @Param Scan - Основной сканер
     * @Param resm - Результат функции menu() */
    public static void Task4(Scanner Scan, int resm)
    {
        logger.info("Вызов функция Task4()");

        try {
            int Num = 0;
            ArrayList<Integer> number = new ArrayList<>();

            if (resm==2)
                System.out.println("\n Задание 4. Введите 3 действительных числа: ");

            for (int i=0; i<3; i++) {
                Num=Scan.nextInt();
                number.add(Num);
            }

            System.out.println("\nРезультат задания 4: ");

            if (number.get(0)<number.get(1) && number.get(1)<number.get(2)) {
                for (int i=0; i<3;i++) {
                    number.set(i, number.get(i)*2);
                    System.out.println(number.get(i));
                }
            }
            else {
                for (int i=0; i<3;i++) {
                    number.set(i, Math.abs (number.get(i)));
                    System.out.println(number.get(i));
                }
            }
        }
        catch (Exception e)
        {
            logger.fatal("Ошибка считывания данных");
        }

    }

    /** Задание 5
     *Даны два действительных положительных числа x и у. Арифметические действия над числами пронумерованы
     * (1 — сложение, 2 — вычитание, 3 — умножение, 4 — деление).
     * Составить программу, которая по введенному номеру выполняет то или иное действие над числами. (switch)
     *
     * @Param Scan - Основной сканер
     * @Param resm - Результат функции menu()*/
    public static void Task5(Scanner Scan, int resm)
    {
        logger.info("Вызов функция Task5()");

        try
        {
            int numberOp;
            float y,x;

            if (resm==2) {
                System.out.println("\nЗадание 5");
                System.out.println("Введите первое число (действительное положительное): ");
            }

            x = Scan.nextFloat();

            if (resm == 2)
                System.out.println("Введите первое число (действительное положительное): ");

            y = Scan.nextFloat();
            if (resm == 2)
                System.out.println("Введите номер операции (1 — сложение, 2 — вычитание, 3 — умножение, 4 — деление): ");

            numberOp = Scan.nextInt();

            System.out.println("\nРезультат задания 5: ");
            switch (numberOp)
            {
                case 1:
                    System.out.println("Результат сложения: " + (x + y));
                    break;
                case 2:
                    System.out.println("Результат вычитания: " +(x - y));
                    break;
                case 3:
                    System.out.println("Результат умножения: " +(x * y));
                    break;
                case 4:
                    System.out.println("Результат деления: " +(x / y));
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        catch (Exception e)
        {
            logger.fatal("Ошибка считывания данных");
        }

    }

    /** Задание 6
     * Найти натуральное число n диапазоне от 1 до n с максимальной суммой делителей.
     * @Param Scan - Основной сканер
     * @Param resm - Результат функции menu()
     * */
    public static void Task6(Scanner Scan, int resm)
    {
        logger.info("Вызов функция Task6()");

        try
        {
            float n;
            int maxsum = 0;
            int numbermax = 0;

            if (resm == 2)
                System.out.println("\n Задание 6. Введите натуральное число  n: ");

            n = Scan.nextFloat();

            for (int i = 1; i <= n; i++)
            {
                int sum = 0;

                for (int j = 1; j <= i; j++) {
                    if(i%j==0) {
                        sum+=j;
                    }
                }
                if (sum>maxsum) {
                    numbermax = i;
                    maxsum = sum;
                }
            }
            System.out.println("\nРезультат задания 6: ");
            System.out.println("Число " + numbermax + " имеет максимальную сумму делителей - " + maxsum);
        }
        catch (Exception e)
        {
            logger.fatal("Ошибка данных");
        }

    }

    /** Задание 7
     * Дано натуральное число n и действительное x. Найти сумму n членов ряда.
     * @Param Scan - Основной сканер
     * @Param resm - Результат функции menu()
     */
    public static void Task7(Scanner Scan, int resm)
    {
        logger.info("Вызов функция Task7()");
        try
        {
            int n;
            double x,S = 0;

            if (resm == 2) {
                System.out.println("\nЗадание 7");
                System.out.println("Введите натуральное число  n: ");
            }

            n = Scan.nextInt();

            if (resm == 2)
                System.out.println("Введите действительное число  х: ");

            x = Scan.nextDouble();

            for (int i=1; i<=n; i++) {
                S+=(Math.pow(-1, i-1) * ((Math.cos(2*i+1)*x)/(Math.pow(2*i+1, 2))));
            }

            S=x+S;

            System.out.println("\nРезультат задания 7: ");
            System.out.println("Сумма членов ряда: " + S);
        }
        catch (Exception e)
        {
            logger.fatal("Ошибка данных");
        }

    }

    /**  Задание 8
     * Написать программу, которая выводит таблицу квадратов первых пяти целых положительных четных чисел.
     * @Param Scan - Основной сканер
     * @Param resm - Результат функции menu()
     */
    public static void Task8()
    {
        logger.info("Вызов функция Task8()");
        System.out.println("\n Результат задания 8: ");
        for (int i = 2; i<=10; i+=2){
            System.out.println("Квадат " + i + " = " + (int) Math.pow(i,2));
        }
    }

}