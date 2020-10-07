import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("Data/dataset.txt"));
            System.out.println(scanner.nextLine());
            String line = scanner.nextLine();

            String[] yearPopulation = line.split("[\\t]");
            System.out.println(yearPopulation[1]);
            String[] populationDivided = yearPopulation[1].split(",");
            String previousPopulationStr = "";
            for (int i = 0; i < populationDivided.length; i++) {
                previousPopulationStr += populationDivided[i];
            }

            BigInteger previous = new BigInteger(previousPopulationStr);
            int maxGainYear = 0;
            BigInteger maxGain = new BigInteger("0");
            for (int i = 1951; scanner.hasNextLine(); i++) {
                line = scanner.nextLine();
                BigInteger population = getPopulation(line);
                if ((population.subtract(previous)).compareTo(maxGain) > 0){
                    maxGain = population.subtract(previous);
                    maxGainYear = i;
                }

                previous = population;

            }

            System.out.println("max gain: " + maxGainYear);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public static BigInteger getPopulation(String line) {
        String[] yearPopulation = line.split("\\t");
        String[] populationDivided = yearPopulation[1].split(",");
        String previousPopulationStr = "";
        for (int i = 0; i < populationDivided.length; i++) {
            previousPopulationStr += populationDivided[i];
        }

        return new BigInteger(previousPopulationStr);
    }
}
