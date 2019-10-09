package com.bladespear.demo.nio.D17_AsynchronousFileChannel_Demo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsynchronousFileChannelDemo {
    public static void main(String[] args) {
        approach1();
        //more tedious
        //approach2();
    }

    private static void approach1() {
        Path sourceImagePath = Paths.get("io/parrot.jpg");
        Path outputImagePath = Paths.get("nio/parrot_AsynchronousFileChannel_output.jpg");
        Path outputImagePath1 = Paths.get("nio/parrot_AsynchronousFileChannel_output1.jpg");
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        try (AsynchronousFileChannel inChannel = AsynchronousFileChannel.open(sourceImagePath, StandardOpenOption.READ);
             //AsynchronousFileChannel version
             AsynchronousFileChannel outChannel = AsynchronousFileChannel.open(outputImagePath, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE)
             //FileChannel version
             //FileChannel outChannel1 = FileChannel.open(outputImagePath1, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE)
        ) {
            int position = 0;
            while (true) {
                Future<Integer> readFuture = inChannel.read(buffer, position);
                while (!readFuture.isDone()) {
                }
                int bytesRead = readFuture.get();
                System.out.println("bytesRead: " + bytesRead);

                //AsynchronousFileChannel version
                if (bytesRead > 0) {
                    buffer.flip();
                    Future<Integer> writeFuture = outChannel.write(buffer, position);
                    //yes, you need to wait here, as well
                    while (!writeFuture.isDone()) {};
                } else {
                    break;
                }

                //FileChannel version
/*                if (bytesRead > 0) {
                    buffer.flip();
                    outChannel1.write(buffer);
                } else {
                    break;
                }*/
                //file channel version ends

                buffer.clear();
                position += bytesRead;

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void approach2() {
        Path sourceImagePath = Paths.get("io/parrot.jpg");
        Path outputImagePath2 = Paths.get("nio/parrot_AsynchronousFileChannel_output2.jpg");
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        //attachment is the bridge between outer class and inner class
        //it contains position and isAllDone
        //if you directly modify position or isAllDone, you will get 'variable is accessed from within inner class, it must be final or effectively final
        //you can also use the attachment parameter inside read() method to visit across scope
        final Attachment attachment = new Attachment();

        try (AsynchronousFileChannel inChannel = AsynchronousFileChannel.open(sourceImagePath, StandardOpenOption.READ);
             FileChannel outChannel2 = FileChannel.open(outputImagePath2, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE)) {

            while (!attachment.isDone()) {
                inChannel.read(buffer, attachment.getPosition(), null, new CompletionHandler<Integer, Object>() {
                    @Override
                    public void completed(Integer result, Object attachment1) {
                        //Attachment attachment1 = (Attachment) attachment;
                        int bytesRead = result;
                        System.out.println("bytesRead: " + bytesRead);

                        if (bytesRead > 0) {
                            buffer.flip();
                            try {
                                outChannel2.write(buffer);
                                buffer.clear();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            attachment.setPosition(attachment.getPosition() + bytesRead);
                        } else {
                            System.out.println("is all done!");
                            attachment.setDone(true);
                        }
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        System.err.println("FAILED");
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Attachment {
        private boolean done = false;
        private int position = 0;

        public Attachment() {
        }

        public boolean isDone() {
            return done;
        }

        public void setDone(boolean done) {
            this.done = done;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
