/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC77_combinations
 * Date Created : 2023-12-28
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-12-28       w15021     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-12-28
 **/
public class LC77_combinations {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> track = new LinkedList<>();

    public static void main(String[] args) {

        combine(1, 1);
        System.out.println(result);

    }

    public static List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return result;
    }

    public static void backtrack(int start, int n, int k) {
        if (k == track.size()) {
            result.add(new LinkedList<>(track));
        }
        for (int i = start; i <= n; i++) {
            track.addLast(i);
            backtrack(i + 1, n, k);
            track.removeLast();
        }
    }
}