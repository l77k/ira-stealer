import java.lang.reflect.Method;

/**
 * Cleaned NativeInvoker (formerly g.java)
 * Acts as a bridge to invoke dynamic methods, often used for stealthy JNA/Native calls.
 */
public class NativeInvoker {
    
    /**
     * Dynamically invokes a method on a target object.
     * Formerly used to hide calls to JNA libraries.
     */
    public static Object invoke(Object target, String methodName, Object[] args) {
        try {
            if (target == null || methodName == null) return null;
            
            // Find the method by name and parameter types
            Class<?>[] parameterTypes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                parameterTypes[i] = args[i].getClass();
            }
            
            Method method = target.getClass().getDeclaredMethod(methodName, parameterTypes);
            method.setAccessible(true);
            return method.invoke(target, args);
        } catch (Exception e) {
            // Stealthy failure
            return null;
        }
    }
}
