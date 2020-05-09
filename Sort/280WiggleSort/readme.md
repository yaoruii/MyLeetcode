# 280. Wiggle Sort
```
Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4]
```
# 直接排序，然后交换位置

将数组用任何可以的方式进行排序，然后成为有序数组后，从第二个开始两两交换
* 第二个小于等于第三个，交换后：**第二个大于等于第三个，肯定也大于等于第一个**
* 然后，第四个和第五个交换后：**五四无论怎么交换都大于等于第三个，所以，大于关系确定，接下来的小于关系通过交换第四个和第五个得到保障**
* 同理，第六和第七，本身就大于左侧的所有元素，所以，将6/7交换满足小于关系 即可。
* 答案用的是系统排序，虽然很方便，但是如何确定时间/空间复杂度呢

# 直接交换（有人说是“贪心”，写完再学）
核心问题：
* 一开始是小于关系(翻译：```a[i]<=a[i+1]```)，如果不满足，就交换i和i+1这两个元素，反之，就不做任何操作。
* 接下来，i++，进入大于关系(和之前的关系相反）：如果满足，就不做任何操作，如果不满足，说明是小于关系(和上一个i对应的“整理”后关系一致！！），当前的i是上一个迭代中的```i+1```,也就是说当前```i-1```小于当前的```i```，当前的```i```小于```i+1```，```i+1```是最大的:因为，他们的关系一致，所以，为了让他们满足**wiggle sort**，将```i```和```i+1```进行交换，这样当前的```i```大于```i+1```，且当前的```i```依旧保持了大于```i-1```的关系。
* 同理，i++后，新的i对应的是小于关系(和之前的关系相反）：果满足，就不做任何操作，如果不满足，说明是大于关系(和上一个i对应的“整理”后关系一致！！），即```i-1```大于```i```,以及```i```大于```i+1``` ，所以，```i+1```是最小的数，交换```i+1```和```i```后，满足了小于关系，同时，当前的```i```依旧小于```i-1```,保持了上一个i的大于关系！！！
* 综上，可以这个样子的交换

![](https://tva1.sinaimg.cn/large/007S8ZIlgy1gemdvgc73zj31ds0u0npd.jpg)