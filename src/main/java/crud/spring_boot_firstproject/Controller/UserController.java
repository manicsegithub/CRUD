package crud.spring_boot_firstproject.Controller;

import crud.spring_boot_firstproject.Entity.UserEntity;
import crud.spring_boot_firstproject.Exceptions.ResourceNotFoundException;
import crud.spring_boot_firstproject.Repository.UserRepository;
import crud.spring_boot_firstproject.Services.UserServices;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")

public class UserController {
//    @GetMapping
//    public String getUser(){
//        return "Hello Mani";
//    }

    //Use for Services
//    @GetMapping
//    public List<UserServices> getUser(){
//        return Arrays.asList(new UserServices(1L, "Mani","Mani@gmail.com"),
//                new UserServices(2L,"Magic","Magic@gmail.com"),
//                new UserServices(3L,"Bas","Bas@gmail.com"),
//                new UserServices(4L,"Rajammal","Raj@gmail.com"),
//                new UserServices(5L,"Manikandan","Manikandan@gmail.com"),
//                new UserServices(6L,"Maddy","Maddy@gmail.com")
//        );
//    }

    //Use for Entity
    @Autowired //It is used for object creating
    private UserRepository userRepository;

    //This is use GET method
    @GetMapping
    public List<UserEntity> getUser(){
        return userRepository.findAll();
    }

    //Create the user or Used for POST Method
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user){
        //System.out.println("User Date : " + user.getName() + "," + user.getEmail());
        //return null;

        return userRepository.save(user); //save is used for insert the data
    }

    //Get Single User API
//    @GetMapping("/{id}")
//    public Optional<UserEntity> getUserById(@PathVariable Long id){
//        return userRepository.findById(id);
//    }

    //Handling User and No User Error
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User is not Founded with this id " + id));
    }

    //Update User API
    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id,@RequestBody UserEntity user){
        UserEntity userData =  userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User is not Founded with this id " + id));
        userData.setEmail(user.getEmail());
        userData.setName(user.getName());
        return userRepository.save(userData);
    }

    //Delete the User API
    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteUser(@PathVariable Long id){
        UserEntity userData = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User is not Founded with this id " + id));
        userRepository.delete(userData);
        return ResponseEntity.ok().build();
    }

}
