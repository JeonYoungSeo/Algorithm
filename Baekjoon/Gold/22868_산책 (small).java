import java.io.*;
import java.util.*;

public class Main {
    public static class Node{
        int link;
        Node next;

        Node(int link, Node next){
            this.link = link;
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            nodes[A] = new Node(B, nodes[A]);
            nodes[B] = new Node(A, nodes[B]);
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int answer = 0;
        String root = S+"";
        Queue<String> que = new LinkedList<>();
        que.add(root);
        boolean[] visited = new boolean[N+1];
        out :
        while(!que.isEmpty()){
            String curr = que.poll();

            StringTokenizer token = new StringTokenizer(curr,".");
            int c_pos = Integer.parseInt(token.nextToken());

            boolean[] tvisited = new boolean[N+1];
            tvisited[c_pos] = true;
            while(token.hasMoreTokens()){
                tvisited[Integer.parseInt(token.nextToken())] = true;
            }
            for(Node each =nodes[c_pos]; each!=null; each=each.next ){
                if(each.link==E){
                    token = new StringTokenizer(curr,".");
                    answer += token.countTokens();
                    while(token.hasMoreTokens()){
                        visited[Integer.parseInt(token.nextToken())] = true;
                    }
                  //  System.out.println(curr+each.link);
                    break out;
                }
                if(tvisited[each.link]) continue ;
                que.add(each.link+"."+curr);
            }
        }

        que = new LinkedList<>();
        que.add(E+"");
        out :
        while(!que.isEmpty()){
            String curr = que.poll();

            StringTokenizer token = new StringTokenizer(curr,".");
            int c_pos = Integer.parseInt(token.nextToken());

            boolean[] tvisited = new boolean[N+1];
            tvisited[c_pos] = true;
            while(token.hasMoreTokens()){
                tvisited[Integer.parseInt(token.nextToken())] = true;
            }
            for(Node each =nodes[c_pos]; each!=null; each=each.next ){
                if(each.link==S){
                    token = new StringTokenizer(curr,".");
                    answer += token.countTokens();
                    while(token.hasMoreTokens()){
                        visited[Integer.parseInt(token.nextToken())] = true;
                    }
                    //  System.out.println(curr+each.link);
                    break out;
                }
                if(tvisited[each.link] || visited[each.link]) continue ;
                que.add(each.link+"."+curr);
            }
        }


        System.out.println(answer);
    }
}
