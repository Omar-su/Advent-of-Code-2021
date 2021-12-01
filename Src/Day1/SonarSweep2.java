package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SonarSweep2 {

    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("C:\\Users\\omars\\Downloads\\Advent-of-Code-2021\\Src\\Day1\\solar2.txt");
        int count = numberOfElem(f);

        Scanner newScanner = new Scanner(f);

        int pivot = newScanner.nextInt();
        int numberOfInc = 0;

        numberOfInc = getNumberOfInc(count, newScanner, pivot, numberOfInc);

        System.out.println(numberOfInc);



    }

    private static int getNumberOfInc(int count, Scanner newScanner, int pivot, int numberOfInc) {
        while (newScanner.hasNextLine()){
            int current = newScanner.nextInt();
            if (pivot < current){
                numberOfInc += 1;
//                System.out.println(" INCREASE : "+ pivot + " current " + current);
                pivot = current;
            }else{
                System.out.println(" decrease : "+ pivot + " current " + current);
                pivot = current;
            }
            count--;
        }
        return numberOfInc;
    }


    private static int numberOfElem(File f) throws FileNotFoundException {
        Scanner mySc = new Scanner(f);
        int count = 0;

        while (mySc.hasNextLine()){
            int i = mySc.nextInt();
            count+=1;
        }

        return count;
    }
}
