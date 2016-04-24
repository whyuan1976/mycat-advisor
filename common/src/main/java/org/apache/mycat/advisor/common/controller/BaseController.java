package org.apache.mycat.advisor.common.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2015/10/31.
 */
public abstract class BaseController {

   protected ResultMap success(Object object) {
       ResultMap resultMap = new ResultMap();
       resultMap.success(object);
       return resultMap;
   }

    protected ResultMap success(List list) {
        ResultMap resultMap = new ResultMap();
        Map<String, Object> data = new HashMap<>();
        data.put("list", list);

        resultMap.success(data);
        return resultMap;
    }
    protected ResultMap success(){
        ResultMap resultMap = new ResultMap();
        resultMap.success();
        return resultMap;
    }

    protected ResultMap failure(String msg) {
        ResultMap resultMap = new ResultMap();
        resultMap.failure(msg);
        return resultMap;
    }

    protected ResultMap failure(){
        ResultMap resultMap = new ResultMap();
        resultMap.failure();
        return resultMap;
    }

    protected ResultMap sucess(Page page) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageInfo", page.pageInfo);
        data.put("list", page.list);
        return success(data);
    }
    protected ResultMap sucess(Page page,Map<String,Object> map) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageInfo", page.pageInfo);
        data.put("list", page.list);
        data.putAll(map);
        return success(data);
    }
    
    protected Map<String,Object> object2map(Object o) {
        if (o == null) {
            return new HashMap<String, Object>();
        }
        Field[] fileds = o.getClass().getDeclaredFields();
        Map<String, Object> map = new HashMap<String, Object>();

        for (Field field : fileds) {
            field.setAccessible(true);

            try {
                map.put(field.getName(), field.get(o));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;

    }

    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
        //initDataBinder(request, binder);
    }
}
