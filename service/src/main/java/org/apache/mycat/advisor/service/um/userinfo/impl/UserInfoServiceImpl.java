package org.apache.mycat.advisor.service.um.userinfo.impl;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.dao.TabUserInfoMapper;
import org.apache.mycat.advisor.persistence.model.TabUserInfo;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.base.BaseServiceImpl;
import org.apache.mycat.advisor.service.um.userinfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2016/3/20.
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<TabUserInfo> implements UserInfoService {
    @Autowired
    TabUserInfoMapper tabUserInfoMapper;
    @Override
    protected MyMapper<TabUserInfo> myMapper() {
        return tabUserInfoMapper;
    }

    @Override
    public TabUserInfo findUserByUsername(String userName) {
        TabUserInfo userInfo = new TabUserInfo();
        userInfo.setUsername(userName);

        return tabUserInfoMapper.selectOne(userInfo);
    }

    @Override
    public Page<TabUserInfo> page(Map<String, Object> param) {
        return super.page(param);
    }

    @Override
    public List<TabUserInfo> findAll() {
        return tabUserInfoMapper.selectAll();
    }

    @Override
    public TabUserInfo findByUsernameAndPassword(String username, String password) {
        TabUserInfo userInfo = new TabUserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);

        return tabUserInfoMapper.selectOne(userInfo);
    }

    @Override
    public boolean save(TabUserInfo o) {
        if (o.getId() != null) {
            o.setUpdateTime(new Date());
            return super.update(o);
        }
        o.setInsertTime(new Date());
        o.setUpdateTime(new Date());
        return super.saveOrUpdate(o);
    }

    @Override
    public Page<Map> pageList(Map<String, Object> param) {
        pageBegin(param);
       /* List<Ext> extList = new ArrayList<>();
        for (int i=0;i<5;i++){
            Ext ext1 = new Ext();
            ext1.start();
            extList.add(ext1);
        }
        for (int i=0;i<5;i++){
            try {
                extList.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int sum = 0;
        for (int i=0;i<5;i++) {
            sum += extList.get(i).getInt();
        }
	@Override
	public List<TabUserInfo> getAllByUsername(String name) {
		 TabUserInfo userInfo = new TabUserInfo();
	     userInfo.setUsername(name);
		return tabUserInfoMapper.getAllByName(userInfo);
	}

<<<<<<< .mine

        System.out.println(sum);
*/


        Object code = param.get("code");
        String str="%%";
        if (code!=null&&StringUtils.isNotEmpty(code.toString())) {
            str = "%" + code + "%";
        }
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(tabUserInfoMapper.findByNameOrCode(str));
        return twoPage(pageInfo);
    }

    @Override
    public List<Map<String, Object>> findListMapByUserName(String query) {


        return tabUserInfoMapper.findListMapByUserName("%"+query+"%");
    }

    @Override
    public TabUserInfo get(long id) {
        TabUserInfo tabUserInfo = tabUserInfoMapper.selectByPrimaryKey(id);
        Map<String,Object> ext = tabUserInfoMapper.getCompanyAndPostByUserId(id);
        if (ext != null) {
            Object companyName = ext.get("companyName");
            Object postName = ext.get("postName");
            tabUserInfo.setCompanyName(companyName!=null?companyName.toString():"");
            tabUserInfo.setPostName(postName!=null?postName.toString():"");
        }


        return tabUserInfo;
    }
=======



































>>>>>>> .theirs
}
