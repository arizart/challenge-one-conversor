import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class PanelTemplate extends JPanel {

	private JPanel inputsPanel;
	private JPanel outputPanel;
	private JTextField inputField;
	private JComboBox<String> originUnit;
	private JButton swapButton;
	private JComboBox<String> targetUnit;
	private JButton convertButton;
	private JLabel output;

	public PanelTemplate() {

		setLayout(new BorderLayout(24, 24));
		setInputsPanel(new JPanel());

		setInputField(new JTextField(7));
		getInputField().setMargin(new Insets(3, 8, 3, 8));
		setOutput(new JLabel(""));
		getInputField().addKeyListener(new UtilInputValidation(getInputField(), getOutput()));
		setSwapButton(new JButton("<>"));
		setConvertButton(new JButton("Convertir"));

		setOutputPanel(new JPanel());
	}

	public JPanel getInputsPanel() {
		return inputsPanel;
	}

	public void setInputsPanel(JPanel inputsPanel) {
		this.inputsPanel = inputsPanel;
	}

	public JPanel getOutputPanel() {
		return outputPanel;
	}

	public void setOutputPanel(JPanel outputPanel) {
		this.outputPanel = outputPanel;
	}

	public JTextField getInputField() {
		return inputField;
	}

	public void setInputField(JTextField inputField) {
		this.inputField = inputField;
	}

	public JComboBox<String> getOriginUnit() {
		return originUnit;
	}

	public void setOriginUnit(JComboBox<String> originUnit) {
		this.originUnit = originUnit;
	}

	public JButton getSwapButton() {
		return swapButton;
	}

	public void setSwapButton(JButton swapButton) {
		this.swapButton = swapButton;
	}

	public JComboBox<String> getTargetUnit() {
		return targetUnit;
	}

	public void setTargetUnit(JComboBox<String> targetUnit) {
		this.targetUnit = targetUnit;
	}

	public JButton getConvertButton() {
		return convertButton;
	}

	public void setConvertButton(JButton convertButton) {
		this.convertButton = convertButton;
	}

	public JLabel getOutput() {
		return output;
	}

	public void setOutput(JLabel output) {
		this.output = output;
	}
}