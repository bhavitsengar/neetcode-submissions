class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int head = 0;

        int tail = numbers.length - 1;

        while(tail > head) {
            int sum = numbers[head] + numbers[tail];
            if(sum == target) {
                int[] ans = new int[2];
                ans[0] = head + 1;
                ans[1] = tail + 1;
                return ans;
            } else if(sum < target) {
                head ++;
            } else {
                tail --;
            }
        }
        
        return null;
    }
}
