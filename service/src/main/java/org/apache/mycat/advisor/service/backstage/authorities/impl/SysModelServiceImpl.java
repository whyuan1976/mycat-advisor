package org.apache.mycat.advisor.service.backstage.authorities.impl;

import org.apache.mycat.advisor.persistence.dao.SysModulesMapper;
import org.apache.mycat.advisor.persistence.model.SysModules;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.backstage.authorities.SysModelService;
import org.apache.mycat.advisor.service.backstage.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cjl on 2016/3/20.
 */
@Service
public class SysModelServiceImpl extends BaseServiceImpl<SysModules> implements SysModelService {
    @Autowired
    private SysModulesMapper mapper;

    @Override
    protected MyMapper<SysModules> myMapper() {
        return mapper;
    }



    @Override
    public List<SysModules> tree() {
        List<SysModules> all = mapper.selectAll();


        List<SysModules> result = new ArrayList<>();

        toTree(all, result, 0L);

        return result;
    }

    @Override
    public boolean save(SysModules info) {
        int i = 0;
        if (info.getModuleId() != null) {
            i=mapper.updateByPrimaryKey(info);
        } else {
            info.setLeaf(1);
            i=mapper.insert(info);
            SysModules parent = mapper.selectByPrimaryKey(info.getParent());
            parent.setLeaf(0);
            mapper.updateByPrimaryKey(parent);
        }

        return i>0;
    }

    @Override
    public List<SysModules> all() {

        return mapper.selectAll();
    }

    @Override
    public List<SysModules> tree(List<Long> modelId) {
        List<SysModules> tree = tree();
        if (modelId != null && !modelId.isEmpty()) {
            for (int i = 0; i < tree.size(); i++) {
                if (modelId.contains(tree.get(i).getModuleId())){
                    tree.get(i).setCheck("checked");
                }
            }
        }
        return tree;
    }

    private void toTree(List<SysModules> all, List<SysModules> result, Long id) {
        List<SysModules> tmp = findModelsByParentId(all, id);
        for (SysModules modules : tmp) {
            result.add(modules);
            //非叶子节点,生成子节点树
            if (modules.getLeaf() != 1) {
                toTree(all, result, modules.getModuleId());
            }
        }
    }

    @Override
    public boolean delete(Long id) {
        SysModules node = mapper.selectByPrimaryKey(id);
        if (node.getParent() != 0) {
            SysModules where = new SysModules();
            where.setParent(node.getParent());
            List<SysModules> list = mapper.select(where);
            if (list.isEmpty()) {
                SysModules parent = mapper.selectByPrimaryKey(node.getParent());
                parent.setLeaf(1);
                mapper.updateByPrimaryKey(parent);
            }
        }

        return super.delete(id);
    }

    private List<SysModules> findModelsByParentId(List<SysModules> all, Long id) {
        List<SysModules> list = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getParent().equals(id)) {
                list.add(all.get(i));
            }
        }
        return list;
    }
}
