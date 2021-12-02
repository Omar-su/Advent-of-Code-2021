package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SonarSweep2 {

    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("Src/Day1/solar.txt");
        int nInc = getnInc(f);
        System.out.println(nInc);


    }

    private static int getnInc(File f) throws FileNotFoundException {
        Scanner scanner = new Scanner(f);
        int pivot1 = scanner.nextInt();
        int pivot2 = scanner.nextInt();
        int pivot3 = scanner.nextInt();
        int nInc = 0;

        while (scanner.hasNextLine()){
            int newElem = scanner.nextInt();

            if ((pivot1 + pivot2 + pivot3) < (pivot2 + pivot3 + newElem)){
                nInc++;

            }
            pivot1 = pivot2;
            pivot2 = pivot3;
            pivot3 = newElem;

        }
        return nInc;
    }


}
