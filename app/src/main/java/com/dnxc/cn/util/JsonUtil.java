package com.dnxc.cn.util;

import com.dnxc.cn.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 张海洋
 * @Date on 2019/04/18.
 * @org 上海..科技有限公司
 * @describe
 */
public class JsonUtil {

    public static final String START_ARRAY = "[";
    public static final String END_ARRAY = "]";

    /**
     * 转化成实体类对象
     *
     * @param result
     * @param beanClass
     * @param <T>
     * @return
     */
    public static <T> T toBean(String result, Class<T> beanClass) {
        Gson gson = new Gson();
        T t = gson.fromJson(result, beanClass);
        return t;
    }

    /**
     * 本地存储
     * 把Map集合||List<Student> mList
     * 转化为json 类型的字符串
     *
     * @param src 得到结果 [{"key":"nage","value":12},{"key":"age","value":17}]    不是json数据   前后多[ ]
     * @return
     */
    public static String toJson(Object src) {
        return new Gson().toJson(src);
    }


    /**
     * 取数据  json 类型的字符串转化成List集合
     */
    public List<Student>   getList(String jsonStr){
        Gson mGson = new Gson();
        return mGson.fromJson(jsonStr, new TypeToken<List<Student>>() {
        }.getType());
    }

    /**
     * 提交服务器
     *
     * @param maps
     * @return
     */
    public static String toJson(Map<String, Object> maps) {
        JSONObject jsonObject = new JSONObject(maps);
        String jsonString = jsonObject.toString();
        return jsonString;
    }


    /**
     * 用于服务器返回数据
     *
     * @param jsonStr json类型的字符串
     * @param tC
     * @param <T>     转化的实体类
     * @return 使用         List<News> newsList = json2listT(jsonStr，News.class);
     */
    public static final <T> List<T> jsontoListBean(String jsonStr, Class<T> tC) {
        //json字符串不能为空
        if (BaseUtil.isEmpty(jsonStr)) return null;
        //json字符串必须为数组节点类型
        if (!(jsonStr.startsWith(START_ARRAY) && jsonStr.endsWith(END_ARRAY))) return null;
        List<T> listT = null;
        try {
            //创建泛型对象
            T t = tC.newInstance();
            //利用类加载加载泛型的具体类型
            Class<T> classT = (Class<T>) Class.forName(t.getClass().getName());
            List<Object> listObj = new ArrayList<Object>();
            //将数组节点中json字符串转换为object对象到Object的list集合
            listObj = new GsonBuilder().create().fromJson(jsonStr, new TypeToken<List<Object>>() {
            }.getType());
            //转换未成功
            if (listObj == null || listObj.isEmpty()) return null;
            listT = new ArrayList<T>();
            //将Object的list中的的每一个元素中的json字符串转换为泛型代表的类型加入泛型代表的list集合返回
            for (Object obj : listObj) {
                T perT = new GsonBuilder().create().fromJson(obj.toString(), classT);
                listT.add(perT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listT;
    }


}
