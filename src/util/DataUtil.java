package util;

public class DataUtil {
// Trả về True/False
    public static boolean isNullOrEmpty(Object obj) {
        return obj == null;
    }
//
    public static boolean isNullOrEmptyArray(Object[] obj) {
        return obj == null && obj.length == 0;
    }

}
