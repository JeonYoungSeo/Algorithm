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
            int n = Integer.parseInt(br.readLine());
 
            boolean one = false;
            boolean distone = false;
            HashSet<Integer> set = new HashSet<>();
 
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            for(int i=0; i<n; i++){
                int num = Integer.parseInt(st.nextToken());
 
                set.add(num);
                if(set.contains(num+1)) distone = true;
                if(set.contains(num-1)) distone = true;
 
                if(num==1){
                    one= true;
                }
 
                if(one && distone){
                    result.append("No\n");
                    continue out;
                }
            }
            result.append("Yes\n");
        }
        System.out.println(result);
    }
