## Set implementations

|Class | Internal representation | Since | Element order | Member restriction | Basic operations | Iteration Performance | Notes |
|------|-------------------------|-------|---------------|--------------------|------------------|-----------------------|-------|
|HashSet | Hashtable | 1.2 | None | None | O(1) | O(capacity) | Best general-purpose implementation.|
|LinkedHashSet | LinkedHashtable | 1.2 | Insertion order | None | O(1) | O(n) | Preserves insertion order. |
|EnumSet | Bit fields | 5.0 | Enum declaration | Enum Values | O(1) | O(n) | Holds non-null enum values only. |
|TreeSet | Red-black tree | 1.2 | Sorted ascending | Comparable | O(log(n)) | O(n) | Comparable elements or Comparator. |
|CopyOnWriteArraySet | Array | 5.0 | Insertion order | None | O(n) | O(n) | Threadsafe without synchronized methods. |

## List implementations

|Class | Internal representation | Since | Random access | Notes |
|------|-------------------------|-------|---------------|-------|
|ArrayList | Array | 1.2 | Yes | Best all-around implementation. |
|LinkedList | Double-linked list | 1.2 | No | Efficient insertion and deletion. |
|CopyOnWriteArrayList | Array | 5.0 | Yes | Threadsafe; fast traversal, slow modi cation. |
|~~Vector~~ | Array | 1.0 | Yes | Legacy class; synchronized methods. Do not use. |
|~~Stack~~ | Array | 1.0 | Yes | ExtendsVector; addspush(),pop(), peek(). Legacy; useDequeinstead. |

## Map implementations

|Class | Internal representation | Since | null keys | null values | Notes |
|------|-------------------------|-------|-----------|-------------|-------|
|HashMap | Hashtable | 1.2 | Yes | Yes | General-purpose implementation. |
|ConcurrentHashMap | Hashtable | 5.0 | No | No | General-purpose threadsafe implementation; seeConcurrentMap interface. |
|ConcurrentSkipListMap | Hashtable | 6.0 |No | No | Specialized threadsafe implementation; see ConcurrentNavigableMap interface. |
|EnumMap | Array | 5.0 | No | Yes | Keys are instances of an enum. |
|LinkedHashMap | Hashtable plus list | 1.4 | Yes | Yes | Preserves insertion or access order. |
|TreeMap | Red-black tree | 1.2 | No | Yes | Sorts by key value. Operations are O(log(n)). See SortedMapinterface.|
|IdentityHashMap | Hashtable | 1.4 | Yes | Yes | Compares with == instead of equals(). |
|WeakHashMap | Hashtable | 1.2 | Yes | Yes | Doesn’t prevent garbage collection of keys. |
|~~Hashtable~~ | Hashtable | 1.0 | No | No | Legacy class; synchronized methods. Do not use. |
|Properties | Hashtable | 1.0 | No | No | Extends Hashtable with String methods.|

TODO: queue

