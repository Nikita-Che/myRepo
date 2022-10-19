package com.webapp;

import com.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume();
        Field field = resume.getClass().getDeclaredFields()[0];
        field.setAccessible(true);  // возможность получать прайват поля и изменять его
        System.out.println(field.getName());
        System.out.println(field.get(resume));
        field.set(resume, "new_uuid");
        System.out.println(resume);

        System.out.println("_____________");
        Method method = Resume.class.getMethod("toString");
        method.setAccessible(true);
        method.invoke(resume);
        System.out.println(method.invoke(resume));

        System.out.println("_____________");
        Method method1 = Resume.class.getDeclaredMethod("toString",null);
        method1.setAccessible(true);
        method1.invoke(resume);
        System.out.println(method1.invoke(resume));
    }
}
