import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] matrix = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = pow(N,B,matrix);

        for(int[] line : result){
            for(int num : line){
                System.out.print(num%1000+" ");
            }
            System.out.println();
        }

    }

    private static int[][] pow(int n, long b, int[][] matrix) {

        if(b==1){
            int[][] ret = new int[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    ret[i][j] = matrix[i][j];
                }
            }

            return matrix;
        }

        int[][] temp = pow(n, b/2, matrix); //제곱 해줄 행렬

        int[][] result = new int[n][n];
        int[][] result2 = new int[n][n]; //결과 저장할 행렬

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    result2[i][j] += (temp[i][k]*temp[k][j])%1000;
                }
            }
        }


        if(b%2 == 1){

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    for(int k=0; k<n; k++){
                        result[i][j] += (matrix[i][k]*result2[k][j])%1000;
                    }
                }
            }
        }else{
            result = result2;
        }
        return result;

    }
}
