# 一：Elementary sort

## 1，selection sort:选择排序

* in iteration i，找到剩下的数组中的最小值的索引mid
* 将a[i]和a[mid]进行交换。
* Invariants:
  * i pointer 迭代从左往右：在i左侧包括i的entries递增排列，且固定。
  * i右侧的entries都大于等于i左侧的entries。
* Runtime : N的平方（compare作为model cost)：quadratic
* runtime和输入无关：即使输入一个已经排好序的数组，runtime也是一样的。
* 数据的移动movement是最少的：线性次数的移动: linear

## 2，Insertion sort:插入排序

* in iteration i, swap a[i] with each larger entry to its left.(和i左侧的比a[i]大的元素交换。)
* Invariants:
  * i pointer 迭代从左往右：在i左侧包括i的entries递增。
  * i右侧的entries还没有被seen !

* Runtime : copmare : 1/4 * N的平方，exchange：1/4 * N的平方
* 取决于输入的数组：
  * best case：如果输入的数组就是增序的：N-1次比较，0次exchange
  * Worst case: 如果输入的数组是减序的同时没有重复元素：1/2 * N的平方的比较和交换，因为每一次的比较都会交换。
  * Partially-sorted arrays: 定义**inversion: a pair of keys that are out of order**
    * runtime is linear time 
    * number of exchange equals to the number of inversions
    * Number of compare = exchanges + (N-1);

## 3，Shellsort:希尔排序

在插入排序的基础上进行了一些改变，插入排序是每次和前边的1位的元素进行比较和交换，希尔排序是和前边h位的元素比较，h是递增数列，刚开始取最大值，然后递减到1，最后进行的是h=1的插入排序，得到最终的结果。

```java
public class Shell
{
 public static void sort(Comparable[] a)
 {
 int N = a.length;
 int h = 1;
 while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, ...
 while (h >= 1)
 { // h-sort the array.
     for (int i = h; i < N; i++)//h=1的时候就是插入排序
     {
         for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
         		exch(a, j, j-h);
 }

 h = h/3;
 }
 }
```



# 二：Merge-Sort:归并排序

## 1，自顶向下排序（递归）

```java
private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
{
 assert isSorted(a, lo, mid); // precondition: a[lo..mid] sorted
 assert isSorted(a, mid+1, hi); // precondition: a[mid+1..hi] sorted
 for (int k = lo; k <= hi; k++)
     aux[k] = a[k];
 int i = lo, j = mid+1;
 for (int k = lo; k <= hi; k++)
 {
     if (i > mid) a[k] = aux[j++];//左半边用尽，直接把右侧放上去
     else if (j > hi) a[k] = aux[i++];//右半边用尽，直接把左侧放上去
     else if (less(aux[j], aux[i])) a[k] = aux[j++];//右侧的小于左侧的：把右侧的放进去，j++
     else a[k] = aux[i++];//左侧的小于右侧的，左侧的放进去，i++
 }
```

归并的前提是：两部分数组已经是sorted的。先将所有元素复制到aux[]中，然后归并回a[]数组中。在归并的过程中，进行四个条件判断。

然后，使用**递归的方法**进行排序：

```java
private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
 {
 if (hi <= lo) return;//只有一个元素会直接return，然后merge，这应该算base case了
 int mid = lo + (hi - lo) / 2;//将数组一分为二
 sort(a, aux, lo, mid);//调用自身函数，进行排序
 sort(a, aux, mid+1, hi);
 merge(a, aux, lo, mid, hi);//排序后，调用上边的merge进行归并
 }
```

递归的方法：每次都一分为二，直到**每个子数组只有一个元素**，两个元素merge成一个长度为2的子数组，所以这应该是排序的base case。

这个aux[]数组是作为全局变量，用于merge()函数中，在merge中，我们先将lo-hi（注意，lo-hi也可能只是整个数组的一部分）放入到aux[]数组中，然后归并时从axu[]数组中提取元素放入到a[]数组中，这样lo-hi的元素就排好序了。

* 时间复杂度：**nlog(n)**

### a little improvement

#### 1，Use insertion sort for small subarrays.

size小于某个值的子数组，使用插入排序，而不是上边的：一分为二+各自排序+归并。

在sort()函数中，加入if语句判断一下传入的数组a[]的lo和hi形成的数组的长度，较小，就直接调用插入排序

```java
if (hi <= lo + CUTOFF - 1)
 {
     Insertion.sort(a, lo, hi);
     return;
 }
```

#### 2，Stop if already sorted.

在进行归并之前，看看是不是已经整体有序了，不需要排序了：

