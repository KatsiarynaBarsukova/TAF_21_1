package tests;

import models.Milestone;
import models.MilestoneBuilder;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.description;
import static org.openqa.selenium.By.id;

public class MilestoneTest {

    @Test
    public void lombokTest1(){
        Milestone milestone = new Milestone();
        milestone.setId(1);
        milestone.setName("kjvn");
        milestone.setDescription("skjn");
        milestone.setCompleted(false);

        Milestone milestone1 = new Milestone();
        milestone1.setId(2);
        milestone1.setName("kjvn");
        milestone1.setDescription("skjn");
        milestone1.setCompleted(false);

        System.out.println(milestone.toString());
        System.out.println(milestone1.toString());
        System.out.println(milestone.equals(milestone1));
       // System.out.println(milestone.getName());
       // System.out.println(milestone.isCompleted());
    }

    @Test
    public void lombokTest2(){
        MilestoneBuilder milestone = MilestoneBuilder.build();
        .id()
                .description("dkfjm")
                .name("dkfjm")
                .byild();

        MilestoneBuilder milestone1 = MilestoneBuilder.build();
               .id()
                .description("dkfjm")
                .name("dkfjm")
                .byild();

        System.out.println(milestone.toString());
        System.out.println(milestone1.toString());
        System.out.println(milestone.equals(milestone1));

    }

    private Test id() {
    }
}
