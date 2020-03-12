# 155. Min Stack

**自己的方法用了2674ms，后来学习后用时5ms。。。。。**

```
比普通的stack多了一个函数：
getMin() -- Retrieve the minimum element in the stack.
```
一开始的方法是：minStack就是一个普通的官方stack，但是多了一个遍历最小值的函数:
* 结果：速度和内存都超级差

思考：从构造上就追踪最小值？类似于list中的追踪size?
* push()增加新元素的时候，追踪最小值很简单：新值< min, 更新min，否则不更新
* pop()删除最上边的元素的时候：如果删除的是最小值，如果及时将min更新为删除后的最小值/删除前的倒数第二个小值？？？
* 创建了另一个strack追踪一个个的min，老min永远最后被pop出去，新min永远在老min上边，所以当当前min被pop出去后，minstack中的下一个min即当前min出现前的min一定会是剩下的元素中的min
