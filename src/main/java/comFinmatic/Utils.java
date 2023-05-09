package comFinmatic;

public class Utils {
    public static String getFrontofficeUrl() {
        return System.getProperty("frontoffice", "https://dev.finmatic.net");
    }

    public static String getBackofficeUrl() {
        return System.getProperty("backoffice", "https://dev-admin.finmatic.net");
    }

    public static String getOpenPaydUrl() {
        return System.getProperty("openpayd", "https://sandbox.openpayd.com/account/login");
    }

    public static String getUser() {
        return System.getProperty("user", "635897003");
    }

    public static String getBrowser() {
        return System.getProperty("browser", "chrome");
    }
}