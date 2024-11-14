package Result_System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import Result_System.Entity.StudentFormFillupEntity;

@Repository
public interface StudentFormFillupRepository extends JpaRepository<StudentFormFillupEntity,Long> {
	
	@Query("SELECT DISTINCT s.session FROM StudentFormFillupEntity s")
    List<String> findDistinctSessions();
	
	 @Query("SELECT s.ID FROM StudentFormFillupEntity s WHERE s.session = :session")
	 List<String> findStudentIdsBySession(@Param("session") String session);

//	@Query("SELECT s.ID FROM StudentFormFillupEntity s")
//	List<String> findAllStudentIds(); 

}