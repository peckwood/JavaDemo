package com.example.demo.nio.D16_Files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFileTreeDemo {
    public static void main(String[] args) throws IOException {
        Path startPath = Paths.get("D:/music");
        //Files.walkFileTree(startPath, new HashSet<FileVisitOption>(1).add(FileVisitOption.FOLLOW_LINKS), 2);
        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("going to visit dir " + dir.toAbsolutePath());
                    return super.preVisitDirectory(dir, attrs);
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileString = file.toAbsolutePath().toString();
                    //System.out.println("pathString = " + fileString);

                    if(fileString.endsWith(".mp3")){
                        System.out.println("music file found at path: " + file.toAbsolutePath());
                    }

                    if(fileString.endsWith(".lrc")){
                        System.out.println("lyric file found at path: " + file.toAbsolutePath());
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    System.out.println("done visiting dir: " + dir);
                    return super.postVisitDirectory(dir, exc);
                }
            });
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
