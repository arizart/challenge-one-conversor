import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class UtilInputValidation implements KeyListener {

	private JTextField inputField;
	private JLabel output;

	public UtilInputValidation(JTextField input, JLabel output) {
		this.inputField = input;
		this.output = output;
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {

		char key = e.getKeyChar();
		boolean validInput = '0' <= key && key <= '9' || key == '.' || key == '\b';

		if (validInput) {
			output.setText("");
		} else if (key == '\n') {
			// TODO: Call convert function.
		} else {
			inputField.setText("");
			output.setText("El campo sólo acepta números.");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}