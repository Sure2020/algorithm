/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC236_
 * Date Created : 2024-02-08
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-08       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 注意给出的提示，因为提示中说了，p和q一定存在于树中，所以如果root节点还没遍历，一开始就匹配到了其中一个节点，那这个节点就是LCA
 * @author: Admin
 * @create: 2024-02-08
 **/
public class LC236_lowest_common_ancestor_of_a_binary_tree {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return dfs(root, p.val, q.val);
        }
        public TreeNode dfs(TreeNode root, int val1, int val2){
            if(root ==null){
                return null;
            }
            //因为提示中说了，p和q一定存在于树中，所以如果root节点还没遍历，一开始就匹配到了其中一个节点，那这个节点就是LCA
            if(root.val == val1 || root.val == val2){
                return root;
            }
            TreeNode left = dfs(root.left, val1, val2);
            TreeNode right = dfs(root.right, val1, val2);
            if(left != null && right != null){
                return root;
            }
            return left != null ?left:right;
        }
    }
    class Solution20240215 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return dfs(root, p.val,q.val);
        }
        public TreeNode dfs(TreeNode root, int val1, int val2){
            if(root==null){
                return null;
            }
            if(root.val==val1||root.val==val2){
                return root;
            }
            TreeNode left = dfs(root.left,val1,val2);
            TreeNode right = dfs(root.right,val1,val2);
            if(left!=null&&right!=null){
                return root;
            }
            return left!=null?left:right;
        }
    }
    //这题，第三次再遇到，只有个模糊的印象，知道有3种情况，其实只要记住，就是去子树中找p或者q节点，写出find函数后面就水到渠成了
    class Solution20240313 {
        //分3种情况，1。两节点都在当前节点的子树中；2.两节点都不在；3.一个在，一个不在
        //这题，第三次再遇到，只有个模糊的印象，知道有3种情况，其实只要记住，就是去子树中找p或者q节点，写出find函数后面就水到渠成了
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null){
                return null;
            }
            if(root.val==p.val || root.val==q.val){
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p,q);
            TreeNode right = lowestCommonAncestor(root.right, p,q);
            if(left!=null && right !=null){
                return root;
            }
            return left!=null ? left:right;
        }
    }

    //看了上次的笔记，那么这次应该是第四次遇到了，开始有些怕，但记住思路后就心里有底了：
//就是去左右子树中找p或q,找到了p或q，说明当前节点有可能是所求，如果左右子树都找到了，说明当前节点就是所求
//诀窍就是搞清楚递归函数的定义，不要去想递归起来以后的细节！否则就是庸人自扰！
    class Solution20240531 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null){
                return null;
            }
            //情况2，如果某个root是p或q,则这个就是所求，直接返回
            if(root==p||root==q){
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p,q);
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            //情况1
            if(left!=null && right!=null){
                return root;
            }
            return left!=null ? left:right;
        }
    }

    //分解的思路，去左右子树中找p或q
    class Solution20240603 {
        //函数定义：返回最近公共祖先
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null){
                return null;
            }
            //case 2
            if(root==p || root==q){
                return root;
            }
            TreeNode left  =  lowestCommonAncestor (root.left, p,q);
            TreeNode right = lowestCommonAncestor (root.right, p,q);
            //case 1
            if(left!=null && right!=null){
                return root;
            }
            return left!=null ? left: right;
        }
    }

    //思路，去左右子树中找p或q，情况1，当前root就是p或q，直接返回root；情况2，左右子树中找到p或q的节点，则root就是所求


    class Solution20240604 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null){
                return null;
            }
            //case 1
            //关于为啥root等于p或q其中一个节点，那root就是所求。可能会问，如果另一个节点在另一颗子树上呢？
            //答：如果在另一颗子树上，那这个子树的root节点早就被认为是所求而返回了，根本到不了当下这个逻辑
            //既然到了当下这个逻辑，说明p和q两个节点都在本子树上
            if(root==p || root==q){
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left,p,q);
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            if(left!=null && right!=null){
                return root;
            }
            return left!=null?left:right;
        }
    }

    class Solution20240624 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null){
                return null;
            }
            if(root==p){
                return p;
            }else if(root==q){
                return q;
            }
            TreeNode left = lowestCommonAncestor(root.left, p,q);
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            //ooooooooo忘了匹配情况2的情形
            if(left!=null && right!=null){
                return root;
            }
            return left!=null?left:right;
        }
    }
//让我回忆一下，分两种情况：1.当前根节点是两节点其中之一，那它就是所求；2.当前节点在两节点上面，继续递归寻找；3.
//如果找不到一个或两个节点，返回null

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution20240730 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null){
                return null;
            }
            //System.out.println(root.val +"  "+ p.val +"   "+ q.val);
            if(p.val==root.val || q.val==root.val){

                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p,q);
            TreeNode right = lowestCommonAncestor(root.right, p,q);
            if(left!=null && right !=null){
                return root;
            }
            return left!=null?left:right;
        }
    }
//1.题目说了，p和q都在二叉树中，所以如果根节点是p或q，那么根节点就是所求
//2.如果根节点的左右子树中能找到p或q，那根节点就是所求。

//事后：卡在了最后那个return语句，注意函数的定义，就是去子树中找p或q,最后要返回找到的值，而非直接返回null


    //让我回忆一下，分两种情况：1.当前根节点是两节点其中之一，那它就是所求；2.当前节点在两节点上面，继续递归寻找；3.
    //如果找不到一个或两个节点，返回null
    //诀窍就是搞清楚递归函数的定义，
    //又看了sun的题解
    /*
    * 解题思路：
两个节点 p,q 分为两种情况：

p 和 q 在相同子树中
p 和 q 在不同子树中
从根节点遍历，递归向左右子树查询节点信息
递归终止条件：如果当前节点为空或等于 p 或 q，则返回当前节点

递归遍历左右子树，如果左右子树查到节点都不为空，则表明 p 和 q 分别在左右子树中，因此，当前节点即为最近公共祖先；
如果左右子树其中一个不为空，则返回非空节点。

作者：Sun
链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solutions/24970/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-jian-j/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
    class Solution20250518 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null){
                return null;
            }
            if(root==p || root==q){
                return root;
            }
            //这里返回的是p或者q
            TreeNode left = lowestCommonAncestor(root.left,p,q);
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            //p和q在子树异侧，则root就是所求
            if(left!=null && right!=null){
                return root;
            }
            return left!=null?left:right;
        }
    }
}