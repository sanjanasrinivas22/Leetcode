class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
    if (first == -1) return new int[]{-1, -1};
    int last = findBound(nums, target, false);
    return new int[]{first, last};
}

private int findBound(int[] nums, int target, boolean isFirst) {
    int l = 0, r = nums.length - 1, res = -1;
    while (l <= r) {
        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            res = mid;
            if (isFirst) r = mid - 1;
            else l = mid + 1;
        } else if (nums[mid] < target) {
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    return res;
    }
}