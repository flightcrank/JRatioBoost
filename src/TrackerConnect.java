
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

//class to connect to a remote torrent tracker and issue HTML GET requests
class TrackerConnect {
	
	public String seeders;
	public String leechers;
	public String interval;
	public String minInterval;
	public String port;
	public String customUserAgent;
	public boolean valid;
	public TorrentInfo tInfo;

	TrackerConnect(TorrentInfo tInfo, String port, String userAgent) throws MalformedURLException, IOException, Exception {
	
		this.tInfo = tInfo;
		this.valid = false;
		this.port = port;
		this.customUserAgent = userAgent;
		connect();
	}

	//request to start a new torrent connection to tracker. using this method with no arguments will
	//also send the events=started message to the tracker.
	public final void connect() throws MalformedURLException, IOException, Exception {
		
		URL tracker;
		URLConnection conn = null;
		
		//check if the annouce URL in the torrent file has a query sting already in it.
		char q = (tInfo.announce.contains("?") == true) ? '&' : '?';  
		
		String queryString = String.format("info_hash=%s&peer_id=%s&port=%s&uploaded=0&downloaded=0&left=0&compact=1&event=started", tInfo.hexStringUrlEnc(0), tInfo.hexStringUrlEnc(1), this.port);
		String request = String.format("%s%s%s", tInfo.announce, q, queryString);
		
		this.doRequest(request);
	}

	//request to send upload and download data to tracker. Note this method omits the "event" key in the 
	//query string as this overloaded method is for updating the ongoing connection
	public final void connect(String uploaded, String downloaded) throws MalformedURLException, IOException, Exception {

		//check if the annouce URL in the torrent file has a query sting already in it.
		char q = (tInfo.announce.contains("?") == true) ? '&' : '?';  
		
		String queryString = String.format("info_hash=%s&peer_id=%s&port=%s&uploaded=%s&downloaded=%s&left=0&compact=1", tInfo.hexStringUrlEnc(0), tInfo.hexStringUrlEnc(1), this.port, uploaded, downloaded);
		String request = String.format("%s%s%s", tInfo.announce, q, queryString);
		System.out.println(request);
		
		this.doRequest(request);
	}
	
	private void doRequest(String request) throws MalformedURLException, FileNotFoundException, IOException, Exception {
		
		URL tracker;
		URLConnection conn = null;
		String userAgent = getUserAgent();

		if (this.customUserAgent != null) {
			
			userAgent = this.customUserAgent;
		} 

		
		//connect to torrent tracker
		tracker = new URL(request);
		conn = tracker.openConnection();
		conn.setRequestProperty("User-Agent", userAgent);
				
		if (conn != null) {

			Blex blex = responce(conn);
			
			if (blex.valid) {
				
				valid = true;
				checkFailResponse(blex.tokenList);
				setInfo(blex.tokenList);
			
			} else {
				
				valid = false;
				throw new Exception("Invalid bencoded responce.");
			}
		}
	}
	
	private String getUserAgent() {
		
		String userAgent;
		char[] client = {(char)tInfo.peerId[1], (char)tInfo.peerId[2]};
		char[] ver = {(char)tInfo.peerId[3],(char)tInfo.peerId[4],(char)tInfo.peerId[5],(char)tInfo.peerId[6]};
		
		switch (new String(client)) {
			
			case "KT":
				userAgent = "KTorrent/" + ver[0] + "." + ver[1] + "." + ver[2]+ "." + ver[3];
				break;
			case "TR":
				userAgent = "Transmission/" + ver[0] + "." + ver[1] + "." + ver[2]+ "." + ver[3];
				break;
			case "JT":
				userAgent = "JavaTorrent/" + ver[0] + "." + ver[1] + "." + ver[2]+ "." + ver[3];
				break;
			case "qB":
				userAgent = "qBittorrent/" + ver[0] + "." + ver[1] + "." + ver[2]+ "." + ver[3];
				break;
			case "UT":
				userAgent = "µTorrent/" + ver[0] + "." + ver[1] + "." + ver[2]+ "." + ver[3];
				break;
				
			default:
				userAgent = "KTorrent/5.1.1";
		}
		
		return userAgent;
	}
	
	private void checkFailResponse(ArrayList<TokenElement> tokenList) throws Exception {
	
		for (int i = 0; i < tokenList.size(); i++) {
			
			String str = tokenList.get(i).getValueString();
			
			if (str != null && str.equals("failure reason")) {
				
				this.valid = false;
				String failReason = tokenList.get(i + 1).getValueString();
				throw new Exception("\nTracker Failure Reason: " + failReason);
			}
		}
	}
	
	//populate instace variables from the responce recieved from the tracker
	private void setInfo(ArrayList<TokenElement> tokenList) {
		
		for (int i = 0; i <tokenList.size(); i++) {
			
			String str = tokenList.get(i).getValueString();
			
			if (str != null && str.equals("complete")) {
					
				this.seeders = new String(tokenList.get(i + 1).value);
			}
			
			if (str != null && str.equals("incomplete")) {
					
				this.leechers = new String(tokenList.get(i + 1).value);
			}
			
			if (str != null && str.equals("interval")) {
					
				this.interval = new String(tokenList.get(i + 1).value);
			}
			
			if (str != null && str.equals("min interval")) {
					
				this.minInterval = new String(tokenList.get(i + 1).value);
			}
		}
	}

	private Blex responce(URLConnection conn) throws FileNotFoundException, IOException {
		
		File tempFile;

		//create a temp file to store the trackers bencoded response
		tempFile = File.createTempFile("responce", ".dat");

		//get the responce from the URL
		InputStream responce = conn.getInputStream();

		//open the temp file to write too
		FileOutputStream fileOut = new FileOutputStream(tempFile);

		int index;

		do {

			index = responce.read();
			fileOut.write(index);

		} while (index > -1);

		return new Blex(new FileInputStream(tempFile.getPath()));
	}

	@Override
	public String toString() {
	
		return String.format("Tracker Connect: [seeders:%s leechers:%s interval:%s min interval:%s]", seeders, leechers, interval, minInterval);
	}
}


