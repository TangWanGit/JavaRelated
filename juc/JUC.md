思考题
1. A线程正在执行一个对象中的同步方法，B线程是否可以同时执行同一个对象中的非同步方法？
    可以，synchronized只锁住当前对象，并不影响其他非同步方法

2：同上，B线程是否可以同时执行同一个对象中的另一个同步方法？
    不可以，因为synchronized会锁住当前对象，而当前对象只能被一个线程锁住
    
3：线程抛出异常会释放锁吗？
    会
    
4：volatile和synchronized区别？
    volatile        线程间可见性
    synchronized    同一时刻只能有一个线程锁住
    
5：写一个程序，证明AtomXXX类比synchronized更高效
    com.tangwan.juc.c4_atomicXXX.T02_AtomicVsSyncVsLongAddr

6：AtomXXX类可以保证可见性吗？请写一个程序来证明
    com.tangwan.juc.c4_atomicXXX.T01_AtomicInteger
    
7：写一个程序证明AtomXXX类的多个方法并不构成原子性
    com.tangwan.juc.c4_atomicXXX.T03_AtomicInteger_WithManyMethods
    
8：写一个程序模拟死锁
com.tangwan.juc.c0_basic.T05_DeadLock
`jstack pic`

```
Found one Java-level deadlock:
=============================
"Thread-1":
  waiting to lock monitor 0x00007fb682829748 (object 0x00000007956ffbd8, a java.lang.String),
  which is held by "Thread-0"
"Thread-0":
  waiting to lock monitor 0x00007fb682829958 (object 0x00000007955b25a8, a java.lang.Integer),
  which is held by "Thread-1"

Java stack information for the threads listed above:
===================================================
"Thread-1":
	at com.tangwan.juc.c0_basic.T05_DeadLock$DeadLock.getId(T05_DeadLock.java:51)
	- waiting to lock <0x00000007956ffbd8> (a java.lang.String)
	- locked <0x00000007955b25a8> (a java.lang.Integer)
	at com.tangwan.juc.c0_basic.T05_DeadLock$$Lambda$2/1922154895.run(Unknown Source)
	at java.lang.Thread.run(Thread.java:748)
"Thread-0":
	at com.tangwan.juc.c0_basic.T05_DeadLock$DeadLock.getName(T05_DeadLock.java:37)
	- waiting to lock <0x00000007955b25a8> (a java.lang.Integer)
	- locked <0x00000007956ffbd8> (a java.lang.String)
	at com.tangwan.juc.c0_basic.T05_DeadLock$$Lambda$1/1313922862.run(Unknown Source)
	at java.lang.Thread.run(Thread.java:748)

Found 1 deadlock.
```

9：写一个程序，在main线程中启动100个线程，100个线程完成后，主线程打印“完成”，使用join()和countdownlatch都可以完成，请比较异同。


10：一个高效的游戏服务器应该如何设计架构？
