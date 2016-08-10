
//  O(n)时间复杂度
int maxSubArray(vector<int>& nums) {
    int n=nums.size();
    int res=-10000;
    int sum=0;
    for(int i=0;i<n;i++){
        sum=sum+nums[i];
        if(res<sum){
            res=sum;
        }
        if(sum<0){
            sum=0;
        }
    }
    return res;
}