import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day02 extends AocDay{
    HashMap<String,Integer> scores;

    public Day02() {
        scores = new HashMap<>();
//        scores.put("A X")
    }
    @Override
    public String solvePart1(String inputFile) throws Exception {
        Scanner s = getScanner(inputFile);
        while (s.hasNext()) {

        }
        return null;
    }

    @Override
    public String solvePart2(String inputFile) throws Exception {
        return null;
    }

    private enum Points{
        ROCK(1),PAPER(2),SCISSORS(3),WIN(0),TIE(3),LOSE(6);
        int score;
        Points(int score) {
            this.score = score;
        }
    }
}
