package Result_System.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Result_System.Entity.myAdmin;


@Repository
public interface AdminRepository  extends JpaRepository<myAdmin,Integer>  {

}
