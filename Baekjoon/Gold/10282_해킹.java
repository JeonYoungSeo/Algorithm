import java.util.*;
import java.io.*;


public class Main
{
    public static class Conn{
        int dep, time;
        Conn next;

        Conn(int dep, int time, Conn next){
            this.dep = dep;
            this.time = time;
            this.next = next;
        }
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            Conn[] conn = new Conn[n+1];

            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                conn[b] = new Conn(a,s, conn[b]);
            }

            boolean visited[] = new boolean[n+1];
            int[] times = new int[n+1];
            Arrays.fill(times, Integer.MAX_VALUE);


            times[c] = 0;
            int curr = c;
            int result1 = 0;
            int result2 = 0;

            while(true){

                int min = Integer.MAX_VALUE;

                for(int i=1; i<=n; i++){
                    if(visited[i]) continue;

                    if(min > times[i]){
                        curr = i;
                        min = times[i];
                    }
                }

                if(min == Integer.MAX_VALUE) break;

                result1++;
                result2 += min;
                visited[curr] = true;

                for(int i=1; i<=n; i++){
                    if(times[i] != Integer.MAX_VALUE)
                        times[i] -= min;
                }

                for(Conn temp = conn[curr]; temp!=null; temp = temp.next){
                    times[temp.dep] = Math.min(times[temp.dep], temp.time);
                }
            }

            System.out.println(result1+" "+result2);


        }

    }
}
