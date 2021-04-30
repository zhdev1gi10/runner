package com.chenxinhao.runner.web.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 陈鑫豪
 * @Time 2018/6/14
 */
@Entity
@Data
@Table(name = "at_manager")
public class Manager {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 50)
    private String username;

    @Column(length = 50)
    private String nickname;

    @Column(length = 50)
    private String password;
    @Column(length = 50)
    private String mobile;

    private Integer status;

    public Manager() {
    }
    public Manager(Long id){
        this.id = id;
    }
}
