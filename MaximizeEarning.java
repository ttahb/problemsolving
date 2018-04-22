import java.io.BufferedReader;
import java.io.*;

class MaximizeEarning {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int S = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < S; i++){
			
			String tokens[] = br.readLine().split(" ");
			int N = Integer.parseInt(tokens[0]);
			int R = Integer.parseInt(tokens[1]);
			String[] h = br.readLine().split(" ");
			int a = Integer.parseInt(h[0]);
			int count = 1;
			for(int j = 0; j < N; j++){
				
				int k = Integer.parseInt(h[j]);
					
				if(k > a){
					a = k;
					count++;
				}		
			}
			 
			System.out.println(count * R);
		}
	}	
	
}