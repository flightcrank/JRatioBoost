
import java.util.ArrayList;

class TorrentInfo {

	String announce;
	String creationDate;
	String createdBy;
	String comment;
	String encoding;
	ArrayList<String> announceList;
	byte[] infoHash;

	public TorrentInfo(String fileName) {
		
		Blex lexTree = new Blex(fileName);
		announceList = new ArrayList<String>();
		infoHash = new byte[20]; 
		TokenElement[] tokenArray = new TokenElement[lexTree.tokenList.size()];
		
		lexTree.tokenList.toArray(tokenArray);
		setInfo(tokenArray);
	}

	private void setInfo(TokenElement[] tokenArray) {
		
		for(int i = 0; i < tokenArray.length; i++) {
			
			String str = tokenArray[i].getValueString();
			
			if (str != null && str.equals("announce") == true) {
				
				System.out.print(tokenArray[i + 1].type);
				System.out.print(" = " + tokenArray[i + 1].getValueString() + "\n");
			
			} else if (str != null && str.equals("created by") == true) {
				
				System.out.print(tokenArray[i + 1].type);
				System.out.print(" = " + tokenArray[i + 1].getValueString() + "\n");
			
			}  else if (str != null && str.equals("creation date") == true) {
				
				System.out.print(tokenArray[i + 1].type);
				System.out.print(" = " + tokenArray[i + 1].getValueString() + "\n");
			
			}  else if (str != null && str.equals("comment") == true) {
				
				System.out.print(tokenArray[i + 1].type);
				System.out.print(" = " + tokenArray[i + 1].getValueString() + "\n");
			}

		}
	}
}
