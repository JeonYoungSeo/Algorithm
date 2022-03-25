import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        out :
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
 
            HashSet<Integer> set = new HashSet<>();
 
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                int num = Integer.parseInt(st.nextToken());
 
                if(set.contains(num+k) || set.contains(num-k)){
                    result.append("Yes\n");
                    continue out;
                }else{
                    set.add(num);
                }
            }
 
            result.append("No\n");
        }
 
        System.out.println(result);
    }
}
