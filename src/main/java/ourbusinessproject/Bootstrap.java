package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;

@Service
public class Bootstrap {

    private InitializationService initializationService;

    public Bootstrap(InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    @PostConstruct
    public void init() {
        try {
            initializationService.initProjects();
        } catch(RuntimeException error) {
            // rien
        }
    }

    public InitializationService getInitializationService() {
        return initializationService;
    }

    public void setInitializationService(InitializationService initializationService) {
        this.initializationService = initializationService;
    }


}
