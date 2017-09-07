package com.javarush.task.task22.task2208;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE

Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}

Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
// Variant 1.
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,String> pair : params.entrySet()) {
            if(pair.getKey() != null && pair.getValue() != null) {
                sb.append(pair.getKey()).append(" = ").append("'").append(pair.getValue()).append("'").append(" and ");
            }
        }

        return sb.substring(0,sb.toString().length()-5);
// Variant 2.
//        StringBuilder sb = new StringBuilder();
//        for (Map.Entry m : params.entrySet()) {
//            if (m.getValue() != null) {
//                if (sb.length() > 0)
//                    sb.append(" and ");
//                sb.append(m.getKey()).append(" = ").append("'").append(m.getValue()).append("'");
//            }
//        }
//        return sb.toString();
    }
}
