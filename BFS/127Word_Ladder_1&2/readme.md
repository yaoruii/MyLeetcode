# 127. Word Ladder
```
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

将开始的单词转换成结束的单词，每次只转换一个字母，每次转换的结果必须要在wordlist中才行
```
# BFS：graph寻找最短路径
转化为graph，startword是源node，endword是终点，需要找到**源到终点的最短路径，**每一个转换得到的单词就是graph中的node。
> We will essentially be working with an undirected and unweighted graph with words as nodes and edges   
between words which differ by just one letter.The problem boils down to finding the shortest path from a start node to a destination node,if there exists one.

最重要的一步是：如何找到相邻的node which和当前的node只有一个字母的区别。为此，使用“x”取代单词中的字母，```Dog ----> D*g <---- Dig```
> To efficiently find the neighboring nodes for any given word we do some pre-processing on the words of the given wordList

比如，进行bfs的时候，为了找到Dug这个单词的相邻节点，我们首先得到dug的generic forms：```1,Dug => *ug```，```2,Dug => D*g```，```3,Dug => Du*```。将wordlist的单词进行预处理：
* 找到每一个单词的generic states，然后将generic forms放入到map中作为keys，value as the list of words which has the same generic form.

**do BFS :**
* 将(startword，1)放入到队列中，1代表一个node的level number，the endword的level就是最短路径的值
* 为了避免cycle，对遍历过的node进行marked
* 只有队列不为空，就POP出一个元素，1:获取它的所有未被标记的相邻的元素curr，2:标记、入队列、action。
   * 1:得到该单词curr的所有的generic forms，check是否这些forms也是wordlist中某些单词的generic form，如果是，说明wordlist中存在和该单词curr只有一个字母不同的单词
   * 如何实现：checking the all_combo_dict.也就是预处理时生成的map。
   * 2:如果存在，那么该target就是curr的邻居，将其放入到队列中。
* 循环直到队列为空。

## bidirection bfs










