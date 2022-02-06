import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] parent;
    public static boolean[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        used = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        int max = -1;
        for(int i=0; i<M; i++){
            int n = Integer.parseInt(st.nextToken());
            parent[n] = n;
            max = Math.max(max,n);
        }
        int temp = max;
        for(int i=max-1; i>=1; i--){
            if(parent[i]==0){
                parent[i] = temp;
            }else{
                parent[i] = temp;
                temp = i;
            }
        }
        StringBuilder answer = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int curr = Integer.parseInt(st.nextToken());
            int result = find(curr);

            answer.append(result+"\n");
        }

        System.out.println(answer);
    }

    private static int find(int curr) {
        int result = parent[curr];
        if(!used[result]){
            parent[curr] = parent[result];
            used[result] = true;
        }else{
            result = find(result);
        }
        return result;
    }
}
