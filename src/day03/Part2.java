package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) {
        long output = 1;
        URL url1 = Part2.class.getResource("Part2-input.txt");
        try {
            Scanner scan = new Scanner(new File(url1.getPath()));
            ArrayList<String> values = new ArrayList<>();
            while (scan.hasNextLine()) {
                values.add(scan.nextLine());
            }
            URL url2 = Part2.class.getResource("input.txt");

            Scanner scan1 = new Scanner(new File(url2.getPath()));

            while (scan1.hasNextLine()) {
                String[] Key = scan1.nextLine().split(",");
                int right = Integer.parseInt(Key[0]);
                int down = Integer.parseInt(Key[1]);
                output *= Trees(values, right, down);
            }
            System.out.println(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int Trees(ArrayList<String> inputs, int right, int down) {
        int count = 0;
        for (int i = down, side = right; i < inputs.size(); i += down, side += right) {
            int index = (side) % inputs.get(i).length();
            if (inputs.get(i).charAt(index) == '#') {
                count++;
            }
        }
        return count;
    }
}
