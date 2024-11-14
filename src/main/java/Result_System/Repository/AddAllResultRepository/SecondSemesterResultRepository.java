package Result_System.Repository.AddAllResultRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import Result_System.Entity.AddAllResultEntity.SecondSemesterResultEntity;

@Repository
public interface SecondSemesterResultRepository extends JpaRepository<SecondSemesterResultEntity,Long> {

	@Query("SELECT u FROM SecondSemesterResultEntity u WHERE u.ID = :ID")
	SecondSemesterResultEntity getStudentResult(@Param("ID") Long studentID);
	
}
