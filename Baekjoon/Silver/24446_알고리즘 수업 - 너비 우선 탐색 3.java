import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] result;
    static boolean[] visited;
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] que = new PriorityQueue[N+1];
        for(int i=1; i<=N; i++){
            que[i] = new PriorityQueue<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            que[u].add(v);
            que[v].add(u);
        }
        result = new int[N+1];
        Arrays.fill(result, -1);
        visited = new boolean[N+1];

        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(R);
        visited[R] = true;
        int dep = 0;
        while(!bfs.isEmpty()){
            int size = bfs.size();

            while(size-->0) {
                int curr = bfs.poll();
                result[curr] = dep;
                while (!que[curr].isEmpty()) {
                    int temp = que[curr].poll();

                    if (visited[temp]) continue;
                    visited[temp] = true;
                    bfs.add(temp);

                }
            }
            dep++;
        }

        for(int i=1; i<=N; i++){
            System.out.println(result[i]);
        }

    }
}
