/**
 * @author Dun Wenlong
 * @date 2020/6/13
 * 搜索旋转数组中的某个元素
 * 思路：首先判定中点值和数组左边的大小，如果中点值大于左边的，说明中点值左边是升序，如果中点值小于左边的说明右边是升序，然后寻找目标值只在左边时
 * 的条件判断以及目标值只在右边的条件值判断，进行右边的判断时需要注意如果数组的最左边和最右边的值相等，且正好为目标值，则应输出左边的索引，否则的
 * 话我们正常考虑
 */
public class SearchRevolveArray {
    public int search(int[] arr, int target){
        int lenArr = arr.length;
        int l = 0;
        int r = lenArr-1;
        if(r == -1){
            return -1;
        }
        while(l<r){
            int mid =  l + (r - l) / 2;;
            if(arr[l]<arr[mid]){
                if(arr[l]<=target && target<=arr[mid]){
                    r = mid;
                } else {
                    l = mid + 1;
                }
                continue;
            }
            if(arr[l]>arr[mid]){
                if(arr[l] == arr[r] && arr[l]!=target){
                    l++;
                    continue;
                } else if(arr[l] == arr[r] && arr[l] == target){
                    return l;
                } else if(arr[mid]<target&& target<=arr[r]){
                    l = mid+1;
                } else{
                    r = mid;
                }
                continue;
                // 加上&& nums[left] > nums[right]这里存在问题比如[5,5,5,1,2,3,4,5] 3
//                if (arr[mid] < target && target <= arr[r] && arr[l] > arr[r]) {
//                    l = mid + 1;
//                } else {
//                    r = mid;
//                }
//                continue;
            }
            if(arr[l] == arr[mid]){
                if(arr[l]!=target){
                    l++;
                } else{
                    r=l;
                }
                continue;
            }
        }
        return (arr[l] == target) ? l : -1;
    }
}
