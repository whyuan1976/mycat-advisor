package org.apache.mycat.advisor.service.backstage.authorities;

import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.model.SysAuthorities;
import org.apache.mycat.advisor.service.backstage.base.BaseService;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2016/3/20.
 *
 * 系统权限
 */
public interface SysAuthoritiesService extends BaseService<SysAuthorities> {


    /**
     * 根据用户名获取到用户的权限并封装成GrantedAuthority集合
     *
     * @param username
     */
    public Collection<GrantedAuthority> loadUserAuthorities(String username);

    Page pageList(Map<String, Object> param);

    String getResIds(Long id);

    boolean changeRes(Map<String, Object> param);

    Page pageList(Map<String, Object> map, List<Long> authId);
}
