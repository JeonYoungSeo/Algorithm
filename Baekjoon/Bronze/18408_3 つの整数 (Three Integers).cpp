#include <iostream>
using namespace std;

int main(){

    int one=0, two=0;
    int a,b,c;

    cin >> a>> b >> c;

    (a==1)? one++: two++; 
    (b==1)? one++: two++; 
    (c==1)? one++: two++; 

    int answer = (one>two)?1:2;

    cout << answer;
}
