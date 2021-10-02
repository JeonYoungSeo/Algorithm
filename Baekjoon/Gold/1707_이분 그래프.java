import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 백준 1707 
* 색을 칠하여서 각 정점에 인접하는지 확인한다 
* bfs로 색을 번갈아서 칠해주었으며 인접한 노드끼리 같은 색을 지니고 있으면 탐색은 중단되고 NO를 출력한다
*/
public class Main{
    public static class Node{
        int next;
        Node link;

        public Node(int next, Node link) {
            this.next = next;
            this.link = link;
        }
    }
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            Node[] node = new Node[V+1];

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                node[u] = new Node(v, node[u]);
                node[v] = new Node(u, node[v]);
            }
            int[] color = new int[V+1];
            boolean check = false;
            for(int i=1; i<=V; i++){
                Queue<Integer> que = new LinkedList<Integer>();
                if(check) break;
                //if(color[i] != 0) continue;
                que.add(i);
                if(color[i]==0) color[i] = 1;
                while(!que.isEmpty()){
                    int curr = que.poll();
                    if(check) break;

                    for(Node temp = node[curr]; temp!=null; temp=temp.link){
                        if(color[temp.next]==0){
                            color[temp.next] = -color[curr];
                            que.add(temp.next);
                        }else{
                            if(color[curr] == color[temp.next]){
                                bw.write("NO\n");
                                check = true;
                                break;
                            }else{
                                continue;
                            }
                        }
                    }

                }
            }
            if(!check){
                bw.write("YES\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
