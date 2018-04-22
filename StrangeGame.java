import java.io.*;
class StrangeGame {

	public static void main(String[] args) throws IOException {
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
		int T = Int(br.readLine());
		
		
	
		for(int i = 0; i < T ; i++){
			String[] tokens = br.readLine().split(" ");
			int N = Int(tokens[0]);
			int K = Int(tokens[1]);

			String[] alice = br.readLine().split(" ");
			String[] bob = br.readLine().split(" ");
			int m = Integer.MIN_VALUE;
			for(int j = 0; j < N; j++){
				
				if(Int(alice[j]) < Int(bob[j])){
					int p = Int(bob[j]) + 1; 
					if(p > m)
						m = p;
				}
			} 
			
			long sum = 0;
			for(int t = 0; t < N; t++){
				if(Int(alice[t]) < m)	
					sum += (m - Int(alice[t]))*K;
			}
			
			System.out.println(sum);
		}
		
	}
	
	static int Int(String a){
		return Integer.parseInt(a);	
	}
}