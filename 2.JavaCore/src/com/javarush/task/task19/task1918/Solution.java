package com.javarush.task.task19.task1918;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>
Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>
text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static int findB(String source, String find) {
        int result = 0;
        int i = 0;
        int nextI = 0;
        while (nextI >= source.length() || (i = source.indexOf(find, nextI)) != -1) {
            result++;
            nextI = i + find.length();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) return;
        BufferedReader rcon = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileIn = new BufferedReader(new FileReader(rcon.readLine()));
        rcon.close();

        StringBuilder sb = new StringBuilder();
        while (fileIn.ready()) {
            sb.append(fileIn.readLine());
        }
        fileIn.close();

        String str = sb.toString().replaceAll("\r\n", "");
        String begin = "<" + args[0];
        String end = "</" + args[0];
        int iBegin = 0;
        int iEnd = 0;

        while (iBegin != -1 && iBegin != str.length()) {
            iBegin = str.indexOf(begin, iBegin);
            iEnd = str.indexOf(end, iBegin);
            if (iEnd != -1) {
                for (int i = findB(str.substring(iBegin + begin.length(), iEnd), begin); i > 0; i--) {
                    iEnd = str.indexOf(end, iEnd + end.length());
                }
            }
            if (iBegin != -1 && iEnd != -1) {
                iEnd = iEnd + end.length() + 1;
                System.out.println(str.substring(iBegin, iEnd));
            }
            if (iBegin != -1) iBegin = iBegin + begin.length();
        }
    }
}