#include <iostream>

using namespace std;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string str;
    cin >> str;

    int answer = 0;
    for(int i=0; i<str.length(); i++){
        int tmp = str.at(i)-'0';
        

        answer += tmp*tmp*tmp*tmp*tmp;
    }

    cout << answer;
    
}