**左侧的最大元素<=右侧的最小的元素**

## 2，自底向上的归并排序：bottom-up merge sort

先**集体归并微型数组**，然后再集体归并得到的子数组：首先两两归并（每个元素为大小为1的数组），然后四四归并（两个大小为2的数组归并为有四个元素的数组），然后八八归并（两个大小为4的数组归并为8个元素的数组）。

N个元素，需要log(N)，比如，8个元素，首先2-2，4次，然后4-4，2次，最后，8-8，1次得到最终结果。每一次比较N次，所以时间复杂度是**nlog(n)**。

```java
 private static void merge(...)
 { /* as before */ }
 public static void sort(Comparable[] a)
 {
   int N = a.length;
   Comparable[] aux = new Comparable[N];
   for (int sz = 1; sz < N; sz = sz+sz)//sz每次double，所以外层循环log(n)次
     for (int lo = 0; lo < N-sz; lo += sz+sz)//固定sz后，对所有N个元素进行sz-sz排序
       merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));//最后一个归并，可能超出数组长度
 }
```



# 三：Comparators

**comparable interface：**

创建自己的数据类型的时候，我们只要实现**Comparable**接口就能保证该数据结构可比较，但是要实现一个compareTo(data that)方法：返回-1，0和1。

```java
public interface Comparable<T>{//T是该接口里面会用到的某个元素的数据类型，范型的用法
  int compareTo(T that){
    //that实例和this进行比较，所以，一般T就是this的数据类型，T实现了comparable
    return 1/0/-1;
  }
}//使用自然排序：natural order
```

**comparator interface：**

```java
public interface Comparator<T>{//同上，T是接口里面用到的某个元素的数据类型。
  int compare(T key1, T key2){
    //比较key1和key2;
  }
}//提供其他种的不同的排序方法：defined by Comparator<String> object
```

要求数据必须是**全序的**，

可以用于Java的系统的排序：

* 创建一个Comparator object
* 将其作为第二个参数传入到Arrays.sort()中。

```
Arrays.sort(a, String.CASE_INSENSITIVE_ORDER);
```

如何实现一个comparator:

* 定义一个嵌套的类 which 实现comparator这个接口
* 实现compare()方法。

```java
public class Student
{
 public static final Comparator<Student> BY_NAME = new ByName();
 public static final Comparator<Student> BY_SECTION = new BySection();
 private final String name;
 private final int section;
 ...
 private static class ByName implements Comparator<Student>
 {
 public int compare(Student v, Student w)
 { return v.name.compareTo(w.name); }
 }
 private static class BySection implements Comparator<Student>
 {
 public int compare(Student v, Student w)
 { return v.section - w.section; }
 }
}
```

然后，该student类的实例，就可以通过多种方法被排序了：

```java
Arrays.sort(a, Student.BY_NAME);
Arrays.sort(a, Student.BY_SECTION);//静态属性
```

# 四：稳定性

**A stable sort preserves the relative order of items with equal keys.**

拥有同样的key的元素们，排序后保持之前他们之前的相对顺序。

**插入排序和合并排序是稳定的，但是选择排序和希尔排序不是稳定的**

**注意：要仔细地检查代码："less than" vs. "less than or equal to"**

* 插入排序：在内for循环中，一旦a[j]和a[j-1]相等，就不再继续循环，因此，相等的元素的相对位置不会变。Equal items never move past each other.

```java
public class Insertion
{
 public static void sort(Comparable[] a)
 {
     int N = a.length;
     for (int i = 0; i < N; i++)
     		for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
     				exch(a, j, j-1);
 }
}
```

* 选择排序：在内for循环中，从i开始寻找从i开始到最后的最小的数，然后将当前i和最小数交换，因此，当前i可能会被交换到任意的位置，所以和a[i]的元素们和a[i]的相对位置就被改变了。Long-distance exchange might move an item past some equal item.

  ```java
  public class Selection
  {
   public static void sort(Comparable[] a)
   {
         int N = a.length;
         for (int i = 0; i < N; i++)
         {
             int min = i;
             for (int j = i+1; j < N; j++)
             		if (less(a[j], a[min]))
             		min = j;
             exch(a, i, min);
   }
   }
  }
  ```

* 希尔排序：不稳定，因为，x和前h个的元素y交换，可能在这h窗口内有和y相等的元素y1，y1一开始在y的右侧，现在y在y1的右侧，相对关系改变：Long-distance exchanges.
* 归并排序：稳定：取决于merge()函数是否稳定，Takes from left subarray if equal keys.如果元素相等，从左侧的子数组中提取元素。

