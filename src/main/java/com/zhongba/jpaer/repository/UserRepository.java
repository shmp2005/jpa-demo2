package com.zhongba.jpaer.repository;

import com.zhongba.jpaer.base.BaseRespository;
import com.zhongba.jpaer.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends BaseRespository<UserEntity, Long> {

    @Query(value = "select * from t_user where t_age > ?1", nativeQuery = true)
    public List<UserEntity> ageMorethan(int age);

    @Transactional
    @Modifying
    @Query(value = "delete from t_user where t_id = ?1", nativeQuery = true)
    public void deleteQuery(int userId);
}
