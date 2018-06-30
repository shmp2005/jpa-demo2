package com.zhongba.jpaer.controller;

import com.zhongba.jpaer.base.PageInfo;
import com.zhongba.jpaer.entity.UserEntity;
import com.zhongba.jpaer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/list")
    public List<UserEntity> list() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/add")
    public String add() {
        UserEntity user = new UserEntity();
        user.setName("tang" + System.currentTimeMillis());
        user.setAddress("shanghai" + System.currentTimeMillis());
        user.setAge(new Random().nextInt(30) + 10);

        userRepository.save(user);

        return "add user successfully." + user;

    }

    @GetMapping(value = "/delete")
    public String delete(Long userId) {
        userRepository.deleteById(userId);

        return "delete user ok.";
    }

    @GetMapping(value = "/age")
    public List<UserEntity> age(int age) {
        return userRepository.ageMorethan(age);
    }

    @GetMapping(value = "/deleteWhere")
    public String deleteWhere(int userId) {
        userRepository.deleteQuery(userId);
        return "delete id: " + userId;
    }

    @GetMapping(value = "cutpage")
    public PageInfo<UserEntity> cutpage(int page) {
        PageInfo<UserEntity> pageInfo = new PageInfo<>();
        pageInfo.setSize(2);
        pageInfo.setSord(Sort.Direction.DESC);
        pageInfo.setPage(page);

        Sort sort = new Sort(pageInfo.getSord(), pageInfo.getSidx());
        PageRequest pageRequest = PageRequest.of(pageInfo.getPage() - 1, pageInfo.getSize(), sort);

        pageInfo.setResult(userRepository.findAll(pageRequest).getContent());

        return pageInfo;
    }
}
