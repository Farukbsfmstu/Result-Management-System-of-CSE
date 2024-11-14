package Result_System.Repository.AddAllResultRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import Result_System.Entity.AddAllResultEntity.SixthSemesterResultEntity;

@Repository
public interface SixthSemesterResultRepository extends JpaRepository<SixthSemesterResultEntity,Long> {

	@Query("SELECT u FROM SixthSemesterResultEntity u WHERE u.ID = :ID")
	SixthSemesterResultEntity getStudentResult(@Param("ID") Long studentID);
	
}
