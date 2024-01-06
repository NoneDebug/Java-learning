
# 集合框架体系

- 集合的理解和好处：
	- 数组
		- 长度开始时必须指定，一旦指定，不能直接更改
		- 保存的必须为同一类型的元素
		- 使用数组进行增加/删除元素，需重新开辟新空间扩容，非常麻烦
	- **集合**
		- 可以动态保存任意多个对象，使用比较方便
		- 提供了一系列方便的操作对象的方法：`add`，`remove`，`set`，`get`

## 集合组成

- 集合
	- `Collection`
		- `List`
			- `ArrayList`
			- `LinkedList`
			- `Vector`
		- `Set`
			- `HashSet`
			- `TreeSet`
	- `Map`
		- `HashMap`
			- `LinkedHashMap`
		- `TreeMap`
		- `Hashtable`
			- `Properties`

## 注意事项

- 集合主要是两组（单列集合，双列集合）
- `Collection` 接口有两个重要的子接口 `List` 和 `Set`，它们的实现子类都是单列集合
- `Map` 接口的实现子类是双列集合，存放的 `K-V`


# `Collection`

## `Collection` 接口 特点 方法

### 特点

- `collection` 实现子类可以存放多个元素，每个元素可以是 `Object`
- 有些`Collection`的实现类，可以存放重复的元素，有些不可以
- 有些`Collection`的实现类，有些是有序的(`List`)，有些不是有序的(`Set`)
- `Collection`接口没有直接的实现子类，是通过它的子接口 `Set` 和 `List` 来实现的

### 方法

- `add`：添加单个元素
- `remove`：删除指定元素
- `contains`：查找元素是否存在
- `size`：判断是否为空
- `clear`：清空
- `addAll`：添加多个元素（以列表元素作为参数传入）
- `containsAll`：查找多个元素是否都存在（以列表元素作为参数传入）
- `removeAll`：删除多个元素（以列表元素作为参数传入）


### 遍历元素方式

- 方式1：使用`Iterator`（迭代器）
	- `Iterator` 对象称为迭代器，主要用于遍历 `Collection` 集合中的元素
	- 所有实现了 `Collection` 接口的集合类都有一个 `iterator` 集合，用以返回一个实现了 `Iterator` 方法，用以返回一个实现了 `Iterator` 接口的对象，即返回了一个迭代器
	- `Iterator` 的结构
	- `Iterator` 仅用于遍历集合，`Iterator`本身并不存放对象

	```
	Iterator iterator = coll.iterator();
	//hasNext(): 判断是否还有下一个元素
	while(iterator.hasNext()){
		//next():指针下移，将下移后集合位置上的元素返回
		System.out.println(iterator.next());
	}
	```
	
	  - Iterator接口的方法
		  - `hasNext()`：如果迭代中有更多的元素，返回 `true`，否则返回 `false`
		  - `next()`：返回迭代中的下一个元素
		  - `remove()`：移除迭代器中返回的最后元素
	
	- 注意事项：在调用 `iterator.next()` 方法之前必须要调用 `it.hasNext()` 进行检测。若不调用，且下一条记录无效，直接调用 `it.next()` 会抛出 `NoSuchElementException`异常


- 方式2：使用 `for`循环增强
	- 增强`for`循环，可以代替 `iterator`迭代器，特点：增强 `for` 就是简化版的 `iterator`，本质一样，只能用于遍历 集合 或 数组
	- 基本语法：
		- `for(元素类型 元素名: 集合名 或 数组名){访问元素}`


## `Collection` 接口的子接口: `List` 实现类: `ArrayList`、`LinkedList`、`Vector`

### `List` 接口基本介绍

- `List` 集合类中元素有序（添加顺序和取出顺序一致）、且可重复
- `List` 集合中的每个元素都有对应的顺序索引，即支持索引
- `List` 容器中的元素都对应一个整数型的序号记载在其容器中的位置，可以根据序号存取容器中的元素

