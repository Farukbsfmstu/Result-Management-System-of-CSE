package Result_System.Repository.AddAllResultRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Result_System.Entity.AddAllResultEntity.EighthSemesterResultEntity;


@Repository
public interface EighthSemesterResultRepository extends JpaRepository<EighthSemesterResultEntity,Long> {

	@Query("SELECT u FROM EighthSemesterResultEntity u WHERE u.ID = :ID")
	EighthSemesterResultEntity getStudentResult(@Param("ID") Long studentID);
	
}
