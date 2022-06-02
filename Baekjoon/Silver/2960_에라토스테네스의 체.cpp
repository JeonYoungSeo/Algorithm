#include <iostream>

using namespace std;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N , K;

    cin >> N >> K;

    bool num[N+1];
    for(int i=0; i<=N; i++){
        num[i] = false;
    }
    int cnt = 0;
    for(int i=2; i<=N; i++){
        if(num[i]) continue;
        for(int j=i; j<=N; j+=i){
            if(!num[j]){
                cnt++;
                if(cnt==K){
                    cout << j << endl;
                    return 0;
                }
            }

            num[j] = true;
        }
    }

}