- 实现类有
	- `ArrayList`
	- `LinkedList`
	- `Vector`

- 相关方法
	- `add(int index, element)` ：向索引 `index` 中插入元素 `element`
	- `addall(int index, list)`：向索引 `index` 中插入整个列表 `list`
	- `indexOf(element)`：查找 `element` 元素首次出现的索引
	- `lastIndexOf(element)`：查找 `element` 元素最后一次出现的索引
	- `set(index, element)` ：将 `index` 上元素置换为 `element`
	- `subset(int fromIndex, int toIndex)`：返回 `fromIndex` 到 `toIndex` 的子集（左闭右开）


### `List` 的三种遍历方式

- 使用 `iterator`
- 使用增强 `for`
- 使用普通 `for`

- 说明：`LinkedList` 的使用方式和 `ArrayList` 相同

### `ArrayList` 的注意事项

- permits all elments, including null, ArrayList 可以加入 `null`，而且多个
- `ArrayList` 是由数组来实现数据存储的
- `ArrayList` 基本等同于 `Vector`，除了 `ArrayList` 是线程不安全的（没有`synchronized`，执行效率高），在多线程情况下，不建议使用 `ArrayList`


### `ArrayList` 底层结构 和 源码分析

- `ArrayList` 中维护了一个 `Object` 类型的数组 `elementData`
	- `transient Object[] elementData;`
	- `transient`：瞬间，短暂的，表示该属性不会被序列化
- 当创建对象时，如果使用的是无参构造器，则初始的 `elementData` 容量为 0(`jdk7` 是10)
- 当添加元素时，先判断是否需要进行扩容，如果需要扩容，则调用 `grow` 方法，否则直接添加元素到合适位置
- 如果使用的是无参构造器，如果第一次添加，需要扩容的话，则扩容 `elementData` 为10，如果需要再次扩容，则扩容 `elementData` 为1.5倍
- 如果使用的是指定容量 `capacity` 的构造器，初始 `elementData` 容量为  `capacity`
	- 如果需要扩容，直接扩容 `elementData` 为 1.5倍


### `Vector` 的基本介绍

- `Vector`类的定义，继承的是 `List`类，实现了`Serializable` 和 `Comparable` 接口
- `Vector`底层也是一个对象数组， `protected Object[] elementData;`
- `Vector` 是线程同步的，即线程安全，`Vector`类的操作方法带有 `synchronized`
- 开发中，如果需要线程同步安全时，考虑适用`Vector`

#### `Vecotr` 底层结构 和 `ArrayList`的比较

|  | 底层结构 | 版本 | 线程安全（同步）效率 | 扩容倍数 |
| ---- | ---- | ---- | ---- | ---- |
| `ArrayList` | 可变数组 | `jdk1.2` | 不安全，效率高 | 有参构造1.5倍；无参构造首次为10，后续为1.5倍扩容 |
| `Vector` | 可变数组 | `jdk1.0` | 安全，效率不高 | 无参，默认为10，满后2倍扩容；指定大小每次直接2倍扩容 |

### `LinkedList` 底层结构

- `LinkedList` 实现了双向链表 和 双端队列特点
- 可以添加任意元素（元素可以重复），包括 `null`
- 线程不安全，没有实现同步

### `LinkedList`底层结构

- 底层维护了一个双向链表
- `LinkedList`中维护了2个属性 `first` 和 `last` 分别指向首节点和尾节点
- 每个节点(`Node`对象)，里面又维护了 `prev`、`next`、`item`三个属性，其中通过 `prev`指向前一个，通过`next`指向后一个，最终实现双向链表
- 所以 `LinkedList` 的元素的添加和删除，不是通过数组完成的，相对来说效率较高

- 相关方法
	- `add(Node n)`：向链表中加入节点`n`
	- `remove(int index)`：删除第 `index` 号节点
		- `remove(Object o)`：删除 `o`节点（需要进行类别的比较）
		- `remove()`：删除第一个节点
	- `set(int index, element e)`：将 `index` 号节点设置为 `e`
	- `get(int index)`：获得 第 `index` 号节点的元素值


