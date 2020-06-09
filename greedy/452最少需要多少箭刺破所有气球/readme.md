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




