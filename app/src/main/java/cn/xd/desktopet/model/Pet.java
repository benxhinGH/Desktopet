package cn.xd.desktopet.model;

import android.content.Context;
import android.content.SharedPreferences;

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
    public static final int themeDefault = 0;
    public static final int theme1=1;
    public static final int theme2=2;


    /**
     * 使用整形常量表示要获取的图片类型
     */
    //静止时显示的图片
    public static final int typeStill=0;
    //空闲时显示的图片
    public static final int typeFree=3;

    /**
     * 信息窗口自动关闭
     */
    public static boolean msgWindowAutoClose=true;


    /**
     * 闲时时间间隔，以秒为单位
     */
    public static int freeTime=6;
    /**
     * 闲时动画持续时间,以秒为单位
     */
    public static int freeContinueTime=5;
    /**
     * 信息窗口持续时间，以秒为单位
     */
    public static int msgWindowContinueTime=4;
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


    static {
        SharedPreferences sp = MyApplication.getContext().getSharedPreferences("pet", 0);
        name = sp.getString("name", "UnKnown");
        sex = sp.getString("sex", "UnKnown");
        theme = sp.getInt("theme", 0);
    }





    /**
     * 将宠物当前的设置信息保存到preference文件中
     *
     * @param context
     */
    public static void saveSetting(Context context) {
        SharedPreferences sp = context.getSharedPreferences("pet", 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name", name);
        editor.putString("sex", sex);
        editor.putInt("theme", theme);
        editor.commit();
    }


    /**
     * 宠物设置改变时改变Pet中的参数
     */
    public static void onPetStatusChanged() {
    }
}