### `ArrayList` 和 `LinkedList` 的比较
|  | 底层结构 | 增删的效率 | 改查的效率 |
| ---- | ---- | ---- | ---- |
| `ArrayList` | 可变数组 | 较低，数组扩容 | 较高 |
| `LinkedList` | 双向链表 | 较高，通过链表添加 | 较低 |
- 如果改查多，使用 `ArrayList`
- 如果增删多，使用 `LinkedList`
- 一般来说，程序中，大多数采用查询，因此大部分情况采用 `ArrayList`
- 在一个项目中，根据业务灵活选择，也可能是这样，一个模块使用的是 `ArrayList`，另一个模块使用的是 `LinkedList`

## `Collection` 接口的子接口: `Set` 实现类: `HashSet`、`LinkedHashSet`

### `Set` 接口基本介绍

- 无序（添加和取出的顺序不一致），没有索引
- 不允许重复元素，最多包含一个 `null`
- 常见的实现类：`HashSet`、`TreeSet`
- 由键值对 K-V组成，但是和 `Map` 不同的地方在于 `Set` 的 `V` 是一个名为 `present` 的常量，由所有 `V` 共享；`Map`中的 `V` 则由用户给定

### `Set` 接口常用方法

- 和 `List` 接口一样，`Set`接口也是 `Collection`子接口，因此，常用方法和 `Collection` 接口一样

### `Set` 接口的遍历方式

- 同 `Collection` 的遍历方式一样，因为`Set`接口是 `Collection` 接口的子接口
	- 可以使用迭代器
	- 增强 `for`
	- **不能使用** 索引的方式来获取（普通`for循环`不能遍历`Set`接口）

### `HashSet`

#### 全面说明

- 实现了 `Set` 接口
- 实际上是 `HashMap`
- 可以存放 `null` 指，但只能有一个 `null`
- 不保证元素是有序的，取决于 `hash` 后，再确定索引的结果
- 不能有重复元素/对象

#### 底层机制

- `HashSet` 底层是 `HashMap`，`HashMap` 底层是（数组 + 链表 + 红黑树）
	- 数组存放初始节点（对应`Hash`索引值）
	- 每个节点开始往后，逐个连接节点，形成一条链表
		- 当链表长度达到一定量时，形成一个红黑树

- 原理
	- `HashSet` 底层是 `HashMap`
	- 添加一个元素时，先得到 `hash`值，会转成索引值
	- 找到存储数据表 `table`，看这个索引位置是否已经存放的有元素
		- 如果没有，直接加入
		- 如果有，调用 `equals`比较，如果相同，则放弃添加，如果不相同，则添加到最后
	- 在 `Java8` 中，如果一条链表的元素个数到达 `TREEIFY_THRESHOLD`（默认是8），并且 `table` 的大小 >= `MIN_TREEIFY_CAPACITY`（默认是64），就会进行树化

### `LinkedHashSet`

#### 全面说明

- `LinkedHashSet` 是 `HashSet` 的子类
- `LinkedHashSet` 底层是一个 `LinkedHashMap`，底层维护了一个 数组 + 双向链表
- `LinekdHashSet` 根据元素的 `hashCode` 值 决定元素的存储位置，同时使用链表维护元素的次序，使得元素看起来以插入顺序保存
- `LinkedHashSet` 不允许添加重复元素

- `LinkedHashSet` 中维护了一个 `hash` 表 和 双向链表（`LinkedHashSet` 有 `head` 和 `tail`）
- 每一个节点有 `before` 和 `after` 属性，形成双向链表
- 添加一个元素时，先计算 `hash` 值，再求索引，确定其在 `table` 中的位置，然后将添加的元素加入到双向链表中去（如果已经存在，不添加）

### `TreeSet`

- 与 `HashSet` 的区别：可排序
- 默认按照字母来排序
- 可使用接口编程的方式来实现指定标准排序



