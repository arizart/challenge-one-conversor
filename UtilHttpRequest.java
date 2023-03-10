import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UtilHttpRequest {

	private URL url;
	private String response;
	private HttpURLConnection connection;

	public String GET(String getUrl) throws IOException {

		url = new URL(getUrl);
		response = "";
		connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("GET");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);

		int statusCode = connection.getResponseCode();

		if (statusCode == HttpURLConnection.HTTP_OK) {
			BufferedReader stream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String currentLine;
			StringBuffer buffer = new StringBuffer();

			while ((currentLine = stream.readLine()) != null) {
				buffer.append(currentLine);
			}

			stream.close();
			response = buffer.toString();

		} else {
			System.out.println("Something went wrong. HTTP Response Code :: " + statusCode);
		}

		return response;
	}
}