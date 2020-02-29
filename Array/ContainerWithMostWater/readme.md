# 11 Container With Most Water


## 我的解法：暴力解：342ms，11.54%
遍历：left从o开始，right要比left大，所以要从left+1的值那里开始，时间复杂度是n2，正方形的右上部分(nxn)/2
```
for(int i = 0; i < len; i++){
            for(int j = i+1; j< len;j++){
                area = Math.max(area, Math.min(height[i],height[j])*(j-i));
            } 
        }
  ```
 
 ## Two Pointer Approach：2ms,95.53%
 
 刚开始的时候，让left和right指向数组的两头，这样width是最大的。**如果left比right短，那么向左移动right是不会让area变大的，因为，area取决于较短的一边，也就是left，那么height没变，width变短了，area肯定变小，所以没必要左移right。同理，如果right较短，就没有必要右移left**，对于第一种情况，我们右移left后，计算area如果变大则更新。然后此时进行上述的left和right谁大谁短的判断，并根据判断移动。最终遍历到right= left结束，返回area即可。
 
 **为什么这样：因为取决于短边，所以移动长边没用（减少了暴力法遍历的遍数，nxn/2 - 一部分）。但是左右都可能是短边，所以每次都要判断，并移动**
