package crud.crud_mysql_api.repositories;


import crud.crud_mysql_api.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UserModel, Long> {

}
