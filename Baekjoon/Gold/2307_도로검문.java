import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static ArrayList<int[]>[] list;
    static int[] distance,path;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list[a].add(new int[] {b,t});
            list[b].add(new int[] {a,t});
        }

        path = new int[N+1];
        Arrays.fill(path, -1);

        int origin = shortestPath();
        int longdist = origin;

        for(int i=1; i<=N; i++){
            if(path[i]==-1) continue;
            longdist = Math.max(longdist, longestPath(i, path[i]));
        }
        System.out.println((longdist==Integer.MAX_VALUE )?-1:longdist-origin);

    }

    private static int longestPath(int from, int to) {
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        Queue<int[]> que = new PriorityQueue<>((o1, o2)-> o1[1]-o2[1]);
        que.add(new int[] {1,0});

        while (!que.isEmpty()){
            int[] cur = que.poll();
            if(cur[1] > distance[cur[0]]) continue;

            for (int[] next : list[cur[0]]) {
                if((from == cur[0] && to == next[0]) ||(to == cur[0] && from == next[0]) ){
                    continue;
                }
                if(distance[next[0]] > distance[cur[0]]+next[1]){
                    distance[next[0]] = distance[cur[0]]+next[1];
                    que.add(new int[]{next[0],distance[next[0]]});
                    path[next[0]] = cur[0];
                }
            }
        }
        return distance[N];
    }

    private static int shortestPath() {
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        Queue<int[]> que = new PriorityQueue<>((o1, o2)-> o1[1]-o2[1]);
        que.add(new int[] {1,0});

        while (!que.isEmpty()){
            int[] cur = que.poll();
            if(cur[1] > distance[cur[0]]) continue;

            for (int[] next : list[cur[0]]) {

                if(distance[next[0]] > distance[cur[0]]+next[1]){
                    distance[next[0]] = distance[cur[0]]+next[1];
                    que.add(new int[]{next[0],distance[next[0]]});
                    path[next[0]] = cur[0];
                }
            }
        }
        return distance[N];
    }

}
