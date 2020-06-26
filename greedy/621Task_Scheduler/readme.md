# 621. Task Scheduler
```
You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter represents a different task. 
Tasks could be done without the original order of the array. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

You need to return the least number of units of times that the CPU will take to finish all the given tasks.

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
```

写了好久结果写错了。

我从767的角度出发了，767是隔一个位置，所以，就先把A放好，每一个A之间隔一个位置，放完A，放B，每一个B之间也是隔一个位置，放到n/2隔元素后，到头了，折回来从index=1开始，继续放。

所以，我的思路就是：1===>>>n，就隔n个元素，放A，放完A再放B，每次放新元素之前都是从第一个为空的slots处开始放，中间有很多特殊情况，想了很久也以为都cover了，结果挂在了最后几个test case上，anyway方法是错的。

学习：（以下为别人的sloution，我只是再打一遍字）

* 1，贪心算法：always arrange tasks with the most frequency first，eg, we have 3A,2B,1C, and n=2, we should arrange A at first, then B,then C. Imagine there are slots and we need to arrange tasks by putting them in the slots

* 2, so ,we should put A in 0、3、6, it will look like: `A ? ? A ? ? A`. Now we use the same way to arrange B and c: `A B ? A B ? A`, THEN `A B C A B # A`, # means the idle。

* 3，到目前为止，和我的思路一样，所以，到底哪里导致我错了呢？

* 4, A separated the line into `partnum = count(A)-1` parts(小学的种树和装路灯问题，亲娘类), every part has lebgth n, so the total empty slots will be `partnum * n`, we can also get the total num of rest tasks which will be `numm
4，if there are more than one tasks with most frequency? like 3A 3B 2C: `A ? ? A ? ? A`, then `A B ? A B ? A B`, but we can see AB as X,like `X ? X ? X`. so the 
