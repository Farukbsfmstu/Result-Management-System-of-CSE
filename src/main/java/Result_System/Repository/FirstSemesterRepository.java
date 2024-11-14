package Result_System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Result_System.Entity.FirstSemesterEntity;


@Repository
public interface FirstSemesterRepository extends JpaRepository<FirstSemesterEntity,Long> {

	@Query("SELECT u FROM FirstSemesterEntity u WHERE u.ID = :ID")
	FirstSemesterEntity getStudentResult(@Param("ID") Long studentID);

	
	
	@Query("SELECT DISTINCT s.Session FROM FirstSemesterEntity s")
	List<String> findDistinctSessions();
	
	
	
	 @Query("SELECT s FROM FirstSemesterEntity s WHERE s.Session = :session")
	 List<FirstSemesterEntity> findAllBySession(String session);
	 
	


	
	

}