# 五：Quicksort:快速排序

## 基本的思想：递归

* 将数组打乱：shuffle
* 对数组进行切分：partition，使得某个j
  * entry a[j]是排定的，已经排定：in place
  * j左侧的entry都不大于a[j]
  * j右侧的entry都不小于a[j]
* 将j两侧的子数组分别排序，然后整个数组有序：递归调用排序函数

切分的步骤：

重复以下步骤，直到i和j指针**相交**：i >= j的时候

* 从左往右扫描，只要a[i]<a[lo]，如果大于等于，就停下
* 从右往左扫描，只要a[j]>a[lo]，如果小于等于，就停下
* 将i和j处的元素交换
* 重复按照1和2继续扫描

当两指针相遇时，i>=j，则不进行i和j的交换，将lo和j的元素交换，结束切分过程。

切分代码：

```java
private static int partition(Comparable[] a, int lo, int hi)//lo和hi都是按照从0开始为基准的
{
 int i = lo, j = hi+1;
 while (true)
 {
   while (less(a[++i], a[lo]))//第一次读取的元素其实是i=lo+1，
   		if (i == hi) break;//防止下一次读取越界
   while (less(a[lo], a[--j]))//第一次读取其实是j=hi+1-1=hi，
   		if (j == lo) break;//防止下一次越界

	 if (i >= j) break;//i和j相交，不能交换，结束循环
   exch(a, i, j);
 }
   exch(a, lo, j);//最后将lo放在正确位置，结束
   return j;//返回切分元素的位置
}
```

递归排序：

```java
public class Quick
{
 private static int partition(Comparable[] a, int lo, int hi)
 { /* see previous slide */ }
 public static void sort(Comparable[] a)
 {
     StdRandom.shuffle(a);
     sort(a, 0, a.length - 1);
 }
 private static void sort(Comparable[] a, int lo, int hi)
 {
     if (hi <= lo) return;
     int j = partition(a, lo, hi);
     sort(a, lo, j-1);
     sort(a, j+1, hi);
 }
} 
```

**最坏的情况：**

比较次数是平方级别的：quadratic， ½ N 2.

**平均的情况：**

比较的次数是正比于： 1.39 N lg N，比归并排序多比较39%，但是更少的数据移动，所以会更快。

**特性：**

* in place
* 不稳定的

**改进：**

**1，对于小的数组，使用插入排序：**

```java
 private static void sort(Comparable[] a, int lo, int hi)
 {
 		if (hi <= lo + CUTOFF - 1)
 {
       Insertion.sort(a, lo, hi);
       return;//对于小数组，使用插入排序，之后的操作就不需要了，所以直接return
 }
   int j = partition(a, lo, hi);
   sort(a, lo, j-1);
   sort(a, j+1, hi);
 }
```

# 六：选择

**给定一个长度为N的数组，找到第K个最小的元素**

应用：找到top k的元素

## 基于quick-sort的思路的quick-select：

* 对数组进行partition，得到位置j= 切分元素的索引！！
* 根据j和K的关系，重复对一个子数组进行partition：
  * 如果，j<k：对右侧子数组partition：lo = j+1
  * 如果，j>k：对左侧子数组partition：hi = j-1
  * 如果，j=k，那么切分元素就是第k个元素，返回a[j]

* 确定好新的lo和hi后，通过while(true)循环来继续partition，直到j==k，调用了return;

```java
public static Comparable select(Comparable[] a, int k)
{
   StdRandom.shuffle(a);
   int lo = 0, hi = a.length - 1;
   while (hi > lo)
 {
     int j = partition(a, lo, hi);
     if (j < k) lo = j + 1;
     else if (j > k) hi = j - 1;
     else return a[k];
 }
	 return a[k];
}
```

**特点：**

* 快速选择平均花费的时间为**线性 linear time**

# 七：重复的元素

mergesort当有重复的元素的时候，Between ½ N lg N and N lg N compares.

Quicksort with duplicate keys：

Algorithm goes quadratic unless partitioning stops on equal keys!

## 三向切分的快速排序：Dijkstra 3-way partitioning 

<img src="https://tva1.sinaimg.cn/large/007S8ZIlgy1geei9e4gixj30nq0a2wex.jpg" alt="屏幕快照 2020-05-02 下午11.06.04" style="zoom:50%;" />

<img src="https://tva1.sinaimg.cn/large/007S8ZIlgy1gef2mcz7lvj30lg074mxd.jpg" alt="屏幕快照 2020-05-03 上午10.50.49" style="zoom:50%;" />

