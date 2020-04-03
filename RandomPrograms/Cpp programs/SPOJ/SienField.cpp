#include <iostream>
#include <stack>
using namespace std;

int main() {
	// your code goes here
	int t=0;
    while(true){
    	string s;
    	cin>>s;
    	if(s.find('-')!=string::npos){
    		break;
    	}
    	t++;
    	int n = s.length();
    	stack<int> st;
    	int operations=0;
    	for(int i=0;i<n;i++){
    		if(st.empty()){
    			st.push(i);
    		}else if(s[st.top()]=='{' && s[i] == '}'){
    			st.pop();
    		}/*else if(s[st.top()]=='}' && s[i]=='}' && (i-st.top()-1)%2==0){
    			operations++;
    			st.pop();
    		}else if(s[st.top()]=='{' && s[i]=='{' && (i-st.top()-1)%2==0){
    			operations++;
    			st.pop();
    		}*/else{
    			st.push(i);
    		}
    	}
    	while(!st.empty()){
    		int a = st.top();
    		st.pop();
    		int b = st.top();
    		st.pop();
    		//cout<<"a: "<<a<<" ";
    		//cout<<"b: "<<b<<" ";
    		if(s[b] == '}' && s[a]=='{'){
    			operations+=2;
    		}else if(s[a] =='{' && s[b]=='{'){
    			operations++;
    		}else if(s[a]=='}' && s[b]=='}'){
    		   operations++;	
    		}
    	}
    	cout<<t<<". "<<operations<<endl;
    }
	return 0;
}