
//Lexical analyser for bencoded torrent files
//JDK 7 or above

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayDeque;
import java.util.ArrayList;

//a class to lexically scan a bencoded file and store the tokens and their values in an ArrayList 
class Blex {
	
	ArrayList<TokenElement> tokenList; //array of all token elements and data
	boolean valid = false;
	
	Blex(FileInputStream fis) throws IOException {
		
		tokenList = new ArrayList<TokenElement>();
		valid = this.readFile(fis);
	}
	
	public String toString() {
		
		return String.format("Blex: [valid=%b, num_tokens=%d]", valid, tokenList.size());
	}

	//open and process the bencoded file 
	private boolean readFile(FileInputStream file) throws IOException {
	
		int fileIndex; 	//store the current byte read from a file
		StringBuffer len = new StringBuffer();  //store a string of numbers to represent the INTEGER token value or the BYTESTRING length
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();//object to track that all the required tokens have a END token

		FileChannel fChan = file.getChannel(); //object to obtain offset current position within the file

		do {

			fileIndex = file.read();

			//DICTIONARY token found
			if (fileIndex == (int) 'd') {

				TokenElement token = new TokenElement();

				//populate tokens instance variables
				token.type = TokenElement.Token.DICTIONARY;
				token.position = fChan.position();
				this.tokenList.add(token);
				stack.push(tokenList.size() - 1);//subtract 1 to get the index number not the size of an array

			//LIST token found
			} else if (fileIndex == (int) 'l') {

				TokenElement token = new TokenElement();

				//populate tokens instance variables
				token.type = TokenElement.Token.LIST;
				token.position = fChan.position();
				this.tokenList.add(token);
				stack.push(tokenList.size() - 1);//subtract 1 to get the index number not the size of an array

			//INTEGER token found
			} else if (fileIndex == (int) 'i') {

				TokenElement token = new TokenElement();

				//populate tokens instance variables
				token.type = TokenElement.Token.INTEGER;
				token.position = fChan.position();
				this.tokenList.add(token);
				stack.push(tokenList.size() - 1);//subtract 1 to get the index number not the size of an array

			//END token found
			} else if (fileIndex == (int) 'e') {

				TokenElement token = new TokenElement();
				TokenElement startToken; 
				TokenElement prevToken = tokenList.get(tokenList.size() - 1);

				if (prevToken.type == TokenElement.Token.INTEGER) {

					prevToken.value = len.toString().getBytes();
				}

				//populate tokens instance variables
				token.type = TokenElement.Token.END;
				token.position = fChan.position();

				if (stack.size() != 0) {

					token.endIndex = stack.peek();//store the index of the TOKEN this END token ends.
				}

				this.tokenList.add(token);

				len.delete(0, len.length());//could be end of an integer so clear the len StringBuffer for the next time a string of numbers is encountered

				if (stack.size() != 0) {

					stack.pop();
				}

				//populate the endIndex field of the calling token with the index of this END token
				int index = this.tokenList.size() - 1;//-1 to obtain index number size
				startToken = this.tokenList.get(token.endIndex);
				startToken.endIndex = index;

			//number found: read in string of number/s and save to a StringBuffer
			} else if (fileIndex >= (int) '0' && fileIndex <= (int) '9' ) {

				len.append((char) fileIndex);

			//BYTESTRING token found: read in number of bytes stored by len (a StringBuffer)
			//and store into a byte array
			} else if (fileIndex == (int) ':') {

				int byteStrLen =  Integer.parseInt(len.toString());
				byte byteStr[] = new byte[byteStrLen];
				TokenElement token = new TokenElement();

				token.type = TokenElement.Token.BYTESTRING;
				token.position = fChan.position();
				fileIndex = file.read(byteStr);
				token.value = byteStr;
				this.tokenList.add(token);
				len.delete(0, len.length());//reset len(StringBuffer) for the next time numbers are encountered
			}

		} while (fileIndex > -1);

		//validates the file, making sure all required tokens have a matching END token
		return stack.isEmpty();
	}
}
