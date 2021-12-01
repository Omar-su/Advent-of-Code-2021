package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SonarSweep1 {

    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("Src/Day1/solar.txt");
        Scanner newScanner = new Scanner(f);

        int pivot = newScanner.nextInt();
        int numberOfInc = 0;

        numberOfInc = getNumberOfInc(newScanner, pivot, numberOfInc);

        System.out.println(numberOfInc);



    }

    private static int getNumberOfInc(Scanner newScanner, int pivot, int numberOfInc) {
        while (newScanner.hasNextLine()){
            int current = newScanner.nextInt();
            if (pivot < current){
                numberOfInc += 1;
            }
            pivot = current;
        }
        return numberOfInc;
    }


}
