package statisticker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StatisticsTest 
{
    @Test
    public void reportsAverageMinMaxx()
    {
        Float[] numbers = {1.5f, 8.9f, 3.2f, 4.5f};
        List<Float> numberList = Arrays.asList(numbers);

        Statistics.Stats s = Statistics.getStatistics(numberList);

        float epsilon = 0.001f;
        assertEquals(s.average, 4.525f, epsilon);
        assertEquals(s.min, 1.5f, epsilon);
        assertEquals(s.max, 8.9f, epsilon);
    }
    @Test
    public void reportsNaNForEmptyInput()
    {
        List<Float> emptyList = new ArrayList<Float>();

        Statistics.Stats s = Statistics.getStatistics(emptyList);

        //All fields of computedStats (average, max, min) must be
        //Float.NaN (not-a-number), as described in
        //https://www.geeksforgeeks.org/nan-not-number-java/
        //Design the asserts here and implement accordingly.
        assertEquals(s.average, Float.NaN, Float.NaN);
        assertEquals(s.min, Float.NaN, Float.NaN);
        assertEquals(s.max, Float.NaN, Float.NaN);
    }
    @Test
    public void reportsAlertsIfMaxIsMoreThanThreshold()
    {
        EmailAlert emailAlerter = new EmailAlert();
        LEDAlert ledAlerter = new LEDAlert();
        IAlerter iAlerter = new IAlerter(emailAlerter, ledAlerter);
        float maxThreshold = 10.2f;
        StatsChecker checker = new StatsChecker(maxThreshold, new IAlerter[]{iAlerter});

        Float[] numbers = {11.5f, 6.9f, 7.5f, 6.6f};
        List<Float> numberList = Arrays.asList(numbers);
        checker.checkAndAlert(numbers);
        
        assertTrue(emailAlerter.emailSent);
        assertTrue(ledAlerter.ledGlows);
    }
}
