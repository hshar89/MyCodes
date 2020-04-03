#include<bits/stdc++.h>
using namespace std;
struct area{
    int x,y;
    area(int x,int y):x(x),y(y){};
};
int getMaxSurvivalTime(area a1, area a2, area a3, int A, int B, int last,map<pair<int,int>,int> &memo){
    if(A<=0 || B <=0){
        return 0;
    } 
    pair<int,int> cur = make_pair(A,B);
    if(memo.find(cur)!=memo.end()){
        return memo[cur];
    }
    int temp;
    switch(last){
        case 1:
        temp = 1+max(getMaxSurvivalTime(a1,a2,a3,(A+a2.x),(B+a2.y),2,memo),
                        getMaxSurvivalTime(a1,a2,a3,(A+a3.x),(B+a3.y),3,memo));
                    break;
        case 2:
            temp = 1+max(getMaxSurvivalTime(a1,a2,a3,(A+a1.x),(B+a1.y),1,memo),
                    getMaxSurvivalTime(a1,a2,a3,(A+a3.x),(B+a3.y),3,memo));
                    break;
        case 3:
            temp = 1+max(getMaxSurvivalTime(a1,a2,a3,(A+a1.x),(B+a1.y),1,memo),
                        getMaxSurvivalTime(a1,a2,a3,(A+a2.x),(B+a2.y),2,memo));
                    break;
    }
    return temp;
}
int getMaxSurvival(area a1, area a2, area a3, int A, int B){

    if(A<=0 ||B<=0){
        return 0;
    }
    map<pair<int,int>,int> memo;
    return max(getMaxSurvivalTime(a1,a2,a3,A+a1.x,B+a1.y,1,memo),max(getMaxSurvivalTime(a1,a2,a3,A+a2.x,B+a2.y,2,memo),
                    getMaxSurvivalTime(a1,a2,a3,A+a3.x,B+a3.y,3,memo)));
}
int main(){

    area a1 (3,2);
    area a2 (-5,-10);
    area a3 (-20,5);
    int A = 20;
    int B = 8;
    cout<<getMaxSurvival(a1,a2,a3,A,B);
}