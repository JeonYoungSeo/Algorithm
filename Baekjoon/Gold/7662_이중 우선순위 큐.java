import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-29
 * Description : 백준
 */


public class Main{
  //숫자와 숫자의 갯수 저장 할 맵
	  static Map<Integer, Integer> map;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //tc
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0) {
          //입력받을 명령 수
        	int k = Integer.parseInt(br.readLine());
        	//우선순위 큐 생성 및 map초기화
        	Queue<Integer> maxque = new PriorityQueue<Integer>(Collections.reverseOrder());
        	Queue<Integer> minque = new PriorityQueue<Integer>();
        	map = new HashMap<Integer, Integer>();
        	while(k-->0) {
        		StringTokenizer st= new StringTokenizer(br.readLine());
        		String first = st.nextToken();
        		if(first.equals("I")) {
        			int temp = Integer.parseInt(st.nextToken());
        			maxque.add(temp);
        			minque.add(temp);
              //처음나온거면 1 이미 있으면 기존횟수 +1
        			map.put(temp, map.getOrDefault(temp, 0)+1);
        		}else{
    				int temp = Integer.parseInt(st.nextToken());
    				//비어있으면 넘어감
    				if(map.size()==0) continue;
    				
    				if(temp == -1) {
              //최소값 제거
    					remove(minque);
    				}else {
              //최댓값 제거
    					remove(maxque);
    				}
        		}
        	}
        	
        	if(map.size()==0) {
        		bw.write("EMPTY\n");
        	}else {
            //최댓값
        		int max = remove(maxque);
        		int min = max;
        		bw.write(max+" ");
            //비어있지 않으면 최솟값 추출
        		if(map.size()!=0) min = remove(minque); 
        		bw.write(min+"\n");
        	}
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int remove(Queue<Integer> que) {
    	int result = 0;
    	
    	while(true) {
    		result = que.poll();
    		
    		int cnt = map.getOrDefault(result,0);
    		//이미 제거해서 없으면 다음 queue poll
    		if(cnt==0) continue;
    		//1개만 있으면 제거, 2개이상이면 cnt--
    		if(cnt==1) map.remove(result);
    		else map.put(result, map.getOrDefault(result, 0)-1);
    		break;
    	}
    	
    	return result;
    }
}
