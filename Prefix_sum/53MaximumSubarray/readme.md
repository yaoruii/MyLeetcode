# 53. Maximum Subarray

## 4月3日，在30天挑战的第三天碰到了这题，此时带着已刷147题的经验，使用前缀和解决了

**借鉴的是644题的check()method的思想，check（）这个函数呢在644题中是看一个数组中是否存在平均值大于mid的长度大于k的子数组，子数组的和也是用pre[j]-pre[i]来表示的，pre[j]在644中是所谓的sum，追踪j之前的所有的prefix的最小值min_pre，遍历j从0到数组长度len，得到pre[j]后和当前的min_pre相减，如果大于mid,那就是存在平均值大于mid的长度大于k的子数组，结束寻找**

**所以，53题找和最大的子数组，就是check()的一个小部件，j从左往右遍历整个数组，得到当前的pre[j]（一路加过来即可），然后和最小的min_pre相减，但是min_pre可能是pre[j]，所以这样一减就是0了，且子数组的长度是0，这肯定是不对的**

所以，操作的顺序很关键：
* min_pre必须是j之前的索引的prefix中的最小的，也就是说**把当前的pre[j]和min_pre的比较更新min_pre时，已经完成了sum和(pre[j]-min_pre)进行比较最大值更新sum的操作。

## follow up:divide and conquer法


