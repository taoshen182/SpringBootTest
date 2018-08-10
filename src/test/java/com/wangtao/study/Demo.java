package com.wangtao.study;

import com.wangtao.redis.RedisLock;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author : Twin
 * @Team Atplan
 * @date : 2018/8/10 10:30
 */

public class Demo {
    private static int[] num = new int[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50};

    private RedisTemplate redisTemplate;

    public Demo(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void test(int aa) {
        String key = "str" + aa;
        RedisLock lock = new RedisLock(redisTemplate, key, 10000, 20000);
        try {
            if (lock.lock()) {
                System.out.println(Thread.currentThread().getName() + ",key:" + key + "start ..." + System.currentTimeMillis());
                System.out.println("num[" + aa + "]:" + num[aa]);
                try {
                    num[aa]--;
                    if (num[aa] <= 0) {
                        System.out.println("num[" + aa + "]-->" + num[aa]);
                    } else {
                        Thread.sleep(3000);
                    }
                } catch (InterruptedException e) {
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //为了让分布式锁的算法更稳键些，持有锁的客户端在解锁之前应该再检查一次自己的锁是否已经超时，再去做DEL操作，因为可能客户端因为某个耗时的操作而挂起，
            //操作完的时候锁因为超时已经被别人获得，这时就不必解锁了。 ————这里没有做
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName() + ",key:" + key + "end ..." + System.currentTimeMillis());
    }
}
