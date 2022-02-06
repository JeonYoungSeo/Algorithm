import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int mid = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(Math.abs(arr[mid]) > Math.abs(arr[i])){
                mid = i;
            }
        }
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        int left = mid;
        int right = mid;
        if(mid-1>0){
            min = Math.abs(arr[mid]+arr[mid-1]);
            left = mid-1;
        }
        if(mid+1<N){
            int num = Math.abs(arr[mid]+arr[mid+1]);
            if(num<min) {
                left = mid;
                right = mid+1;
                min = num;
            }
        }

        answer[0] = arr[left];
        answer[1] = arr[right];

        while(left !=0 || right != N-1){
            int l,r,m;
            l=r=m=Integer.MAX_VALUE;

            if(left!=0){
                l = Math.abs(arr[left-1]+arr[right]);
            }
            if(right!=N-1){
                r = Math.abs(arr[left]+arr[right+1]);
            }
            if(right!=N-1 && left!=0){
                m = Math.abs(arr[left-1]+arr[right+1]);
            }

            int temp_min = Math.min(l,Math.min(r,m));

            if(left>0 && temp_min == l){
                left--;
                if(min>l){
                    min = l;
                    answer[0] = arr[left];
                    answer[1] = arr[right];
                }
            }else if(right<N-1 && temp_min == r){
                right++;
                if(min>r){
                    min = r;
                    answer[0] = arr[left];
                    answer[1] = arr[right];
                }
            }else{
                left--;
                right++;
                if(min>m){
                    min = m;
                    answer[0] = arr[left];
                    answer[1] = arr[right];
                }
            }
            if(min == 0){
                System.out.println(answer[0]+" "+answer[1]);
                return;
            }
        }
        System.out.println(answer[0]+" "+answer[1]);
    }
}
