package Sort;


public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        if (k < 0 || k > nums.length) return -1;
        buildMaxHeapify(nums);
        heapSort(nums,nums.length-1-k+1);
        return nums[nums.length-1-k+1];
    }

    private static void buildMaxHeapify(int[] data){
        int startIndex = (data.length - 1 - 1) >> 1;
        for (int i = startIndex; i >= 0; i--) {
            maxHeapify(data, data.length, i);
        }
    }

    private static void maxHeapify(int[] data, int heapSize, int index){
        // 当前点与左右子节点比较
        int left = (index << 1) + 1;
        int right = (index << 1) + 2;

        int largest = index;
        if (left < heapSize && data[index] < data[left]) {
            largest = left;
        }
        if (right < heapSize && data[largest] < data[right]) {
            largest = right;
        }
        if (largest != index) {
            int temp = data[index];
            data[index] = data[largest];
            data[largest] = temp;
            maxHeapify(data, heapSize, largest);
        }
    }

    private static void heapSort(int[] data, int k) {
        for (int i = data.length - 1; i >= k; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            maxHeapify(data, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,0,10,20,3,5,6,4,9,8,12,17,34,11};
        System.out.println(findKthLargest(a,3));
    }
}
