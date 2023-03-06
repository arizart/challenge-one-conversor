import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AppLayout implements ActionListener {

	public static JPanel cardsPanel = new JPanel(new CardLayout());
	public static final String CURRENCYPANEL = "Divisas";
	public static final String TEMPERATUREPANEL = "Temperatura";

	public void addComponentsToPane(Container pane) {

		JPanel navigationPanel = new JPanel();
		JButton button = new JButton(CURRENCYPANEL);
		JButton button2 = new JButton(TEMPERATUREPANEL);

		button.addActionListener(new AppLayout());
		button2.addActionListener(new AppLayout());

		navigationPanel.add(button);
		navigationPanel.add(button2);

		JPanel currenciesPanel = new PanelCurrencies();
		JPanel temperaturePanel = new PanelTemperature();

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