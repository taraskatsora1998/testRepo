package comFinmatic.dto;

public class TestContextBusiness {
    private final String phoneBusiness;
    private final String emailBusiness;

    public TestContextBusiness() {
        this.phoneBusiness = getPhoneBusiness();
        this.emailBusiness = getEmailBusiness(this.phoneBusiness);
    }

    private String getEmailBusiness(String phoneBusiness) {
        return phoneBusiness + "@mailinator.com";
    }

    private String getPhoneBusiness() {
        long time = System.currentTimeMillis();
        final String timeStr = String.valueOf(time);
        final int timeLength = timeStr.length();
        String phoneNumber = "98" + timeStr.substring(timeLength - 7 , timeLength);

        return phoneNumber;
    }

    public String getPnoneBusiness() {
        return phoneBusiness;
    }

    public String getEmailBusiness() {
        return emailBusiness;
    }

}