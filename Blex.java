
//Lexical analyser for bencoded torrent files
//JDK 7 or above

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.nio.channels.FileChannel;

//object to represent a bencoded token type and value
class TokenElement {

	public enum Token {

		BYTESTRING, INTEGER, LIST, DICTIONARY, END;
	}
	
	Token type;	//the type of token encountered
	byte value[];	//the value (if any) associated with the token
	long position;	//the byte offset position in the file the token was found at

	public String getValueString() {
		
		if (value != null) {
			
			String str = new String(value);

			if (str.matches(".+")) {

				return str;
			}
		}

		return null;
	}
}

//a class to lexically scan a bencoded file 
class Blex {
	
	//instance elements
	ArrayList<TokenElement> tokenList;	
	
	//constructor
	public Blex(String fileName) {
		
		tokenList = new ArrayList<TokenElement>();
		this.readFile(fileName);
	}
	
	//open and process the bencoded file 
	private void readFile(String fileName) {
	
		int fileIndex; 				//store the current byte read from a file
		StringBuffer len = new StringBuffer();  //store a string of numbers to represent the INTEGER token value or the BYTESTRING length
		
		try (FileInputStream file = new FileInputStream(fileName)) {
			
			FileChannel fChan = file.getChannel(); //object to obtain offset current position within the file

			do {
				
				fileIndex = file.read();
				
				//DICTIONARY token found
				if (fileIndex == (int) 'd') {
					
					TokenElement token = new TokenElement();
					
					token.type = TokenElement.Token.DICTIONARY;
					token.position = fChan.position();
					this.tokenList.add(token);
				
				//LIST token found
				} else if (fileIndex == (int) 'l') {
				
					TokenElement token = new TokenElement();
					
					token.type = TokenElement.Token.LIST;
					token.position = fChan.position();
					this.tokenList.add(token);

				//INTEGER token found
				} else if (fileIndex == (int) 'i') {
				
					TokenElement token = new TokenElement();
					
					token.type = TokenElement.Token.INTEGER;
					token.position = fChan.position();
					this.tokenList.add(token);
				
				//END token found
				//could be end of an integer so clear the len StringBuffer for the next time a 
				//string of numbers are encountered
				} else if (fileIndex == (int) 'e') {
				
					TokenElement token = new TokenElement();
					TokenElement prevToken = tokenList.get(tokenList.size() - 1);
					
					if (prevToken.type == TokenElement.Token.INTEGER) {
						
						prevToken.value = len.toString().getBytes();
					}

					token.type = TokenElement.Token.END;
					token.position = fChan.position();
					this.tokenList.add(token);
					len.delete(0, len.length());

				//number found: read in string of number/s and save to a StringBuffer
				} else if (fileIndex >= (int) '0' && fileIndex <= (int) '9' ) {
					
					len.append((char) fileIndex);
				
				//BYTESTRING token found: read in number of bytes stored by len (a StringBuffer)
				//and store into a byte array
				} else if (fileIndex == (int) ':') {
					
					int byteStrLen = Integer.parseInt(len.toString());
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

		} catch (IOException e) {
			
			System.out.println("error: " + e);
		}
	}
}
