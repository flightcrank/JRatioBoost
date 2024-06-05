
import java.util.Timer;

/**
 *
 * @author karma
 * 
 * This class contains all the torrent data such as torrent name, size, tracker
 * info etc. It also contains the elements such as the thread objects so more than
 * one torrent can be spoofed at the same time.
 */

public class TorrentElement {
	
	private int index;		//int that represents the object index in an array	
	private Timer timer;		//object that represents a new thread to perform the upload
	private TorrentInfo tInfo;	//object that contains all relevent torrent info
	private TrackerConnect tConn;	//object that represents the spoofed upload info to send
	private int uploadAmount;
	private int downloadAmount;

	public TorrentElement() {
		
		this.uploadAmount = 0;
		this.downloadAmount = 0;
	}

	public void setUploadAmount(int uploadAmount) {
		this.uploadAmount = uploadAmount;
	}

	public void setDownloadAmount(int downloadAmount) {
		this.downloadAmount = downloadAmount;
	}
	
	public void setIndex(int index) {
	
		this.index = index;
	}
	
	public void settInfo(TorrentInfo tInfo) {
	
		this.tInfo = tInfo;
	}

	public void settConn(TrackerConnect uInfo) {

		this.tConn = uInfo;
	}

	public void setTimer(Timer timer) {

		this.timer = timer;
	}

	public TorrentInfo gettInfo() {

		return tInfo;
	}

	public TrackerConnect gettConn() {

		return tConn;
	}

	public Timer getTimer() {
	
		return timer;
	}
	
	public int getIndex() {
	
		return index;
	}

	public int getUploadAmount() {
		return uploadAmount;
	}

	public int getDownloadAmount() {
		return downloadAmount;
	}
}
