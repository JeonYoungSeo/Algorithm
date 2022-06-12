#include <iostream>
#include <stack>

using namespace std;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int H,W;

    cin >> H >> W;

    stack<int> st[H+1];

    for(int i=0; i<W; i++){
        int Height ;
        cin >> Height;

        for(int j=Height; j>0; j--){
            st[j].push(i+1);
        }
    }

    int answer = 0;

    for(int i=1; i<=H; i++){
        int pre = -1;
        while(!st[i].empty()){
            int tmp = 0;
            tmp = st[i].top();

            if(pre!=-1){
                if(pre-tmp > 1)
                    answer += (pre-tmp)-1;
            }

            st[i].pop();
            pre = tmp;
        }
    }

    cout << answer << endl;

    
}
