package Day3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryDiagnostic2 {

    static StringBuilder gamma = new StringBuilder();
    static StringBuilder epsilon = new StringBuilder();

    static ArrayList<char []> h20Chars = new ArrayList<>();
    static ArrayList<char []> co2Chars = new ArrayList<>();


    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(BinaryDiagnostic.file);

        ArrayList<char[]> charsArr = BinaryDiagnostic.getBinaryMatrix(scanner);

        int size = charsArr.get(0).length;

        ArrayList<char[]> h20 = new ArrayList<>(charsArr);
        ArrayList<char[]> co2 = new ArrayList<>(charsArr);

        BinaryDiagnostic.getGE(co2, gamma, epsilon);



        getGases(size, h20, co2);

        printSupportRating(h20, co2);


    }

    private static void printSupportRating(ArrayList<char[]> h20, ArrayList<char[]> co2) {
        int h20F = Integer.parseInt(String.valueOf(h20.get(0)), 2);
        int c20F = Integer.parseInt(String.valueOf(co2.get(0)), 2);

        System.out.println(h20F * c20F);
    }


    private static void getGases(int size, ArrayList<char[]> h20, ArrayList<char[]> co2) {
        StringBuilder garbage = new StringBuilder();
        for (int j = 0; j < size; j++ ){
            if (h20.size() > 1){
                char c = gamma.charAt(j);
                addPossibleSolution(h20, h20Chars, j, c);
                recalculate(h20, gamma, h20Chars);
                BinaryDiagnostic.getGE(h20, gamma, garbage);
            }
            if (co2.size() > 1){
                char e = epsilon.charAt(j);
                addPossibleSolution(co2, co2Chars, j, e);
                recalculate(co2, epsilon, co2Chars);
                BinaryDiagnostic.getGE(co2, garbage, epsilon);
            }

        }
    }

    private static void addPossibleSolution(ArrayList<char[]> gas, ArrayList<char[]> gChars, int j, char c) {
        for (char[] chars : gas) {
            if (chars[j] == c) {
                gChars.add(chars);
            }

        }
    }

    private static void recalculate(ArrayList<char[]> gas, StringBuilder rate, ArrayList<char[]> chars) {
        gas.clear();
        gas.addAll(chars);
        chars.clear();
        rate.setLength(0);
    }


}
