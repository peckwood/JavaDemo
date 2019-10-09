package com.bladespear.demo.nio.D15_Path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
    public static void main(String[] args) {
        Path currentDir = Paths.get(".");;
        System.out.println("currentDir: " + currentDir.toAbsolutePath());

        Path apiDir = Paths.get("../api_boot");
        System.out.println("apiDir absolute path: " + apiDir.toAbsolutePath());

        System.out.println("apiDir absolute path normalized: " + apiDir.toAbsolutePath().normalize());
    }
}
