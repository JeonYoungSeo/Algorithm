import java.io.*;
import java.util.*;
/*
활용 된 것 : LIS, 이분탐색, DP
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
    static int[] pos;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] elec = new Node[N];
        pos = new int[N];
        int[] raw = new int[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            elec[i] = new Node(a,b);
        }

        Arrays.sort(elec);

        int[] arr = new int[N];
        int curr = 0;
        for(int i=0; i<N; i++){
            if(i==0){
                arr[i] = elec[i].b;
                raw[i] = elec[i].a;
                continue;
            }
            if(arr[curr] < elec[i].b){
                curr++;
                arr[curr] = elec[i].b;
                pos[i] = curr;
                raw[i] = elec[i].a;
            }else if(arr[0]>elec[i].b){
                arr[0] = elec[i].b;
                pos[i] = 0;
                raw[i] = elec[i].a;
            }else{
                int position = find(arr,0, curr,elec[i].b);
                pos[i] = position;
                raw[i] = elec[i].a;
            }
//            for(int n : arr){
//                System.out.print(n+" ");
//            }
//            System.out.println();
        }
//        for(int n : pos){
//            System.out.print(n+" ");
//        }
        int result = N-curr-1;

        Stack<Integer> stack = new Stack<>();

        for(int i=N-1; i>=0; i--){
            if(pos[i]==curr){
                curr--;
                continue;
            }
            stack.add(raw[i]);
        }
        System.out.println(result);
        while(!stack.isEmpty()){
            System.out.println(stack.pop()+" ");
        }
    }

    private static int find(int[] arr, int s, int e, int val) {
        if(s==e){
            arr[s] = val;
            return s;
        }

        int half = (s+e)/2;
        int result = -1;
        if(arr[half]>val){
            //move right
            result = find(arr,s,half,val);
        }else if(arr[half]<val){
            //move left
            result = find(arr,half+1,e,val);
        }

        return result;
    }

}
