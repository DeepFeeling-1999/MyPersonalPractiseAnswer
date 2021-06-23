CAS即Compare and swap，是jdk提供的非阻塞原子性操作，是通过硬件来
保证（比较————更新）的原子性
比如 boolean compareAndSwapLong（Object obj, long valueOffset, long expect, long update）方法
就是对象obj中内存偏移量为valueOffset的变量值为expect，则使用新的update替换旧的
这是处理器提供的一个原子性指令

CAS中有ABA问题，就是线程一进行比较的时候，线程二对A操作，使A变成B后又改回A
其中最终A还是A，但是中间可能做的一些操作使状态不一样，但是线程一还是认为状态一致，使CAS成功
ABA问题可以使用AtomicStampedReference给每个变量配一个时间戳来解决

使用AtomicLong时，在高并发下大量线程同时去竞争同一个原子变量，
但同时只有一个线程的CAS操作会成功，造成大量线程CAS失败后会无限循环
进行自旋操作尝试CAS,会浪费CPU资源
后在LongAdder中通过cell数组解决这个问题


@sun.misc.Contended注解，用来解决伪共享问题
可用来修饰类或变量


