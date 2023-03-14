import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

	private static JFrame frame;
	private static CardsPane cards;

	private static void renderGUI() {

		frame = new JFrame("Conversor de unidades");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("assets/icon.jpg").getImage());
		frame.setResizable(false);

		cards = new CardsPane();
		cards.addComponentsToPane(frame.getContentPane());

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