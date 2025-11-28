
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


/**
 *
 * @author karma
 */
public class JRatioBoost {
	
	public static void main(String args[]) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				//Use native look and feel
				try {

					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

					//native l&f
					//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

				} catch (Exception e) {

					System.out.println(e);
				}

				//create and show the Swing GUI
				new Gui(args).setVisible(true);
			}
		});
	}
}
