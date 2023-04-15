import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReadInNewThread implements Runnable
{
    File file;
    public  int number;
    private final PrintWriter printWriter;
    ArrayList<Double> values = new ArrayList<>();
    Scanner scanner;
    /**Конструктор класса FileReadInNewThread инициализирует переменные которые передаются по параметрам
     * @param pathIn - путь к файлу с которого будет считываться информация типа (string)
     * @param  printWriter - класс, производящий запись в файл*/
    public FileReadInNewThread(String pathIn, PrintWriter printWriter, int number){
        file = new File(pathIn);
        this.number = number;
        try {
            scanner = new Scanner(this.file);
            this.printWriter = printWriter;
        }
        catch (Exception e)
        {
            throw new RuntimeException();
        }
    }

    @Override
    public void run() {
        int operation;
        try
        {
            operation = scanner.nextInt();
        }
        catch (Exception e)
        {
            throw new RuntimeException();
        }
        fillArayList(values,scanner);
        switch (operation) {
            case 1 -> printOnFile(printWriter, sumAll(values));
            case 2 -> printOnFile(printWriter, multiplicationAll(values));
            case 3 -> printOnFile(printWriter, sumOfSquares(values));
            default -> {
            }
        }
    }
    /**Функция производит заполнение ранее инициализированного ArrayList с ранее инициализированного Scaner
     * @param values - ArayList типа double, который будет заполняться значениями из файла(должен быть ранее инициализирован)
     * @param scanner - сканер, который хранит ссылку на файл, с которого производится считывание*/
    private void fillArayList(ArrayList<Double> values, Scanner scanner){

        while (scanner.hasNextDouble()){
            values.add(scanner.nextDouble());
        }
    }
    /**Функция суммирует все элементы коллекции ArrayList типа double
     * @param values - коллекция ArrayList типа double
     * @return возвращает сумму коллекции типа double*/
    private double sumAll(ArrayList <Double> values)
    {
        double sum = 0;
        for (Double value : values) {
            sum += value;
        }
        return sum;
    }

    /**Функция умножает все элементы коллекции ArrayList типа double
     * @param values - коллекция ArrayList типа double
     * @return возвращает произведение коллекции тип данных double*/
    private double multiplicationAll(ArrayList <Double> values)
    {
        double  multiplication = 1;
        for (Double value : values) {
            multiplication *= value;
        }
        return multiplication;
    }
    /**Функция суммирует квадраты всех элементов коллекции ArrayList типа double
     * @param values - коллекция ArrayList типа double
     * @return возвращает сумму квадратов коллекции тип данных double*/
    private double sumOfSquares(ArrayList <Double> values){
        double sum = 0;

        for (Double value : values) {
            sum += Math.pow(value, 2);
        }
        return sum;
    }
    /**Функция выполняет запись в файл полученных данных
     * @param printWriter - ранее инициализированный объект типа PrintWriter, хронящий ссылку на файл для вывода
     * @param res - результат который необходимо вывести*/
    private void printOnFile(PrintWriter printWriter, double res)
    {
        printWriter.println("Поток "+ number+" вывел " + res);
    }
}
