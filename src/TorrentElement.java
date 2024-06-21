
import java.util.ArrayList;
import java.util.Timer;

/**
 *
 * This class contains all the torrent data such as torrent name, size, tracker
 * info etc. It also contains the elements such as the thread objects so more than
 * one torrent can be spoofed at the same time.
 * 
 * @author karma
 * @version 1.0
 * 
 */
public class TorrentElement {
	
	/**
	 * int that represents the object index in an array
	 */
	private int index;			

	/**
	 * int to keep track of how much has been uploaded
	 */
	private long uploadAmount;
	
	/**
	 * int to keep track of how much has been downloaded
	 */
	private long downloadAmount;			
	
	/**
	 * int to set the simulated speed of the upload
	 */
	private int uploadSpeed;			

	/**
	 * int to set the simulated speed of the downloaded
	 */
	private int downloadSpeed;			
	
	/**
	 * int to keep track of the number of seconds left to send the upload/download data
	 */
	private int timeLeft;				

	/**
	 * int that keeps track of how much spoofed upload data has been received by the tracker 
	 */
	private long uploadSent;			
	
	/**
	 * String to keep track of what port the program will report its using to the tracker
	 */
	private String port;				
	
	/**
	 * String set a custom user agent
	 */
	private String customUserAgent;			
	
	/**
	 * object that represents a new thread to perform the upload
	 */
	private Timer timer;				
	
	/**
	 * object that contains all relevant torrent info
	 */
	private TorrentInfo tInfo;			

	/**
	 * object that represents the spoofed upload info to send
	 */
	private TrackerConnect tConn;			

	/**
	 * value that keeps track of how many announcement's have been made to the tracker
	 */
	private ArrayList<String> numAnnouce;	
	
	/**
	 * A string array of error messages this torrent may or may not get. e.g unable to connect to tracker
	 */
	private ArrayList<String> errorMsg;	
	
	/**
	 * Constructor that initialises all member variables to their default values
	 */
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
	
	/**
	 * 
	 * @return A String representing a User Agent specified by the user 
	 */
	public String getCustomUserAgent() {

		return customUserAgent;
	}
	
	/**
	 * 
	 * @return The amount in bytes that has been sent to the torrent tracker 
	 */
	public long getUploadSent() {
		
		return uploadSent;
	}

	/**
	 * 
	 * @return A String that represents the port number set to the torrent tracker 
	 */
	public String getPort() {
		
		return port;
	}
	
	/**
	 * 
	 * @return A ArrayList of Strings that contain the announcements that have been sent to the torrent tracker 
	 */
	public ArrayList<String> getNumAnnouce() {

		return numAnnouce;
	}

	/**
	 * 
	 * @return A ArrayList of Strings that contain error messages 
	 */
	public ArrayList<String> getErrorMsg() {

		return errorMsg;
	}
	
	/**
	 * 
	 * @return A integer that represents the number of seconds left until the nest announcement is made
	 */	
	public int getTimeLeft() {
		
		return timeLeft;
	}
	
	/**
	 * 
	 * @return a integer that represents the upload speed in KiloBytes per second
	 */
	public int getUploadSpeed() {

		return uploadSpeed;
	}

	/**
	 * 
	 * @return a integer that represents the download speed in KiloBytes per second
	 */
	public int getDownloadSpeed() {
		
		return downloadSpeed;
	}

	/**
	 * 
	 * @return A TorrentInfo object that represents all the information held within the torrent file.
	 */
	public TorrentInfo gettInfo() {

		return tInfo;
	}

	/**
	 * 
	 * @return A TrackerConnect object that represents all the info that the tracker sends back
	 * after a request has been made.
	 */
	public TrackerConnect gettConn() {

		return tConn;
	}
	
	/**
	 * 
	 * @return a Timer object that represents a thread that runs periodically.
	 */
	public Timer getTimer() {
	
		return timer;
	}

	/**
	 * 
	 * @return A integer that represents the index that an instance of this object is in a ArrayList.
	 */	
	public int getIndex() {
	
		return index;
	}

	/**
	 * 
	 * @return A long integer that represents the amount of spoofed uploads in bytes.
	 */
	public long getUploadAmount() {

		return uploadAmount;
	}

	/**
	 * 
	 * @return A long integer that represents the amount of spoofed downloads in bytes. 
	 */
	public long getDownloadAmount() {

		return downloadAmount;
	}

	/**
	 * This function sets the customUserAgent member variable. If an empty sting is given as a parameter
	 * it will set the member variable to null as a precaution.
	 * @param customUserAgent A String that represents the user agent string that is sent to the tracker 
	 */	
	public void setCustomUserAgent(String customUserAgent) {
	
		if (customUserAgent.isEmpty()) {
			
			this.customUserAgent = null;
		
		} else {
		
			this.customUserAgent = customUserAgent;
		}
	}
	
	/**
	 * Sets the port number to be spoofed
	 * @param port the port number as a string
	 */
	public void setPort(String port) {

		this.port = port;
	}

	/**
	 * This function sets the amount of uploads that the tracker has received
	 * @param uploadSent the amount of upload data sent in bytes
	 */
	public void setUploadSent(long uploadSent) {

		this.uploadSent = uploadSent;
	}

	/**
	 * This function set the amount of time left until the next announcement is made
	 * @param timeLeft time left until the next announcement in seconds
	 */	
	public void setTimeLeft(int timeLeft) {

		this.timeLeft = timeLeft;
	}

	/**
	 * This function sets the upload speed per-second in bytes
	 * @param uploadSpeed upload speed in bytes
	 */
	public void setUploadSpeed(int uploadSpeed) {

		this.uploadSpeed = uploadSpeed;
	}

	/**
	 * This function sets the download speed per-second in bytes
	 * @param downloadSpeed 
	 */
	public void setDownloadSpeed(int downloadSpeed) {
		
		this.downloadSpeed = downloadSpeed;
	}
	
	/**
	 * This function sets the spoofed upload amount in bytes
	 * @param uploadAmount spoofed upload amount in bytes
	 */
	public void setUploadAmount(long uploadAmount) {
		
		this.uploadAmount = uploadAmount;
	}

	/**
	 * This function sets the spoofed download amount in bytes
	 * @param downloadAmount spoofed download amount in bytes
	 */
	public void setDownloadAmount(long downloadAmount) {

		this.downloadAmount = downloadAmount;
	}
	
	/**
	 * This function sets the index member variable that keeps track of where in an ArrayList
	 * an instance of this object is.
	 * @param index position in an ArrayList.
	 */	
	public void setIndex(int index) {
	
		this.index = index;
	}

	/**
	 * This function stores a TorrentInfo object in a member variable that contains all the data
	 * from a torrent retrieved from a torrent file
	 * @param tInfo torrent data from a torrent file
	 */	
	public void settInfo(TorrentInfo tInfo) {
	
		this.tInfo = tInfo;
	}

	/**
	 * This function stores TrackerConnect object in a member variable that contains the data 
	 * that is received from a tracker when a connection to the tracker is made.
	 * @param uInfo data received from a connection to a tracker
	 */
	public void settConn(TrackerConnect uInfo) {

		this.tConn = uInfo;
	}

	/**
	 * This function sets a Timer object as a member variable to represent a thread that executes
	 * a task periodically.
	 * @param timer 
	 */
	public void setTimer(Timer timer) {

		this.timer = timer;
	}
}
