package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dive2 {


    private static int x = 0;
    private static int depth = 0;
    private static int aim = 0;


    //TODO down X increases your aim by X units.

    //TODO up X decreases your aim by X units.

    //TODO    forward X does two things:
    //        It increases your horizontal position by X units.
    //        It increases your depth by your aim multiplied by X.
    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("Src/Day2/dive.txt");
        diveWithAim(f);
        System.out.println("depth : " + depth + " forward : " + x);
        System.out.println(depth*x);


    }

    private static void diveWithAim(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            String[] s2 = s.split(" ");

            int currentX = Integer.parseInt(s2[1]);

            if (s2[0].equals("forward")){
                x += currentX;
                depth += (aim * currentX);
            }
            else if(s2[0].equals("down")){
                aim += currentX;
            }
            else {
                aim -= currentX;
            }

        }
    }

}
