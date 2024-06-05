/**
 *
 * @author karma
 * 
 * This class represents the spoofed upload data that is sent to the tracker
 */
public class TrackerInfo {
	
	private int seeders;
	private int leeches;
	private int downloaded;
	private int uploaded;
	private int updateInterval;

	public void setSeeders(int seeders) {

		this.seeders = seeders;
	}

	public void setLeeches(int leeches) {

		this.leeches = leeches;
	}

	public void setDownloaded(int downloaded) {

		this.downloaded = downloaded;
	}

	public void setUploaded(int uploaded) {

		this.uploaded = uploaded;
	}

	public void setUpdateInterval(int updateInterval) {

		this.updateInterval = updateInterval;
	}

	public int getSeeders() {

		return seeders;
	}

	public int getLeeches() {

		return leeches;
	}

	public int getDownloaded() {

		return downloaded;
	}

	public int getUploaded() {
		return uploaded;
	}

	public int getUpdateInterval() {

		return updateInterval;
	}
	
	public TrackerInfo() {
		
	}
}
