#include <iostream>
using namespace std;

class Node {
    public :
    int link;
    Node *next;

    Node(){
        link=-1;
        next = NULL;
    }

    Node(int link, Node* next){
        this -> link = link;
        this -> next = next;
    }
};

Node * nodes[5001];
int height[5001];
bool visited[5001];
int dp[5001];

int dfs(int c, int h, int depth){
    if(dp[c] != 0) return dp[c]+1;
    int answer = 1;
    Node curr = *nodes[c];
    if(curr.link==-1){
        dp[c] = 1;
        return dp[c]+1;
    }
    while(true){
        if(visited[curr.link] || h>= height[curr.link]) {
            if(curr.next == NULL) break;
            curr = *curr.next;
            continue;
        }

        visited[curr.link] = true;
        int tmp = dfs(curr.link, height[curr.link], depth+1);
        visited[curr.link] = false;

        answer = (answer>tmp)?answer:tmp;
        if(curr.next == NULL) break;
        curr = *curr.next;

    }
    dp[c] = answer;
    return dp[c]+1;
}

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M ;

    cin >> N >> M;

    for(int i=1; i<=N; i++){
        nodes[i] = new Node();
    }

    for(int i=1; i<=N; i++){
        cin >> height[i];
    }

    for(int i=0; i<M; i++){
        int a,b;

        cin >> a >> b;

        if(height[a]<height[b]){
            nodes[a] = new Node(b, nodes[a]);
        }else{
            nodes[b] = new Node(a, nodes[b]);
        }
    }

    for(int i=1; i<=N; i++){
        
        int answer = dfs(i, height[i], 1);

        cout << dp[i] << "\n";
    }

}
