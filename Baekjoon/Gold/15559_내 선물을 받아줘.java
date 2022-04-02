import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] visited;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 맵 크기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //맵 생성
        char[][] map = new char[N][M];

        //입력
        visited = new int[N][M];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j);
            }
        }

        int num = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){

                if(visited[i][j]!=0 ) continue;
                num++;
                int temp = dfs(num, i,j, map);
                if(temp<num){
                    num--;
                }
            }
        }

        System.out.println(num);
//        for(int[] line : visited){
//            for(int n : line){
//                System.out.print(n+" ");
//            }
//            System.out.println();
//        }

    }

    private static int dfs(int num, int i, int j, char[][] map) {
        if(visited[i][j]!=0) return visited[i][j];
        visited[i][j] = num;
        int n = num;
        switch (map[i][j]){
            case 'S':
                if(i+1<N)
                    n = dfs(num,i+1, j, map);
                break;
            case 'N':
                if(i-1>=0)
                    n = dfs(num,i-1, j, map);
                break;
            case 'W':
                if(j-1<M)
                    n = dfs(num,i, j-1, map);
                break;
            case 'E':
                if(j+1>=0)
                    n = dfs(num,i, j+1, map);
                break;
        }
        visited[i][j] = n;
        return n;
    }
}
