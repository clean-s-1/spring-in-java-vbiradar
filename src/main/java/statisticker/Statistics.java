package statisticker;

import java.util.Collections;
import java.util.List;

public class Statistics {
	public static Stats getStatistics(List<Float> numbers) {

		Stats stats = new Stats();

		if (!numbers.isEmpty()) {
			stats.min = Collections.min(numbers);
			stats.max = Collections.max(numbers);
			float average = 0;
			for (float f : numbers) {
				average += f;
			}
			average = average / numbers.size();
			stats.average = average;
		} else {
			stats.max = Float.NaN;
			stats.min = Float.NaN;
			stats.average = Float.NaN;
		}
		return stats;

	}

	public static class Stats {

		public float min;
		public float max;
		public float average;

	}

}
