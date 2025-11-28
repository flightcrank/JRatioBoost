
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;
import javax.swing.Timer;

/**
 *
 * @author karma
 */
public class StartConnectionTask extends SwingWorker<String, Void> {

	TorrentElement te;
	Gui gui;
	public static final String CONNECTION_SUCCESSFULL = "Started Connection Successfull";
	
	public StartConnectionTask(TorrentElement te, Gui gui) {
	
		this.te = te;
		this.gui = gui;
	}
	
	@Override
	protected String doInBackground() throws Exception {
	
		try {
			
			te.settConn(new TrackerConnect(te.gettInfo(), te.getPort(), te.getCustomUserAgent()));
			
		} catch (MalformedURLException ex) {
			
			return "URL Error: The tracker URL is not properly formatted.\n" + ex.getMessage();
			
		} catch (IOException ex) {
			
			return "Error IO (network or timeout): \n" + ex.getMessage();
		
		} catch (Exception ex) {
			
			return "Exception: \n" + ex.getMessage();
		} 
			
		return StartConnectionTask.CONNECTION_SUCCESSFULL;
	}

	@Override
	protected void done() {
		
		String result;
		
		try {
			
			result = get();
		
			if (result.equals(StartConnectionTask.CONNECTION_SUCCESSFULL)) {
				
				String announce = String.format("%s?info_hash=%s&peer_id=%s&port=%s&uploaded=0&downloaded=0&left=0&compact=1&event=started", te.gettInfo().announce, te.gettInfo().hexStringUrlEnc(0), te.gettInfo().hexStringUrlEnc(1), te.gettConn().port);
				te.getNumAnnouce().add(announce);
				System.out.println(result + ": " + te.getNumAnnouce().get(te.getNumAnnouce().size() - 1));
				
				//valid connection made
				if (te.gettConn() != null && te.gettConn().valid == true) {

					gui.connectButton.setText("Stop");
					gui.torrentList.repaint();

					Timer t = new Timer(1000, e -> {
					
						// This code runs on the EDT, guaranteed safe for GUI updates!
						gui.periodicUpdate(te);
					});

					te.setTimeLeft(Integer.parseInt(te.gettConn().interval));
					te.setTimer(t);
					t.start();
				}

			} else {

				te.getErrorMsg().add(result); // Error content
				gui.errorsButton.setText(String.valueOf(te.getErrorMsg().size()));
				gui.stopAction(te.getIndex());
			}
		
		} catch (InterruptedException | ExecutionException e) {
			
			String errMsg = new String("Error during execution: " + e.getCause().getMessage());
				
			te.getErrorMsg().add(errMsg); // Error content
			gui.errorsButton.setText(String.valueOf(te.getErrorMsg().size()));
			gui.stopAction(te.getIndex());
		
		} finally {

			gui.WindowPanel.setCursor(null);
		}
	}
}
