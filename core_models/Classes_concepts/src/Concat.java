public class Concat {
    public int[] getConcatenation(int[] nums) {
        int ln = nums.length;
        int[] doub_nums = new int[ln * 2];
        for(int i = 0; i < ln * 2; i++){
            doub_nums[i] = nums[i % ln];
        }
        return  doub_nums;
    }
}
