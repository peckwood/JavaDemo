

### p4

A demo to show the usages of `wait` and `notify`.

> ```
> https://howtodoinjava.com/java/multi-threading/wait-notify-and-notifyall-methods/
> ```

### p5  How p4 will work on a multiple-producer-multiple-consumer situation

1. shows you what is gonna happen when there are multiple producers and consumers in p4. Issues that happen when you use a single lock (queue itself ) when having multiple producers and consumers

   ```
   Consumer t8 has lock
   t8 consumed 1, integerQueue: []
   Consumer t8 notified All
   
   Consumer t7 has lock
   Queue empty, t7 waits.
   
   Consumer t10 has lock
   Queue empty, t10 waits.
   ```

   When a consumer consumed the last element, it releases the lock and waits. Now this lock should NOT be acquired by any consumers because they will just wait as well. We will fix this in p6 by using a write and read lock.

2. how to use ThreadFactory to create named threads with ThreadPoolExecutor, 

   I wanted to name threads based on their type (Producer or Consumer), but the `Runnable` passed to `CustomThreadFactory` is wrapped to a `Worker`

3. How to create a ExecutorService pool using `new ThreadPoolExecutor` instead of `Executors` And t

   1. The meanings of its params.
   2. How it manages the amount of threads

   > Dropbox\learning_notes\java\classes\ThreadPoolExecutor



