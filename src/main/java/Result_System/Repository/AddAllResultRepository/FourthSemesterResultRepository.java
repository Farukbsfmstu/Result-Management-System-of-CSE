package Result_System.Repository.AddAllResultRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Result_System.Entity.AddAllResultEntity.FourthSemesterResultEntity;
import Result_System.Entity.AddAllResultEntity.SecondSemesterResultEntity;

@Repository
public interface FourthSemesterResultRepository extends JpaRepository<FourthSemesterResultEntity,Long> {
  
	@Query("SELECT u FROM FourthSemesterResultEntity u WHERE u.ID = :ID")
	FourthSemesterResultEntity getStudentResult(@Param("ID") Long studentID);
}
