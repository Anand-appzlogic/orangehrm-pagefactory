package failure;

public class AIFailureAnalyzer {
	public static String analyze(String errorMessage) {

        if (errorMessage == null) {
            return "Unknown failure occurred.";
        }

        if (errorMessage.contains("NoSuchElementException")) {
            return "Element not found. Possible UI change or incorrect locator.";
        }

        if (errorMessage.contains("TimeoutException")) {
            return "Page or element load timeout. Check waits or application speed.";
        }

        if (errorMessage.contains("AssertionError")) {
            return "Assertion failed. Actual result did not match expected result.";
        }

        if (errorMessage.contains("ElementNotInteractableException")) {
            return "Element present but not interactable. Possibly hidden or disabled.";
        }

        return "Unexpected error occurred. Manual investigation required.";
    }

	

}
