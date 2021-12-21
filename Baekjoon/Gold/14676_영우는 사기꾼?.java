import java.util.*;
import java.io.*;


public class Main
{
    public static class Build{
        int need;
        Build next;

        Build(int need, Build next){
            this.need = need;
            this.next = next;
        }
    }

    public static class Destroy{
        int disable;
        Destroy next;

        Destroy(int disable, Destroy next){
            this.disable = disable;
            this.next = next;
        }
    }


    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Build[] build = new Build[N+1];
        Destroy[] destroys = new Destroy[N+1];

        boolean[] able = new boolean[N+1];
        Arrays.fill(able, true);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            build[b] = new Build(a, build[b]);
            destroys[a] = new Destroy(b, destroys[a]);

            able[b] = false;
        }

        int[] building = new int[N+1];


        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //건설
            if(a==1){
                if(!able[b]){
                    for (Build curr = build[b]; curr != null; curr = curr.next) {
                        if (building[curr.need] <= 0) {
                            System.out.println("Lier!");
                            return;
                        }
                    }
                    able[b] = true;
                }
                building[b]++;
            }
            else{//파괴
                if(building[b]<=0){
                    System.out.println("Lier!");
                    return;
                }

                building[b]--;

                if(building[b]==0){
                    for(Destroy curr = destroys[b]; curr != null; curr = curr.next){
                        able[curr.disable] = false;
                    }
                }
            }

        }
        System.out.println("King-God-Emperor");

    }
}
