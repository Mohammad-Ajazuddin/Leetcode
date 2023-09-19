class Solution {
    static void mergeSort(int[] nums, int low, int high) {
        if (low>=high)
        {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    static void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int[] temp = new int[high-low+1];
        int i = 0;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[i] = nums[left];
                i++;
                left++;
            } else {
                temp[i] = nums[right];
                i++;
                right++;
            }
        }

        while (left <= mid) {
            temp[i] = nums[left];
            i++;
            left++;
        }

        while (right <= high) {
            temp[i] = nums[right];
            i++;
            right++;
        }
        
        for (i = low; i <=high; i++) {
            nums[i] = temp[i - low];
        }
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        return nums;
    }
}
