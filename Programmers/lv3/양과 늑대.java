class Solution {
    public static class Node {
        int next;
        Node Next;
        
        Node(int next, Node Next){
            this.next = next;
            this.Next = Next;
        }
    }
    static Node[] nodes;
    static int len,result;
    
    public int solution(int[] info, int[][] edges) {
        len = info.length;
        
        nodes = new Node[len];
        
        for(int i=0; i<len-1; i++){
            int s = edges[i][0];
            int t = edges[i][1];
            
            nodes[s] = new Node(t, nodes[s]);
        }
        result = 0;
        dfs(0,0,0,1,info);
        
        return result;
    }
    public static void dfs(int sheep, int wolf, int curr, int able,int[] info){

        if(info[curr]==0){
            sheep++;
        }else{
            wolf++;
        }
        result = Math.max(sheep,result);
        if(sheep<=wolf) return;

        able -= 1<<curr;
        for(Node node = nodes[curr]; node!=null; node=node.Next){
            able += 1<<(node.next);
        }

        for(int i=1; i<=len; i++){
            if((able & (1<<i))>=1)
            dfs(sheep, wolf, i,able,info);
        }

    }
}
