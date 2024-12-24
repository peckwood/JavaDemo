package com.example.demo.breakpoint;

public class BreakpointTest {
    // https://stackoverflow.com/questions/76202690/intellij-idea-java-debugging-how-to-create-a-line-breakpoint-that-will-only-tri
    public static void main(String[] args) {
        String c = null;
        c.toString();
    }
}
