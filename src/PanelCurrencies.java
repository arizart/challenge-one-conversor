import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCurrencies extends PanelTemplate {

	private String exchangeAPI;
	private HashMap<String, Double> exchangeRates;
	private String[] currencies = { "test", "test2", "test3" };
	private JPanel refreshPanel;
	private JButton refreshCurrencies;

	public PanelCurrencies() {

		super();

		exchangeAPI = "https://open.er-api.com/v6/latest/USD";
		GetExchangeRates();

		exchangeRates = new HashMap<>();
		refreshPanel = new JPanel();

		refreshCurrencies = new JButton("Actualizar divisas");
		refreshCurrencies.addActionListener(new ClickListener());

		setOriginUnit(new JComboBox<>(currencies));
		setTargetUnit(new JComboBox<>(currencies));

		getConvertButton().addActionListener(new ClickListener());

		refreshPanel.add(refreshCurrencies);
		getInputsPanel().add(getInputField());
		getInputsPanel().add(getOriginUnit());
		getInputsPanel().add(new JLabel(" a "));
		getInputsPanel().add(getTargetUnit());
		getInputsPanel().add(getConvertButton());
		getResultPanel().add(getResult());

		add(refreshPanel, BorderLayout.PAGE_START);
		add(getInputsPanel(), BorderLayout.CENTER);
		add(getResultPanel(), BorderLayout.PAGE_END);
	}

	public class ClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO: Call convert function
			String test = String.valueOf(getOriginUnit().getSelectedItem());
			String test2 = String.valueOf(getTargetUnit().getSelectedItem());
			System.out.println(test + test2);
		}
	}

	public void GetExchangeRates() {
		UtilHttpRequest request = new UtilHttpRequest();
		try {
			request.GET(exchangeAPI);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			getResult().setText(
					"No se pudo actualizar las divisas. Revisa tu conección a internet y vuelve a intentarlo.");
		}
	}
}