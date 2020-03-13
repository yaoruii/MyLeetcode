# 86. Partition List

## two pointer :100% 0ms

* start指向：如果要把小于x的元素往前移的话，我们要接受的位置：也就是start的next就是大于x的node，即最右的小于x的元素，同时左侧全部都是小于x的node
* end指向：从start开始，往右遍历，直到遇到end.next小于x时候，或者end.next==null的时候，说明接下来要移动end.next了，或者说明已经遍历到头，可以结束
* 因为是要保持原有的顺序不变，所以start在前边，有点类似real_index，end在后边，碰到一个小于x的noed，就把这个小的node移到start后边，start = start.next,这样小于x的被移到前边的也是按照他们各自出场顺序排列的

