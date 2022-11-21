package adapters;

import models.Project;
import org.asynchttpclient.Response;
import utils.Endpoints;

public class ProjectAdapter extends BaseAdapter {

    public void  add(){

    }

    public Project[] getAllProjects(){
        Response response = given()
                .get(Endpoints.GET_ALL_PROJECT);

              return  gson.fromJson(response.getBody(), asPrettyString(),Project[].class);


    }
    public void getProject(){
    }
}