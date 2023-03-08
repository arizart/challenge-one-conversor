import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UtilHttpRequest {
	public String GET(String getUrl) throws IOException {
		URL url = new URL(getUrl);
		String response = "";
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		con.setConnectTimeout(5000);
		con.setReadTimeout(5000);

		int statusCode = con.getResponseCode();

		if (statusCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer buffer = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				buffer.append(inputLine);
			}
			in.close();

			response = buffer.toString();
		} else {
			System.out.println("Something went wrong. HTTP Response Code :: " + statusCode);
		}
		return response;
	}
}