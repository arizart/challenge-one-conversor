import java.util.HashMap;

public class UtilUnitConverter {

	public float Currency(Float input, String origin, String target, HashMap<String, Float> exchangeRates) {
		return input / exchangeRates.get(origin) * exchangeRates.get(target);
	}
}