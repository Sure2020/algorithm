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

* 2024.06.17.LC5，最长回文字串，记住双指针，然后从中心向两边扩散

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

** 2024.12.02 LC169,寻找众数，正负电子的思路，真的巧妙
* 2024.12.03 LC83,删除重复节点，注意用while让fast连续跳过重复节点

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
8.int[] nums; nums.length



top100,easy
206. 反转链表,递归，迭代均可
21. 合并两个有序链表，三个指针，当P1，p2都非null，依次对比拼接，最后判断谁非空谁拼到后面。记得p3搞个dummy节点
记忆点：1.三指针，2.p3 dummy
1. 两数之和，搞个map，key是值，value是下标。遍历数组，并得到当前target值，去map中找，找到则返回，找不到则放进map
**121. 买卖股票的最佳时机, 关键思路是，若想达到最高利润，则一定选择价格最低的交易日买入，可称之为贪心
坑点：// cost默认值要搞个大值
   int result = 0,cost=Integer.MAX_VALUE;
20. 有效的括号,利用栈，遍历，先将左括号放入栈中，当遇到右括号，就栈顶找对应的左括号，找到就弹出，否则返回false。最后如果栈是空，就整体合法。
坑点：
    // 下面这组if else有讲究
    if(!stack.isEmpty() && d==stack.peek()){
        stack.pop();
    }else{
        return false;
    }

88. 合并两个有序数组，关键是从后往前放。最后如果数组2中还有元素，就直接遍历放入数组1即可。
不管是合并链表还是数组，都要3指针

141. 环形链表，快慢指针，如果最后相遇，则为环。快走二，慢走一。
415. 字符串相加，从后往前遍历，当两个下标和进位变量都非零，就继续遍历。中间的逻辑取模，取余即可。
有两个关键，1.求当前字符对应的数字，用chat-'0'，2.最后要sb.reverse()

160. 相交链表,labuladong的思路，拼起来，那么不论最后相交与否，结束条件都是p1==p2.while(p1!=p2)即可。最后返回p1
    2025.05.13补充：要确保循环一次只走一步，比如只有当p1==null，才p1=headB，!=null，就向后走。而不能if(p1==null){p1=headB;} p1=p1.next;

94. 二叉树的中序遍历,喜欢
704. 二分查找，left,right,mid  while(left<=right),开始找。
*232. 用栈实现队列，两个栈，共pop,peek,push,empty()4个函数，后两者简单，empty判断两个栈都空，则为空。
思路是，进s1，需要出栈的时候，（前提是s2为空）先将s1的元素全部放入s2，再从s2出栈即可。
69. x 的平方根，二分查找的变体，需注意的是要强转一下，long temp = (long)mid*mid;

70. 爬楼梯，斐波那契数列，但可以精简，n1,n2,n3.   基础是n1=1,n2=2,以后i=3开始到n,为：n3=n1+n2,n1=n2,n2=n3.

链表中的倒数第k个节点，快慢指针，快先走k步，再同步走，知道快==null，则慢为所求。


** 155. 最小栈，中等，搞两个栈，栈2专门放相对栈1当前元素，的最小值。if(minStack.isEmpty() || val<=minStack.peek())
minStack.push(val);else minStack.push(minStack.peek());

101. 对称二叉树,递归，base case有三个，当都==null,true,其中一个==null，false，val不相等，false。
然后递归，比较node1.left,node2.right && node1.right,node2.left

144. 二叉树的前序遍历,haha
104. 二叉树的最大深度,大意了，递归，要用分解的思路，不要用全局变量容易有坑。base case是root==null,return 0,root.left==null && root.right==null,return 1
然后int left=fun(root.left),int right=fun(root.right),return Math.max(left,right)+1;

110. 平衡二叉树,这次可以搞个全局变量放结果，然后其他细节同上，在拿到left和right后判断Math.abs(left,right)>1

543. 二叉树的直径，和求二叉树高度类似，只不过在处理left和right时，多加一步：result=Math.max(result,(left+right))

14. 最长公共前缀,以第一个为基准，比如拿出第一个str的第一个字符，循环对比后面的，不相等就返回。

112. 路径总和，有点巧妙，和自己的直觉思路不对应。还是递归分解的思路，base case是 到达根节点，且target=root,val
否则判断 return func(root.left,target-root.val) || func(root.right,target-root.val);

