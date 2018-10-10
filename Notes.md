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


## Day 5 - Sever-side Rendering

Real web sites have a technology stack. It often look like this: 

- Operating System

- Web Server

- Static Content

- Dynamic Content

- Persistent Data (i.e. a database)

In order to replicate this in a simple way, we first need to move the HTML code out of our java server and int separate HTML files. This is easy for static HTML files that will not change based on user input. But for pages that change dynamically, we need a way to read the HTML, identify what is dynamic, run code to generate that dynamic content and send it along as HTML.

In the late 1990's into the early 2000's a common way to do this was with a LAMP stack. LAMP stands for Linux (OS), Apache (Web server), PHP (dynamic content), MySQL (database). This was what Facebook originally used when it started in 2004.

For our inclass project, we'll use a simpler method for generating dynamic content and persistence (for now).

## Day 6 - CSS and Cryptohashes

### CSS - CSS

Cascading Style Sheets
- Separates how things look (CSS) from what things say (HTML) and how things change (JS).
- Enterprise projects often use CSS meta-languages, for example SCSS
- name{} styles an element tag
- .name{} styles a class, i.e. <tag class="name">
- #name{} styles an id, i.e. <tag id="name">
- You can also style inline, i.e. <ta style="">
 
 ### Cryptohashes
 
 Users often reuse passwords. If a hacker accesses a server's password database, they should access be able to see your password. If they do, they could assume that your email/password combination would work on other sites as well.
 
 Cryptohashes protect against this and other security vulnerabilities.
 
 Instead of storing your password, the server stores evidence about your password.  As a simple example, all passwords can be treated as numbers. The server could store whether or not your password "number" is ever or odd. When your log in, the server could compare the evenness of your supplied password to the stored evenness in the password database. Obviously this is a bad example because everyother password would have the correct evenness (often called parity), so it would be easy to guess a matching password. Modern crypto hashes are much more complicated.
 
 Desired attributes of a cryptohash:
 - Deterministic
 - Irreversible
 - Collision Avoidance
 - Always the same length
 - Salt
 
 ## Day 7 - Career Fair & Encryption
 
 ### Your career
 
 Part of preparing for a job is using the technology usid in the workplace. A great way to know what used in the "wild" is the [Stakcoverflow survey](https://insights.stackoverflow.com/survey/2018#technology).  Among other things, the survey points out that the most common computer language is javascript. With that in the mind, we'll be using javascript for much of the rest of this class. If you want to learn javascript, I'd recommend the following resources:
 - Google it
 - Code Academy (the free version)
 - W3schools
 
 Using the same tutorial, you'll also find that the most popular IDE right now is Visual Studio Code, so we'll be using that in class as well.
 
 Speaking of the workplace, take some time to polish up your resume. I'd recommend putting down in big, bold letters headers such as "Java - 2 years experence" for all the languages you know. Think back on every class you've taken at UNO-- you might be surprised how many big, bold headers you can come up with. If you can't decide which language to use at home for the sprint, use the stack overflow survey as you guide...it's a pretty good indicator of what people are using.
 
 ### Encryption
 
 Encryption is a huge part of the security aspect of communication networks, but encryption outdates the internet by millenia. We'll talk about the Caesar cipher in class, which is over two thousand years old. Attributed to Julius Caesar, the Caesar cipher  encrpyts plain text by taking each letter and moving it forward is the alphabet by three characters. For example, A becomes A->B->C->D, B becomes B->C->D->E, and C becomes C->D->E->F. Encrypting a simple work such as "cab" therefore would be encrypted as "fde".
 
 ## Day 8 - jQuery & Assymetric Encryption
 
 ### jQuery
 
 Modern client-side javascript relies frequently on a library called jQuery. jQuery, among other things, makes is easy to query the DOM for specific elements, get their contents, and update their values. As this is standard practice in industry, we will be doing this in class. 
 
 To use jQuery, include a script code that include jQuery. The best way to find this is to Google "jQuery cdn". This will lead you to jQuery's cdn page (https://code.jquery.com/) where you can choose between the uncompressed and minified versions. As with most js libraries, the uncompressed version provides code in a traditional, tab formatted, human-readable format. Minified, on the otherhand, is the same semantically, but has a smaller file size (and smaller download time) but is not human readable. Using special minifying algorithms, the code is shrunk by automatically remove white space, shrinking variable names, etc. Unless you want to read the code of the library, the minified version will usually suffice.
 
 To use jQuery, to get the text of an element in HTML, simple call $("#id").val(), where id is the id of the element. To set the value of id, use $("#id").html(val).
 
 ### Assymetric Encryption
 
 The Caeser cipher is an example of assymetric encryption--the key used to cipher the plain text and the key used to decipher the cipher text are differeent. This is different from symmentric encryption where the key to cipher and decipher is the same. 
 
 The Caeser cipher is easy to break using frequency analysis--look for the most common letter in the cipher text and assume that is an "e". By counting the difference between that letter and e, you know the key used to cipher the text.
 
 To avoid this, you can cipher the text with a key of length more that one. In this case, the text is broken down in n sets, where n is the length of the key. Each set is ciphered with each letter of the key. In this case, letters in the plain text do not always map to the same letter in cipher text. This makes frequency analysis harder to do, but it is still not hard with a computer. By iterating over possible key lengths, a computer can deduce the key length by finding a key length where the frquency of cipher text letters matches the plain text language and then working backwards as with the Caesar cipher.
 
 The one way to avoid frequency analysis is to use a "one-time pad". In this case, the key is as long as the plain text and is truly random. With a one-time pad there is no way to do frquency analysis as there is no statistical method of analysis available.
 
 
 ## Day 9 - vueJS & Digital Signatures
 
 ### Vue
 
 One way to think about your goal as a programmer is to make your code **clear** and **concise**. If your code is clear, you can read it and so can the people who will work with your code. If your code is concise, it will be easier to debug and refactor. These two often go together with clear code being concise and vis versa.
 
 In javascript, in recent years that have been several MVC libraries released that help make your js code and html much more clear and concise. Right now, the most popular ones are React and Angular. Both are very powerful and would be great to have on your resume. Unfortunately, they each have a little more of a learning curve than this class allows, so we will use a more recent library called vue (pronnounced view). Vue follows many of the same principles of React and Angular (specifically Angular) and will help you prepare to learn those languages. 

### Digital Signatures

For centuries people have used different techniques to prove that letters have come from the person from whom they claimed to come.
Before general literacy, royalty proved that a letter was transcribed in their behalf by placing their seal on wax on the letter. As more and more people learned to read and write, people began signing their letters. With signatures, the thought was that since your signature was unique and known to the recipient, a fraudelent letter could be detected by the recipient.

On the internet, the possibility for fraud is rampant. Since the recipient of a message only receives a series of bytes, it is easy to impersonate a message--hence the need for digital signatures.  This leads to to the need for assymetric encryption.

With assymetric encryption there are two keys. Anything ciphered by one key can be deciphered by the other and vis versa.  On the internet, parties who want to exchange information securely need to both encrypt their conversation and assure the recipient that the message indeed came from them.  To do this, both parties generate a key pair. One of the keys they keep secret and call their "private" key. The other key they can safely share with anyone (specifically the other party) and is called their "public" key. With modern encryption algorithms, it is intractible to go from one key to its pair in a reasonable amount of time, so sharing a public key (in theory) doesn't mean an opponent can derive your private key.

To digitally sign a message, the sender concatonates the plain text with the plain text encrypted with the senders private key. Anyone with the public key can decrypt the second half of the message. This does not provide any secrecy--in fact the ciphered text is already available as plain text. However, since only one person has the private key (the sender), the fact that deciphering the cipher text produced the plain text proves that the person who sent the message was indeed the real sender.

#### Practical example from class



- Client

Plain Text: Put Money in my account

Public Key: d

Private Key: x

Cipher Text: mrqjlkbvfkjvxzzlrkq

Message to Server =>Put Money in my account+mrqjlkbvfkjvxzzlrkq

- Server:

Knows Client's public Key: d

Plain Text: putmoneyinmyaccount

Cipher Text: putmoneyinmyaccount

Checks out!

## Responsive CSS & SSL/TLS

Today:
-Download VS Code (if you want)
-eventually we'll go to https://github.com/bricksSeeds/html.vuejs

CSS Libraries
- Bootstrap (Twitter)
- Foundation
- Skeleton

We'll cover Vuetify

Common themes across responsive layout libraries:
- Repsonsive grid. A responsive grid changes the size of grid items based on breakpoints. Breakpoints are based on the size of the screen, roughly corresponding the the size of phones, tablets, small screens, wide screens, and huge screens.
- Advanced components. HTML gives you some basic UI components (input fields, etc.), but they don't give you the rich set of components you are used to on most websites. A robust library will give you a solid component set that includes cards, etc. 



New Technology:
-Material
-Vuetify
-Catch us up on moden CSS

-Cover SSL and TLS

-The slides for today are on github already (fyi)



--SSL/TLS (Secure Socket Layer/Transport Layer Security)

Goals:
1. Recipient knows the message came from sender and hasn't been changed.
2. Sender and recipient know that no one else can read the message.

Step:
1. Use assymetric keys to establish communication
2. Use symmetic encryption using a "one-time pad"

Today we're focused on the first step.

Signing->Method of guaranteeing that the message came from you and wasn't changed.

Signing. 
- Sender generates a public and private key. 
- Encrypts message with priavte key. 
- Send plain message with encrypted "signature"
- Recipient can decipher signature to ensure authenticity.

Encryption.
- Sender enrypts message with recipients public key.
- Sender sends cipher text.
- No one can read message without recipients private key.
- Recipient deciphers message.
- Message was safely sent.

Put it together:
- Sender ciphers message with senders private key (signature).
- Sender ciphers new message with recipient's public key.
- No one can read the message but the recipient.
- Recipient deciphers with recipient's private key.
- Recipient ensures authenticity with sender's public key.

3 Party Encryption.

Key Authorities or Certificate Authorities -> See Slides under Encryption Repo.


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


