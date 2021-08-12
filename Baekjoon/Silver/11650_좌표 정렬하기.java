import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //수의 개수
        int N = Integer.parseInt(br.readLine());
    	
        String[] lst = new String[200002];
        for(int i=0; i<200002; i++) {
        	lst[i] = new String();
        }
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int temp = Integer.parseInt(st.nextToken())+100000;
    		lst[temp] += (" "+st.nextToken());
    	}
        
        for(int i=0; i<200002; i++) {
        	StringTokenizer st = new StringTokenizer(lst[i]);
        	List<Integer> Lst = new ArrayList<Integer>();
        	if(st.hasMoreTokens()) {
        		Lst.add(Integer.parseInt(st.nextToken()));
        	}
        	while(st.hasMoreTokens()) {
        		int temp = Integer.parseInt(st.nextToken());
        		boolean check = true ;
        		int M = Lst.size();
        		for(int j=0; j<M; j++) {
        			if(Lst.get(j)>temp) {
        				Lst.add(j,temp);
        				check = false;
        				break;
        			}
        		}
        		if(check) Lst.add(temp);
        	}
        	
        	while(!Lst.isEmpty()) {
        		bw.write(i-100000+" "+Lst.get(0)+"\n");
        		Lst.remove(0);
        	}
        	
        }
        bw.flush();
        bw.close();
        br.close();
        
    }
}

