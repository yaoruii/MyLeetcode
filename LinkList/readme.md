# LinkedList

## 从list的尾部开始遍历的话要怎么做？

**比如109这道题，一开始觉得listnode这种数据结构，无法像array那样，根据索引去获取node，所以无从下手**

但是可以用一个for循环，把每一个listnode放入java自带的数据结构List中，使用get.size()即可，但是performance就比较慢了。

其他的题，需要首先定位到末尾元素的话，还是根据具体题分析吧，之前写过一波：LinkedList的two pointers的题，可得还不错，但是还没总结。。。


## 要定位list的mid元素怎么办？

还是109这题，本来像得到末尾，是为了得到mid，所以可以one pass直接得到mid的node。

### three pointer: slow_pointer, fast_pointer, pre_pointer:
<img src="https://tva1.sinaimg.cn/large/00831rSTgy1gd409sbzzrj30w80b4abw.jpg" style="zoom:30%;" />

* 如果一共有n个nodes，n是偶数，那么fast_pointer从head开始每次跳两格，（n/2-1）次会从head跳到倒数第二个node：因为head= 1，跳一次到达了3，然后5，7，9，，，，：1 + (timeX2)，所以最终到达n-1，这个时候停止，同时：**slow_pointer从head开始，跳一次到2，3，：1+time = 1 + n/2-1= n/2，指向了中心node**
* 如果n是奇数，faster_pointer最终会跳到最后一个node，（n-1）/2次，slow_pointer从head开始，跳这么多次，到（n-1）/2+1 == （n+1)/2，指向中间的元素。
* 