* 维护一个指针lt：使得a[lo，lt-1]都小于v
* 维护指针i：使得a[lt, i-1]都等于v
* 维护指针gt：使得a[i, gt]都是还未被遍历的元素，a[gt+1, hi]是大于v的元素

lo和hi是数组最左端和最右端的元素的索引，开始时，lt、i都指向lo，gt==hi，切分元素是a[lo]。从左往右扫描i:

* a[i]<v: 交换a[lt]和a[i], lt和i都增加1，因为i指向的元素小于v，需要放在lt的右侧，也就是此时的lt，然后lt++，现在lt指向的元素就是V，因此，将a[lt]和a[i]交换即可，然后，该i处的元素已经被遍历，i++即可。
* a[i]==v: i处的元素放在其自身的位置即可，i++即可
* a[i]>v：i指向的元素大于v，因此需要放在gt处，因为gt+1是目前最左侧的大于v的元素，所以，将a[gt]和a[i]交换，然后gt--，这样gt+1依旧是最左侧的大于v的元素，之前的gt处的元素交换到a[i]处，它属于未被遍历的元素，所以，i不需要++，下一轮，将继续遍历i处的该元素

```java
private static void sort(Comparable[] a, int lo, int hi)//参数是索引，且包含
{
     if (hi <= lo) return;
     int lt = lo, gt = hi;
     Comparable v = a[lo];
     int i = lo;
     while (i <= gt)//因为从i到gt这些元素是未被遍历的
     {
         int cmp = a[i].compareTo(v);
         if (cmp < 0) exch(a, lt++, i++);
         else if (cmp > 0) exch(a, i, gt--);
         else i++;
     }
         sort(a, lo, lt - 1);
         sort(a, gt + 1, hi);
}
```

对于包含大量重复元素的数组，它将排序时间从线性对数级降低到了线性级别。

# 八：system sorts

Arrays.sort():

* 对于每一个primitive type都有其自己的方法
* 对于实现了comparable的数据类型有一个方法
* 有一个方法，其中使用了comparator
* 对于primitive type，使用quick-sort，对于其他的object，使用merge-sort。

# 九：堆排序：heapsort

就地排序的（in place）基本思路：

* 使用所有的N个元素创造一个Max-heaps
* 重复地移走最大的元素

**构建heap:**

使用自底向上的方法构建一个max-heap：

从右往左遍历数组，用sink()方法构造子堆，数组的每一个位置都已经是一个子堆的根结点了，sink()对这些子堆也适用。**如果一个结点的两个子结点都已经是堆了，那么在该结点上调用sink()可以将它们变成一个堆**，对结点使用sink()，结点会被移动到合适的位置，因此sink()函数需要加入参数k和N，分别代表对k结点使用sink，和可以被access的最大元素的索引是N（自底向上，所有被调用的sink的N都是该数组的所有元素数n）。可以跳过大小为1的堆。

```java
for (int k = N/2; k >= 1; k--)//忽略1个元素的堆，第一个root从N/2开始，往左遍历，k--
 sink(a, k, N);//将k这个root结点下沉
```

**排序：**

* 一次移除一个最大的元素：和最右的元素a[N]交换位置，然后N--，因为最大的元素此时被移除了。
* 将被移动到index=1处的新root进行sink()到合适的位置：sink(a, 1, N);

```java
while (N > 1)//当N==1，heap只有一个元素，那是最小的元素，将其放在index=1位置即可。1和1进行交换，没有意义
{
 exch(a, 1, N--);
 sink(a, 1, N);
}
```

**less()和exch()函数，在这里要将传入的参数减1后作为数组的索引，因为，原地排序，root在数组中是a[0]而不是优先队列中的a[1]，所以，在其他函数中继续1-based indexing，因为其他函数没有直接的access数组元素，而是调用less()和exch()中有直接的access数组，所以在这两个函数中传入的参数要先减1**

**特性：**

构建heap：使用了<= 2N次的比较和<=N次的交换（比较需要两倍）

堆排序：使用小于2 N lg N 的比较和小于 N lg N 的交换

**它是唯一一个满足：In-place sorting algorithm with N log N worst-case.**

* merge sort：需要额外的线形空间
* Quick sort：worse case can be Quadratic

**缺点：**heap sort在时间和空间上都是优化的，但是

* 内部的循环时间比quick sort更长
* 对缓存的内存使用率不高
* **不稳定**

# 十：总结

![屏幕快照 2020-05-04 上午11.21.48](https://tva1.sinaimg.cn/large/007S8ZIlgy1geg951q66oj31g40u0agf.jpg)

x表示满足这一个条件。