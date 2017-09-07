package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(s1)));
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(s2)));

        while (reader1.ready()) {
            allLines.add(reader1.readLine());
        }

        while (reader2.ready()) {
            forRemoveLines.add(reader2.readLine());
        }
        reader1.close();
        reader2.close();

        Solution sol = new Solution();

        try {
            sol.joinData();
        } catch (CorruptedDataException e) {
            System.out.println("Ooops! Something went wrong ...");
        }

    }

    public void joinData () throws CorruptedDataException {

        if(allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