# `Map`
## `Map` 接口 特点 方法

### 特点

- `Map` 和 `Collection` 并列存在，用于保存具有映射关系的数据：`Key-Value`
- `Map` 中的 `Key` 和 `Value` 可以是任何引用类型的数据，会封装到 `HashMap$Node` 对象中
- `Map` 中的 `Key` 不允许重复，原因和 `HashSet`一样
- `Map` 中的 `Value` 可以为 `null`，`key`也可以为 `null`，`key`为 `null`，只能有一个
- `Map` 的 `value` 可以重复
- 常用 `String` 类作为 `Map` 的 `key`
- `key` 和 `value` 之间存在单向一对一关系，即通过指定的 `key` 总能找到对应的 `value`

- 当有相同的 `key`，但对应的 `value` 不同，就等价于用新 `value` 替换 旧 `value`
- `MAP` 存放数据的 `key-value`结构为：一对 `k-v` 放在一个 `Node` 中，因为 `Node` 实现了 `Entry` 接口（一对 `k-v` 实现了一个 `Entry`） 
	- `k-v` 为了方便程序员的遍历，还会创建 `EntrySet` 集合，该集合存放的元素的类型 为 `Entry`，一个 `Entry` 对象有 `k,v EntrySet<Entry<K,V>>`，即 `transient Set<Map.Entry<K,V>> entrySet;`
	- 底层：`k-v`存放在 `HashMap$Node` 中，该`HashMap$Node`存放在 `entry`中，`entry`的具体类型为 `Set<Map.Entry<K, V>>`，其包含一个 `Set` 和 `Collection`，分别存放各 `key-value` 的引用。


### 常用方法

- `Map`接口 的具体实现
	- `Hashtable`
		- `Properties`
	- `HashMap`
		- `LinkedHashMap`
	- `SortedMap`（一个接口）
		- `TreeMap`

- `Map`接口 的常用方法
	- `put`：添加
	- `remove`：根据键删除映射关系
	- `get`：根据键获取值
	- `size`：获取元素个数
	- `clear`：清除
	- `containsKey`：查找键是否存在

- `Map` 接口的 遍历方法
	- 因为 `Map` 中 `Entry` 本质上由 `Set` 和  `Collection` 构成，因此遍历所有键值对需要同时遍历 `Set` 和 `Collection`





## `Map` 接口的实现类：`HashMap`、`Hashtable`等

### `HashMap`

#### `HashMap` 小结

- `Map` 接口的常用实现类：`HashMap`、`Hashtable` 和 `Properties`
- `HashMap` 是 `Map` 接口使用频率最高的实现类
- `HashMap` 是以 `key-val` 对的方式来存储数据
- `key` 不能重复，但是值可以重复，允许使用 `null` 键 和 `null` 值
- 如果添加相同的 `key` ，则会覆盖原来 `key-val`，等同于修改（`key`不会替换，`val`会替换）
- 与 `HashSet` 一样，不保证映射的顺序，等同于修改
- `HashMap` 没有实现同步，因为线程是不安全的

#### `HashMap` 底层机制 及 源码剖析

- `HashMap` 的扩容机制
	- `HashMap`底层维护了 `Node` 类型的数组`table`，默认为 `null`
	- 创建对象时，将加载因子(loadfactor)初始化为0.75
	- 添加 `key-val`时，通过 `key` 的哈希值得到在 `table` 的索引。然后判断该索引处是否有元素，如果没有元素直接添加。如果该索引处有元素，则继续判断该元素 `key` 是否和准备加入的 `key` 相等，如果相等，则直接替换 `val`；如果不相等需要判断是树结构还是链表结构，做出相应处理。如果添加时发现容量不够，则需要扩容。
	- 第一次添加，需要扩容 `table` 容量为 16，临界值(threshold)为12。
	- 以后再扩容，则需要扩容 `table` 容量为原来的2倍，临界值为原来的2倍，即24，以此类推
	- `Java8` 中，如果一条链表的元素个数 `> TREEIFY_THRESHOLD`（默认是8），并且 `table`的大小 `>= MIN_TREEIFY_CAPACITY`（默认64），就会进行树化（红黑树）。 
	- 扩容是因为 (两种情况)
		- 添加的元素超过  `TREEIFY_THRESHOLD`（默认是8）。
		- 前者已经树化，而修改次数超过阈值（修改次数 >= 数组大小 * 加载因子）

