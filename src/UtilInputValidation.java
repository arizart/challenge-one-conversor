import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class UtilInputValidation implements KeyListener {

	private PanelTemplate panel;

	public UtilInputValidation(PanelTemplate panel) {
		this.panel = panel;
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {

		try {
			Float.valueOf(panel.getInputField().getText());
			panel.getOutput().setText("");
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			panel.getOutput().setText("Entrada inválida. El campo sólo acepta números.");
		}

		char key = e.getKeyChar();
		if (key == '\n') {
			panel.ConvertUnits();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public boolean Validate(JTextField input) {
		try {
			Float.valueOf(panel.getInputField().getText());
			return true;
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			return false;
		}
	}
}