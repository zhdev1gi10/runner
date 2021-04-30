package com.chenxinhao.runner.web.service;


import com.chenxinhao.runner.web.domain.Manager;

/**
 * 管理员服务接口
 * @author 陈鑫豪
 * @Time 2018/6/7
 */
public interface ManagerService {
    /**
     * 管理员登陆
     * @param username
     * @param password
     * @return
     */
    public Manager login(String username, String password);

    /**
     * 通过ID获取管理员信息
     * @param id
     * @return
     */
    public Manager detil(Long id);

    /**
     * 修改密码
     * @param id
     * @param newPassword
     * @return
     */
    public Manager update(Long id, String newPassword);
}
