import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTemperature extends JPanel {

	PanelTemperature() {
		this.add(new JLabel(AppLayout.TEMPERATUREPANEL));
		this.add(new JButton("Calor"));
		this.add(new JButton("Farenheit"));
	}
}