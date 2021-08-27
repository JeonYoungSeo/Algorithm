import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
      //수빈이와 동생으 위치
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
      //방문엽 배열
        boolean[] visited = new boolean[100001];
      //bfs 위한 큐
        Queue<Integer> queue = new LinkedList<Integer>();
      // 첫 인자 넣고 방문 처리
        queue.add(N);
        visited[N] = true;
        int count = 0;
      //빌때까지 진행
        while(!queue.isEmpty()){
            int size = queue.size();
          //한 횟수를 한 사이클로
            while(size!=0){
                int curr = queue.poll();
                size--;
                //기저조건
                if(curr == M){
                    System.out.println(count);
                    return;
                }
                //각각의 경우의 수
                int temp1 = curr-1;
                int temp2 = curr+1;
                int temp3 = curr*2;
              //범위조건과 방문하지 않아야 큐에 추가
                if(temp1>=0 && !visited[temp1]){
                    queue.add(temp1);
                    visited[temp1] = true;
                }
                if(temp2<=100000 && !visited[temp2]){
                    queue.add(temp2);
                    visited[temp2] = true;
                }
                if(temp3<=100000 && !visited[temp3]){
                    queue.add(temp3);
                    visited[temp3] = true;
                }
            }
          //한사이클 끝나면 횟수 추가
            count++;
        }
        br.close();
    }
}

