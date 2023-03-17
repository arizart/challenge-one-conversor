import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

	private static JFrame frame;
	private static CardsPane cards;

	private void renderGUI() {

		frame = new JFrame("Conversor de unidades");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon logo = new ImageIcon(getClass().getResource("/res/icon.jpg"));
		frame.setIconImage(logo.getImage());
		frame.setResizable(false);

		cards = new CardsPane();
		cards.addComponentsToPane(frame.getContentPane());

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				App app = new App();
				app.renderGUI();
			}
		});
	}
}