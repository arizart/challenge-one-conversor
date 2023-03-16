import java.awt.BorderLayout;
import java.lang.reflect.Method;

import javax.swing.JComboBox;

public class PanelTemperature extends PanelTemplate {

	private String[] scales = { "Celsius", "Fahrenheit", "Kelvin", "Rankine" };

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
		float input = Float.parseFloat(getInputField().getText());
		String origin = String.valueOf(getOriginUnit().getSelectedItem());
		String target = String.valueOf(getTargetUnit().getSelectedItem());
		String methodName = origin + "To" + target;
		float result = 0.0f;

		if (origin != target) {
			UtilUnitConverter converter = new UtilUnitConverter();
			Method[] methods = converter.getClass().getDeclaredMethods();

			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					try {
						result = (float) method.invoke(converter, input);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			result = input;
		}

		getOutput().setText(input + " " + origin + " equivale a " + String.format("%.1f", result) + " " + target);
	}
}