5.最长回文子串，有印象，从中间向两边蔓延，而且判断return func(i,i) || func(i,i+1);
base case 是i<0 || j>s.length()


234. 回文链表，用快慢指针找到中点，从slow节点翻转后面的，再两条链表逐个比对。

** 169. 多数元素，直觉是利用map，但labuladong正负电子的思路确实妙。就是把多数元素看作是正电子，其他元素为负电子
target=0,count=0
for(int i=0,i<nums.length;i++){
if(count==0),target=nums[i]
else if(nums[i]==target),count++
else count --
}
return target

83. 删除排序链表中的重复元素,//注意fast需要连续跳过重复节点，需要用while
226. 翻转二叉树, 记住不用像链表那样保持节点本身不变，这里可以直接交换两个节点的值。不要想去链接，不要去root.left=xxx
if(root==null),return null
用temp变量交换left和right
func(root.left)
func(root.right)
return root;

283. 移动零，关键是复用移除0的方法，先将所有0删除，再最后填补0.
移动零,双指针，while(fast<length){
if(nums[fast]!=val)
    nums[slow]=nums[fast]
    slow++
  } 
  fast++
}
return slow


26. 删除排序数组中的重复项，思路就是，双指针，如果快慢的值相等，快就一直往前走，当不相等，则slow++后，将nums[slow]=nums[fast]
最后return slow.  labuladong的思路里面，那个动图做的挺好的。

##top,mid
3. 无重复字符的最长子串，思路是滑动窗口，一左一右两个指针，用set记录遍历过的char,
    set中没有，就加入set，并扩张窗口（right++），set中有，把当前left指向的char删掉,再缩小窗口（left++）。
146. LRU缓存机制。关键是哈希链表这个数据结构，linkedHashMap。
    还有关键的函数，mackRecently，将get或put过的，都变成最进使用过的。
215. 数组中的第K个最大元素。用小顶堆，priorityQueue,先往里放，最大的自动会沉到底部，
    边放边判断，元素个数大于k了，就poll。最后的队顶，就是第K大的。
    坑点：//这里不要写>=k,要时刻清楚要干嘛，而不是机械地去输出
     if(queue.size()>k){
         queue.poll();
     }

25. K 个一组翻转链表
坑点：
    if(p==null){
        //break;
        return head;
    }
5. 最长回文子串。就是一次判断i,i 和 i,i+1两个起点向外扩展，能找到的最长回文子串。

102. 二叉树的层序遍历，借助queue保存每一层的节点，然后遍历queue，遍历时再把当前节点的左右子节点都放入queue。
踩坑点： size要提取算，不能在for循环中算，因为那时候已经有下一层的插入queue了
33. 搜索旋转排序数组
2024.07.25,LC33，搜索旋转数组。用mid与left比较，先确定断崖在哪边。
    //关键思路是通过比较mid和Left,确定mid在断崖的哪边
    //mid大于left，mid在断崖左边，left---mid递增
    //mid等于left，仍然可以认为left---mid递增
        //left<target<mid，大胆地收缩右边界，否则，收缩左边界，交由下次循环，再次判断mid与left的关系去处理
        //否则收缩左边界
    //mid小于left，mid在断崖右边，mid---right递增
        //mid<target<right,收缩左边界
        //否则收缩右边界
坑点：right = num.length-1，忘了-1

103. 二叉树的锯齿形层次
//坑点：1.记住LinkedList有方法可以头插或者尾插！自然就可以控制方向了，需要将临时list定义为LinkedList类型；2.
    isLeftToRight的取反，要放在for循环之外
坑点：每层list要用链表：LinkedList<Integer> levelList = new LinkedList<>();


*****236. 二叉树的最近公共祖先
    //搞清楚递归函数的含义，不要去想递归运行起来的细节；递归，是从最底层开始向上返回的，会把最近公共祖先一层层返回上来。

92. 反转链表 II,//思路：先实现reverseN，也就是翻转前N个，再将head前进到left的位置，调用reverseN.
    reverseK，最后记得head.next=next,将翻转后的链表和未翻转的链表连起来
    前进到left:
    if(left==1){
        return reverseK(head,right);
    }
    head.next = reverseBetween(head.next,left-1,right-1);

