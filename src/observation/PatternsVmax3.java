package observation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 *
 * @author tadaki
 */
public class PatternsVmax3 extends AbstractPatterns {

    public PatternsVmax3() {
        super();
        sysSize = 40;
        numCars = 10;
        vmax = 3;
    }

    public void OneAdditionalSimulation() {
        int s[] = {3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
            3, -1, -1, -1, 3, -1, -1, 0, 3, -1, -1, -1,
            3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
            3, -1, -1, -1
        };
        simulationWithPattern(s);
    }

    public void OneAdditionalSimulation2() {
        int s[] = {3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
            3, -1, -1, -1, 3, -1, 1, -1, 3, -1, -1, -1,
            3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
            3, -1, -1, -1
        };
        simulationWithPattern(s);
    }

    public void OneAdditionalSimulation3() {
        int s[] = {3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
            3, -1, -1, -1, 3, 2, -1, -1, 3, -1, -1, -1,
            3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
            3, -1, -1, -1
        };
        simulationWithPattern(s);
    }

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        PatternsVmax3 patterns = new PatternsVmax3();
        InitialPattern[] initialPatterns = new InitialPattern[]{
            new InitialPattern("1台 初速0",
            new int[]{3, -1, -1, 0, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1}),
            new InitialPattern("1台 初速1",
            new int[]{3, -1, 1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1}),
            new InitialPattern("1台 初速2",
            new int[]{3, 2, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1}),
            new InitialPattern("2台 初速00",
            new int[]{3, -1, -1, 0, 3, -1, -1, -1, 3, -1, -1, 0,
                3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1}),
            new InitialPattern("2台 初速01",
            new int[]{3, -1, -1, 0, 3, -1, -1, -1, 3, -1, 1, -1,
                3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1}),
            new InitialPattern("2台 初速02",
            new int[]{3, -1, -1, 0, 3, -1, -1, -1, 3, 2, -1, -1,
                3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1}),
            new InitialPattern("2台 初速01 近い",
            new int[]{3, 1, -1, 0, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1,
                3, -1, -1, -1})
        };

        String filename = PatternsVmax3.class.getSimpleName() + ".txt";
        try (PrintStream out = new PrintStream(new File(filename))) {
            patterns.setOut(out);
            patterns.SimpleSimulation();
            for (InitialPattern p : initialPatterns) {
                patterns.simulationWithPattern(p);
            }
        }
    }
}
