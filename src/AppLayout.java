import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AppLayout implements ActionListener {

	private static JPanel cardsPanel;
	private JPanel navigationPanel;
	private JPanel currenciesPanel;
	private JPanel temperaturePanel;
	private String CURRENCYPANEL = "Divisas";
	private String TEMPERATUREPANEL = "Temperatura";
	private JButton navBtnCurrency;
	private JButton navBrnTemperature;

	public void addComponentsToPane(Container pane) {

		cardsPanel = new JPanel(new CardLayout());
		navigationPanel = new JPanel();
		navigationPanel.setLayout(new GridLayout(0, 2));

		navBtnCurrency = new JButton(CURRENCYPANEL);
		navBrnTemperature = new JButton(TEMPERATUREPANEL);
		navBtnCurrency.setMargin(new Insets(8, 16, 8, 16));

		navBtnCurrency.addActionListener(new AppLayout());
		navBrnTemperature.addActionListener(new AppLayout());

		navigationPanel.add(navBtnCurrency);
		navigationPanel.add(navBrnTemperature);

		currenciesPanel = new PanelCurrencies();
		temperaturePanel = new PanelTemperature();

		cardsPanel.add(currenciesPanel, CURRENCYPANEL);
		cardsPanel.add(temperaturePanel, TEMPERATUREPANEL);

		pane.add(navigationPanel, BorderLayout.PAGE_START);
		pane.add(cardsPanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		CardLayout cl = (CardLayout) cardsPanel.getLayout();
		cl.show(cardsPanel, source.getText());
	}
}