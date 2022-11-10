package tests;

import models.User;
import org.testng.annotations.Test;

public class UserTest {
    @Test
    public void  userTest(){
        User user = new User.Buider()
                .withEmail("dkhdbj")
                .withPassword("sjvkl")
                .build();
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
    }
}
