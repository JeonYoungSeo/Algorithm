import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
	static int[] heap;
	static BufferedReader br;
	static BufferedWriter bw;
	static int num = 0;
	static int N ;
    public static void main(String[] args) throws IOException {
    	br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //수의 개수
        N = Integer.parseInt(br.readLine());
        //1을 1로 사용하기 위함
        heap = new int[N+1];
        
        for(int t=0; t<N; t++) {
        	int temp = Integer.parseInt(br.readLine());
        	//삽입
        	heap[++num] = temp;
        	//최소힙 정렬
        	minheap(num);
        }
        //작은거부터 출력
        print();
        
        
        bw.flush();
        br.close();
        bw.close();
    }    
    
    //최소힙 정렬
    private static void minheap(int num) {
    	if(num/2==0) return;
    	
    	if(num/2>0) {
    		if(heap[num/2] > heap[num]) {
    			int temp = heap[num/2];
    			heap[num/2] = heap[num];
    			heap[num] = temp;
    			minheap(num/2);
    		}
    	}
    }
    
    
    private static void print() throws IOException{
    	if(num==0) return;
    	
    	bw.write(heap[1]+"\n");//출력
    	heap[1] = heap[num--];//위로 옮기고
    	heap[num+1] = 0;//소거
    	printSort(1);//후 정렬
    	print();
    	
    }
    
    //출력후 정렬위한 함수
    private static void printSort(int n) {
    	//기저조건 ??
    	
    	if(n*2>N || heap[n*2] ==0) return;
    	if(heap[n]>heap[n*2]) {
    		int temp = heap[n];
    		heap[n] = heap[n*2];
    		heap[n*2] = temp;
    		printSort(n*2);
    	}
    	
    	
    	if(n*2+1>N || heap[n*2+1] == 0) return;
    	if(heap[n]>heap[n*2+1]) {
    		int temp = heap[n];
    		heap[n] = heap[n*2+1];
    		heap[n*2+1] = temp;
    		printSort(n*2+1);
    	}
    	
    	
    }
}

