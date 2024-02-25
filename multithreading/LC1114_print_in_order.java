/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC1114_print_in_order
 * Date Created : 2024-02-25
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-25       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-25
 **/
public class LC1114_print_in_order {
    class Foo {
        private CountDownLatch cdl12,cdl23;
        public Foo() {
            cdl12 = new CountDownLatch(1);
            cdl23 = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            cdl12.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            cdl12.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            cdl23.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            cdl23.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
    class FooSemaphore {
        private Semaphore semaphore12,semaphore23;

        public FooSemaphore() {
            semaphore12 = new Semaphore(0);
            semaphore23 = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            semaphore12.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            semaphore12.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            semaphore23.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            semaphore23.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}