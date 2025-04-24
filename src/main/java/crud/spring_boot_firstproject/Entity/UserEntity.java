package crud.spring_boot_firstproject.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "users") //users is database table name
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //Create constructor
    public UserEntity(Long id, String name, String email) {
        super(); //Calls parent class's constructor
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserEntity() {
        super(); //Calls parent class's constructor
    }
}
