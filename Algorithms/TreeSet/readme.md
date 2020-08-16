# TreeSet

一直需要用到set的地方，都是用的hashset，还没有遇到过用treeset的情况

直接上常见用法吧：

### add(E e):
将元素加入到此set中，如果此set不存在该元素，并且返回true，否则没发挥false。

### addAll(Collection<? extends E> e):
将指定 collection 中的所有元素添加到此 set 中。

### ceiling(E e):
返回大于等于e的最小的元素。如果不存在这样的元素，则返回 null。

### floor(E e):
返回set中小于或等于元素e的最大的元素。如果不存在这样的元素，则返回 null。

### contains(Object O):
返回是否该set包含元素o

### higher(E e):
返回严格大于e的最小元素，如果不存在返回null

### lower(E e):
返回严格小于e的最大元素，如果不存在就返回null。

### remove(E e)：
如果e存在于该set中，就将e移除，返回true

### isEmpty():

### 
