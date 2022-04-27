import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long min=12_000_000_000L;
    static long max=0;
    static int k;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] arr = new char[k];
        for(int i=0; i<k; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        StringBuilder answer = new StringBuilder();
        visited = new boolean[10];
        permu(0,arr,answer);

        String ma = Long.toString(max);
        String mi = Long.toString(min);

        if(ma.length()==k+1) System.out.println(max);
        else System.out.println("0"+max);
        if(mi.length()==k+1) System.out.println(min);
        else System.out.println("0"+min);
    }

    private static void permu(int num, char[] arr, StringBuilder answer) {
        if(num==k+1){
            max = Math.max(Long.parseLong(answer.toString()), max);
            min = Math.min(Long.parseLong(answer.toString()), min);
            return;
        }
        out :
        for(int i=0; i<10; i++){
            if(visited[i]) continue ;
            if(answer.length()!=0){
                int n = answer.charAt(answer.length()-1)-'0';
                switch (arr[num-1]){
                    case '>':
                        if(n<i)
                            continue out;
                        break;
                    case '<':
                        if(n>i)
                            continue out;
                        break;
                }
            }
            answer.append(i);
            visited[i] = true;
            permu(num+1, arr, answer);
            answer.setLength(answer.length()-1);
            visited[i] = false;
        }
    }
}
