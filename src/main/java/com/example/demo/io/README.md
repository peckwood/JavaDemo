

#### BufferedOutputStream

why is BufferedInputStream and BufferedOutputStream faster than FileInputStream and FileOutputStream?

[answer](https://stackoverflow.com/a/18600383/986966)

### write vs flush vs close

- `flush` flushes buffered output stream, it has no effect on non-buffered output streams.
- `write` writes specified byte or bytes to output stream.
- `close` calls flush before closing

### BufferedInput/OutputStream converts Input/OutputStream to Reader/Writer

> http://tutorials.jenkov.com/java-io/index.html

### D13_Pipe

data's structure

`[100][1][1]/[1][1]/[1][2]/[1][3]/...[1][89]/[2][144]/[2][233]...`

`NewIOFibonacciDriver` is copied from https://flylib.com/books/en/1.134.1/pipe_channels.html

- producer runnable can be constructed with how many numbers to generate
- better way to generate fibonacci numbers
- remembered to close the channels
- how to handle exceptions from finally block

`CustomNewIOFibonacciDriver` is my implementation (based on NewIOFibonacciDriver)

- removed unnecessary while loops
- Used ExecutorService to run threads