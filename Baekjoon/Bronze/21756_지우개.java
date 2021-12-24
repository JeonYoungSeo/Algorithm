import java.io.*;


public class Main
{

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Integer N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = i;
        }

        int time = 1;

        if(N==1){
            System.out.println(1);
            return;
        }
        
        while(arr[2] != 0){
            int curr = 1;

            while(curr<=N && arr[curr] != 0){
                arr[curr] = 0;
                curr += 2;
            }

            int pos = 1;

            for(int i=1; i<=N/time; i++){
                if(arr[i] != 0){
                    arr[pos++] = arr[i];
                    arr[i] = 0;
                }
            }

            time ++;
        }

        System.out.println(arr[1]);

    }

}
