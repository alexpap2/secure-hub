package authproject.secure_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RoleName name;

    public enum RoleName {
        ROLE_USER,
        ROLE_ADMIN
    }
    
    public Role() {}
    
    public Role(RoleName name) {
    	this.name = name;
    }

    public Long getId() {
        return id;
    }
    public RoleName getName() {
        return name;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(RoleName name) {
        this.name = name;
    }
    
}
