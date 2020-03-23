/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1; int hi = n; int mid;
        while(lo < hi){
            mid = lo + (hi - lo)/2;
            if(isBadVersion(mid)){
                //mid可能是第一个，也可能第一个在mid的左侧：
                hi = mid;
            }
            else{
                //第一个在mid的右侧
                lo = mid+1;
            }
        }
        return lo;
    }
}
