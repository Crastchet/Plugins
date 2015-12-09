package plugins;

public abstract class CaesarCode implements Plugin {

	char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; 
	
	@Override
	public abstract String transform(String str);

	@Override
	public abstract String getLabel();

	public String rollLetters(String str, int shift) {
		String tmp = "", strLow = str.toLowerCase();
		for(int i=0; i<str.length(); i++)
			for(int j=0; j<alphabet.length; j++)
				if(strLow.charAt(i) == alphabet[j]) {
					tmp += alphabet[(j+1)%26];
					break;
				}
		return tmp;
	}
}
