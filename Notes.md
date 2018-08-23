# Notes from Day 1

Everything in this class generally falls into what I call "Three Pillars of Networking":

- It is inherently *distributed*

- It has to run on the current *infrastructure*

- It has to be *secured*

# Notes from Day 2

Moving to distributed code -- threading.

To create threaded code:

- Create a class that implements Runnable
- Create an instance of Thread that takes an instance of your new class as a parameter in the constructor
- Call start() on your new Thread instance.
- Call join() to wait until the thread had finished running.

## Things to watch out for

- Threads run in the background and the spawing thread doesn't wait for them to finish before moving on.
- Thread that operate on the same memory can create unpredictable results. You need to *lock* operations that multiple threads might simultaneouly call.

We created a simple example of threads and these gottchas in this folder: https://github.com/CS3550/Course/tree/master/simplethreads
