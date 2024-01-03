public class build_by_permition {
    public int[] buildArray(int[] nums) {
        // Newermind, that is for now
        return nums;
    }
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    ans += 1;
                }
            }
        }
        return  ans;
    }

    public static void main(String[] args){
        // Example with chars
        char ch = 'a';
        System.out.println(ch);
        int copy = ch;
        System.out.println(copy);
    }
}
