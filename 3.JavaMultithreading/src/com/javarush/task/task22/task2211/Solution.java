package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String source = args[0];
        String destination = args[1];

        FileInputStream input = new FileInputStream(source);
        FileOutputStream output = new FileOutputStream(destination);

        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        byte[] buffer = new byte[input.available()];
        input.read(buffer);
        input.close();

        output.write(new String(buffer,utf8).getBytes(windows1251));
        output.close();
    }
}
