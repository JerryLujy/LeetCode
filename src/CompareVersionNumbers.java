/**
 * <h1>165. Compare Version Numbers</h1>
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * <p>
 * You may assume that the version strings are non-empty and contain only digits and the '.' character.
 * The '.' character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * <p>
 * Here is an example of version numbers ordering: 0.1 < 1.1 < 1.2 < 13.37
 *
 * @author Jerry
 * @since 1/25/17
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] numbers1 = version1.split("\\.");
        String[] numbers2 = version2.split("\\.");
        for (int i = 0; i < Math.max(numbers1.length, numbers2.length); i++) {
            int number1 = i < numbers1.length ? Integer.parseInt(numbers1[i]) : 0;
            int number2 = i < numbers2.length ? Integer.parseInt(numbers2[i]) : 0;
            if (number1 != number2) {
                return Integer.compare(number1, number2);
            }
        }
        return 0;
    }
}
