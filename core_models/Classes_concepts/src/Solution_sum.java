public class Solution_sum{
    public int[] twoSum(int[] nums, int target) {
        // Sort and creation of another array
        int ln = nums.length;
        int[] index_ar = make_index_arr(ln);
        int[] local_cp = nums;

        // Cycle -> in another method
        for(int i = 0; i < ln; i++){
            for(int j = i + 1; j < ln; j++){
                if(local_cp[i] > local_cp[j]){
                    // How to decompose ?
                    int swp = local_cp[j];
                    local_cp[j] = local_cp[i];
                    local_cp[i] = swp;
                    swp = index_ar[i];
                    index_ar[i] = index_ar[j];
                    index_ar[j] = swp;
                }else {
                    continue;
                }
            }
        }
        //
        // We need to find sum with two flags
        int[] ans = new int[2];
        int flg1 = 0;
        int flg2 = ln - 1;
        while (true){
            int local_sm = local_cp[flg1] + local_cp[flg2];
            if(local_sm == target){
                ans[0] = index_ar[flg1];
                ans[1] = index_ar[flg2];
                break;
            }else{
                if(local_sm > target){
                    flg2 -= 1;
                }else{
                    flg1 += 1;
                }
                if(flg1 == flg2){
                    System.out.println("Wrong algorithm");
                    break;
                }
            }
        }
        return ans;
    }

    public int[] make_index_arr(int len){
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = i;
        }
        return  arr;
    }
}
