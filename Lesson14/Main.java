package Regular;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sve on 19.06.2017.
 */
public class Main {

    public static void main(String[] args) {

       // Номер авто
        String text = "6525 AB-1";
        Pattern p = Pattern.compile("[0-9]{4}\\s\\w{2}-[0-7]{1}");
        Matcher m = p.matcher(text);

        if(m.matches()){
            System.out.println("Номер верен");
        }else{
            System.out.println("Номер неверен");
        }


        //Ппроверка телефона
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сномер телефона:");
        String number = scanner.nextLine();

        Pattern numb = Pattern.compile("\\+(375)\\s?(17|44|29|33)\\s?[0-9]{7}");
        Matcher matcher = numb.matcher(number);

        if(matcher.matches()){
            System.out.println("Номер верен");
        }else{
            System.out.println("Номер неверен");
        }


        // Поиск E-mail
        String mail = "llcmdlmdcdl mmkmkm@mail.ru gtgtgtgrtr";
        Pattern pat = Pattern.compile("\\s\\w*\\.?\\w*\\@\\w*\\.\\w*\\.?[a-z]{2,6}");
        Matcher match = pat.matcher(mail);

        if (match.find()) {
            System.out.println("E-mail: " + match.group());
        } else {
            System.out.println("E-mail не найден");
        }

        // 1-e задание по регуляркам
        String cut = "hellowoooorld";

        Pattern pattern = Pattern.compile("(.)\\1+");
        Matcher matcher1 = pattern.matcher(cut);

        StringBuffer sb = new StringBuffer();

        while (matcher1.find()) {
            String d = matcher1.group().substring(1, 2) + matcher1.group().length();
            matcher1.appendReplacement(sb,d);
        }

        matcher1.appendTail(sb);
        System.out.println(sb.toString());


        // 2-е задание по регуляркам
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите название файла:");
        String format = scanner1.nextLine();

        Pattern patFormat = Pattern.compile("\\.(\\w+)");
        Matcher matcher2 = patFormat.matcher(format);

        if(matcher2.find()){
            if(matcher2.group(1).equals("xml")){
                System.out.println("Формат файла xml");
            }
            else if(matcher2.group(1).equals("json")){
                System.out.println("Формат файла json");
            }
            else {
                System.out.println("Некорректный формат файла");
            }


        }else{
            System.out.println("Неправильно ввели название файла");
        }





    }
}





