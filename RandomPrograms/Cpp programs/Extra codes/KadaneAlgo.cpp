//Finding Max sum of contiguous sub array in an array using kadane's algo
/*This is a function problem.You only need to complete the function given below*/
//User function Template for C++
//Complete this function
long long maximumSum(int arr[], int sizeOfArray)
{
   long long dp[sizeOfArray]={0}; //declaring dp array 
   dp[0]=arr[0]; //the first element is maximum till now
   long long answer=arr[0];
   for(int i=1;i<sizeOfArray;i++)
   {
       //The maximum sum at dp[i] will be max of (current array element+dp[i-1]) and (current array element)
       //Complete this code
       dp[i] = max(arr[i]+(int)dp[i-1],arr[i]);
       answer=max(answer,dp[i]);
   }
   //To print the dp array
   for(int i=0;i<sizeOfArray;i++)
   {
       cout<<dp[i]<<" ";
   }
   cout<<endl;
   //Printing over
   
   return answer;
}
//The below is an extention to above. Find out the maximum sum of the array if
//neighbours cannot be added together
long long maximumSum(int arr[], int n)
{
  //Your code here
  long long dp[n];
  dp[0] = arr[0];
  dp[1] = max((int)dp[0],arr[1]);
  long long maximumS = INT_MIN;
  for(int i=2;i<n;i++){
      if(dp[i-2]>=0){
          dp[i] = max((int)dp[i-2]+arr[i],(int)dp[i-1]);
      }else{
     dp[i] = max((int)dp[i-1],arr[i]);
      }
      maximumS = max(maximumS,dp[i]);
  }
  return maximumS;
}