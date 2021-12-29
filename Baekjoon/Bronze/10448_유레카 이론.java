import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[45];
        for(int i=1; i<45; i++){
            arr[i] = arr[i-1] + i;
        }
        out :
        while(N-->0){
            int num = Integer.parseInt(br.readLine());

            for(int i=1; i<45; i++){
                for(int j=1; j<45; j++){
                    for(int k=1; k<45; k++){
                        if(num==arr[i]+arr[j]+arr[k]){
                            System.out.println(1);
                            continue out;
                        }
                    }
                }
            }
            System.out.println(0);
        }

    }
}
