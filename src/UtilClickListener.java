import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class UtilClickListener implements ActionListener {

	private PanelTemplate panel;

	public UtilClickListener(PanelTemplate panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String sauce = ((JButton) e.getSource()).getName();
		if (sauce == "UpdateExchangeRates") {
			panel.UpdateExchangeRates();
		} else if (sauce == "SwapUnits") {
			panel.SwapUnits();
		} else if (sauce == "ConvertUnits") {
			panel.ConvertUnits();
		}
	}
}