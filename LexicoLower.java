class LexicoLower {
	public static void main(String[] args){
		int k, n;
		k = 77;
		n = 3;
		String str = getWord(k, n);
		System.out.println(str);
	}
	
	static String getWord(int k , int n){
		String string = null;
		if(n == 1 && k <= 26)
			string = Character.toString((char) (k+96));
		else if(n > 1) {
			
			if(k < 26) {
				char[] ch = new char[n-1];
				for(int i = 0; i < n - 1; i++)
					ch[i] = 'a';
				string = String.valueOf(ch) + Character.toString((char) (26 -(n-1) + 96));
			} else {
				int count = 0;
				
				while(k >= 26){
					k = k - 26;
					count++;
				}
				
				char[] ch = new char[count];
				for(int i = 0; i < count; i++)
					ch[i] = 'z';
				
				if(k != 0)
					string = Character.toString((char) (k+96)) + String.valueOf(ch);
				else 
					string = String.valueOf(ch);
			}
		}
		
		return string;
	}
}