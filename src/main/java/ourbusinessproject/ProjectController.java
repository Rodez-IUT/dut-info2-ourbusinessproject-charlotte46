package ourbusinessproject;

import net.minidev.json.annotate.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    public ProjectController(EnterpriseProjectService enterpriseProjectService) {
        this.enterpriseProjectService = enterpriseProjectService;
    }

    @JsonIgnore
    @RequestMapping("/projectsWithEnterprises")
    @ResponseBody
    public String findAllProjectsWithEnterprises() {
        List<Project> projects = enterpriseProjectService.findAllProjects();

        StringBuilder response = new StringBuilder();

        for (Project project: projects) {
            response.append("<br/>"+ project.toString() + "<br/>");
        }

        return response.toString();
    }
}
