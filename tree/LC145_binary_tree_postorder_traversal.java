/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC145_binary_tree_postorder_traversal
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

import java.util.ArrayList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-08
 **/
public class LC145_binary_tree_postorder_traversal {
    class Solution {
        List<Integer> result = new ArrayList<>();
        public List<Integer> postorderTraversal(TreeNode root) {
            if(root ==null){
                return result;
            }
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            result.add(root.val);
            return result;
        }

    }
}