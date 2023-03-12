import java.awt.BorderLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class PanelTemplate extends JPanel {

	private JPanel inputsPanel;
	private JPanel resultPanel;
	private JTextField inputField;
	private JComboBox<String> originUnit;
	private JButton swapButton;
	private JComboBox<String> targetUnit;
	private JButton convertButton;
	private JLabel result;

	public PanelTemplate() {

		setLayout(new BorderLayout(24, 24));
		setInputsPanel(new JPanel());

		setInputField(new JTextField(7));
		getInputField().setMargin(new Insets(3, 8, 3, 8));
		setResult(new JLabel("test"));
		getInputField().addKeyListener(new UtilInputValidation(getInputField(), getResult()));
		setConvertButton(new JButton("Convertir"));

		setResultPanel(new JPanel());
	}

	public JPanel getInputsPanel() {
		return inputsPanel;
	}

	public void setInputsPanel(JPanel inputsPanel) {
		this.inputsPanel = inputsPanel;
	}

	public JPanel getResultPanel() {
		return resultPanel;
	}

	public void setResultPanel(JPanel resultPanel) {
		this.resultPanel = resultPanel;
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

	public JLabel getResult() {
		return result;
	}

	public void setResult(JLabel result) {
		this.result = result;
	}
}