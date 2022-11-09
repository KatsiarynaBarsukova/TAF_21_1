package tests;

import models.Project;
import org.testng.annotations.Test;
import steps.ProjectsStep;

public class ProjectTest {
    ProjectTest projectTest = new ProjectsStep();

    @Test
    public void createProjectTest(){
        projectStep.createProject ("test1", "sdfsfsd", falce);

    }
    @Test
    public void updateProjectTest(){
        Project project = new Project();
        project.setName("est");
        projectStep.createProject ("test1", "sdfsfsd", falce);

    }


}
