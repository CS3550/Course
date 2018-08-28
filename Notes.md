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

# Notes from Day 3

Process on the same machine don't share memory, so they need a different way to communicate. The operating system provides this using *ports*. Ports are similar to the mailboxes in an old time hotel--partrons would leave messages for each other at the reception desk. Each box had a number (think port number) and this way they could communicate.

We will communicate over ports using sockets.

A *server* is a process that binds to a port and awaits for a *client* socket to connect. A server has a know address and answers questions. A client finds a server and asks questions.

In Java, server code has the following form:
- Create a server socket
- Wait for a client to connect
- Create connections to read and write to the client socket
- Communicate
- Close the socket

It's important for the server to the threaded, so that multiple clients can communicate with the socket simultaneously.

In Java, client code is simpler
- Attached to a server, which returns a socket
- Create connections to read and write to the server socket.
- Communicate

It's also import for the client to be threaded, especially if the client has any sort of UI.