143. 重排链表
     //一句话就能明白思路：因为题目要求后半部分是倒叙穿插到前半部分，
     所以用栈把后半部分节点压入，再逐个弹出。来自题解，用户：算法什么时候能搞定啊
    两个注意点，while(left.next!=right || left.next.next!=right),对应偶数和奇数，或的关系
    循环外，left.next=null，断开和后面的连接，否则会成环。
记忆点：利用栈，节点全压入栈，再取出，达到倒叙的目的。后面再拼接
坑点：或的关系：while(left.next!=right || left.next.next!=right)。
    解释：当有4个节点，循环结束一次后，其实此时是left.next.next=right的，还要继续循环处理一次。所以要或


142. 环形链表 II
     快慢指针，快走2，慢走1，找到相遇点，慢再从head开始，快慢都走1.
    //注意点，循环结束条件这么写，whlie(fast!=null || fast.next!=null){
        if(fast==slow){
            return null;
        }
     }


19. 删除链表的倒数第N个节点
    用快慢指针的方式完全可以，但还可以用递归：
    //删除链表的题目，首先直接一个dummy节点写出来。。。
    //删除倒数第n个，那对于head.next,就是删除倒数第n-1个，对于某个head,就是删除自己
    dummy.next=head;
    head.next = removeNthFromEnd(head.next,n);
    count++;
    if(count==n){
        return head.next;
    }
    return dummy.next;

83. 删除排序链表中的重复元素(先做简单的这个)
    //双指针
    //简单题就是思路很直接，没那么多陷阱和弯弯绕，反正按思路写完，简单调试后就过了
    //注意fast需要连续跳过重复节点，需要用while
    82. 删除排序链表中的重复元素 II
    //两个原则，slow要永远落后于fast，在dummy节点就开始；
    ListNode slow=dummy,fast=head;
    //只有当slow和fast之间没元素，slow才移动。
        if(slow.next==fast){
            slow = slow.next;
        }else{
            //跳过重复的节点，但此时slow仍没动，保持slow落后于fast
            slow.next=fast.next;
        }
        //fast日常移动，在没重复节点时的移动
        fast=fast.next;


25. K 个一组翻转链表
    先写出翻转两个节点间的函数，再
    //翻转整个链表相当于翻转从Head到null之间的链表，稍作修改就能写出翻转从head到p节点之间节点的方法
    //然后不断调用reverseBetween达到最终效果
    ListNode p = head;
    for(int i=1;i<=k;i++){
        if(p==null){
            return head;
        }
        p = p.next;
    }
    ListNode newHead = reverseBetween(head,p);
    head.next = reverseKGroup(p,k);
    return newHead;


199. 二叉树的右视图
    层序遍历的变种，只将每层的最后一个节点放入list

2. 两数相加
   // 就是1，两数之和的变种


105. 从前序与中序遍历序列构造二叉树
    //诀窍是借助一个三层的满二叉树，来分析各个下标
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
         if(preStart>preEnd || inStart>inEnd){
            return null;
         }
         int rootIndex = inorderMap.get(preorder[preStart]);
         int leftLength = rootIndex-inStart;
         int rightLength = inEnd - rootIndex;
         TreeNode root = new TreeNode(preorder[preStart]);
         root.left = build(preorder, preStart+1, preStart+leftLength, inorder, inStart, rootIndex-1);
         // 这里竟然错把rightLength写成了leftLength
         root.right = build(preorder, preEnd-rightLength+1, preEnd, inorder, rootIndex+1, inEnd);
         return root;
     }

     129. 求根节点到叶节点数字之和
         递归
          public void sum(TreeNode root, int current){
          if(root==null){
            return;
          }
          current = current * 10 + root.val;
          if(root.left==null && root.right==null){
            result += current;
            return;
          }
          sum(root.left, current);
          sum(root.right, current);
          }
34. 在排序数组中查找元素的第一个和最后一个位置
    // 寻找左右边界结合
    找边界，注意找到==target后，就要收缩左边界（left=mid+1）或右边界（right=mid-1）
    左编辑，右边界函数，搞个founded标志位记录是否找到，没找到就赋值-1

24. 两两交换链表中的节点
    上面25的简化版或者变种

76. 最小覆盖子串
    直接看注释
    近期的错误：缩小窗口时把left++错写成了left --。。。。。


###top hard
23. 合并 K 个升序链表
利用小顶堆，先将所有头节点放进去，再取出来，并把当前节点的下一个节点放进去。类似二叉树层序遍历的思想