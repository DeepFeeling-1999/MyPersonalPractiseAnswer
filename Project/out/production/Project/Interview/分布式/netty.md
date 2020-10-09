## linux 网络I/O模型

### 1. 阻塞IO

### 2. 非阻塞IO

### 3. IO复用模型

比多线程开销小，**一个线程**管理多个io操作。

#### select/poll、epoll

**select**：每次调用将监视的文件描述符集合发送给内核（数据拷贝，数组长度1024个），内核来遍历该集合的内容，如果某个IO状态改变，则返回给调用select的进程。

**poll**：poll修改了文件描述符集合的描述方式（链表），使得可以发送1024以上的文件描述符。

**epoll**：调用epoll_ctl时拷贝进内核并保存（红黑树，添加删除只需要传入fd就行），调用wait不拷贝，利用事件回调机制将就绪的fd放入准备队列（双向链表）中。除了都有水平触发以外，epoll还支持边缘触发。

select/poll顺序扫描fd是否准备就绪；epoll用基于事件驱动方式代替顺序扫描，有fd就绪时，立即触发回调函数。

### 4. 信号驱动IO模型

类似于发布订阅机制，发布一个消息，当fd准备好时，发送一个信号给应用程序，通知对方来读数据

### 5. 异步IO

## 同步、异步

同步：程序1调用程序2时，必须等程序2执行完返回的结果才能继续下一步。

异步：程序1调用程序2时，不必等程序2执行的结果，程序1继续往下执行。

## 阻塞、非阻塞

阻塞：当某个程序调用一个资源时，若资源没准备好，会阻塞当前的调用操作。

非阻塞：当某个程序调用一个资源时，若资源没准备好，不会阻塞当前的调用操作，会立即返回表示没准备好。

## 教程

### Netty是什么

Netty 是一款基于 NIO（Nonblocking I/O，非阻塞IO）开发的网络通信框架

* **高并发**：基于nio开发，同时封装了nio的细节，更易于调用
* **零拷贝**：bytebuffer使用堆外内存进行socket读写，不需要多次拷贝，使用transferto方法直接将文件缓冲区的数据发到channel中

### 解决tcp粘包、拆包

#### 1. LineBasedFrameDecoder + StringDecoder

```java
arg0.pipeline().addLast(new LineBasedFrameDecoder(1024));
arg0.pipeline().addLast(new StringDecoder());
arg0.pipeline().addLast(new Handler());
```

参数1024的表示单条消息的最大长度，达到该长度仍然没有找到分隔符，就抛出异常。要求读数据时，读到的是string，而非缓冲区

```java
public void channelRead(ChannelHandlerContext ctx, Object msg)throws Exception{
        String buf = (String) msg;
        dosomething;
}
```

发送消息时，每个消息末尾要加换行符``` System.getProperty("line.separator")```

#### 2. DelimiterBasedFrameDecoder + StringDecoder

根据指定的分隔符

```java
arg0.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,
ByteBuf delimiter));
arg0.pipeline().addLast(new StringDecoder());
arg0.pipeline().addLast(new Handler());
```

#### 3. FixedLengthFrameDecoder + StringDecoder

无论一次接收到多少数据报，都会按照固定长度解码。如果收到半包，则先缓存并等待下个包到达后拼包。

### netty信息流模型

一个channel有一个pipeline，pipeline中按照顺序编排好inboundHandler和outBoundHandler，调用```ctx.channel().write()```时，消息从最后一个outboundhandler依次经过前面的outboundhandler，调用```ctx.write()```时，从当前handler之前的outboundhandler发送。

### 默认情况 Netty 起多少线程？何时启动？

Netty 默认是 CPU 处理器数的两倍，bind 完之后启动。

**启动流程**：

1. 初始化channel，并且注册到selector，设置对外监听的channelhandler为acceptor
2. bind操作，回调active事件

## Reactor模式

* 事件驱动
* 有多个请求输入
* 一个请求分发器
* 一个或多个请求处理器

当请求输入时，驱动分发器，根据请求事件类型转发给相应的请求处理器。

优点：

* **关注点分离：**Reactor模式将与应用程序无关的分解复用和调度机制与特定于应用程序的挂钩方法功能分离。
* **改进事件驱动的应用程序的模块化，可重用性和可配置性：**该模式将应用程序功能分离为单独的类。
* **提高了应用程序的可移植性：**该发起分派器的接口可以独立于OS的系统调用执行事件多路分离的可重复使用。
* **提供粗粒度的并发控制：**Reactor模式在流程或线程内的事件多路分解和分派级别上序列化事件处理程序的调用.

## Java NIO

**Selector**类封装了操作系统提供的同步事件多路分解器功能。

## netty线程模型

netty服务器有两个NIO线程池，bossgroup用于处理新建立连接请求，完成accept操作，然后将建立的连接轮询交给workergroup中的一个eventloop处理。

### NIOEventLoopGroup

可以指定具体线程数，默认为cpu内核数*2或CPU内核+1。不要把I/O线程数设置得过大，除了会导致线程竞争加剧，还会带来其他副作用。

NioEventLoopGroup对象中有一组EventLoop数组，并且数组中的每个EventLoop对象都对应一个线程FastThreadLocalThread。

EventLoop执行死循环，1、首先轮询注册到reactor线程对应的selector上的所有的channel的IO事件。2、处理IO事件。3、处理异步任务队列。

ServerChannel 相关联的 EventLoopGroup 将分配一个 负责为传入连接请求创建Channel 的 EventLoop。一旦连接被接受，第二个 EventLoopGroup 就会给它的Channel分配一个 EventLoop。

* 一个 EventLoopGroup 包含一个或者多个 EventLoop；

* 一个 EventLoop 在它的生命周期内只和一个 Thread 绑定；
* 所有由 EventLoop 处理的 I/O 事件都将在它专有的 Thread 上被处理；
* 一个 Channel 在它的生命周期内只注册于一个 EventLoop；
*  一个 EventLoop 可能会被分配给一个或多个 Channel。

### eventLoop

eventLoop是一个reactor模型的事件处理器，一个EventLoop对应一个线程，内部维护一个selector和taskqueue，负责处理客户端请求和内部任务。

线程管理：

EventLoop.inEventLoop(Thread)判断当前线程是否是分配给当前EventLoop的线程，如果是，那么直接执行对应的代码块；反之则将任务放入内部队列中等待。这样保证了一个channel只在一个线程中执行，实现了数据同步性。每个EventLoop都有自己的任务队列。

