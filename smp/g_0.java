import java.lang.invoke.*;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * Cleaned SecureDispatcher (formerly g_0.java)
 * Acts as a secure proxy for calling internal methods and detecting analysis environments.
 */
public class SecureDispatcher {

    /**
     * Verifies if the caller is legitimate and checks for analysis tools.
     */
    private static boolean isSafeToExecute(MethodHandles.Lookup lookup) {
        try {
            Class<?> caller = lookup.lookupClass();
            String name = caller.getName();
            
            // Block calls from standard Java/Internal classes or if it's being debugged
            if (name.startsWith("java.") || name.startsWith("jdk.") || name.startsWith("sun.")) {
                return false;
            }

            // Check for debugger arguments
            List<String> args = ManagementFactory.getRuntimeMXBean().getInputArguments();
            for (String arg : args) {
                String lower = arg.toLowerCase();
                if (lower.contains("jdwp") || lower.contains("debug") || lower.contains("agent")) {
                    return false; // Debugger detected!
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Secretly resolves and calls a method using MethodHandles.
     */
    public static CallSite bootstrap(MethodHandles.Lookup lookup, String methodName, MethodType type, 
                                   String targetClassName, String methodDescriptor, int typeId) throws Throwable {
        
        if (!isSafeToExecute(lookup)) {
            return new ConstantCallSite(MethodHandles.empty(type));
        }

        try {
            Class<?> targetClass = Class.forName(targetClassName, false, lookup.lookupClass().getClassLoader());
            MethodType targetType = MethodType.fromMethodDescriptorString(methodDescriptor, lookup.lookupClass().getClassLoader());
            
            MethodHandle handle;
            switch (typeId) {
                case 2: // Static call
                    handle = lookup.findStatic(targetClass, methodName, targetType);
                    break;
                case 4: // Special call
                    handle = lookup.findSpecial(targetClass, methodName, targetType, lookup.lookupClass());
                    break;
                default: // Virtual call
                    handle = lookup.findVirtual(targetClass, methodName, targetType);
                    break;
            }
            
            return new ConstantCallSite(handle.asType(type));
        } catch (Throwable t) {
            return new ConstantCallSite(MethodHandles.empty(type));
        }
    }
}
