# 231. Power of Two

求一个数是不是2的次方

##递归法：
**base case：
* n= 0,false;
* n=1, true,0次方
* n= 奇数，false;
然后剩下的数，我们只需要看n/2是不是2的次方即可，同命运
