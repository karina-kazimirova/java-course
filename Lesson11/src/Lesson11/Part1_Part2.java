package Lesson11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Sve on 19.06.2017.
 */
public class Part1_Part2 {
    public static void main(String[] args) {

        ArrayList<String> name = new ArrayList<>();
        boolean isVvod = true;

        while (isVvod) {
            Scanner scanner = new Scanner(System.in);
            String newText = scanner.nextLine();

            if (newText.equals(" ")) {
                break;
            } else {
                name.add(newText);
            }
        }


        // Удаление элемента из массива
        for (Iterator<String> iter = name.iterator(); iter.hasNext(); ) {
            String s = iter.next();
            if (s.equals("а")) {
                iter.remove();
            }

        }

        System.out.println(name.toString());

        // Удаление дубликатов
        HashSet<String> set = new HashSet<>(name);

        name.clear();
        name.addAll((set));

        System.out.println(name.toString());
    }
}
