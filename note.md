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
2024.06.25,LC23，还有个坑，要先判断if(lists.length==0){
                                     return null;
                                 }
否则new priorityQueue的时候老报不合法的语句，妈的，也不明确说长度参数不能为0！


2024.05.24, LC92,反转链表II，
//前进到第left个节点的方式，值得记忆！
head.next = reverseBetween(head.next, left-1,right-1);
2024.06.25，LC92补充：值得记忆！值得记忆！一个月后竟然调试了一个小时！主要思路是利用递归，将left递归到==1，再利用翻转前N个节点的函数
*****************************************2024.07.31，lc92,翻转链表II，注意两点，1.搞清楚base case。2.翻转前N个节点的函数，记得拼接后面未翻转的.3.注意reverseK从head开始而不是从Head.next
                       //这题克我，做过很多遍，每次都纠结好久，练！

2024.05.24，LC25, K 个一组翻转链表
// 哈哈我踏马真是做一次就在这里踩坑一次，如果翻转整个链表，结束条件才是!=null，现在是翻转区间，就要!=b
while(current!=b){

2024.05.28, LC19，打印倒数第k个链表节点，是个很基础的东西！记住count++要放在递归之后，参考二叉树的后续遍历
2024.07.01,LC10,利用递归，可以从后往前计数，关键是计数到第n个时，返回head.next，相当于跳过了当前节点。关键还是对后续遍历的理解，count++放在递归调用的后面！

2024.05.28,LC82,删除重复节点，还是没能写出来，记住一点，移动完，slow不能和fast指向同一个节点。fast要先去前面探路，所以移动时要等slow移动完，再移动，
这样能保持领先
2024.05.29,LC103,//唉！恍然大悟！记住LinkedList有方法可以头插或者尾插！自然就可以控制方向了

2024.05.31，LC236,//就是去左右子树中找p或q,找到了p或q，说明当前节点有可能是所求，如果左右子树都找到了，说明当前节点就是所求
//诀窍就是搞清楚递归函数的定义，不要去想递归起来以后的细节！否则就是庸人自扰！

2024.06.03，LC124,这里为什么在小于0时要返回0，而不是直接返回outMax?为了让贡献值为负的节点不影响整个路径的最大和。那怎么做到不影响呢，
就在本层递归直接返回0，那在此次递归的外层，会加0，就相当于什么也没加，就相当于没影响到最大路径和了
2024.06.07,LC124和LC543可以一起看，都是典型的分解递归思路
2024.07.01,LC124,这里return的时候不能返回root+left+right，而要返回root+Max(left,right);

2024.06.04,LC105,注意！根节点的值要写成preorder[preStart]，而不是preorder[0]!因为子树的根节点在变，不固定！
********2024.07.10,LC105,//三点！1.计算leftLen和rightLen，就利用rootIndex和inStart\inEnd来，也就是全用中序遍历相关的变量别扯其他的！
//2.计算左子树的边界：
//左子树的前序界，就用preStart和leftLength算，别扯其他的！
//左子树的中序边界，就用inStart和rootIndex算，别扯其他的！
//3.计算右子树的边界：
//右子树的前序边界，就用preEnd和rightLen算，别扯其他的！
//右子树的中序边界，就用inEnd和rootIndex算，别扯其他的！

2024.06.07,LC662，二叉树最大宽度，再练练吧，细节挺有意思的，虽然没啥技巧可言
*******2024.07.15，LC662,总能立即往坑里跳，想成是层序遍历+判断节点最多的层。其实要求两个节点的距离，包含中间的null节点。

2024.06.12,LC162寻找峰值，判断mid和left，right的大小关系太复杂，上面就是反例，关键思路是换个角度，判断mid和mid+1的大小关系

2024.06.13，LC146，LRU，我觉得很重要，只要记住一点，要用到linkedhashmap
2024.07.22, LC146,LRU，这个语法总是记不住：int oldestKey = cache.keySet().iterator().next();
让我们默写一遍：cache.keySet().iterator.next()

2024.06.17.LC5，最长回文字串，记住双指针，然后从中心向两边扩散

2024.06.18,LC215,数组中第k大元素，记住用优先级队列即可
2024.07.23,LC215,数组中的第k大元素，优先队列语法不熟，见下方章节

2024.06.18,LC415,字符串相加，技巧：获得char类型的数字对应的int值，char-'0'

2024.06.19,LC25,K个一组翻转链表，记住1.迭代方式的翻转链表，是节点两个两个地翻转，不要一次想翻转3个节点，然后是，2.最后返回previous节点

2024.06.27,LC143,重排链表，关键点是，1.链表，2.栈，3.先p2.next=p1.next，后面就顺畅了

2024.07.02,LC82,删除重复节点。一招hasSkiped，来控制slow节点要不要向后移动，纯纯自己的思路！让其他所谓高明的技巧见鬼去吧！

2024.07.03,LC70，爬楼梯，其实就是斐波那契数列

2024.07.03,LC322，动态规划，凑零钱，再做！//两处失误，一个是没搞清楚base case，amount<0要返回-1,amount==0要返回0;另一个是，返回结果时要判断要不要返回-1
                             //其实太遗憾了，仅仅差一步之遥，就是忘了一个base case，遗憾了

2024.07.18,LC24,两个一组交换节点，不知不觉踩坑了，其实记住，迭代翻转两节点之间节点的函数，翻转[a,b)之间的节点，能避免麻烦。
1.while条件用current!=node2，返回 previous
2.swap(head,p),   swapK(p,k)

2024.07.25,LC33，搜索旋转数组。用mid与left比较，先确定断崖在哪边。
如果找峰值，就要mid与mid+1做比较，找出趋势
********有阻力，写出来了但花了大量时间调试，而且是剽窃的上次提交
********主要是当判断target是否在left--mid或mid--right之间时，要严谨判断：nums[left]<=target<=nums[mid],nums[mid]<=target<=nums[right]

********2024.07.29,LC88，合并两个排序的数组，不太顺畅

*** 2024.07.30,LC236,二叉树的最近公共祖先
注意函数的定义，只要找到left或right就返回，而不是返回null
* 2024.07.31，lc103，蛇形打印二叉树，关键是利用linkedlist可以选择头插或尾插

*** 2024.08.01,lc69,sqrtx,不能用double类型，否则小数点会带来麻烦，用long即可
* 2024.08.01,lcr140,训练计划II，链表倒数第k个节点，用快慢指针
* 2024.08.01,lc101,判断是否是对称二叉树，不能对比==就随便返回true，因为可能当前为true，后面为false。应该遇到false时返回false！
** 2024.08.03,LC110,判断是否是平衡二叉树，失误在树高度的算法上，以后不用全局变量的算法了，全局变量容易影响其他。还有，搞清楚递归的base case。
* 2024.08.03,lc543，求二叉树最长路径，注意在利用left和right进行差异计算时，想清楚要求什么
* 2024.08.04,LC100,两棵树是否相等，其实在判断何时返回true时，过于谨慎了，只要写清楚了返回false的条件。最后能成功走到p==q==null这个条件，已经可以说明上面的都相等

* 2024.08.05,lc142,环形链表II， 稍微纠结了一下，在判断返回null时没处理好，fast==null || fast.next==null都应返回null
*** 2024.08.05,LC19,删除倒数第n个节点，1.迭代法，用双指针找到倒数第n个，再处理next；2.递归法！这里关键是k++在递归函数之后，是为了先让递归函数去触发base case，让递归开始逐层返回，开始返回了，才可以开始count++。或者这么说，都是需要先触发base case，再进行特殊处理。

铁律：
1.不要复制粘贴上面的代码到下面，容易引入很多坑！无论什么情况，都不要复制粘贴
2.尽量缩小变量作用域，即使每次循环都声明一次变量又如何？
3.返回值为boolean的问题，不能对比==就随便返回true，因为可能当前为true，后面为false。应该遇到false时返回false！
4.求最大值的问题，给result赋值要用Math.max挑战后赋值，而不是直接赋值！
5.少用全局变量

语法熟悉：
1.set取第一个key：set.keySet().iterator().next();
2.优先队列：Queue<Object> queue = new PriorityQueue<>((a,b)->a-b);小顶堆这么写
3.Math.max(a,b)
4.Integer.MAX_VALUE
5.String s;   s.length()
6.List s;   s.size()

7.substring(a,b)取的是区间[a,b)之间的子串，注意是左闭右开