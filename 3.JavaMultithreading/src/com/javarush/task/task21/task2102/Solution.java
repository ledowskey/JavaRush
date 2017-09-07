package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
*/
public class Solution {
    public static void main(String[] args) {
        int modifiersOfThisClass = Solution.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
        return Modifier.isStatic(allModifiers) && Modifier.isStatic(specificModifier)
                || Modifier.isPublic(allModifiers) && Modifier.isPublic(specificModifier)
                || Modifier.isAbstract(allModifiers) && Modifier.isAbstract(specificModifier)
                || Modifier.isPrivate(allModifiers) && Modifier.isPrivate(specificModifier)
                || Modifier.isFinal(allModifiers) && Modifier.isFinal(specificModifier)
                || Modifier.isInterface(allModifiers) && Modifier.isInterface(specificModifier)
                || Modifier.isNative(allModifiers) && Modifier.isNative(specificModifier)
                || Modifier.isProtected(allModifiers) && Modifier.isProtected(specificModifier)
                || Modifier.isStrict(allModifiers) && Modifier.isStrict(specificModifier)
                || Modifier.isSynchronized(allModifiers) && Modifier.isSynchronized(specificModifier)
                || Modifier.isTransient(allModifiers) && Modifier.isTransient(specificModifier)
                || Modifier.isVolatile(allModifiers) && Modifier.isVolatile(specificModifier);
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
