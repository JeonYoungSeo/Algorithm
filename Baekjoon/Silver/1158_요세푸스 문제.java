import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] arags) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	List<Integer> lst = new LinkedList<Integer>();
    	
    	for(int i=1; i<=N; i++) {
    		lst.add(i);
    	}
    	
    	bw.write("<");
    	StringBuilder sb = new StringBuilder();
    	int curr = K-1;
    	while(true) {
    		sb.append(lst.get(curr)+", ");
    		lst.remove(curr);
    		if(lst.isEmpty()) break;
    		N--;
    		curr = (curr-1+K>=N)?(curr-1+K)%N:curr-1+K;
    	}
    	sb.setLength(sb.length()-2);
    	bw.write(sb.toString());
    	bw.write(">");
    	
    	bw.flush();
    	bw.close();
    	br.close();
    }
}
