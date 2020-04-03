#include<iostream>
#include<bits/stdc++.h>
typedef unsigned long long int ll;
#define M 1000000007
using namespace std;
int powerOfTwo(int n){
	int res = 1;
	while(n--){
		res=(res*2)%M;
	}
	return res;
}
int main(){
	/*int a,b,c,n;
    a=3;
    b=1;
    c=2;
    n=6;
    int temp = 1000000007;
    cout<<temp;
	int s1;
    int s2;
		int F[n+1];
		F[1] = 1;
		ll sum = 1;
		priority_queue<int,vector<int>,greater<int>> minpq;
		priority_queue<int> maxpq;
		maxpq.push(1);
		int median = 1;
		for(int i=2;i<=n;i++){
           cout<<"median "<<median<<" ";

			F[i] = (a*median+b*i+c)%M;
            cout<<"F[i]: "<<F[i]<<"  ";            
			if(F[i]>median){
				minpq.push(F[i]);
			}else{
				maxpq.push(F[i]);
			}
			s1 = maxpq.size();
			s2 = minpq.size();
			if((s1-s2)>1){
				minpq.push(maxpq.top());
				maxpq.pop();
			}else if((s2-s1)>1){
				maxpq.push(minpq.top());
				minpq.pop();
			}
            s1= maxpq.size();
            s2 = minpq.size();
			if(s1 == s2){
				median = maxpq.top();
			}else{
				median = s1>s2?maxpq.top():minpq.top();
			}
			sum+=F[i];
		}
		cout<<sum<<endl;*/
        ll a = 4;
        ll b = 5;
        ll res=0;
        while(b){
            if(b&1){
              res = (res+ a)%M;
            }
            a = (a*2)%M;
            b>>=1; 
        }
        cout<<res<<"\n";
		double d1 = 1e11;
		double d2 = 1e11;
		double d3 = pow(d1*d1+d2*d2,0.5);
		double d4 = pow(2000,203);
		cout<<d4<<" ";
		cout<<fixed<<setprecision(10)<<d3<<endl;
		double n1 = 1e20;
		int n2 = 'a'+26;
		cout<<n1<<" "<<n2<<" ";

		cout<<"\nPower of two\n";
		cout<<powerOfTwo(200000)<<" ";
}