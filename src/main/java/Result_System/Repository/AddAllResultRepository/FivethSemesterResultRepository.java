package Result_System.Repository.AddAllResultRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Result_System.Entity.AddAllResultEntity.FiveSemesterResultEntity;
import Result_System.Entity.AddAllResultEntity.FourthSemesterResultEntity;

@Repository
public interface FivethSemesterResultRepository extends JpaRepository<FiveSemesterResultEntity,Long> {
   
	@Query("SELECT u FROM FiveSemesterResultEntity u WHERE u.ID = :ID")
	FiveSemesterResultEntity getStudentResult(@Param("ID") Long studentID);
}
