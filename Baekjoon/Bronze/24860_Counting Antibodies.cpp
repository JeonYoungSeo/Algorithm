#include <iostream>

using namespace std;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long a,b,c,d,e,f,g;

    cin >> a >> b ;
    cin >> c >> d ;
    cin >> e>> f>> g;

    cout << e*f*g*(a*b+c*d) << endl;
}
