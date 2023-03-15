import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.json.*;

public class PanelCurrencies extends PanelTemplate {

	private String exchangeAPI;
	private HashMap<String, Float> exchangeRates;
	private ArrayList<String> currencies;
	private JPanel refreshPanel;
	private JButton refreshCurrencies;

	public PanelCurrencies() {

		super();

		setExchangeAPI("https://open.er-api.com/v6/latest/USD");
		setExchangeRates(new HashMap<>());
		setCurrencies(new ArrayList<>());
		UpdateExchangeRates();

		setRefreshPanel(new JPanel());

		setRefreshCurrencies(new JButton("Actualizar divisas"));
		getRefreshCurrencies().setName("UpdateExchangeRates");
		getRefreshCurrencies().addActionListener(new UtilClickListener(this));

		setOriginUnit(new JComboBox<>());
		setTargetUnit(new JComboBox<>());

		getOriginUnit().setModel(new DefaultComboBoxModel<String>(currencies.toArray(new String[0])));
		getTargetUnit().setModel(new DefaultComboBoxModel<String>(currencies.toArray(new String[0])));

		getSwapButton().addActionListener(new UtilClickListener(this));
		getConvertButton().addActionListener(new UtilClickListener(this));

		getRefreshPanel().add(refreshCurrencies);
		getInputsPanel().add(getInputField());
		getInputsPanel().add(getOriginUnit());

		getInputsPanel().add(getSwapButton());
		getInputsPanel().add(getTargetUnit());
		getInputsPanel().add(getConvertButton());
		getOutputPanel().add(getOutput());

		add(getRefreshPanel(), BorderLayout.PAGE_START);
		add(getInputsPanel(), BorderLayout.CENTER);
		add(getOutputPanel(), BorderLayout.PAGE_END);
	}

	public String getExchangeAPI() {
		return exchangeAPI;
	}

	public void setExchangeAPI(String exchangeAPI) {
		this.exchangeAPI = exchangeAPI;
	}

	public HashMap<String, Float> getExchangeRates() {
		return exchangeRates;
	}

	public void setExchangeRates(HashMap<String, Float> exchangeRates) {
		this.exchangeRates = exchangeRates;
	}

	public ArrayList<String> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(ArrayList<String> currencies) {
		this.currencies = currencies;
	}

	public JPanel getRefreshPanel() {
		return refreshPanel;
	}

	public void setRefreshPanel(JPanel refreshPanel) {
		this.refreshPanel = refreshPanel;
	}

	public JButton getRefreshCurrencies() {
		return refreshCurrencies;
	}

	public void setRefreshCurrencies(JButton refreshCurrencies) {
		this.refreshCurrencies = refreshCurrencies;
	}

	@Override
	public void UpdateExchangeRates() {

		UtilHttpRequest request = new UtilHttpRequest();
		String response;

		try {
			response = request.GET(getExchangeAPI());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			getOutput().setText(
					"No se pudo actualizar las divisas. Revisa tu conección a internet y vuelve a intentarlo.");
			return;
		}

		JSONObject rates = new JSONObject(response).getJSONObject("rates");
		Iterator<String> keys = rates.keys();

		while (keys.hasNext()) {
			String key = keys.next();
			getExchangeRates().put(key, rates.getFloat(key));
			getCurrencies().add(key);
		}

		Collections.sort(getCurrencies());
		getOutput().setText("Actualización correcta.");
	}

	public void ConvertUnits() {
		float input = Float.parseFloat(getInputField().getText());
		String origin = String.valueOf(getOriginUnit().getSelectedItem());
		String target = String.valueOf(getTargetUnit().getSelectedItem());

		UtilUnitConverter converter = new UtilUnitConverter();
		float result = converter.Currency(input, origin, target, getExchangeRates());

		getOutput().setText(input + " " + origin + " equivale a " + String.format("%.2f", result) + " " + target);
	}
}