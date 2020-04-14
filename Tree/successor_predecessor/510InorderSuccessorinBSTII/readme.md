# 510. Inorder Successor in BST II

**285的变形题，给的不是root，而是只给了p，但是node拥有了一个指向父节点的指针，所以，可以根据p找到root，然后调用285的方法。找到root后，把285的函数拿过来当helper()函数即可，剩下的和285一样**

