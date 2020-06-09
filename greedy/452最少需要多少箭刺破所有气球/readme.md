# 452. Minimum Number of Arrows to Burst Balloons

**step one**
> 对于每一个气球x，射穿它的箭头的的坐标在x[0]和x[1]之间（包含）。将这些气球按照ending position进行排序。

**step two**
> **按照排好的顺序对🎈进行处理时，确保每一个射中的🎈越多越好**

> We should shoot as to the right as possible, because since balloons are sorted, this gives you the best chance to take down more balloons. 
Therefore the position should always be balloon[i][1] for the ith balloon.

> 这句话的意思是


