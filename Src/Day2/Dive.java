package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dive {

    static int Y = 0;
    static int X = 0;

    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("Src/Day2/dive.txt");
        dive(f);
        System.out.println("depth : " + Y + " forward : " + X);
        System.out.println(Y*X);

    }




    private static void dive(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);

        while (sc.hasNextLine()){
            String s = sc.nextLine();
            String[] s2 = s.split(" ");
            if (s2[0].equals("forward")){
                X = X + Integer.parseInt(s2[1]);
            }else if(s2[0].equals("down")){
                Y = Y +Integer.parseInt(s2[1]);
            }else {
                Y = Y - Integer.parseInt(s2[1]);
            }
        }
    }


}
