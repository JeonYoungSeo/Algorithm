#include <iostream>
#include <set>

using namespace std;

void permu(string str, set<string>& set, int arr[], int n);
bool visited[11];
int n;
int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int k;
    cin >> n ;
    cin >> k;

    int arr[n];
    for(int i=0; i<n; i++){
        cin >> arr[i];
    }

    set<string> set;
    string str;
    permu(str, set, arr, k);

    cout << set.size();


}

void permu(string str, set<string>& set, int arr[], int cnt){

    if(cnt==0){
        set.insert(str);
        return ;
    }

    for(int i=0; i<n; i++){
        if(visited[i]) continue;
        visited[i] = true;
        permu(str+to_string(arr[i]), set, arr, cnt-1);
        visited[i] = false;
    }

}
