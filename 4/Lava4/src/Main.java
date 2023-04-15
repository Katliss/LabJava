import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

     File f1 = new File("Dan.txt");

        ArrayList<String> IPv4 = new ArrayList<>();
        ArrayList<String> IPv6 = new ArrayList<>();

            fillCollections(IPv4,IPv6,f1);


            System.out.println(IPv4);
            System.out.println(IPv6);
    }

    /** Данный метод производит заполнения коллекций строк "IPv4" и "IPv6" типа ArrayList значениями IP найденными в файле
     * @param IPv4 - коллекция типа ArrayList<String> для хранения IPv4
     * @param IPv6 - коллекция типа ArrayList<String> для хранения
     * @param f1 - файл в котором будет происходить поиск IPv4 и IPv6*/
    private static void fillCollections(ArrayList<String> IPv4, ArrayList<String> IPv6, File f1)
    {
        Pattern patternIPv4 = Pattern.compile("(\\s+|^)\\d{3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}(\\s+|$)");
        Pattern patternIPv6 = Pattern.compile("(\\s+|^)\\w{4}:\\w{1,4}:\\w{1,4}:\\w{1,4}:\\w{1,4}:\\w{1,4}:\\w{1,4}:\\w{1,4}(\\s+|$)");
        Matcher m;
        Scanner scanner;
        try {
            scanner= new Scanner(f1);
        }
        catch (Exception e) {
            throw new RuntimeException();
        }
        String buffer;
        while(scanner.hasNextLine())
        {
            buffer = scanner.nextLine();
            m = patternIPv4.matcher(buffer);

            while(m.find()) {
                IPv4.add(m.group());
            }

            m = patternIPv6.matcher(buffer);

            while (m.find())
            {
                IPv6.add(m.group());
            }
        }

        removeSpace(IPv4);
        removeSpace(IPv6);

        printMenedger(IPv4,IPv6);

    }
    /** Данный метод производит удаление пробелов в коллеции строк типа ArrayList
     * @param IP - коллекция строк типа ArrayList  для хранения IP*/
    private static void removeSpace(ArrayList<String> IP)
    {   String IpByffer;
        for (int i = 0; i < IP.size();i++){
            IpByffer = IP.get(i);
            IP.set(i,IpByffer.replaceAll(" ",""));
        }
    }

    /**Метод выполняет инициализацию и закрытие PrintWriter и выполняет сортировку коллекций,
     * а затем вызывает метод printInFile с переданными в него коллекциями
     * @param IPv4 - коллекция типа ArrayList<String> для хранения IPv4
     * @param IPv6 - коллекция типа ArrayList<String> для хранения*/
    private  static  void printMenedger(ArrayList<String> IPv4, ArrayList<String> IPv6) {
        PrintWriter writer;

        try {
            writer = new PrintWriter("Result.txt","UTF-8");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(IPv4);
        Collections.sort(IPv6);


        printInFile(IPv4,writer);
        printInFile(IPv6,writer);
        writer.close();
    }

    /** Метод выполняет заполнение в файл данных коллеции
     *  @param IP - коллекция строк типа ArrayList  для хранения IP
     *  @param writer - инициалезцированный PrintWriter который хранит ссылку на файл*/

    private static void printInFile(ArrayList<String> IP, PrintWriter writer)
        {
            for (int i = 0; i < IP.size(); i ++){
                writer.println(IP.get(i));
            }
        }
}