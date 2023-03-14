import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class PanelTemperature extends PanelTemplate {

	private String[] scales = { "Celsius", "Fahrenheit", "Kelvin" };

	public PanelTemperature() {

		super();

		setOriginUnit(new JComboBox<>(scales));
		setTargetUnit(new JComboBox<>(scales));

		getSwapButton().addActionListener(new ClickListener());
		getConvertButton().addActionListener(new ClickListener());

		getInputsPanel().add(getInputField());
		getInputsPanel().add(getOriginUnit());
		getInputsPanel().add(getSwapButton());
		getInputsPanel().add(getTargetUnit());
		getInputsPanel().add(getConvertButton());
		getOutputPanel().add(getOutput());

		add(getInputsPanel(), BorderLayout.PAGE_START);
		add(getOutputPanel(), BorderLayout.PAGE_END);
	}

	public class ClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String sauce = ((JButton) e.getSource()).getName();
			if (sauce == "SwapUnits") {
				// TODO: Implement SwapUnits function.
			} else if (sauce == "ConvertUnits") {
				ConvertUnits();
			}
		}
	}

	public void ConvertUnits() {
		float value;
		try {
			value = Float.parseFloat(getInputField().getText());
		} catch (NumberFormatException nfe) {
			getOutput().setText("Digite un monto.");
			nfe.printStackTrace();
			return;
		}

		String origin = String.valueOf(getOriginUnit().getSelectedItem());
		String target = String.valueOf(getTargetUnit().getSelectedItem());
		System.out.println(origin + target + value);
	}
}