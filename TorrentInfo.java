
import java.util.ArrayList;
import java.util.ArrayDeque;

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
		
		setInfo(lexTree.tokenList);
	}

	private void setInfo(ArrayList<TokenElement> tokenArray) {
		
		for(int i = 0; i < tokenArray.size(); i++) {
			
			String str = tokenArray.get(i).getValueString();
			
			if (str != null && str.equals("announce") == true) {
				
				i++;
				this.announce = tokenArray.get(i).getValueString();
			
			} else if (str != null && str.equals("created by") == true) {
				
				i++;
				this.createdBy = tokenArray.get(i).getValueString();
			
			} else if (str != null && str.equals("creation date") == true) {
				
				i++;
				this.creationDate = tokenArray.get(i).getValueString();
			
			} else if (str != null && str.equals("comment") == true) {
				
				i++;
				this.comment = tokenArray.get(i).getValueString();
			
			} else if (str != null && str.equals("encoding") == true) {
				
				i++;
				this.encoding = tokenArray.get(i).getValueString();

			} else if (str != null && str.equals("announce-list") == true) {
				
				i++;
				ArrayDeque<TokenElement> announceStack = new ArrayDeque<TokenElement>();		
				announceStack.push(tokenArray.get(i));

				while (announceStack.isEmpty() != true) {
					
					i++;

					if (tokenArray.get(i).type == TokenElement.Token.END) {
						
						announceStack.pop();

					} else if (tokenArray.get(i).type == TokenElement.Token.LIST) {
						
						announceStack.push(tokenArray.get(i));

					} else if (tokenArray.get(i).type == TokenElement.Token.BYTESTRING) {
						
						this.announceList.add(tokenArray.get(i).getValueString());
					}
				}
			}
		}
	}
}
