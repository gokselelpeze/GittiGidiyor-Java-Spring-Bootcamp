package service.loan.gittigidiyor_graduation_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import service.loan.gittigidiyor_graduation_project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Modifying
    @Query("update User u set u.fullName=?1, u.identityNumber=?2, u.monthlyIncome=?3,u.phoneNumber=?4 where u.id=?5")
    void updateUser(String fullName, String identityNumber, int monthlyIncome, String phoneNumber, int id);

    @Modifying
    void deleteUserById(int id);

    User findUserByIdentityNumber(String id);

    boolean existsByIdentityNumber(String id);
}
