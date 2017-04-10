package java_test;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 */
public class CustomClassloadingExamples {
    public static class DiskLoader extends ClassLoader {
        public DiskLoader() {
            super(DiskLoader.class.getClassLoader());
        }

        public Class<?> loadFromDisk(String clzName) throws IOException {
            byte[] b = Files.readAllBytes(Paths.get(clzName));
            // String className = Paths.get(clzName).getFileName().toString().replaceFirst("[.][^.]+$", "");
            String className = "java_test.CustomClassloadingExamples";
            return defineClass(className, b, 0, b.length);
        }
    }

    public void findDeprecatedMethods(Class<?> clz) {
        for (Method m : clz.getMethods()) {
            for (Annotation a : m.getAnnotations()) {
                if (a.annotationType() == Deprecated.class) {
                    System.out.println(m.getName());
                }
            }
        }
    }

    @Deprecated
    public void deprMethod() {

    }

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        CustomClassloadingExamples rfx = new CustomClassloadingExamples();

        String clz = rfx.getClass().getResource("/java_test/CustomClassloadingExamples.class").getPath();

        DiskLoader dlr = new DiskLoader();
        Class<?> clzToTest = dlr.loadFromDisk(clz);
        rfx.findDeprecatedMethods(clzToTest);
    }
}