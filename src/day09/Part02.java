package day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Part02 {

    public static void main(String[] args) throws FileNotFoundException {
        URL url = Part01.class.getResource("input.txt");
        Scanner scan = new Scanner(new File(url.getPath()));
        ArrayList<Integer> input = new ArrayList<>();
        while (scan.hasNextInt()) {
            input.add(scan.nextInt());
        }
        System.out.println(findRange(input, findNumber(input, 25)));
    }

    public static int findNumber(ArrayList<Integer> input, int preamble) {
        for (int i = preamble; i < input.size(); i++) {
            if (!isValid(new ArrayList<>(input.subList(i - preamble, i)), input.get(i))) {
                return input.get(i);
            }
        }
        return -1;
    }

    public static boolean isValid(List<Integer> input, int value) {
        Collections.sort(input);
        for (int i : input) {
            if (Collections.binarySearch(input, Math.abs(i - value)) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static int findRange(ArrayList<Integer> input, int sum){
        for(int i=0;i<input.size();i++){
            int sum1 = 0;
            for(int j=i;j<input.size();j++){
                if(sum1==sum){
                    int min = Collections.min(input.subList(i,j));
                    int max = Collections.max(input.subList(i,j));
                    return min + max;
                }
                sum1 += input.get(j);
            }
        }
        return -1;
    }
}
