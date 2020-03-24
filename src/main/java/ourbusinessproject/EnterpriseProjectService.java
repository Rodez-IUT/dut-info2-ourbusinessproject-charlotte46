package ourbusinessproject;

import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Object entity) {
        entityManager.persist(entity);
        entityManager.flush();
    }

    public Project findProjectById(Long idProject) {
        return entityManager.find(Project.class, idProject);
    }

    public Enterprise findEnterpriseById(Long idEnterprise) {
        return entityManager.find(Enterprise.class, idEnterprise);
    }

    public List<Project> findAllProjects() {
        String sql = "SELECT p FROM Project";
        TypedQuery<Project> projects =
                entityManager.createQuery(sql, Project.class);
        return projects.getResultList();
    }
}
