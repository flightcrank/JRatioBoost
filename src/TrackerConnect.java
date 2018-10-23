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
	TorrentInfo tInfo;

	TrackerConnect(TorrentInfo tInfo) {
	
		this.tInfo = tInfo;
		connect();
	}

	//request to start a new torrent connection to tracker. using this method with no arguments will
	//also send the events=started message to the tracker.
	public void connect() {
		
		URL tracker;
		URLConnection conn = null;
		String queryString = String.format("?info_hash=%s&peer_id=%s&port=6881&uploaded=0&downloaded=0&left=0&compact=1&event=started", tInfo.hexStringUrlEnc(0), tInfo.hexStringUrlEnc(1));
		String request = String.format("%s%s", tInfo.announce, queryString);
		
		//connect to torrent tracker
		try {
			tracker = new URL(request);
			conn = tracker.openConnection();
			System.out.println("connection timeout " + conn.getReadTimeout());
		
		} catch (MalformedURLException e) {

			System.out.println("URL Error:" + e);		
		
		} catch (IOException e) {
			
			System.out.println("Connection Error:" + e);		
		}
	
		if (conn != null) {

			Blex blex = responce(conn);
			
			if (blex.valid) {
				
				setInfo(blex.tokenList);
			}
		}
	}

	//request to send upload and download data to tracker. Note this method omits the "event" key in the 
	//query string as this overloaded method is for updating the ongoing connection
	public void connect(String uploaded, String downloaded) {
	
		URL tracker;
		URLConnection conn = null;
		String queryString = String.format("?info_hash=%s&peer_id=%s&port=6881&uploaded=%s&downloaded=%s&left=0&compact=1", tInfo.hexStringUrlEnc(0), tInfo.hexStringUrlEnc(1), uploaded, downloaded);
		String request = String.format("%s%s", tInfo.announce, queryString);
		System.out.println(request);
		
		//connect to torrent tracker
		try {
			tracker = new URL(request);
			conn = tracker.openConnection();
		
		} catch (MalformedURLException e) {

			System.out.println("URL Error:" + e);		
		
		} catch (IOException e) {
			
			System.out.println("Connection Error:" + e);		
		}
		
		if (conn != null) {

			Blex blex = responce(conn);
			
			if (blex.valid) {
				
				setInfo(blex.tokenList);
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

	private Blex responce(URLConnection conn) {
		
		File tempFile;

		//create a temp file to store the trackers bencoded response
		try { 

			tempFile = File.createTempFile("responce", ".dat");
			
			//get the responce from the URL
			try (InputStream responce = conn.getInputStream();) {
				
				//open the temp file to write too
				try (FileOutputStream fileOut = new FileOutputStream(tempFile);) {

					int index;

					do {
						
						index = responce.read();
						fileOut.write(index);
					
					} while (index > -1);

				} catch (FileNotFoundException e) {
					
					System.out.println("Could not open temp file: " + e);
				}

			} catch (IOException e) {
			
				System.out.println("Tracker responce error:" + e);
			}
		
			return new Blex(tempFile.getPath());
		
		} catch (IOException e) {
			
			System.out.println("Create File error:" + e);		
		}

		return null;
	}

	public String toString() {
	
		return String.format("Tracker Connect: [seeders:%s leechers:%s interval:%s min interval:%s]", seeders, leechers, interval, minInterval);
	}
}


