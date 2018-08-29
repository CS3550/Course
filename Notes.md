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

# Day 4 - A Wiki
 Distributed + Infrastructure + A Security Vulnerability

## Protocols Overview:

Common themes:

- Start Entire Message

-Identify their format

-Header (meta data)

-End Header

-Payload (actual data)

-End Entire Message


### Example: A book
Start with a cover (start message): Title, Author, Publisher and other meta data

Cover identifies what the book is--fiction/non-fiction, is it what I'm looking for, is it for me?

First page - Publisher info no one reads, then another title page, dedication page, empty pages (all more meta data).

Payload (the book content)

Back cover (end of entire message) ...or index or appendix or advertisements or a CD that your computer can't read because its a MAC.

### Another example:
CB radio communication:

BLEEP - This is K4545 to K6363. {Start Message + Meta Data}

[Message] {Payload}

BLEEP - Over and Out {End Message}


## HTTP Protocol:

### Request
First line:

[Request type] [requested URL] [Requested Protocol]

As an example

GET / HTTP/1.0

or

GET /index.html?q=Chocolate HTTP/1.1

The rest of the header is a series of Key: Value pairs

A blank line indicates that the request has ended (end of message).

### Response

First line

[Protocol] [Response Code] [Response Code Explanation]

For example

HTTP/1.0 200 OK

Response Codes:
- 200 - OK
- 404 - Not found
- 4xx - Bad request
- 5xx - Server error -- it's not you (browser), it's me (server). Usually, if you changed code and this starts appearing, you broke something (look for an exception).


## The Sprint
What to do in the Sprint

-Work on the Java server code.

-GitHub.com

--Student Pack

--Digital Ocean Credits

---Spin up an Apache server

---Spin up a node Server

-Namecheap get a domain. $.88 

-I will give a bunch of AWS credits

-Sign up for AWS - there area  lot of free things

-Learn JS HTML CSS

-Anything else relevant


