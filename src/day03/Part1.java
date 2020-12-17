package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) {
        URL url = Part1.class.getResource("Part1-input.txt");
        try {
            Scanner scan = new Scanner(new File(url.getPath()));
            ArrayList<String> values = new ArrayList<>();
            while (scan.hasNextLine()) {
                values.add(scan.nextLine());
            }
            System.out.println(Trees(values, 3, 1));
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
