import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] dist = new boolean[N+1][N+1];
        HashSet<Integer>[] nodes = new HashSet[N+1];
        int[] cnt = new int[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            boolean first = true;
            int pre = 0;
            while(st.hasMoreTokens()){
                int curr = Integer.parseInt(st.nextToken());
                if(first){
                    first = false;
                    pre = curr;
                    continue;
                }

                if(nodes[pre]==null){
                    nodes[pre] = new HashSet<>();
                }
                if(!nodes[pre].contains(curr))
                    cnt[curr]++;
                nodes[pre].add(curr);
                dist[pre][curr] = true;
                if(dist[pre][curr] && dist[curr][pre]){
                    System.out.println(0);
                    return;
                }

                pre = curr;
            }
        }

        Queue<Integer> que = new LinkedList<>();

        for(int i=1; i<=N; i++){
            if(cnt[i]==0){
                que.add(i);
            }
        }
        int allcnt = 0;
        StringBuilder result = new StringBuilder();
        while(!que.isEmpty()){
            int curr = que.poll();
            allcnt++;
            result.append(curr+"\n");
            if(nodes[curr]==null) continue;
            for(int n : nodes[curr]){
                cnt[n]--;
                if(cnt[n]==0){
                    que.add(n);
                }
            }
        }
        if(result.length()==0 || allcnt!=N){
            System.out.println(0);
        }else
            System.out.println(result);

    }


}
