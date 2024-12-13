public class DataProviderCredentials extends BaseTest{
    @org.testng.annotations.DataProvider(name = "incorrectCredentials")
    public Object [][] provideIncorrectCredentials(){
        return new Object[][]{
                {"iana.kocharian@testpro.io", "incorrectPassword"},
                {"incorrect@Email.com", "CwqOPgQw"},
                {"iana.kocharian@testpro.io", ""},
                {"", "CwqOPgQw"},
                {"", ""},
        };
    }
}
