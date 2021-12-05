package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GiantSquid {

    static private String winningNum = "";



    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("Src/Day4/squidBingo.txt");
        Scanner scanner = new Scanner(file);

        String[] nums = scanner.nextLine().split(",");


        System.out.println(scanner.nextLine().isEmpty());

        ArrayList<ArrayList<String[]>> listOfMatrixes = new ArrayList<>();
        ArrayList<String[]> listOfLines = new ArrayList<>();

        genMatrixes(scanner, listOfMatrixes, listOfLines);


        // PART 1
        ArrayList<ArrayList<String[]>> winner = getWinningMatrix(nums, listOfMatrixes);

        printWinnerAndWinningNum(winner, winningNum);

        int sum = getSumMaurice(winner);

        System.out.println(sum);
        System.out.println(sum*Integer.parseInt(winningNum));

        // PART 2
        winner.clear();
        listOfLines.clear();
        listOfMatrixes.clear();
        scanner = new Scanner(file);
        nums = scanner.nextLine().split(",");


        System.out.println(scanner.nextLine().isEmpty());
        genMatrixes(scanner, listOfMatrixes, listOfLines);

        winningNum = "";


        winner = getLosingMatrix(nums, listOfMatrixes);

        printWinnerAndWinningNum(winner, winningNum);

        sum = getSumMaurice(winner);

        System.out.println(sum);
        System.out.println(sum*Integer.parseInt(winningNum));






    }

    private static ArrayList<ArrayList<String[]>> getWinningMatrix(String[] nums, ArrayList<ArrayList<String[]>> listOfMatrixes) {
        ArrayList<ArrayList<String[]>> winner = new ArrayList<>();
        outerloop:
        for (String num : nums) {
            for (ArrayList<String[]> m : listOfMatrixes) {
                for (String[] strings : m) {
                    for (int i = 0; i < 5; i++) {
                        if (strings[i].equals(num)){
                            strings[i] = "_";
                        }

                    }
                    int streak = 5;
                    for (String s : strings){
                        if (s.equals("_")){
                            streak--;
                        }
                    }
                    if (streak == 0){
                        winningNum = num;
                        winner.add(m);
                        break outerloop;
                    }

                    for (int h = 0; h < 5; h++){
                        streak = 5;
                        for (String [] strings1 : m){
                            if (strings1[h].equals("_")){
                                streak--;
                            }
                        }
                        if (streak == 0){
                            winningNum = num;
                            winner.add(m);
                            break outerloop;
                        }
                    }



                }
            }
        }
        return winner;
    }

    private static void genMatrixes(Scanner scanner, ArrayList<ArrayList<String[]>> listOfMatrixes, ArrayList<String[]> listOfLines) {
        int n = 5;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitLine = line.trim().replaceAll(" +", " ").split(" ");

            if (n==1){
                listOfLines.add(splitLine);
                listOfMatrixes.add((ArrayList<String[]>) listOfLines.clone());
                listOfLines.clear();
                n = 5;
            }

            else if (!line.isBlank()) {
                listOfLines.add(splitLine);
                n--;
            }

        }
    }

    private static ArrayList<ArrayList<String[]>> getLosingMatrix(String[] nums, ArrayList<ArrayList<String[]>> listOfMatrixes) {
        ArrayList<ArrayList<String[]>> winner = new ArrayList<>();
        ArrayList<ArrayList<String[]>> deletedMatrixes = new ArrayList<>();

        for (String num : nums) {
            listOfMatrixes.removeAll(deletedMatrixes);
            for (ArrayList<String[]> m : listOfMatrixes) {
                oloop:
                for (String[] strings : m) {
                    for (int i = 0; i < 5; i++) {
                        if (strings[i].equals(num)){
                            strings[i] = "_";
                        }

                    }
                    int streak = 5;
                    for (String s : strings){
                        if (s.equals("_")){
                            streak--;
                        }
                    }
                    if (streak == 0){
                        if (listOfMatrixes.size() == 1){
                            winner.add(m);
                            winningNum = num;
                            return winner;
                        }
                        deletedMatrixes.add(m);
                        break;
                    }

                    for (int h = 0; h < 5; h++){
                        streak = 5;
                        for (String [] strings1 : m){
                            if (strings1[h].equals("_")){
                                streak--;
                            }

                        }
                        if (streak == 0){
                            if (listOfMatrixes.size() == 1){
                                winner.add(m);
                                winningNum = num;
                                return winner;
                            }
                            deletedMatrixes.add(m);
                            break oloop;
                        }
                    }



                }
            }
        }
        return winner;
    }

    private static int getSumMaurice(ArrayList<ArrayList<String[]>> winner) {
        int sum = 0;
        for (String[] lines : winner.get(0)){
            for (String s : lines){
                if (!s.equals("_")){
                    sum += Integer.parseInt(s);
                }

            }

        }
        return sum;
    }

    private static void printWinnerAndWinningNum(ArrayList<ArrayList<String[]>> winner, String winningNum) {
        System.out.println(winningNum);
        for (List<String[]> m : winner){
            System.out.println("________________________________");
            for (String [] strings : m){
                System.out.println(Arrays.toString(strings));
            }

        }
        System.out.println("________________________________");
    }


}

