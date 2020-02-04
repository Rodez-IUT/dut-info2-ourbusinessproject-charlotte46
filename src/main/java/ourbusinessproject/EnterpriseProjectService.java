package ourbusinessproject;

import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
