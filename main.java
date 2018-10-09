

class RatioBoost {

	public static void main (String[] args) {
		
		//object containg all relevant torrent file information
		TorrentInfo tInfo = new TorrentInfo("test.torrent");
		
		//object for communicating to torrent track
		TrackerConnect tConn = new TrackerConnect(tInfo.announce, tInfo);

		System.out.println(tConn);

	}
}
