import java.util.HashMap;

public class UtilUnitConverter {

	public float Currency(Float input, String origin, String target, HashMap<String, Float> exchangeRates) {
		return input / exchangeRates.get(origin) * exchangeRates.get(target);
	}

	public float CelsiusToFahrenheit(float input) {
		return KelvinToRankine(input) + 32;
	}

	public float CelsiusToKelvin(float input) {
		return input + 273.15f;
	}

	public float CelsiusToRankine(float input) {
		return FahrenheitToRankine(CelsiusToFahrenheit(input));
	}

	public float FahrenheitToCelsius(float input) {
		return (input - 32) * 5 / 9;
	}

	public float FahrenheitToKelvin(float input) {
		return FahrenheitToCelsius(input) + 273.15f;
	}

	public float FahrenheitToRankine(float input) {
		return input + 459.67f;
	}

	public float KelvinToCelsius(float input) {
		return input - 273.15f;
	}

	public float KelvinToFahrenheit(float input) {
		return CelsiusToFahrenheit(KelvinToCelsius(input));
	}

	public float KelvinToRankine(float input) {
		return input * 9 / 5;
	}

	public float RankineToCelsius(float input) {
		return FahrenheitToCelsius(RankineToFahrenheit(input));
	}

	public float RankineToFahrenheit(float input) {
		return input - 459.67f;
	}

	public float RankineToKelvin(float input) {
		return input * 5 / 9;
	}
}