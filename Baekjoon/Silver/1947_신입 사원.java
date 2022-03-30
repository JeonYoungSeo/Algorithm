import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node>{
        int a,b;

        Node(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Node o) {
            return this.a-o.a;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int N = Integer.parseInt(br.readLine());

            Node[] nodes = new Node[N];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                nodes[i] = new Node(a,b);
            }

            Arrays.sort(nodes);

            int num = N+1;
            int result = 0;
            for(Node curr : nodes){
                if(curr.b<num){
                    num = curr.b;
                    result ++;
                }
            }
            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();
    }
}
