package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    static {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }
    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }
    public interface ReadFileInterface {
        void setFileName(String fullFileName);
        String getFileContent();
        void join() throws InterruptedException;
        void start();
    }
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String fullFileName = "";
        String FileContent = "";

        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }
        public String getFileContent() {
            return this.FileContent;
        }
        public void run() {

            try {

                BufferedReader reader = new BufferedReader(new FileReader(this.fullFileName));

                while (reader.ready()) {
                    String s = reader.readLine();
                    this.FileContent += s + " ";
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
