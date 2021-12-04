package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinaryDiagnostic {

    static File file = new File("Src/Day3/binaryinput.txt");


    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);

        ArrayList<char[]> charsArr = getBinaryMatrix(scanner);

        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();

        getGE(charsArr, gamma, epsilon);

        int gammaInt = Integer.parseInt(String.valueOf(gamma), 2);
        int epsilonInt = Integer.parseInt(String.valueOf(epsilon), 2);

        System.out.println(gammaInt * epsilonInt);


    }

    public static void getGE(ArrayList<char[]> charsArr, StringBuilder gamma, StringBuilder epsilon) {
        for (int i = 0; i < charsArr.get(0).length; i++ ){
            int num = getFrequency(charsArr, i);
            checkAndSetValue(gamma, epsilon, num);

        }
    }

    private static void checkAndSetValue(StringBuilder gamma, StringBuilder epsilon, int num) {
        if (num >= 0){
            gamma.append("1");
            epsilon.append("0");
        }else {
            epsilon.append("1");
            gamma.append("0");
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

    public static ArrayList<char[]> getBinaryMatrix(Scanner scanner)  {

        ArrayList<char []> charsArr = new ArrayList<>();

        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            char [] chars = s.toCharArray();
            charsArr.add(chars);
        }
        return charsArr;
    }


}
