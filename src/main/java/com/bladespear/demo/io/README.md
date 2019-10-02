

#### BufferedOutputStream

why is BufferedInputStream and BufferedOutputStream faster than FileInputStream and FileOutputStream?

[answer](https://stackoverflow.com/a/18600383/986966)

### write vs flush vs close

- `flush` flushes buffered output stream, it has no effect on non-buffered output streams.
- `write` writes specified byte or bytes to output stream.
- `close` calls flush before closing

### BufferedInput/OutputStream converts Input/OutputStream to Reader/Writer

> http://tutorials.jenkov.com/java-io/index.html