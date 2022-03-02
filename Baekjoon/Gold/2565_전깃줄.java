import java.io.*;
import java.util.*;


/*
한쪽 전깃줄 기준으로 정렬후 최장길이배열을 찾으면 해결되는 문제이다.
*/
public class Main {
    public static class Node implements Comparable<Node>{

        int a,b;

        Node(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Node o) {
            return this.a-o.a;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] case1 = new Node[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            case1[i] = new Node(a,b);
        }

        Arrays.sort(case1);


        int[] arr = new int[N];
        int curr = 0;
        for(int i=0; i<N; i++){
            if(i==0){
                arr[i] = case1[i].b;
                continue;
            }

            if(arr[curr] < case1[i].b){
                curr++;
                arr[curr] = case1[i].b;
            }else if(arr[0]>case1[i].b){
                arr[0] = case1[i].b;
            }else{
                for(int j=0; j<=curr; j++){
                    if(arr[j] >= case1[i].b){
                        arr[j] = case1[i].b;
                        break;
                    }
                }
            }
//            for(int n : arr){
//                System.out.print(n+" ");
//            }
//            System.out.println();
        }

        System.out.println(N-curr-1);

    }

}
