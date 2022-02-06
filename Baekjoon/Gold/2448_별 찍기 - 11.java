import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int q = 0;
        int M = 5;
        while (3 * Math.pow(2, q) != N) {
            q++;
            M = M*2+1;
        }
        char[][] map = new char[N][M];

        star(0, 0, N, map);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                if(map[i][j] == '*'){
                    result.append("*");
                }else{
                    result.append(" ");
                }
            }
            result.append("\n");
        }
        System.out.println(result);
    }

    public static void star(int n, int m,int size, char[][] map){
        if(size==3) {
            map[n][m + 2] = '*';
            map[n + 1][m + 1] = '*';
            map[n + 1][m + 3] = '*';
            for (int i = 0; i < 5; i++) {
                map[n + 2][m+i] = '*';
            }
            return ;
        }
        star(n,m+size/2 ,size/2 , map);
        star(n+size/2, m,size/2, map);
        star(n+size/2, m+size, size/2, map);
    }
}
