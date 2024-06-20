
import java.util.ArrayList;
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
	
	private int index;			//int that represents the object index in an array	
	private long uploadAmount;		//int to keep track of how much has been uploaded
	private long downloadAmount;		//int to keep track of how much has been downloaded
	private int uploadSpeed;		//int to set the simulated speed of the upload
	private int downloadSpeed;		//int to set the simulated speed of the downloaded
	private int timeLeft;			//int to keep track of the number of seconds left to send the upload/download data
	private long uploadSent;		//int that keeps track of how much spoofed upload data has been recieved by the tracker
	private String port;			//String to keep track of what port the program will report its using to the tracker
	private String customUserAgent;		//String set a custom user agent
	private Timer timer;			//object that represents a new thread to perform the upload
	private TorrentInfo tInfo;		//object that contains all relevent torrent info
	private TrackerConnect tConn;		//object that represents the spoofed upload info to send
	private ArrayList<String> numAnnouce;	//value that keeps track of how many announcents have been made to the tracker
	private ArrayList<String> errorMsg;	//A string array of error messages this torrent may or may not get. e.g unable to connect to tracker

	public TorrentElement() {
		
		this.uploadAmount = 0;
		this.downloadAmount = 0;
		this.uploadSpeed = 40;
		this.downloadSpeed = 10;
		this.timeLeft = 0;
		this.uploadSent = 0;
		this.port = "6881";
		this.customUserAgent = null;
		this.numAnnouce = new ArrayList<>();
		this.errorMsg = new ArrayList<>();
	}

	public String getCustomUserAgent() {

		return customUserAgent;
	}

	public long getUploadSent() {
		
		return uploadSent;
	}

	public void setCustomUserAgent(String customUserAgent) {
	
		this.customUserAgent = customUserAgent;
	}

	public String getPort() {
		
		return port;
	}

	public void setPort(String port) {

		this.port = port;
	}

	public void setUploadSent(long uploadSent) {

		this.uploadSent = uploadSent;
	}

	public ArrayList<String> getNumAnnouce() {

		return numAnnouce;
	}

	public void setNumAnnouce(ArrayList<String> numAnnouce) {

		this.numAnnouce = numAnnouce;
	}

	public ArrayList<String> getErrorMsg() {

		return errorMsg;
	}

	public void setErrorMsg(ArrayList<String> errorMsg) {

		this.errorMsg = errorMsg;
	}
	
	public int getTimeLeft() {
		
		return timeLeft;
	}

	public void setTimeLeft(int timeLeft) {

		this.timeLeft = timeLeft;
	}

	public int getUploadSpeed() {

		return uploadSpeed;
	}

	public void setUploadSpeed(int uploadSpeed) {

		this.uploadSpeed = uploadSpeed;
	}

	public int getDownloadSpeed() {
		
		return downloadSpeed;
	}

	public void setDownloadSpeed(int downloadSpeed) {
		
		this.downloadSpeed = downloadSpeed;
	}

	public void setUploadAmount(long uploadAmount) {
		
		this.uploadAmount = uploadAmount;
	}

	public void setDownloadAmount(long downloadAmount) {

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

	public long getUploadAmount() {

		return uploadAmount;
	}

	public long getDownloadAmount() {

		return downloadAmount;
	}
}
