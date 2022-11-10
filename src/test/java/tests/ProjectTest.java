package tests;

import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.ProjectsStep;

public class ProjectTest {
    ProjectTest projectTest = new ProjectsStep();

    @Test
    public void createProjectTest(){
        projectStep.createProject ("test1", "sdfsfsd", 1, falce, true, true);

    }
    @Test
    public void updateProjectTest(){
        Project project = new Project();
        project.setName("test2");
        project.setDescription("sdfsfsddddddf");
        project.setType(2);
        project.setShowAnon(falce);
        project.setAccess(true);
        project.setDeleted(true);

        projectStep.createProject (project);
    }
    @Test
    public void compareProjectTest() {
        Project project = new Project();
        project.setName("test2");
        project.setDescription("sdfsfsddddddf");
        project.setType(2);
        project.setShowAnon(falce);
        project.setAccess(true);
        project.setDeleted(true);

        Project project1 = new Project();
        project1.setName("test2");
        project1.setDescription("sdfsfsddddddf");
        project1.setType(2);
        project1.setShowAnon(falce);
        project1.setAccess(true);
        project1.setDeleted(true);

        Assert.assertEquals(project.equals(project1));
    }
}
