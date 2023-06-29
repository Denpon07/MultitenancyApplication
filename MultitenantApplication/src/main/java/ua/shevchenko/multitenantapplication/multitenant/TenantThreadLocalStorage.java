package ua.shevchenko.multitenantapplication.multitenant;


public class TenantThreadLocalStorage {

    private static final ThreadLocal<String> tenant = new ThreadLocal<>();

    public static void setTenant(String tenantName) {
        tenant.set(tenantName);
    }

    public static String getTenant() {
        return tenant.get();
    }

    public static void clear() {
        tenant.remove();
    }
}
