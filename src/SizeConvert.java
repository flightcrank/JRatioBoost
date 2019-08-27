
//This class can convert bytes into kilo, mega, or gigabytes 
class SizeConvert {
	
	enum SizeType {
		
		B, KB, MB, GB;
	}

	float value;
	SizeType size;	

	public SizeConvert(long bytes) {
		
		long oneKB = 1024;
		long oneMB = (long) Math.pow(1024, 2);
		long oneGB = (long) Math.pow(1024, 3);

		if (bytes >= 1024 && bytes < oneMB) {
			
			value = kiloBytes(bytes);
			size = SizeType.KB;
		 
		 } else if (bytes >= oneMB && bytes < oneGB) {
		 
			value = megaBytes(bytes);
			size = SizeType.MB;

		 } else if (bytes >= oneGB) {
		 
			value = gigaBytes(bytes);
			size = SizeType.GB;
		 
		 } else {
		 	
			value = (float) bytes;
			size = SizeType.B;
		 }
	}

	public static float kiloBytes(long bytes) {
	
		return (float) bytes / 1024.0f;
	}
	
	public static float megaBytes(long bytes) {
	
		return kiloBytes(bytes) / 1024.0f;
	}
	
	public static float gigaBytes(long bytes) {
	
		return megaBytes(bytes) / 1024.0f;
	}
	
	public static long KBToB(int kb) {

		return kb * 1024;
	}
	
	@Override
	public String toString() {
		
		return String.format("%.02f %s", value, size);
	}
}
