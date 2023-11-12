import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class AocDay {
    File file;
    public abstract String solvePart1(String inputFile) throws Exception;
    public abstract String solvePart2(String inputFile) throws Exception;

    protected Scanner getScanner(String filepath) throws FileNotFoundException {
        this.file = new File(filepath);
        return new Scanner(file);
    }
}
