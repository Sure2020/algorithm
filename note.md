2024.04.12，感觉回溯有点难，虽然算法框架简单，但变种有点难
2024.04.13，从LC22学到两个提升性能的技巧：
            1.结果数组中的元素是字符串的回溯，将track的类型由链表改为stringbuilder，可提升性能，因为最后链表需要join("",track)，而stringbuilder直接tostring即可；
            2.删除最后一个字符这里用setLength方法，总用时由1ms将为0ms，因为setLength方法不用像deleteCharAt方法那样需要遍历并挪动字符
2024.04.16, 子集，元素不重复，不可复选，用start控制元素相对位置            ，关键字，start
            子集，组合，元素可重复，不可复选，先排序，再跳过值相同的元素      ，关键字，sort
            排列，元素不重复，不可复选，用used数组记录已用过的元素         , 关键字，used，排列！
            排列，元素重复，不可复选，用used数组记录已用过的元素+sort再剪枝！        , 关键字，used，排列！+sort剪枝
            （从这里可以看到，只要元素可重复，就用sort剪枝！）
2024.04.17，回溯解决组合/子集，排列问题：
			1.元素不重复，不可复选，组合子集：用start控制；排列：用used控制
			2.元素可重复，不可复选，组合子集：start控制 + sort再剪枝； 排列：used控制 + sort再剪枝，注意剪枝时要判断！used(i-1)->continue
			3.元素不重复，可以复选，组合子集：用start控制，且下一次从i开始，而不是i+1；排列：不used，不sort

2024.05.14，滑动窗口的框架：
    1.先将target读入map
    need 存target
    window 存s
    while(right<t.size()){
    
    如果右指针指向的字符在need存在，设置window，并更新valid
        如果valid==need.size(),开始收缩窗口，
            先判断最小长度是否需要更新，再判断valid是否需要更新，再更新window
    
    }
（感觉这么写框架没多大用，还是直接看代码吧）

2024.05.18,LC23. 合并 K 个升序链表
//注意new 后面的尖括号别落下
PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a,b)->(a.val-b.val));