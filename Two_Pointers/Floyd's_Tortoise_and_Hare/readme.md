# Floyd's Tortoise and Hare for detect a loop link

> Imagine two runners running on a track at different speed. What happens when the track is actually a circle?  
 case A： The fast runner is just one step behind the slow runner. In the next iteration, they both increment one and two steps respectively and meet each other.  
we have not considered cases where the fast runner is two or three steps behind the slow runner yet. This is simple, because in the next or next's next iteration, this case will be reduced to case A mentioned above.  
总有一天快的那个人会遇到慢的那个人，不过快的那个人可能已经比慢的人多跑好几圈了。

** 相关题目： ： 287. Find the Duplicate Number，141. Linked List Cycle,142. Linked List Cycle II **
