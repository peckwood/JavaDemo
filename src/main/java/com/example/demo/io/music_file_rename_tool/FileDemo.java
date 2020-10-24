package com.example.demo.io.music_file_rename_tool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class FileDemo {
    public static void main(String[] args) {
        File musicFolder = new File("D:\\music");
        List<File> mp3Files = new ArrayList<>();
        List<File> wavFiles = new ArrayList<>();
        List<File> lyricFiles = new ArrayList<>();
        List<File> allFiles = new ArrayList<>();
        List<File> folders = new ArrayList<>();
        Set<String> fileTypes = new HashSet<>(2);
        List<String> nullFileTypeNames = new ArrayList<>();
        int maxAuthorLength = 0;
        int maxSongNameLength = 0;
        //Read List of Files in Directory
        Arrays.stream(musicFolder.listFiles()).forEach(file -> {
            //Check if Path is File or Directory
            if (file.isDirectory()) {
                folders.add(file);
                System.out.println("dir: " + file);
                Arrays.stream(file.listFiles()).forEach(subFolderFile -> {
                    if (!subFolderFile.isDirectory()) {
                        allFiles.add(subFolderFile);
                    }
                });
            } else {
                allFiles.add(file);
                //System.out.println("file: " + file);


            }
        });

        System.out.println(String.format("%60s|%60s", "Author", "Song"));
        for (File file : allFiles) {
            File1 file1 = null;
            try {
                String fileType = Files.probeContentType(file.toPath());
                //.mp3
                if ("audio/mpeg".equals(fileType)) {
                    wavFiles.add(file);
                    file1 = new File1(file, file.getName(), FileType.WAV);
                    //.wav
                } else if ("audio/wav".equals(fileType)) {
                    mp3Files.add(file);
                    file1 = new File1(file, file.getName(), FileType.MP3);
                    //.lrc
                } else if (fileType == null) {
                    file1 = new File1(file, file.getName(), FileType.LYRIC);
                    nullFileTypeNames.add(file.getName());
                    lyricFiles.add(file);
                } else {
                    try {
                        throw new Exception("Unexpected file type: " + fileType);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                fileTypes.add(fileType);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String originalFileName = file1.getOriginalName();
            int dotIndex = originalFileName.lastIndexOf(".", originalFileName.length() - 4);
            String fileNameWithoutExtension = originalFileName.substring(0, dotIndex);
            file1.setFileNameWithoutExtension(fileNameWithoutExtension);

            int myFreeMP3Index = fileNameWithoutExtension.lastIndexOf(" my-free-mp3s.com ");
            if (myFreeMP3Index == -1) {
                myFreeMP3Index = fileNameWithoutExtension.lastIndexOf(" www.my-free-mp3.net ");
            }
            if (myFreeMP3Index != -1) {
                file1.setDownloadedFromMyFreeMP3(true);
            }
            if (myFreeMP3Index == -1) {
                myFreeMP3Index = fileNameWithoutExtension.lastIndexOf(" (online-audio-converter.com)");
            }

            if (myFreeMP3Index != -1) {
                file1.setFileNameWithoutExtensionAndMyFreeMP3(fileNameWithoutExtension.substring(0, myFreeMP3Index));
            } else {
                file1.setFileNameWithoutExtensionAndMyFreeMP3(fileNameWithoutExtension);
            }

            String[] splitFileName = file1.getFileNameWithoutExtensionAndMyFreeMP3().split(" - ");
            if (splitFileName.length == 2) {
                file1.setAuthorName(splitFileName[0]);
                file1.setSongName(splitFileName[1]);
                if (file1.getAuthorName().length() > maxAuthorLength) {
                    maxAuthorLength = file1.getAuthorName().length();
                }
                if (file1.getSongName().length() > maxSongNameLength) {
                    maxSongNameLength = file1.getSongName().length();
                }
                file1.setRegular(true);
                //irregular file
            } else {
                file1.setRegular(false);
            }
            String songOutput;
            if (file1.isRegular()) {
                songOutput = String.format("%60s|%60s", file1.getAuthorName(), file1.getSongName());
            } else {
                songOutput = "Irregular: " + file1.getFileNameWithoutExtensionAndMyFreeMP3();
            }
            System.out.println(songOutput);
        }

        //System.out.println("null fileTypes:" + nullFileTypeNames);
        System.out.println(fileTypes);
        System.out.println("max author length: " + maxAuthorLength);
        System.out.println("max song name length: " + maxSongNameLength);


    }

}