### `Hashtable`

#### 基本介绍

- 存放的元素是键值对 `k-v`
- `Hashtable` 的 键 和 值都不能为 `null`
- `Hashtable` 使用方法基本上 和 `HashMap` 一致
- `Hashtable` 是线程安全的， `HashMap` 是线程不安全的
- 底层数组为 `Hashtable$Entry[]`，初始化大小为11
- 临界值 `threshold 8 = 11 * 0.75`
- 扩容：按照自己的扩容机制来扩容
	- 每次扩容为原来的2倍 + 1


#### `Hashtable` 和 `HashMap` 对比

|  | 版本 | 线程安全（同步） | 效率 | 允许 `null`键 `null`值 |
| ---- | ---- | ---- | ---- | ---- |
| `HashMap` | 1.2 | 不安全 | 高 | 允许 |
| `Hashtable` | 1.0 | 安全 | 较低 | 不允许 |
 

### `Properties`

#### 基本介绍

- `Properties` 类继承自 `Hashtable` 类并实现了 `Map` 接口，也是一种键值对的形式来保存数据
- 使用特点 和 `Hashtable` 类似
- `Properties` 可以用于 从 xxx.properties文件中，加载数据到 `Properties` 类对象，并进行读取和修改
- 工作后 xxx.properties 文件通常作为配置文件。

### `TreeMap`

- 在 `TreeSet` 的基础上使用键值对作为元素


# 开发中对集合实现类的选择

- 先判断存储类型（一组对象 或 一组键值对）
	- 一组对象：`Collection` 接口
		- 允许重复：`List`
			- 增删多：`LinkedList`【底层维护一个双向链表】
			- 改查多：`ArrayList`【底层维护 `Object`类型的可变数组】
				- 需要线程安全，使用 `Vector`
		- 不允许重复：`Set`
			- 无序：`HashSet`【底层是`HashMap`，维护一个哈希表】
			- 排序：`TreeSet`
			- 插入和取出顺序一致：`LinkedHashSet`，维护数组 + 双向链表
	- 一组键值对：`Map`
		- 键无序：`HashMap`【底层是：哈希表】
			- jdk7：数组 + 链表
			- jdk8：数组 + 链表 + 红黑树
		- 键排序：`TreeMap`
		- 键插入和取出顺序一致：`LinkedHashMap`
		- 读取文件：`Properties`



# `Collections`
## `Collections` 工具类的使用 

### 介绍

- 操作 `Set`、`List` 和 `Map` 等集合的工具类
- `Collections` 中 提供了一系列静态的方法对集合元素进行排序、查询 和 修改等操作

### 排序方法

- `reverse`：反转 集合中元素
- `shuffle`：对 集合中元素进行随机排序
- `sort`：按照元素自然顺序对集合中元素进行升序排序
- `sort(collection, Compartor)`：根据指定的 `Comparator` 对 集合元素进行排序
- `swap(list, int, int)`：将`list`中 i 处元素 和 j 处元素

### 查找、替换方法

- `max(Collection)`：根据元素的自然排序，返回给定集合中的最大元素
- `max(Collection, Comparator)`：根据 `Comparator` 指定顺序，返回给定集合中的最大元素
- `min(Collection)`：和上面类似
	- `min(Collection, Comparator)`
- `int frequency(Collection, Object)`：返回指定集合中指定元素的出现次数
- `void copy(List dest, List src)`：将 `src` 内容复制到 `dest` 中
- `boolean replaceAll(list list, Object oldVal, Object newVal)` ：使用新值替换 `List` 对象的所有旧值
