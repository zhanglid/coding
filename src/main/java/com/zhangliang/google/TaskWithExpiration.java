package com.zhangliang.google;
/*
(高频)带时间戳expiration的hashmap以及删除expired的entry
有一堆task，有expiration time，比如1000ms之后expire。
然后实现一个generic的hashmap，能够add task，get task (如果task已经expire，就delete)。
这两个都实现了，最后要求加一个可以 自动clean up没有被get过，但是已经expire的task 
应该可以用HashMap + DoublyLinkedList，类似LRU的做法。然后​定期​从头遍历DLL，删除过期 的entry from DLL & Map。
如果对于所有task，experation是固定值的话，感觉也可以用circular array做，这样clean up会比 较快，空间也比较节省，
代码大概这样(get时不更新timestamp的写法):
*/


/**
 * get O(1), put O(1), clean O(k), S(k), k is expiration
 */
public class TaskWithExpiration {
    public TaskWithExpiration(int expiration) {

    }

    public int get(int key, int timestamp) {

    }

    public void put(int key, int val, int timestamp) {

    }

    public void clean(int timestamp) {

    }
}