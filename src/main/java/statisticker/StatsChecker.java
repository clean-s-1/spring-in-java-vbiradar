/**
 * 
 */
package statisticker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StatsChecker {

	// private EmailAlert emailAlert;

	// private LEDAlert ledAlert;

	private IAlerter[] alerter;

	private float threshold;

	public StatsChecker(float threshold, IAlerter[] alerter) {
		super();
		this.alerter = alerter;
		this.threshold = threshold;
	}

	public void checkAndAlert(Float[] numbers) {

		List<Float> numberList = Arrays.asList(numbers);
		float maxNumber = Collections.max(numberList);
			if(threshold<maxNumber) {
				alerter[0].getAlert().emailSent=true;
				alerter[0].getLedAlert().ledGlows=true;
			}
		
	}

}
