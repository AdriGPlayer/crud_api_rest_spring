package crud.crud_mysql_api.services;

import crud.crud_mysql_api.models.UserModel;
import crud.crud_mysql_api.repositories.IUsuarioRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUsuarioRepository usuarioRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) usuarioRepository.findAll();

    }

    public UserModel saveUser(UserModel user){
        return usuarioRepository.save(user);
    }

    public Optional<UserModel> getByID(Long id){
        return usuarioRepository.findById(id);

    }

    public UserModel updateById(UserModel request, long id){
        UserModel user = usuarioRepository.findById(id).get();
       user.setName(request.getName());
       user.setLast_name(request.getLast_name());
       user.setEmail(request.getEmail());
       return user;
    }

    public Boolean deleteUser(long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
