#include <iostream>
using namespace std;

const int si = 51;
int N ;
void cnt(int num, char arr[], bool (&check)[si]);
int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N ;

    char arr[N][N];

    for(int i=0; i<N; i++){
        string tmp;
        cin >> tmp;
        for(int j=0; j<N; j++){
            arr[i][j] = tmp[j];
        }
    }

    int answer = 0;

    for(int i=0; i<N; i++){
        bool check[si] = {false,};
        for(int j=0; j<N; j++){
            if(arr[i][j] == 'N') continue;
            check[j] = true;
            cnt(i, arr[j], check);
        }

        int count = 0;
        for(int j=0; j<N; j++){
            if(i==j) continue;
            if(check[j]) count++;
        }
        answer = (answer>count)? answer : count;
        
    }

    cout << answer << "\n";

        
}

void cnt(int num, char arr[], bool (&check)[si]){

    for(int i=0; i<N; i++){
        if(num==i) continue;
        if(arr[i] == 'Y'){
            check[i] = true;
        }
    }
    
}
