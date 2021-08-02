import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] sch = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=N; i++){
            sch[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st2.nextToken());
            int num = Integer.parseInt(st2.nextToken());
            
            if(sex == 1){
            	int number = num;
                while(number<=N){
                    sch[number] = (sch[number]+1)%2;
                    number += num ;
                }

            }else{
                int plus = 1;
                sch[num] = (sch[num]+1)%2;
                while(num-plus>0 && num+plus<=N){
                    if(sch[num-plus] == sch[num+plus]){
                        sch[num-plus] = (sch[num-plus]+1)%2;
                        sch[num+plus] = (sch[num+plus]+1)%2;
                    }else{
                        break;
                    }
                    plus++;
                }

            }
        }
        bw.write(Integer.toString(sch[1]));
        for(int i=2; i<=N; i++){
            bw.write(" "+Integer.toString(sch[i]));
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

   
}
