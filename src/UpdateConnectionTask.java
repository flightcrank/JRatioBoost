
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;

/**
 *
 * @author karma
 */
public class UpdateConnectionTask extends SwingWorker <String, Void> {

	private TorrentElement te;
	private TrackerConnect tc;
	private Gui gui;
	public static final String UPDATE_SUCCESSFULL = "Update Connection Successfull";
	
	public UpdateConnectionTask(TorrentElement te, Gui gui) {
	
		this.te = te;
		this.tc = te.gettConn();
		this.gui = gui;
	}
	
	//preform connection to tracker in its own background thread to prevent blocking
	//the GUI on the Event dispatch thread.
	@Override
	protected String doInBackground() throws Exception {
		
		try {
		
			//send get request to tracker with upload/download data
			tc.connect(String.format("%d", te.getUploadAmount()), "0");
			
		} catch (MalformedURLException ex) {
			
			return "URL Error: The tracker URL is not properly formatted.\n" + ex.getMessage();
			
		} catch (IOException ex) {
			
			return "Error IO (network or timeout): \n" + ex.getMessage();
			
		}
		
		return UPDATE_SUCCESSFULL;
	}
 	
	@Override
	protected void done() {
		
		String result;
		
		try {
			
			result = get();

			if (result.equals(UpdateConnectionTask.UPDATE_SUCCESSFULL)) {
				
				//keep track if the amount of spoofed uploads that has been sent so far
				long num = te.getUploadSent() + (te.getUploadAmount() - te.getUploadSent());
				te.setUploadSent(num);

				//add a new announcement to the list
				String announce = String.format("%s?info_hash=%s&peer_id=%s&port=%s&uploaded=%d&downloaded=%d&left=0&compact=1", te.gettInfo().announce, te.gettInfo().hexStringUrlEnc(0), te.gettInfo().hexStringUrlEnc(1), tc.port, te.getUploadAmount(), te.getDownloadAmount());
				te.getNumAnnouce().add(announce);
				
				//reset interval timer
				te.setTimeLeft(Integer.parseInt(te.gettConn().interval));
				
				te.getTimer().start();
				
				System.out.println(result + ": " + te.getNumAnnouce());
		
			} else {
				
				te.getErrorMsg().add(result); // Error Type
				gui.errorsButton.setText(String.valueOf(te.getErrorMsg().size()));
				gui.stopAction(te.getIndex());
			}
				
		} catch (InterruptedException | ExecutionException e) {
			
			String errMsg = "InterruptedException/ExecutionException: " + e.getMessage();
			
			te.getErrorMsg().add(errMsg); // Error content
			gui.errorsButton.setText(String.valueOf(te.getErrorMsg().size()));
			gui.stopAction(te.getIndex());
		}
	}
}
