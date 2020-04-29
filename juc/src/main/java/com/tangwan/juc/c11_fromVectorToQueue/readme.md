同步容器类

1. Vector Hashtable：早起使用synchronized实现
2. ArrayList HashSet：未考虑多线程安卓（未实现同步）
3. HashSet vs  Hashtable ， StringBuilder vs StringBuffer
4. Collections.synchronized*** 工厂方法使用的也是synchronized

使用早期的同步容器以及Collections.synchronized***方法的不足之处，请阅读：
http://blog.csdn.net/itm_hadf/article/details/7506529

使用新的并发容器
http://xuganggogo.iteye.com/blog/321630


## 不足之处：
### Hashtable
Hashtable的所有方法都是同步的。此时，无竞争的同步会导致可观的性能代价


Hashtable和synchronizedMap所采取的获得同步的简单方法（同步Hashtable中或者同步的Map包装器对象中的每个方法）有两个主要的不足。
- 首先，这种方法对于可伸缩性是一种障碍，因为一次只能有一个线程可以访问hash表。
- 同时，这样仍不足以提供真正的线程安全性，许多公用的混合操作仍然需要额外的同步。

虽然诸如get()和put()之类的简单操作可以在不需要额外同步的情况下安全地完成.
但还是有一些公用的操作序列，例如迭代或者put-if-absent（空则放入），需要外部的同步，以避免数据争用。

有条件的线程安全性同步的集合包装器 synchronizedMap和synchronizedList:
有时也被称作有条件地线程安全――所有单个的操作都是线程安全的.
但是多个操作组成的操作序列却可能导致数据争用，因为在操作序列中控制流取决于前面操作的结果。


