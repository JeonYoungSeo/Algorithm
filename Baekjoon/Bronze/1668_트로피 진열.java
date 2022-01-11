import java.io.*;

public class Main {
    static StringBuilder subResult;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int left = 0;
        int left_max = 0;
        int right = 0;
        int right_max = 0;

        for(int i=0; i<N; i++){
            if(left_max < arr[i]){
                left_max = arr[i];
                left++;
            }
        }

        for(int i=N-1; i>=0; i--){
            if(right_max < arr[i]){
                right_max = arr[i];
                right++;
            }
        }

        System.out.println(left);
        System.out.println(right);


    }
}
