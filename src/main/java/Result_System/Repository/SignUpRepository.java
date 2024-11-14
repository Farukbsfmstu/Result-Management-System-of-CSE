package Result_System.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Result_System.Entity.SingupEntityStudent;
@Repository
public interface SignUpRepository extends JpaRepository<SingupEntityStudent,Long> {
	
	@Query("SELECT u FROM SingupEntityStudent u WHERE u.username = :username")
    SingupEntityStudent getStudentByUsername(@Param("username") String username);

//for find result individual result	
	@Query("SELECT s.ID FROM SingupEntityStudent s WHERE s.username = :username")
	Long findStudentIdByUsername(@Param("username") String username);

}
