package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinaryDiagnostic {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<char[]> charsArr = getBinaryMatrix();
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();

        for (int i = 0; i < charsArr.get(0).length; i++ ){
            int num = getFrequency(charsArr, i);
            checkAndSetValue(gamma, epsilon, num);

        }

        int gammaInt = Integer.parseInt(String.valueOf(gamma), 2);
        int epsilonInt = Integer.parseInt(String.valueOf(epsilon), 2);

        System.out.println(gammaInt);
        System.out.println(epsilonInt);
        System.out.println(gammaInt * epsilonInt);


    }

    private static void checkAndSetValue(StringBuilder gamma, StringBuilder epsilon, int num) {
        if (num > 0){
            gamma.append("1");
            epsilon.append("0");
        }else {
            gamma.append("0");
            epsilon.append("1");
        }
    }

    private static int getFrequency(ArrayList<char[]> charsArr, int i) {
        int num = 0;
        for (char[] chars : charsArr) {
            if (chars[i] == '1') {
                num++;
            } else {
                num--;
            }

        }
        return num;
    }

    private static ArrayList<char[]> getBinaryMatrix() throws FileNotFoundException {
        File file = new File("Src/Day3/binaryinput.txt");

        Scanner scanner = new Scanner(file);

        ArrayList<char []> charsArr = new ArrayList<>();

        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            char [] chars = s.toCharArray();
            charsArr.add(chars);
        }
        return charsArr;
    }


}
