package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dive {

    private static int depth = 0;
    private static int x = 0;

    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("Src/Day2/dive.txt");
        dive(f);
        System.out.println("depth : " + depth + " forward : " + x);
        System.out.println(depth * x);

    }




    private static void dive(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);

        while (sc.hasNextLine()){
            String s = sc.nextLine();
            String[] s2 = s.split(" ");

            int currentX = Integer.parseInt(s2[1]);

            if (s2[0].equals("forward")){
                x = x + currentX;
            }
            else if(s2[0].equals("down")){
                depth = depth + currentX;
            }
            else {
                depth = depth - currentX;
            }

        }
    }


}
