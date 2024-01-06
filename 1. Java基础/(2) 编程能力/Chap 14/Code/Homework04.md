试分析 `HashSet` 和 `TreeSet` 分别如何实现去重的？

- `HashSet`去重机制：`hashCode() + equals()`，底层先通过存入对象，运算得到 `hash`值，通过 `hash`值得到相应的索引，没有数据，直接存放；有数据，进行 `equals` 比较【遍历比较】，比较后，不相同，就加入，否则不加入。

- `TreeSet` 去重机制：传入一个 `Comparator`匿名对象，使用实现的 comparator 去重，如果返回0，认为是相同的元素/数据，不添加，如果没有传入 `Comparator` 匿名对象，则以添加的对象实现的 `Comparable` 接口的 `compareTo` 进行比较。 
