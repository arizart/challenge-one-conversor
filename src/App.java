import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

	private static JFrame frame;
	private static AppLayout al;

	private static void renderGUI() {

		frame = new JFrame("Conversor de unidades");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("currency_exchange.jpg").getImage());
		frame.setResizable(false);

		al = new AppLayout();
		al.addComponentsToPane(frame.getContentPane());

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				renderGUI();
			}
		});
	}
}