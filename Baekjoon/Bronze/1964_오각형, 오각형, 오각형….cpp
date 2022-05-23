#include <iostream>
using namespace std;

int main(){

    int n;
    cin >> n;

    int d = 3;
    int r = 1;

    int answer = 5;
    while(n!=1){
        
        answer += d*2;
        answer += r;
        answer %= 45678;

        r++;
        d++;
        
        n--;
    }

    cout << answer;
}
