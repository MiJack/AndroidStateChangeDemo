package cn;

import android.app.Activity;
import android.view.View;

import com.mijack.XlogUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Member;

import static com.mijack.XlogBuilder.KEY_TO_VALUE2;

/**
 * @author Mi&Jack
 * @since 2018/7/15
 */

public class XlogStater {
    public static final String[] ACTIVITY_LIFECYCLE_METHOD_LIST = new String[]{
            ".onCreate(android.os.Bundle)",
            ".onStart()",
            ".onResume()",
            ".onPause()",
            ".onStop()",
            ".onDestroy()",};
    public static final String[] WIDGET_CLICK_METHOD_LIST = new String[]{
            ".onClick(android.view.View)"
    };

    public static String activityState(Object instance, Object[] args) {
        com.mijack.Xlog.logStaticMethodEnter("java.lang.String cn.XlogStater.activityState(java.lang.Object,[java.lang.Object)",instance,args);try{if (instance == null || !(instance instanceof Activity)) {
            {com.mijack.Xlog.logStaticMethodExit("java.lang.String cn.XlogStater.activityState(java.lang.Object,[java.lang.Object)");return "{}";}
        }
        Activity activity = (Activity) instance;
        {com.mijack.Xlog.logStaticMethodExit("java.lang.String cn.XlogStater.activityState(java.lang.Object,[java.lang.Object)");return activityDetailState(activity);}}catch(Throwable throwable){com.mijack.Xlog.logStaticMethodExitWithThrowable("java.lang.String cn.XlogStater.activityState(java.lang.Object,[java.lang.Object)",throwable);throw throwable;}
    }

    public static String activityDetailState(Activity activity) {
        com.mijack.Xlog.logStaticMethodEnter("java.lang.String cn.XlogStater.activityDetailState(android.app.Activity)",activity);try{StringBuilder sb = new StringBuilder();
        sb.append("{");
/*//        int i=0;*/
        Field[] declaredFields = activity.getClass().getDeclaredFields();
        for (int i = 0; declaredFields != null && i < declaredFields.length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            Field field = declaredFields[i];
            if (field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                sb.append(String.format(KEY_TO_VALUE2, field.getName(), XlogUtils.object2String(field.get(activity))));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        sb.append("}");
        {com.mijack.Xlog.logStaticMethodExit("java.lang.String cn.XlogStater.activityDetailState(android.app.Activity)");return sb.toString();}}catch(Throwable throwable){com.mijack.Xlog.logStaticMethodExitWithThrowable("java.lang.String cn.XlogStater.activityDetailState(android.app.Activity)",throwable);throw throwable;}
    }

    public static String widgetState(Object instance, Object[] args) {
        com.mijack.Xlog.logStaticMethodEnter("java.lang.String cn.XlogStater.widgetState(java.lang.Object,[java.lang.Object)",instance,args);try{if (args == null
                || args.length != 1
                || args[0] == null
                || !(args[0] instanceof View)
                ) {
            {com.mijack.Xlog.logStaticMethodExit("java.lang.String cn.XlogStater.widgetState(java.lang.Object,[java.lang.Object)");return "{}";}
        }
        View view = (View) args[0];
        if (view.getContext() == null || !(view.getContext() instanceof Activity)) {
            {com.mijack.Xlog.logStaticMethodExit("java.lang.String cn.XlogStater.widgetState(java.lang.Object,[java.lang.Object)");return "{}";}
        }
        Activity activity = (Activity) view.getContext();
        {com.mijack.Xlog.logStaticMethodExit("java.lang.String cn.XlogStater.widgetState(java.lang.Object,[java.lang.Object)");return activityDetailState(activity);}}catch(Throwable throwable){com.mijack.Xlog.logStaticMethodExitWithThrowable("java.lang.String cn.XlogStater.widgetState(java.lang.Object,[java.lang.Object)",throwable);throw throwable;}
    }

    public enum StateMethodType {
        /**
         * Activity的生命周期
         */
        ACTIVITY,
        /**
         * 点击事件
         */
        ON_CLICK,
        /**
         * 无需记录
         */
        NO_LOG;
    }

    public static StateMethodType getStateType(Member method) {
        com.mijack.Xlog.logStaticMethodEnter("StateMethodType cn.XlogStater.getStateType(java.lang.reflect.Member)",method);try{if (method == null) {
            {com.mijack.Xlog.logStaticMethodExit("StateMethodType cn.XlogStater.getStateType(java.lang.reflect.Member)");return StateMethodType.NO_LOG;}
        }
        if (Activity.class.isAssignableFrom(method.getDeclaringClass())) {
            for (String methodSign : ACTIVITY_LIFECYCLE_METHOD_LIST) {
                if (method.toString().endsWith(methodSign)) {
                    {com.mijack.Xlog.logStaticMethodExit("StateMethodType cn.XlogStater.getStateType(java.lang.reflect.Member)");return StateMethodType.ACTIVITY;}
                }
            }
            {com.mijack.Xlog.logStaticMethodExit("StateMethodType cn.XlogStater.getStateType(java.lang.reflect.Member)");return StateMethodType.NO_LOG;}
        }
        if (View.OnClickListener.class.isAssignableFrom(method.getDeclaringClass())) {
            for (String methodSign : WIDGET_CLICK_METHOD_LIST) {
                if (method.toString().endsWith(methodSign)) {
                    {com.mijack.Xlog.logStaticMethodExit("StateMethodType cn.XlogStater.getStateType(java.lang.reflect.Member)");return StateMethodType.ON_CLICK;}
                }
            }
            {com.mijack.Xlog.logStaticMethodExit("StateMethodType cn.XlogStater.getStateType(java.lang.reflect.Member)");return StateMethodType.NO_LOG;}
        }
        {com.mijack.Xlog.logStaticMethodExit("StateMethodType cn.XlogStater.getStateType(java.lang.reflect.Member)");return StateMethodType.NO_LOG;}}catch(Throwable throwable){com.mijack.Xlog.logStaticMethodExitWithThrowable("StateMethodType cn.XlogStater.getStateType(java.lang.reflect.Member)",throwable);throw throwable;}
    }
}
