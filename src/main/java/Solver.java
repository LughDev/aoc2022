import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Solver {
    public static void main(String[] args) throws Exception{
        String inputs = "src/main/inputs/";
        AocDay[] days = new AocDay[3];
        for(int day = 1; day < days.length; day++) {
            String zDay = (day < 10 ? "0" : "") + day;
            String inputFilePath = inputs + "day" + zDay + ".txt";
            Class<? extends AocDay> cls = (Class<? extends AocDay>) Class.forName("Day" + zDay);
            AocDay aocDay = cls.getConstructor().newInstance();
            System.out.println("Day"+zDay+".1: " + aocDay.solvePart1(inputFilePath));
            System.out.println("Day"+zDay+".2: " + aocDay.solvePart2(inputFilePath));
        }
    }
}
