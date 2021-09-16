import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-16
 * Description : 백준 12738
 */


public class Main{
	static int[] LIS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        LIS = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int curr = 0;
        LIS[0] = arr[0];
        for(int i=1; i<N; i++) {
        	if(LIS[curr]<arr[i]) {
        		curr++;
        		LIS[curr] = arr[i];
        		continue;
        	}else if(LIS[0]>arr[i]) {
        		LIS[0] = arr[i];
        		continue;
        	}
        	
        	int pos = Bs(arr[i],0,curr);
        	
        	if(pos!=-1) {
        		LIS[pos] = arr[i];
        	}
        }
        
        bw.write(curr+1+"\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int Bs(int n,int left, int right) {
    	
    	int mid = (left+right)/2;
    	
    	int result = 1000001;
    	
    	if(LIS[mid] == n) return -1;
    	if(left==right) return right;
    	if(LIS[mid]>n) {
    		result = Bs(n, left, mid);
    	}else {
    		result = Bs(n, mid+1,right);
    	}
    	
    	return result;
    }
}
