package Result_System.Repository.AddAllResultRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Result_System.Entity.AddAllResultEntity.SeventhSemesterResultEntity;
import Result_System.Entity.AddAllResultEntity.SixthSemesterResultEntity;

@Repository
public interface SeventhSemesterResultRepository extends JpaRepository<SeventhSemesterResultEntity,Long> {
   
	@Query("SELECT u FROM SeventhSemesterResultEntity u WHERE u.ID = :ID")
	SeventhSemesterResultEntity getStudentResult(@Param("ID") Long studentID);
}
