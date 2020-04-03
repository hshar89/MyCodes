//Comination Sum
//Given an array of positive integers arr[] and a sum x, find all unique
//combinations in arr[] where the sum is equal to x.
//The same repeated number may be chosen from arr[] unlimited number of times.
//This is inhouse built
void combinationSumUtil(vector<int> &A,vector<vector<int>> &sol,
                           vector<int> v,int sum,int x, int start){
    for(int i=start;i<A.size();i++){
        x+=A[i];
        v.push_back(A[i]);
        if(x<sum){
        combinationSumUtil(A,sol,v,sum,x,i);
        v.pop_back();
        x-=A[i];
        if(x == 0){
            return;
        }
        }else if(x == sum){
        vector<int> temp;
        for(auto j=v.begin();j!=v.end();j++){
            temp.push_back(*j);
        }
        sol.push_back(temp);
        return;
        }else{
            return;
        }
    }
}
//This is inhouse solution
vector<vector<int> > combinationSum(vector<int> &A, int B) {
    // Your code here
    vector<vector<int>> sol;
    sort(A.begin(),A.end());
    A.erase(unique(A.begin(),A.end()),A.end());
    for(int i = 0;i<A.size();i++){
        vector<int> temp;
      combinationSumUtil(A,sol,temp,B,0,i);
    }
    return sol;
}