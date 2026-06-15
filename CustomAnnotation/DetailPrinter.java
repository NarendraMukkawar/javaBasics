package CustomAnnotation;

import java.lang.reflect.Field;

public class DetailPrinter {
    public static void printObject(Object obj) {
        Class<?> clazz = obj.getClass();

        if (clazz.isAnnotationPresent(DumpDetails.class)) {
            System.out.println("=== Class Details: " + clazz.getSimpleName() + " ===");
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    System.out.println("  " + field.getName() + " -> " + field.get(obj));
                } catch (IllegalAccessException e) {
                    System.out.println("Could not read field: " + field.getName());
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Student myStudent = new Student();
        printObject(myStudent);
    }
}
