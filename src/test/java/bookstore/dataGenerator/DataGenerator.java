package bookstore.dataGenerator;

import org.apache.commons.lang3.RandomStringUtils;

public class DataGenerator {


    public static String generator(){
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        String generatedFigures = RandomStringUtils.randomNumeric(2);
        String generatedLine = "Qw"+ generatedString + generatedFigures + "@";
        return generatedLine;
    }

    public static long randomBetween(long minValue, long maxValue) {
        return minValue + Math.round(Math.random() * (maxValue - minValue));
    }
}
