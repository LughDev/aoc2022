import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Day01 extends AocDay {
    @Override
    public String solvePart1(String inputFile) throws Exception {
        Scanner fileReader = getScanner(inputFile);
        ArrayList<Integer> elves = new ArrayList<>();
        int i = 0;
        elves.add(i,0);
        while(fileReader.hasNext()){
            String nextLine = fileReader.nextLine();
            if (nextLine.isBlank()){
                elves.add(0);
                i++;
            } else {
                elves.set(i,elves.get(i) + Integer.parseInt(nextLine.trim()));
            }
        }
        Collections.sort(elves,Comparator.reverseOrder());
//        System.out.println(elves);
        return ""+(elves.get(0));
    }

    @Override
    public String solvePart2(String inputFile) throws Exception {
        Scanner fileReader = getScanner(inputFile);
        ArrayList<Integer> elves = new ArrayList<>();
        int i = 0;
        elves.add(i,0);
        while(fileReader.hasNext()){
            String nextLine = fileReader.nextLine();
            if (nextLine.isBlank()){
                elves.add(0);
                i++;
            } else {
                elves.set(i,elves.get(i) + Integer.parseInt(nextLine.trim()));
            }
        }
        Collections.sort(elves,Comparator.reverseOrder());
//        System.out.println(elves);
        return ""+(elves.get(0)+elves.get(1)+elves.get(2));
    }
}
