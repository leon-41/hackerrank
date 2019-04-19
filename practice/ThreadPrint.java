
public class ThreadPrint {

    /**
     * 用程序实现两个线程交替打印 0~100 的奇偶数。
     * https://mp.weixin.qq.com/s?__biz=MzIzMzgxOTQ5NA==&mid=2247486942&idx=1&sn=2a41d7f38d682bf46f8e3a2d45de8b46&chksm=e8fe91d7df8918c1303c455b86e0acabebf66880ab12ef51263d226c4a9a652e26ab3cb77ad7&scene=38#wechat_redirect
     */

    private static int count = 0;
    private static final Object lock = new Object();


    /**
     * 讨巧的方案
     * 用了一个讨巧的方式避开了线程交替获取锁的需求，明显没有答到面试官想考察的考点上。
     * 而且效率较低，如果同一个线程一直抢到锁，而另一个线程一直没有拿到，就会导致线程做很多无谓的空转。
     */
    public static void turning1() {

        Thread even = new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    // 只处理偶数
                    if ((count & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                    }
                }
            }
        }, "偶数");

        Thread odd = new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    // 只处理奇数
                    if ((count & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                    }
                }
            }
        }, "奇数");
        even.start();
        odd.start();
    }



    /**
     * 交替获取锁的方案
     * 这种实现方式的原理就是线程1打印之后唤醒其他线程，然后让出锁，自己进入休眠状态。
     * 因为进入了休眠状态就不会与其他线程抢锁，此时只有线程2在获取锁，所以线程2必然会拿到锁。
     * 线程2以同样的逻辑执行，唤醒线程1并让出自己持有的锁，自己进入休眠状态。这样来来回回，持续执行直到任务完成。
     * 就达到了两个线程交替获取锁的效果了。
     */
    public void turning2() throws InterruptedException {
        Thread even = new Thread(() -> {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println("偶数: " + count++);
                    lock.notifyAll();
                    try {
                        // 如果还没有结束，则让出当前的锁并休眠
                        if (count <= 100) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread odd = new Thread(() -> {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println("奇数: " + count++);
                    lock.notifyAll();
                    try {
                        // 如果还没有结束，则让出当前的锁并休眠
                        if (count <= 100) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        even.start();
        // 确保偶数线程线先获取到锁
        Thread.sleep(1);
        odd.start();
    }


    /**
     * 上面为了直观起见，将两个线程都独立写了出来，
     * 其实 Thread 中的代码是相同的，可以抽成一个 Runnable 类
     */

    public void turning() throws InterruptedException {
        new Thread(new TurningRunner(), "偶数").start();
        // 确保偶数线程线先获取到锁
        Thread.sleep(1);
        new Thread(new TurningRunner(), "奇数").start();
    }

    class TurningRunner implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                // 获取锁
                synchronized (lock) {
                    // 拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    // 唤醒其他线程
                    lock.notifyAll();
                    try {
                        if (count <= 100) {
                            // 如果任务还没有结束，则让出当前的锁并休眠
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args){
        turning1();
    }


}
