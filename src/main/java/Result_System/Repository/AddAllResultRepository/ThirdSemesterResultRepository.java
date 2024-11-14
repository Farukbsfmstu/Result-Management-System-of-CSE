package Result_System.Repository.AddAllResultRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Result_System.Entity.AddAllResultEntity.ThirdSemesterResultEntity;

@Repository
public interface ThirdSemesterResultRepository extends JpaRepository<ThirdSemesterResultEntity,Long> {
	
	
	@Query("SELECT u FROM ThirdSemesterResultEntity u WHERE u.ID = :ID")
	ThirdSemesterResultEntity getStudentResult(@Param("ID") Long studentID);
}
