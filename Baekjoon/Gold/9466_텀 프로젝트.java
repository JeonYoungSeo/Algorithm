import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            check = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[N+1];

            for(int i=1; i<=N; i++) {
                if(check[i] != 0) continue;
                dfs(i,i,visited, arr);
            }
            int ans = 0;
            for(int i=1; i<=N; i++) {
                if (check[i]==-1) ans++;
            }
//            for(int n : check){
//                System.out.print(n+" ");
//            }
            result.append(ans+"\n");
        }
        System.out.println(result);
    }

    private static int dfs(int start, int end, boolean[] visited, int[] arr) {

        if(visited[end]){
            check[end] = 1;
            return end;
        }
        if(check[arr[end]]==-1) {
            check[end] = -1;
            return 0;
        }

        int result = 0;
        visited[end] = true;
        result = dfs(start, arr[end],visited, arr);
        visited[end] = false;
        if(result == 0 ){
            check[end] = -1;
            return 0;
        }else if(result == end){
            check[end] = 1;
            return 0;
        }else{
            check[end] = 1;
            return result;
        }
    }

}
