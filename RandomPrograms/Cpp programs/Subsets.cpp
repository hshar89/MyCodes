//Subsets of a int array in lexigraphical order
void funcUtil(unordered_set<string>& sol, vector<int> ar, string res,int index){
    if(index>=ar.size()){
        return;
    }
    for(int i=index;i<ar.size();i++){
        res+=to_string(ar[i]);
        if(sol.find(res)==sol.end()){
           cout<<"("<<res<<")";
           sol.insert(res); 
        }
        res+=" ";
        funcUtil(sol,ar,res,i+1);
        res = res.substr(0,res.length()-2);
    }
}
void func(vector<int> ar){
    // Your code here
    sort(ar.begin(),ar.end());
    unordered_set<string> sol;
    cout<<"()";
    funcUtil(sol,ar,"",0);
    cout<<endl;
}