package comFinmatic.dto;

public class TestContextPersonal {
    private final String phone;
    private final String email;
    private final String password;
    private final String registrationNumber;

    public TestContextPersonal() {
        this.phone = getPhone();
        this.email = getEmail(this.phone);
        this.password = "Aa123b123-1";
        this.registrationNumber = getUniqueRegistrationNumber();
    }

    private String getEmail(String phone) {
        return phone + "@mailinator.com";
    }

    private String getPhone() {
        long time = System.currentTimeMillis();
        final String timeStr = String.valueOf(time);
        final int timeLength = timeStr.length();
        String phoneNumber = "98" + timeStr.substring(timeLength - 7 , timeLength);

        return phoneNumber;
    }

    private String getUniqueRegistrationNumber() {
        long time = System.currentTimeMillis();
        final String timeStr = String.valueOf(time);

        return timeStr;
    }


    public String getPnone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

}
