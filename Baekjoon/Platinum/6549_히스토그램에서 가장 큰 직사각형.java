import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
분할정복, 이분탐색....

*/
public class Main {
    public static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            if(N==0) return;

            arr = new long[N];

            for(int i=0; i<N; i++){
                arr[i] = Long.parseLong(st.nextToken());
            }

            System.out.println(recur( 0, N-1));


        }



    }

    private static long recur(int left, int right) {

        if(left == right){
            return arr[left];
        }

        int mid = (left + right)/2;

        long answer = Math.max(recur(left,mid), recur(mid+1, right));

        long area = 2*Math.min(arr[mid], arr[mid+1]);
        answer = Math.max(area, answer);

        int mid_left = mid;
        int mid_right = mid+1;
        long height = Math.min(arr[mid_left], arr[mid_right]);
        while(mid_left>=left && mid_right<=right){
            if(mid_left==left && mid_right==right) break;
            
            if(mid_left>left && (mid_right==right || arr[mid_left-1]>arr[mid_right+1])){
                mid_left--;

                height = Math.min(height, arr[mid_left]);
            }else{
                mid_right++;

                height = Math.min(height,arr[mid_right] );
            }

            area = (mid_right-mid_left+1)*height;

            answer = Math.max(answer, area);


        }

        return answer;
    }
}
