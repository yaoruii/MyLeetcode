# 452. Minimum Number of Arrows to Burst Balloons

**step one**
> 对于每一个气球x，射穿它的箭头的的坐标在x[0]和x[1]之间（包含）。将这些气球按照ending position进行排序。

**step two**
> **按照排好的顺序对🎈进行处理时，确保每一个箭头➡️射中的🎈越多越好**

> We should shoot as to the right as possible, because since balloons are sorted, this gives you the best chance to take down more balloons. 

> 这句话的意思是：**因为，已经按照ending position排好序了，对于第i个气球，我们可以发射一个x=balloon[i][1]的箭头➡️，这样，如果i之后存在气球覆盖了x=bollean[i][1]这一点，那么会将之后的气球也射穿了，如果不覆盖，即之后所有的气球的starting position都大于x=bollean[i][1]这一点，无论箭头在哪里发射，都只能射穿i这一个气球**

因此，the position should always be balloon[i][1] for the ith balloon.

**step three**
> check how many balloons I can shoot down with one shot aiming at the ending position of the current balloon. Then I skip all these balloons and start again from the next one (or the leftmost remaining one) that needs another arrow.

> 将i之后也被射中的气球跳过。

**目测，代码编写的难点将在于：如何skip那些i之后被刺到的气球：**

**回答：  
i之后被刺穿的气球j的特征：j的starting position小于x=bollean[i][1]这一点，即覆盖**


### During Coding:
**nx2的二维数组，根据每一行的第二列进行排序，也挺难的：**

谷歌了一下：按照某一列对数组进行排序，**使用比较器构建内部类**

```java
Arrays.sort(arr, new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];//改下o1和o2的位置，就是从大到小排序
    }
});
```
所有的代码：
```java
public int findMinArrowShots(int[][] points) {
        if(points==null || points.length == 0) return 0;//没有气球
        int n = points.length;
        Arrays.sort(points, new Comparator<int[]>(){//Comparator是一个类，新建一个类
            //类里面有一个叫compare()的方法
            @Override//重写这个方法
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }    
        });
        //int i = 0; int res=0; int currp;
        // while(i<n){
        //     currp = points[i][1];
        //     res++;i++;//箭的个数++,开始看i下一个气球的情况
        //     while(i<n && points[i][0]<=currp){
        //         i++;
        //     }
        // }
        //上边的while套while有点啰嗦：
        int res = 1; int currp = points[0][1];
        for(int i = 1; i<n;i++){
            if(points[i][0]<= currp){
                //当前的i覆盖了当前的箭头的位置，所以，当前的箭头足够了，不需要新的箭头，跳过
                continue;
            }
            //否则，需要新的箭头
            res++;currp = points[i][1];
        }
        return res;
    }
```


## 用meeting room的思路的话：
**如果，下一个气球开始的位置：starting position大于当前气球的结束位置：ending position，那些需要一个新的箭，res++，否则，什么都不做，i++，继续for循环，这样似乎更好理解**

```java
class Solution {
  public int findMinArrowShots(int[][] points) {
    if (points.length == 0) return 0;

    // sort by x_end
    Arrays.sort(points, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
    });

    int arrows = 1;
    int xStart, xEnd, firstEnd = points[0][1];
    for (int[] p : points) {
      xStart = p[0];
      xEnd = p[1];
      // if the current balloon starts after the end of another one,
      // one needs one more arrow
      if (firstEnd < xStart) {
        arrows++;
        firstEnd = xEnd;
      }
    }

    return arrows;
  }
}
```

**综上，可以看出，452题和meeting room II的区别：452是有重叠不需要新箭头，room是无重叠不需要新房间**
