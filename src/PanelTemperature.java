import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class PanelTemperature extends PanelTemplate {

	private String[] scales = { "Celsius", "Fahrenheit", "Kelvin" };

	public PanelTemperature() {

		super();

		setOriginUnit(new JComboBox<>(scales));
		setTargetUnit(new JComboBox<>(scales));

		getConvertButton().addActionListener(new ClickListener());

		getInputsPanel().add(getInputField());
		getInputsPanel().add(getOriginUnit());
		getInputsPanel().add(new JLabel(" a "));
		getInputsPanel().add(getTargetUnit());
		getInputsPanel().add(getConvertButton());
		getResultPanel().add(getResult());

		add(getInputsPanel(), BorderLayout.PAGE_START);
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
}