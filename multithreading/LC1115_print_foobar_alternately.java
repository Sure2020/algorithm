/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC1115_print_foobar_alternately
 * Date Created : 2024-04-21
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-04-21       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.concurrent.Semaphore;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-04-21
 **/
class LC1115_print_foobar_alternately {
    class FooBar {
        private int n;
        private Semaphore fooSema = new Semaphore(1);
        private Semaphore barSema = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                //信号量如果大于1，则如果获取到信号量，信号量就-1，后面的程序执行。否则线程睡眠直到信号量大于1
                fooSema.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                //释放信号量，则该信号量+1，
                barSema.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                barSema.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooSema.release();
            }
        }
    }
}