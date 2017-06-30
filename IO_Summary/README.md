一、JAVA流式输入/输出原理
　　
    ![输入/输出原理](picture/001.png)

　　流是用来读写数据的，java有一个类叫File，它封装的是文件的文件名，只是内存里面的一个对象，真正的文件是在硬盘上的一块空间，在这个文件里面存放着各种各样的数据，我们想读文件里面的数据怎么办呢？是通过一个流的方式来读，咱们要想从程序读数据，对于计算机来说，无论读什么类型的数据都是以010101101010这样的形式读取的。怎么把文件里面的数据读出来呢？你可以把文件想象成一个小桶，文件就是一个桶，文件里面的数据就相当于是这个桶里面的水，那么我们怎么从这个桶里面取水呢，也就是怎么从这个文件读取数据呢。

　　常见的取水的办法是我们用一根管道插到桶上面，然后在管道的另一边打开水龙头，桶里面的水就开始哗啦哗啦地从水龙头里流出来了，桶里面的水是通过这根管道流出来的，因此这根管道就叫流，JAVA里面的流式输入/输出跟水流的原理一模一样，当你要从文件读取数据的时候，一根管道插到文件里面去，然后文件里面的数据就顺着管道流出来，这时你在管道的另一头就可以读取到从文件流出来的各种各样的数据了。当你要往文件写入数据时，也是通过一根管道，让要写入的数据通过这根管道哗啦哗啦地流进文件里面去。除了从文件去取数据以外，还可以通过网络，比如用一根管道把我和你的机子连接起来，我说一句话，通过这个管道流进你的机子里面，你马上就可以看得到，而你说一句话，通过这根管道流到我的机子里面，我也马上就可以看到。有的时候，一根管道不够用，比方说这根管道流过来的水有一些杂质，我们就可以在这个根管道的外面再包一层管道，把杂质给过滤掉。从程序的角度来讲，从计算机读取到的原始数据肯定都是010101这种形式的，一个字节一个字节地往外读，当你这样读的时候你觉得这样的方法不合适，没关系，你再在这根管道的外面再包一层比较强大的管道，这个管道可以把010101帮你转换成字符串。这样你使用程序读取数据时读到的就不再是010101这种形式的数据了，而是一些可以看得懂的字符串了。

   流是用来读写数据的，java有一个类叫File，它封装的是文件的文件名，只是内存里面的一个对象，真正的文件是在硬盘上的一块空间，在这个文件里面存放着各种各样的数据，我们想读文件里面的数据怎么办呢？是通过一个流的方式来读，咱们要想从程序读数据，对于计算机来说，无论读什么类型的数据都是以010101101010这样的形式读取的。怎么把文件里面的数据读出来呢？你可以把文件想象成一个小桶，文件就是一个桶，文件里面的数据就相当于是这个桶里面的水，那么我们怎么从这个桶里面取水呢，也就是怎么从这个文件读取数据呢。

　　常见的取水的办法是我们用一根管道插到桶上面，然后在管道的另一边打开水龙头，桶里面的水就开始哗啦哗啦地从水龙头里流出来了，桶里面的水是通过这根管道流出来的，因此这根管道就叫流，JAVA里面的流式输入/输出跟水流的原理一模一样，当你要从文件读取数据的时候，一根管道插到文件里面去，然后文件里面的数据就顺着管道流出来，这时你在管道的另一头就可以读取到从文件流出来的各种各样的数据了。当你要往文件写入数据时，也是通过一根管道，让要写入的数据通过这根管道哗啦哗啦地流进文件里面去。除了从文件去取数据以外，还可以通过网络，比如用一根管道把我和你的机子连接起来，我说一句话，通过这个管道流进你的机子里面，你马上就可以看得到，而你说一句话，通过这根管道流到我的机子里面，我也马上就可以看到。有的时候，一根管道不够用，比方说这根管道流过来的水有一些杂质，我们就可以在这个根管道的外面再包一层管道，把杂质给过滤掉。从程序的角度来讲，从计算机读取到的原始数据肯定都是010101这种形式的，一个字节一个字节地往外读，当你这样读的时候你觉得这样的方法不合适，没关系，你再在这根管道的外面再包一层比较强大的管道，这个管道可以把010101帮你转换成字符串。这样你使用程序读取数据时读到的就不再是010101这种形式的数据了，而是一些可以看得懂的字符串了。