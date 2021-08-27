import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class Node implements Comparable<Node>{
        int start, end;
        // 회의 시작 시간, 종료시간
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
        //정렬을 위하 컴퍼러블 -- 종료시간 오름차순, 종료시간 같으면 시작시간 오름차순
        @Override
        public int compareTo(Node node){
             if(this.end>node.end){
                 return 1;
             }else if(this.end==node.end){
                 return this.start- node.start;
             }

             return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //회의의 수
        int N = Integer.parseInt(br.readLine());
        Node[] node = new Node[N];

        //입력
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            node[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        //정렬
        Arrays.sort(node);
        int count=0;
        int start=-1, end=-1;
        //종료시간 이후 가장 빨리 시작하고 빨리 시작하는 회의가 나오면 count++해주고 그 회의의 종료시간을 기준으로 다음 회의를 찾는다.
        for(int i=0; i<N; i++){
            if(end<=node[i].start){
                count++;
                end = node[i].end;
            }
        }
        System.out.println(count);

        br.close();
    }
}
