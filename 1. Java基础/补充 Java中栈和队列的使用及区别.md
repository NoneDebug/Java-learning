# `Stack` 栈

- 介绍：后进先出（LIFO），对 `Vector` 进行了继承（`Vector` 是对 `AbstractList` 的继承，与其同级的类为 `ArrayList`，`ArrayLinkedList`，`ArrayList` 是一种非同步的集合，而 `Vector` 是一种同步的集合），`Vector` 是一种允许多线程操作的集合类，`Stack` 在其基础上实现了栈的功能。
	- 压入 `push` 和 弹出 `pop`
	- 查看栈顶 `peek`
	- 用于栈中搜索元素 并发现 其距离 `top` 距离的方法 `search`
	- 查看栈是否为空：`empty()` 

| 类型 | 方法 | 描述 |
| ---- | ---- | ---- |
| `boolean` | `empty()` | 测试栈是否为空 |
| `E` | `peek()` | 不将其从栈中移除的情况下，查看栈顶的对象，栈为空时，会报 `EmptyStackException` |
| `E` | `pop()` | 删除栈顶部对象，将该对象作为此函数值返回，栈为空的时候会报 `EmptyStackException` |
| `E` | `push(E item)` | 将一个对象压入栈的顶部 |
| `int` | `search(Object o)` | 返回对象在此堆栈上的从 1 开始的位置，对象不存在会返回 -1 |

- 文档上推荐使用 `Deque` 双端队列的实现来完成 `Stack` 的操作，因为 `java` 中 `Stack` 类设计有一些问题，一般建议多实现少继承的原则，而 `Stack` 是对 `Vector` 的继承。
- 建议优先使用 `Deque` 接口，它提供了更为完整的 `LIFO` 操作


# `Queue` 单向队列

- 一个接口，无法实例化
- 介绍：除了基本的 “收集” 操作外，队列提供插入，提取和检查操作
	- 操作失败引发异常 或 返回特殊值 （`null` 或 `false`）

|  | `Throws Exception` | `Returns special value` |
| ---- | ---- | ---- |
| `Insert` | `add(e)` | `offer(e)` |
| `Remove` | `remove()` | `poll()` |
| `Examine` | `element()` | `peek()` |

- 相关方法

| 类型 | 方法 | 描述 |
| ---- | ---- | ---- |
| `boolean` | `add(E e)` | 如果可以立即将指定元素插入此队列，不会违反容量限制，则在成功时返回 `true`，如果当前没有可用空间，则抛出 `IIlegalStateException` |
| `boolean` | `offer(E e)` | 如果可以在不违反容量限制的情况下，立即将制定元素插入此队列 |
| `E` | `element()` | 检索但不删除队列的头|
| `E` | `peek()` | 检索但不删除队列的头 |
| `E` | `poll()` | 检索并删除此队列的头部，如果此队列为空，则返回 `null`|
| `E` | `remove()` | 检索并删除队列的头|


# `Deque` 双端队列/栈

- 介绍：双端队列的接口，使用最多的队列，既可以当作栈 也可以当作队列使用
- `Deque` 支持双端插入和删除元素的线性组合，`double ended queue` 的缩写，大多数 `Deque` 对它们可能包含的元素数量没有固定限制，**但本接口支持容量受限的双端队列以及没有固定大小限制的栓孤单队列，** 所有方法以两种形式存在：一种在操作失败时，引发异常，另一种返回一个特殊值（`null` 或 `false`）。

- 头部操作

|  | `Throws exception` | `Returns special value` |
| ---- | ---- | ---- |
| `Insert` | `addFirst(e)` | `offerFirst(e)` |
| `Remove` | `removeFirst()` | `pollFirst()` |
| `Examine` | `getFirst()` | `peekFirst()` |
- 尾部操作

| |`Throws exception`|`Returns special value`|
|---|---|---|
|`Insert`|`addLast(e)` |`offerLast(e)` |
|`Remove`|`removeLast()` |`pollLast()` |
|`Examine`|`getLast()` |`peekLast()` |

- 因为 `Deque` 是对 `Queue` 的实现，因此 `Queue` 中定义的一些方法有和其自定义等价的方法

| `Queue` 方法 | 等价 `Deque` 方法 |
| ---- | ---- |
| `add(e)` | `addLast(e)` |
| `offer(e)` | `offerLast(e)` |
| `remove()` | `removeFirst()` |
| `poll()` | `pollFirst()` |
| `element()` | `getFirst()` |
| `peek()` | `peekFirst()` |

- `Deque` 也可实现后进先出的堆栈功能，此接口优于旧版 `Stack` 的使用，它 和 `Stack` 没什么关系（无继承的父子关系），但是它变相实现了 `Stack` 的 功能。

| `Stack` 方法 | 等价 `Deque` 方法 |
| ---- | ---- |
| `push(e)` | `addFirst(e)` |
| `pop()` | `removeFirst()` |
| `peek()` | `peekFirst()` |
- `Deque` 的实现类与很多，不考虑多线程的话，使用 `ArrayDeque` `LinkedList` 就足够了

#  `PriorityQueue` 优先级队列/堆

- 基于优先级堆的无界优先级队列，根据自然顺序或在队列构造时提供的 `Comparator` 进行排序，具体取决于所使用的构造函数。不允许空元素，依赖自然顺序的优先级队列也不允许插入不可比较的对象，否则会引起 `ClassCastException`
- `PriorityQueue` 是一个优先级队列，需要堆的时候就可以使用 `PriorityQueue`，当作堆进行使用，因为 `PriorityQueue` 继承自 `AbstractQueue`，而 `AbstractQueue` 继承自 `Queue`，所以它和 `Queue` 的方法差不多，



# 栈 和 队列的区别



## 数据的插入、删除

- 栈：特殊线性表，只能在一端进行 插入和删除，进行插入和删除的位置称为栈顶，无法进行插入删除操作的一端称为 栈底，符合 先进后出（FILO）。
- 队列：在一端（队头）进行插入，另一端（队尾）进行删除。

## 遍历速度

- 栈：遍历时需要额外开辟空间，以保证数据在遍历时不会被打乱（使用数组或另一个栈保存）
- 队列：能基于指针进行遍历，可以从队头/队尾开始遍历，不需要另外开辟空间来保证数据的顺序，不影响数据结构，因此速度更快。

## 使用场景

- 栈：具有记忆能力，适用于括号求解、表达式转换、函数递归和调用的实现、深度优先搜索遍历、浏览器后退功能，需要记忆原来数据内容的场景。
- 队列：可以进行有顺序的处理，如计算机系统各种资源的管理、消息缓冲器的管理、广度优先搜索等场景。


# 总结

- 不考虑多线程情况
	- 使用栈：`Deque` 的实现类（`LinkedList`、`ArrayQue`）
	- 使用队列：`Deque` 的实现类（同上）
	- 使用堆：`PriorityQueue`

