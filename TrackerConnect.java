
import java.net.*;
import java.io.*;
import java.io.File;
import java.util.ArrayList;

//class to connect to a remore torrent tracker and issue HTML GET requests
class TrackerConnect {
	
	URL tracker;
	URLConnection conn;
	String seeders;
	String leechers;
	String interval;
	String minInterval;

	TrackerConnect(String url, TorrentInfo tInfo) {
	
		String queryString = String.format("?info_hash=%s&peer_id=%s&port=6881&uploaded=0&downloaded=0&left=0&compact=1&event=started", tInfo.hexStringUrlEnc(0), tInfo.hexStringUrlEnc(1));
		String request = String.format("%s%s", url, queryString);
		
		//connect to torrent tracker
		try {
			tracker = new URL(request);
			conn = tracker.openConnection();
		
		} catch (MalformedURLException e) {

			System.out.println("URL Error:" + e);		
		
		} catch (IOException e) {
			
			System.out.println("Connection Error:" + e);		
		}
		
		Blex blex = responce();

		if (blex.valid) {
			
			setInfo(blex.tokenList);
		}
	}
	
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

	private Blex responce() {
		
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
	
		return String.format("Tracker Connect: [%s,\n seeders:%s leechers:%s interval:%s min interval:%s]", tracker, seeders, leechers, interval, minInterval);
	}
}


