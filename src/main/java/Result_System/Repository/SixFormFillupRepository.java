package Result_System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Result_System.Entity.SixFormFillupEntity;

@Repository
public interface SixFormFillupRepository extends JpaRepository<SixFormFillupEntity,Long> {

	@Query("SELECT DISTINCT s.session FROM SixFormFillupEntity s")
    List<String> findDistinctSessions();
	
	 @Query("SELECT s.ID FROM SixFormFillupEntity s WHERE s.session = :session")
	 List<String> findStudentIdsBySession(@Param("session") String session);
	
}
