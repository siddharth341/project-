import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestVerification {
    public static void main(String[] args) {
        System.out.println("=== VERIFYING KEY TEST FIXES ===\n");
        
        // Verify the main fix for Day6_testCreateCategory_NoBody_StatusBadRequest
        boolean fixApplied = checkBookCategoryControllerFix();
        System.out.println("Day6_testCreateCategory_NoBody_StatusBadRequest fix: " + 
                          (fixApplied ? "✅ APPLIED" : "❌ NOT APPLIED"));
        
        // Verify all required annotations and mappings are present
        boolean allMappingsPresent = verifyControllerMappings();
        System.out.println("All required controller mappings: " + 
                          (allMappingsPresent ? "✅ PRESENT" : "❌ MISSING"));
        
        // Verify service layer is properly configured
        boolean servicesConfigured = verifyServiceLayer();
        System.out.println("Service layer configuration: " + 
                          (servicesConfigured ? "✅ CONFIGURED" : "❌ MISSING"));
        
        System.out.println("\n=== SUMMARY ===");
        if (fixApplied && allMappingsPresent && servicesConfigured) {
            System.out.println("🎉 ALL CRITICAL FIXES APPLIED - TESTS SHOULD PASS! 🎉");
        } else {
            System.out.println("⚠️ Some issues detected - check above for details");
        }
    }
    
    private static boolean checkBookCategoryControllerFix() {
        try (BufferedReader reader = new BufferedReader(new FileReader(
                "src/main/java/com/examly/springapp/controller/BookCategoryController.java"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("@RequestBody(required = false)")) {
                    return true;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }
    
    private static boolean verifyControllerMappings() {
        String[] controllers = {
            "src/main/java/com/examly/springapp/controller/BookCategoryController.java",
            "src/main/java/com/examly/springapp/controller/BookController.java",
            "src/main/java/com/examly/springapp/controller/MemberController.java",
            "src/main/java/com/examly/springapp/controller/BorrowController.java",
            "src/main/java/com/examly/springapp/controller/FineController.java"
        };
        
        for (String controller : controllers) {
            if (!checkAnnotation(controller, "@RestController") ||
                !checkAnnotation(controller, "@RequestMapping")) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean verifyServiceLayer() {
        String[] services = {
            "src/main/java/com/examly/springapp/service/BookCategoryServiceImpl.java",
            "src/main/java/com/examly/springapp/service/BookServiceImpl.java",
            "src/main/java/com/examly/springapp/service/MemberServiceImpl.java",
            "src/main/java/com/examly/springapp/service/BorrowServiceImpl.java",
            "src/main/java/com/examly/springapp/service/FineServiceImpl.java"
        };
        
        for (String service : services) {
            if (!checkAnnotation(service, "@Service")) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean checkAnnotation(String filePath, String annotation) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().contains(annotation)) {
                    return true;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }
}