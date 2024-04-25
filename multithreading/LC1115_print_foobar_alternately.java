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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-04-21
 **/
class LC1115_print_foobar_alternately {
    class FooBarSemaphore {
        private int n;
        private Semaphore fooSema = new Semaphore(1);
        private Semaphore barSema = new Semaphore(0);

        public FooBarSemaphore(int n) {
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

    //容易超时
    class FooBarLock {
        private int n;
        private Lock lock;
        volatile boolean fooPrinted;
        public FooBarLock(int n) {
            this.n = n;
            lock = new ReentrantLock(true);
            fooPrinted = false;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            //一开始把lock写在了外面，肯定要写for里面，因为要逐次上锁
            //lock.lock();
            //后来忘了把默认的代码中这里的i++去掉，太坑了
            //for (int i = 0; i < n; i++) {
            for (int i = 0; i < n;) {
                lock.lock();
                try{
                    if(!fooPrinted){
                        // printFoo.run() outputs "foo". Do not change or remove this line.
                        printFoo.run();
                        i++;
                        fooPrinted = true;
                    }
                }finally {
                    lock.unlock();
                }

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            //lock.lock();
            //for (int i = 0; i < n; i++) {
            for (int i = 0; i < n; ) {
                lock.lock();
                try{
                    if (fooPrinted){
                        // printBar.run() outputs "bar". Do not change or remove this line.
                        printBar.run();
                        i++;
                        fooPrinted=false;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    //无锁超时，无法通过测试用例
    class FooBarNoLock {
        private int n;
        volatile boolean fooPrinted;
        public FooBarNoLock(int n) {
            this.n = n;
            fooPrinted = false;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n;) {
                if(!fooPrinted){
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    i++;
                    fooPrinted = true;
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; ) {
                if (fooPrinted){
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    i++;
                    fooPrinted=false;
                }
            }
        }
    }

    class FooBarCyclicBarrier {
        private int n;
        private CyclicBarrier cyclicBarrier;
        volatile Boolean finished = true;
        public FooBarCyclicBarrier(int n) {
            this.n = n;
            cyclicBarrier = new CyclicBarrier(2);
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; ) {
                //finished标记，为了控制foo的打印能先执行
                // 这里写成while(!finished);更好理解，但不知道写成if为啥也行
                //这里误写成了!finished
                if (finished){
                    try {
                        printFoo.run();
                        finished=false;
                        i++;
                        cyclicBarrier.await();
                    } catch (BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            //这里i++和下面的i++重复了
            for (int i = 0; i < n; ) {
                try {
                    cyclicBarrier.await();
                }catch (Exception e){

                }
                //循环栅栏所设置的线程数都到达栅栏后，才执行bar的打印
                printBar.run();
                i++;
                finished=true;
            }
        }
    }

    class FooBarBlockingQueue {
        private int n;
        private BlockingQueue fooQueue;
        private BlockingQueue barQueue;
        public FooBarBlockingQueue(int n) {
            this.n = n;
            fooQueue = new LinkedBlockingQueue<Integer>();
            fooQueue.add(0);
            barQueue = new LinkedBlockingQueue<Integer>();
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                fooQueue.take();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                barQueue.add(0);
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                barQueue.take();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooQueue.add(0);
            }
        }
    }

}