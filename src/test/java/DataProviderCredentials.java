import org.testng.annotations.DataProvider;

public class DataProviderCredentials extends BaseTest{
    @DataProvider(name = "incorrectCredentials")
    public Object[][] provideIncorrectCredentials(){
        return new Object[][]{
                {"iana.kocharian@testpro.io", ""},
                {"", "CwqOPgQw"},
                {"iana.kocharian@testpro.io", "incorrectPassword"},
                {"incorrectEmail@testpro.io", "CwqOPgQw"},
                {"", ""}
        };
    }
}
