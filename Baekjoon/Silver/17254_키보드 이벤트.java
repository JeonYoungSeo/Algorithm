import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node>{
        int a,b;
        String c;

        Node(int a, int b, String c){
            this.a = a;
            this.b =b ;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            if(this.b != o.b){
                return this.b-o.b;
            }else{
                return this.a-o.a;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[M];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            String c= st.nextToken();

            nodes[i] = new Node(a,b,c);
        }

        Arrays.sort(nodes);

        StringBuilder result = new StringBuilder();

        for(Node curr : nodes){
            result.append(curr.c);
        }

        bw.write(result.toString());


        bw.flush();
        bw.close();
    }
}
