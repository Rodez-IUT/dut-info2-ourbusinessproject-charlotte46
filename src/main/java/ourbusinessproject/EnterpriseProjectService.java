package ourbusinessproject;

import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Project project) {
        entityManager.persist(project.getEnterprise());
        entityManager.persist(project);
        entityManager.flush();
    }

    public void save(Enterprise enterprise) {
        entityManager.persist(enterprise);
        entityManager.flush();
    }


    public Project findProjectById(Long idProject) {
        return entityManager.find(Project.class, idProject);
    }

    public Enterprise findEnterpriseById(Long idEnterprise) {
        return entityManager.find(Enterprise.class, idEnterprise);
    }

    public List<Project> findAllProjects() {

        String getProjectEnterprise = "SELECT p FROM Project p JOIN FETCH p.enterprise ORDER BY p.title";

        TypedQuery<Project> projects =
                entityManager.createQuery(getProjectEnterprise, Project.class);

        return projects.getResultList();
    }
}
