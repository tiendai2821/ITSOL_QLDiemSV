package util;

public class StringUtil {
// kiểm t
    public static boolean isNullOrEmpty(String str) {
        return DataUtil.isNullOrEmpty(str) && str.trim().isEmpty();
    }
    // String Null or empty và String bỏ đầu, cuối trống
}
