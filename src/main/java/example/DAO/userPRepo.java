package example.DAO;

import example.Entities.userP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface userPRepo extends JpaRepository<userP, Integer>{
    @Query("SELECT a from userP a where a.Account= :Account")
    userP findByAccount(@Param("Account") String Account);
}
