package tests.properties;

import config.CredConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class OwnerTest {
    CredConfig config = ConfigFactory.create(CredConfig.class);

    @Test
    @Tag("owner")
    void credentialTest() {
        String login = config.login();
        String password = config.password();
        String baseUrl = config.baseUrl();
        System.out.println("Login: "+login);
        System.out.println("Password: "+password);
        System.out.println("baseUrl: "+baseUrl);
    }
}
