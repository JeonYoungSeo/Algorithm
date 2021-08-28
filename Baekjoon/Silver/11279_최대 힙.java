import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-28
 * Description : 백준 1927
                  최소힙 코드를 가져와서 입력과 출력시 -를 붙여주어서 해결하였다. 
 */

public class Main{
  //최대힙을 위한 리스트와 현재 원소의 갯수
	static int[] heap;
	static int num = 0;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//입력되는 원소의 갯수 
		int N = Integer.parseInt(br.readLine())+1;
		heap = new int[N+1];
    //입력수만큼 반복
		for(int i=1; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			//자연수가 입력되면 마지막 트리에 입력후 정렬
			if(n!=0) {
				heap[++num] = n;
				min_heap(num);
			}else {
        //0이 입력됫을경우 1. 원소가 없으면 0 출력후 다음, 있으면 출력후 맨마지막 원소를 첫번째로 끌어온후 정렬
				if(heap[1]==0) {
					bw.write(0+"\n");
				}else {
					bw.write(heap[1]+"\n");
					heap[1] = heap[num--];
					if(num == 0)
						heap[num+1] = 0;
					min_heap2(1);
				}
			}
		}
		
		
		bw.flush();
		bw.close();
		br.close();
			
	}
	//입력 한 후의 정렬 함수
	public static void min_heap(int num) {
		if(num<=1) return;
		
		if(heap[num] < heap[num/2]) {
			int temp = heap[num];
			heap[num] = heap[num/2];
			heap[num/2] = temp;
			min_heap(num/2);
		}else {
			return;
		}
		
	}
	//출력 후의 정렬함수
	public static void min_heap2(int n) {
		if(n>num) return;
		//3가지 경우
    //1. 왼쪽 node만 있을때
		if(n*2 <=num && n*2+1 > num) {
			if(heap[n] > heap[n*2]) {
				int temp = heap[n];
				heap[n] = heap[n*2];
				heap[n*2] = temp;
				min_heap2(n*2);
			}
			return;
			//양쪽 노드가 있을때
		}else if(n*2 <=num && n*2+1 <= num) {
			if(heap[n*2]<heap[n*2+1]) {
				if(heap[n] > heap[n*2]) {
					int temp = heap[n];
					heap[n] = heap[n*2];
					heap[n*2] = temp;
					min_heap2(n*2);
				}
				return;
			}else {
				if(heap[n] > heap[n*2+1]) {
					int temp = heap[n];
					heap[n] = heap[n*2+1];
					heap[n*2+1] = temp;
					min_heap2(n*2+1);
				}
				return;
			}
		}
		//노드가 없을때 
    return;
		
	}
}
