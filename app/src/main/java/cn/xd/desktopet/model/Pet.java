package cn.xd.desktopet.model;

import android.content.Context;
import android.content.SharedPreferences;

import cn.xd.desktopet.R;
import cn.xd.desktopet.util.MyApplication;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

/**
 * 宠物模型类
 */
public class Pet {

    /**
     * 使用整形常量表示不同的主题
     */
    public static final int themeDefault=0;
    /**
     * 姓名
     */
    public static String name;
    /**
     * 性别
     */
    public static String sex;
    /**
     * 主题
     */
    public static int theme;
    /**
     * 口头禅
     */
    public static String petPhrase;

    static{
        SharedPreferences sp = MyApplication.getContext().getSharedPreferences("pet", 0);
        name = sp.getString("name", "UnKnow");
        sex = sp.getString("sex", "Boy");
        theme = sp.getInt("theme", -1);
        petPhrase = sp.getString("petPhrase", "No Content");
    }

    /**
     * 获取静态图片资源
     */
    public static int getStillImageId(){
       return R.drawable.beaver;
    }

    /**
     * 获取动态Gif资源
     */

    public static int getMoveImageId(){
        return R.drawable.dance;
    }

    /**
     * 将宠物当前的设置信息保存到preference文件中
     * @param context
     */
    public static void save(Context context){
        SharedPreferences sp=context.getSharedPreferences("pet",0);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("name",name);
        editor.putString("sex",sex);
        editor.putInt("theme",theme);
        editor.putString("petPhrase",petPhrase);
        editor.commit();
    }


    /**
     * 宠物设置改变时改变Pet中的参数
     */
    public static void onPetStatusChanged(){
    }
}
