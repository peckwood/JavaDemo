package com.bladespear.demo.io.music_file_rename_tool;

import java.io.File;

public class File1 {
    private File file;
    private String originalName;
    private String fileNameWithoutExtension;
    private String fileNameWithoutExtensionAndMyFreeMP3;
    private FileType fileType;

    private boolean downloadedFromMyFreeMP3;
    private boolean regular;

    private String songName;
    private String authorName;

    public File1(File file, String originalName, FileType fileType) {
        this.file = file;
        this.originalName = originalName;
        this.fileType = fileType;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getFileNameWithoutExtension() {
        return fileNameWithoutExtension;
    }

    public void setFileNameWithoutExtension(String fileNameWithoutExtension) {
        this.fileNameWithoutExtension = fileNameWithoutExtension;
    }

    public String getFileNameWithoutExtensionAndMyFreeMP3() {
        return fileNameWithoutExtensionAndMyFreeMP3;
    }

    public void setFileNameWithoutExtensionAndMyFreeMP3(String fileNameWithoutExtensionAndMyFreeMP3) {
        this.fileNameWithoutExtensionAndMyFreeMP3 = fileNameWithoutExtensionAndMyFreeMP3;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public boolean isDownloadedFromMyFreeMP3() {
        return downloadedFromMyFreeMP3;
    }

    public void setDownloadedFromMyFreeMP3(boolean downloadedFromMyFreeMP3) {
        this.downloadedFromMyFreeMP3 = downloadedFromMyFreeMP3;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isRegular() {
        return regular;
    }

    public void setRegular(boolean regular) {
        this.regular = regular;
    }
}
