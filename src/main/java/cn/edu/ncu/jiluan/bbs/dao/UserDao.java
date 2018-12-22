package cn.edu.ncu.jiluan.bbs.dao;

import cn.edu.ncu.jiluan.bbs.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by krito on 2018/12/19
 */
@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
    @Modifying
    @Transactional
    void deleteUserEntityByUserId(Integer userId);
}
