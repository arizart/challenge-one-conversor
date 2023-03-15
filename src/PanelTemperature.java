import java.awt.BorderLayout;

import javax.swing.JComboBox;

public class PanelTemperature extends PanelTemplate {

	private String[] scales = { "Celsius", "Fahrenheit", "Kelvin" };

	public PanelTemperature() {

		super();

		setOriginUnit(new JComboBox<>(getScales()));
		setTargetUnit(new JComboBox<>(getScales()));

		getSwapButton().addActionListener(new UtilClickListener(this));
		getConvertButton().addActionListener(new UtilClickListener(this));

		getInputsPanel().add(getInputField());
		getInputsPanel().add(getOriginUnit());
		getInputsPanel().add(getSwapButton());
		getInputsPanel().add(getTargetUnit());
		getInputsPanel().add(getConvertButton());
		getOutputPanel().add(getOutput());

		add(getInputsPanel(), BorderLayout.PAGE_START);
		add(getOutputPanel(), BorderLayout.PAGE_END);
	}

	public String[] getScales() {
		return scales;
	}

	public void setScales(String[] scales) {
		this.scales = scales;
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