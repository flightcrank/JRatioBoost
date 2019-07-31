import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

//class to connect to a remore torrent tracker and issue HTML GET requests
class TrackerConnect {
	
	String seeders;
	String leechers;
	String interval;
	String minInterval;
	String port;
	boolean valid;
	TorrentInfo tInfo;

	TrackerConnect(TorrentInfo tInfo, String port) throws MalformedURLException, IOException, Exception {
	
		this.tInfo = tInfo;
		this.valid = false;
		this.port = port;
		connect();
	}

	//request to start a new torrent connection to tracker. using this method with no arguments will
	//also send the events=started message to the tracker.
	public void connect() throws MalformedURLException, IOException, Exception {
		
		URL tracker;
		URLConnection conn = null;
		
		//check if the annouce URL in the torrent file has a query sting already in it.
		char q = (tInfo.announce.contains("?") == true) ? '&' : '?';  
		
		String queryString = String.format("info_hash=%s&peer_id=%s&port=%s&uploaded=0&downloaded=0&left=0&compact=1&event=started", tInfo.hexStringUrlEnc(0), tInfo.hexStringUrlEnc(1), this.port);
		String request = String.format("%s%s%s", tInfo.announce, q, queryString);
		
		System.out.println(request);
		
		//connect to torrent tracker
		tracker = new URL(request);
		conn = tracker.openConnection();
		System.out.println("connection timeout " + conn.getReadTimeout());
			
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

	//request to send upload and download data to tracker. Note this method omits the "event" key in the 
	//query string as this overloaded method is for updating the ongoing connection
	public void connect(String uploaded, String downloaded) throws MalformedURLException, IOException, Exception {
	
		URL tracker;
		URLConnection conn = null;
		
		//check if the annouce URL in the torrent file has a query sting already in it.
		char q = (tInfo.announce.contains("?") == true) ? '&' : '?';  
		
		String queryString = String.format("info_hash=%s&peer_id=%s&port=%s&uploaded=%s&downloaded=%s&left=0&compact=1", tInfo.hexStringUrlEnc(0), tInfo.hexStringUrlEnc(1), this.port, uploaded, downloaded);
		String request = String.format("%s%s%s", tInfo.announce, q, queryString);
		System.out.println(request);
		
		//connect to torrent tracker
		tracker = new URL(request);
		conn = tracker.openConnection();
				
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

		return new Blex(tempFile.getPath());
	}

	public String toString() {
	
		return String.format("Tracker Connect: [seeders:%s leechers:%s interval:%s min interval:%s]", seeders, leechers, interval, minInterval);
	}
}


