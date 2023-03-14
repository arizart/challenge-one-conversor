import org.json.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PanelCurrencies extends PanelTemplate {

	private String exchangeAPI;
	private HashMap<String, Double> exchangeRates;
	private ArrayList<String> currencies;
	private JPanel refreshPanel;
	private JButton refreshCurrencies;

	public PanelCurrencies() {

		super();

		exchangeAPI = "https://open.er-api.com/v6/latest/USD";
		exchangeRates = new HashMap<>();
		currencies = new ArrayList<>();
		UpdateExchangeRates();

		refreshPanel = new JPanel();

		refreshCurrencies = new JButton("Actualizar divisas");
		refreshCurrencies.addActionListener(new ClickListener());

		setOriginUnit(new JComboBox<>());
		setTargetUnit(new JComboBox<>());

		getOriginUnit().setModel(new DefaultComboBoxModel<String>(currencies.toArray(new String[0])));
		getTargetUnit().setModel(new DefaultComboBoxModel<String>(currencies.toArray(new String[0])));

		getSwapButton().addActionListener(new ClickListener());
		getConvertButton().addActionListener(new ClickListener());

		refreshPanel.add(refreshCurrencies);
		getInputsPanel().add(getInputField());
		getInputsPanel().add(getOriginUnit());

		getInputsPanel().add(getSwapButton());
		getInputsPanel().add(getTargetUnit());
		getInputsPanel().add(getConvertButton());
		getOutputPanel().add(getOutput());

		add(refreshPanel, BorderLayout.PAGE_START);
		add(getInputsPanel(), BorderLayout.CENTER);
		add(getOutputPanel(), BorderLayout.PAGE_END);
	}

	public class ClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO: Call convert function
		}
	}

	public void UpdateExchangeRates() {
		UtilHttpRequest request = new UtilHttpRequest();
		String response;
		try {
			response = request.GET(exchangeAPI);
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
			exchangeRates.put(key, rates.getDouble(key));
			currencies.add(key);
		}

		Collections.sort(currencies);
		getOutput().setText("Actualización correcta.");
	}
}