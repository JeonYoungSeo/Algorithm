import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
      // 입력
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
      
        Stack<Integer> result = new Stack<>();
        Stack<Integer> check = new Stack<>();
        result.push(-1);
        check.push(arr[N-1]);

        for(int i=N-2; i>=0; i--){
            int num = arr[i];

            while(!check.isEmpty() && num>=check.peek()){
                check.pop();
            }

            if(check.isEmpty()){
                result.push(-1);
            }else{
                result.push(check.peek());
            }

            check.push(num);
        }

        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty())
            sb.append(result.pop()+" ");
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }

}
