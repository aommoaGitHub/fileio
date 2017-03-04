#File Input and Output (Lab6)
Learn how to read and write files using Java I/O classes and catch exceptions.
There are tasks about reading a file in many solutions. Record the elapsed time and explain why some copy methods are faster or slower than others.
There are 3 classes
* FileUtil defines copy methods that will be used for each task.
* FileCopyTask perform file to copy
* Main for running the tasks

![alt text](https://github.com/aommoaGitHub/fileio/blob/master/FilrIO_UML.png "UML_FileIO")
UML of this project

No.| Tasks                                                                       | Time
---|-----------------------------------------------------------------------------|-------------:
 1 |copy the file one byte at a time                                             | 3.988400 sec
 2 |copy the file using a byte of array size 1KB (1024 bytes)                    | 0.006645 sec
 3 |copy the file using a byte of array size 4KB                                 | 0.005097 sec
 4 |copy the file using a byte of array size 16KB                                | 0.003818 sec
 5 |copy the file using a byte of array size 32KB                                | 0.002869 sec
 6 |copy the file using a byte of array size 64KB                                | 0.001742 sec
 7 |copy the file using a byte of array size 128KB                               | 0.003886 sec
 8 |copy the file using a byte of array size 256KB                               | 0.005368 sec
 9 |copy the file using BufferedReader and PrintWriter to copy **lines** of text | 0.097159 sec
10 |copy the file using BufferedReader and PrintWriter with an **array of char** | 0.041974 sec

About 10 tasks above, we can separate them into 2 group. Task 1 to 8 which read and write using `byte` (include a array of byte) is group 1. Task 9 and 10 which read and write using BufferedReader and PrintWriter using `String` and `array of char` is group 2.

Imagine that There is sand. Moving these sand to another place is *reading file*. Moving those sand to another place again is *writing file*.

**Task 1** is you move a grain of sand to another place at a time. How many times have you to take a grain of sand up and down? Surely, it should be the slowest task.

**Task 2-8** now you have a bucket in any size to move sand. But if the bucket is too big, you or your computer will work slower. From the table, elapsed time of task 2 is the highest and continue decrease to a minimum at task 6 (a byte of array size 64KB) and increase in next 2 tasks. 64KB as the capacity of RAM of your computer for putting data to be read or write. 128KB and 256KB are over. The overflow data are put in the main memory. The main memory is very very slower than RAM. More data be read in main memory means more time you have to spend. Therefore, the conclusion is a big size of an array of byte doesn't mean less time of reading and writing. It's one factor. The computer specification is one of power factor, too.

**Task 9-10** You must know the full path of reading and writing file. It read in byte --> byte[] --> a character (char) --> char[] --> String. Writing is the reverse path of reading. In Task 9, we read one line at a time and return in String so we have to pass the full path. Then we write that line to an output file so we have to pass the full path again, in opposite direction. But in Task 10, the path is final at char[]. We don't have to convert to String. Because task 10 has the shorter path than task 9 so task 10 is faster than task 9.
