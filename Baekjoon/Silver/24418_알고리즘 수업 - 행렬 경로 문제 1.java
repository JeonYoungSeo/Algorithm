import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int result1, result2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N+1][N+1];
        result1 = result2 = 0;
        matrix_path(map,N);
        matrix_path2(map,N);

        System.out.println(result1+" "+result2);

    }

    private static void matrix_path2(int[][] map, int n) {
        int[][] d = new int[n+1][n+1];

        for(int i=0; i<n; i++){
            d[i][0] = 0;
        }
        for(int i=1; i<n; i++){
            d[0][i] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                d[i][j] = map[i][j] + Math.max(d[i-1][j], d[i][j-1]);
                result2++;
            }
        }
    }

    private static int matrix_path(int[][] m, int n) {
        return matrix_path_rec(m,n,n);
    }

    private static int matrix_path_rec(int[][] m, int i, int j) {
        if( i==0 || j==0){
            result1++;
            return 0;
        }else{
            return m[i][j]+Math.max(matrix_path_rec(m,i-1,j), matrix_path_rec(m,i,j-1));
        }
    }

}
