## 如何遍历map?
遍历map有四种方法：
* 在for-each循环中，使用entries来遍历：使用entrySet(),Entry.getKey(),Entry.getValue()
```java
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
 
    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
 
}
```
* 使用keySet()得到key的集合，使用values()得到value的集合
* 通过key去找value：先通过keySet()，遍历这个set，然后用get(key)遍历value----**这个方法效率较低**
* 使用迭代器iterator,和1一样，在map.entrySet()上建立iterator
