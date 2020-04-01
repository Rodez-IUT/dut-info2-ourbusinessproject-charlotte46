package ourbusinessproject;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    private String description;

    @NotNull
    @ManyToOne
    private Enterprise enterprise;

    public Project() {}

    public Project(String title, String description, Enterprise enterprise) {
        this.title = title;
        this.description = description;
        this.enterprise = enterprise;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        if (this.enterprise != null) {
                this.enterprise.getProjects().remove(this);
        }
        this.enterprise = enterprise;
        if (this.enterprise != null) {
            if (this.enterprise.getProjects() == null) {
                this.enterprise.setProjects(new ArrayList<>());
            }
            this.enterprise.getProjects().add(this);
        }
    }
}
