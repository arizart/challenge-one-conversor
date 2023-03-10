import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class UtilInputValidation implements KeyListener {

	private JTextField inputField;
	private JLabel result;

	public UtilInputValidation(JTextField input, JLabel result) {
		this.inputField = input;
		this.result = result;
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {

		char key = e.getKeyChar();
		boolean validInput = '0' <= key && key <= '9' || key == '.' || key == '\b';

		if (validInput) {
			result.setText("");
		} else if (key == '\n') {
			// TODO: Call convert function.
		} else {
			inputField.setText("");
			result.setText("El campo sólo acepta números.");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}