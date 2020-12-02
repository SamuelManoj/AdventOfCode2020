package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) {
        URL url = Part1.class.getResource("input.txt");
        try {
            Scanner scan = new Scanner(new File(url.getPath()));
            ArrayList<String> values = new ArrayList<>();
            int count = 0;
            while (scan.hasNextLine()) {
                values.add(scan.nextLine());
            }
            for (String value : values) {
                if (checkPassword(value)) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkPassword(String value) {
        int Vcount = 0;
        String key = value.split(":")[0];
        String password = value.split(":")[1];
        char ch = key.charAt(key.length() - 1);
        String word = key.substring(0, key.length() - 2);
        int initial = Integer.parseInt(word.split("-")[0]);
        int end = Integer.parseInt(word.split("-")[1]);
        char[] Carray = password.toCharArray();
        if (Carray[initial] == ch && Carray[end] != ch) {
            return true;
        }
        if (Carray[initial] != ch && Carray[end] == ch) {
            return true;
        }
        return false;
    }
}
