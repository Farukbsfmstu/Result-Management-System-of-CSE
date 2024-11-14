package Result_System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Result_System.Entity.ForuthFormFillupEntity;

@Repository
public interface FourthFormFillupRepository extends JpaRepository<ForuthFormFillupEntity,Long> {

	@Query("SELECT DISTINCT s.session FROM ForuthFormFillupEntity s")
    List<String> findDistinctSessions();
	
	 @Query("SELECT s.ID FROM ForuthFormFillupEntity s WHERE s.session = :session")
	 List<String> findStudentIdsBySession(@Param("session") String session);
	
}
