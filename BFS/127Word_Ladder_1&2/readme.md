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

转化为graph，startword是源node，endword是终点，需要找到**源到终点的最短路径，**每一个转换得到的单词就是graph中的node。
> We will essentially be working with an undirected and unweighted graph with words as nodes and edges   
between words which differ by just one letter.The problem boils down to finding the shortest path from a start node to a destination node,if there exists one.

最重要的一步是：如何找到相邻的node which和当前的node只有一个字母的区别。为此，To efficiently find the neighboring nodes for any given word we do some pre-processing on the words of the given wordList

预处理：将单词
