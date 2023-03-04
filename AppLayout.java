import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppLayout implements ActionListener {
	public static JPanel cards;
	public static final String CURRENCYPANEL = "Divisas";
	public static final String TEMPERATUREPANEL = "Temperatura";

	public void addComponentsToPane(Container pane) {
		JPanel menu = new JPanel();
		JButton button = new JButton(CURRENCYPANEL);
		JButton button2 = new JButton(TEMPERATUREPANEL);
		button.addActionListener(new AppLayout());
		button2.addActionListener(new AppLayout());
		menu.add(button);
		menu.add(button2);

		JPanel currencies = new JPanel();
		currencies.add(new JLabel(CURRENCYPANEL));
		JPanel temperature = new JPanel();
		temperature.add(new JLabel(TEMPERATUREPANEL));

		cards = new JPanel(new CardLayout());
		cards.add(currencies, CURRENCYPANEL);
		cards.add(temperature, TEMPERATUREPANEL);

		pane.add(menu, BorderLayout.PAGE_START);
		pane.add(cards, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		CardLayout cl = (CardLayout) cards.getLayout();
		cl.show(cards, source.getText());
	}
}