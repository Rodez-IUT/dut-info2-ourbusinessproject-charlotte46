package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitializationService {

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    private Project project1E1;
    private Project project1E2;
    private Project project2E1;

    private Enterprise enterprise1;
    private Enterprise enterprise2;

    @Transactional
    public void initProjects() {
        enterprise1 = new Enterprise();
        enterprise1.setName("Enterprise 1");
        enterprise1.setDescription("Enterprise 1 description");
        enterprise1.setContactName("Enterprise 1 Contact");
        enterprise1.setContactEmail("enterprise1@mail.com");

        enterprise2 = new Enterprise();
        enterprise2.setName("Enterprise 2");
        enterprise2.setDescription("Enterprise 2 description");
        enterprise2.setContactName("Enterprise 2 Contact");
        enterprise2.setContactEmail("enterprise2@mail.com");

        // si on ne respecte pas les règles des annotations
        // lors de la construction d'un objet
        // vu que la méthode est faite par transaction
        // s'il existe une erreur aucun objet n'est créé
        project1E1 = new Project("project1E1", "project1E1 description", enterprise1);
        project1E2 = new Project("project1E2", "project1E2 description", enterprise2);
        project2E1 = new Project("project2E1", "project2E1 description", enterprise1);

        enterpriseProjectService.save(project1E1);
        enterpriseProjectService.save(project1E2);
        enterpriseProjectService.save(project2E1);
    }

    public Project getProject1E1() {
        return project1E1;
    }

    public Project getProject1E2() {
        return project1E2;
    }

    public Project getProject2E1() {
        return project2E1;
    }

    public Enterprise getEnterprise1() {
        return enterprise1;
    }

    public Enterprise getEnterprise2() {
        return enterprise2;
    }
}
