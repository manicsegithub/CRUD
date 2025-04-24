package crud.spring_boot_firstproject.Services;

public class UserServices {
    private long id;
    public void setId(Long id){
        this.id = id;
    }
    public long getId() {
        return id;
    }

    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    private String email;
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    //constructor
    public UserServices(Long id, String name, String email){
        super();
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
