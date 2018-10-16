
//object to represent a bencoded token type and value
class TokenElement {

	public enum Token {

		BYTESTRING, INTEGER, LIST, DICTIONARY, END;
	}
	
	Token type;	//the type of token encountered
	byte value[];	//the value (if any) associated with a INTEGER or BYTESTRING token
	long position;	//the byte offset position in the file the token was found at
	int endIndex;	//DICTIONARY, LIST, BYTESTRING and INTEGER tokens will hold the array index on their END token. END tokens will hold the index of the calling tokens

	public String getValueString() {
		
		if (value != null) {
			
			String str = new String(value);

			if (str.matches(".+")) {

				return str;
			}
		}

		return null;
	}

	public String toString() {

		return String.format("[%s, %s, %d, %d]", type, this.getValueString(), position, endIndex);

	}
}
