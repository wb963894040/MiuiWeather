package com.hl.policeweather.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.widget.Toast;

import com.hl.policeweather.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AppUtils
{
    
    private Context mContext;
    
    public AppUtils(Context context)
    {
        this.mContext = context;
    }
    
    public static boolean checkBrowser(String packageName, Context context)
    {
        if (packageName == null || "".equals(packageName))
            return false;
        
        try
        {
            ApplicationInfo info = context.getPackageManager()
                    .getApplicationInfo(packageName,
                            PackageManager.GET_UNINSTALLED_PACKAGES);
            if (info == null)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        catch (NameNotFoundException e)
        {
            return false;
        }
    }
    
    /**
     * 获取当前应用程序的版本号
     *
     * @return
     */
    
    public String getVersionName()
    {
        try
        {
            PackageManager packageManager = mContext.getPackageManager();
            PackageInfo packInfo = packageManager
                    .getPackageInfo(mContext.getPackageName(), 0);
            String version = packInfo.versionName;
            return version;
        }
        catch (NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public int getVersionCode()
    {
        try
        {
            PackageManager packageManager = mContext.getPackageManager();
            PackageInfo packInfo = packageManager
                    .getPackageInfo(mContext.getPackageName(), 0);
            int version = packInfo.versionCode;
            return version;
        }
        catch (NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    /**
     * 获取当前正在运行的Activity
     *
     * @return <uses-permission android:name="android.permission.GET_TASKS"/>
     */
    public String getActivityName()
    {
        ActivityManager manager = (ActivityManager) mContext
                .getSystemService(Context.ACTIVITY_SERVICE);
        RunningTaskInfo info = manager.getRunningTasks(1).get(0);
        String shortClassName = info.topActivity.getShortClassName();
        System.out.println("shortClassName=" + shortClassName);
        return shortClassName;
    }
    
    /**
     * 安装指定文件路径的apk文件
     *
     * @param path
     */
    public void installApk(String path)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.fromFile(new File(path)),
                "application/vnd.android.package-archive");
        mContext.startActivity(intent); // 安装新版本
    }
    
    /**
     * 安装指定文件路径的apk文件
     *
     * @param context
     * @param path
     */
    public static void installApk(Context context, String path)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.fromFile(new File(path)),
                "application/vnd.android.package-archive");
        context.startActivity(intent); // 安装新版本
    }
    
    /**
     * 创建桌面快捷方式
     *
     * @param resId 应用图标 <uses-permission android:name=
     *            "com.android.launcher.permission.INSTALL_SHORTCUT" />
     */
    public void createShortcut(int resId)
    {
        Intent shortcut = new Intent(
                "com.android.launcher.action.INSTALL_SHORTCUT");
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME,
                mContext.getString(R.string.app_name));
        shortcut.putExtra("duplicate", false);
        ComponentName comp = new ComponentName(mContext.getPackageName(),
                "." + ((Activity) mContext).getLocalClassName());
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT,
                new Intent(Intent.ACTION_MAIN).setComponent(comp));
        ShortcutIconResource iconRes = ShortcutIconResource
                .fromContext(mContext, resId);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
        mContext.sendBroadcast(shortcut);
    }
    
    /**
     * 获取翼销售的版本号
     *
     * @return
     */
    public int getESaleVersionCode()
    {
        try
        {
            PackageManager packageManager = mContext.getPackageManager();
            PackageInfo packInfo = packageManager
                    .getPackageInfo("com.sale.tydic.eSale", 0);
            int version = packInfo.versionCode;
            return version;
        }
        catch (NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    public int getMarkeTviewVersionCode()
    {
        try
        {
            PackageManager packageManager = mContext.getPackageManager();
            PackageInfo packInfo = packageManager
                    .getPackageInfo("com.tydic.yxs.marketview", 0);
            // PackageInfo info = manager.getPackageInfo(this.getPackageName(),
            // 0);
            // PackageInfo info = ("com.sale.tydic.eSale");
            int version = packInfo.versionCode;
            return version;
        }
        catch (NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    /**
     * 获取实名制的版本号
     *
     * @return
     */
    public static int getRealNameUpdateCode(Context context)
    {
        try
        {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packInfo = packageManager
                    .getPackageInfo("com.tydic.SalePhone.realName", 0);
            int version = packInfo.versionCode;
            return version;
        }
        catch (NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    /**
     * 获取实名制的版本号
     *
     * @return
     */
    public int getRealNameUpdateCode()
    {
        try
        {
            PackageManager packageManager = mContext.getPackageManager();
            PackageInfo packInfo = packageManager
                    .getPackageInfo("com.tydic.SalePhone.realName", 0);
            // PackageInfo info = manager.getPackageInfo(this.getPackageName(),
            // 0);
            // PackageInfo info = ("com.sale.tydic.eSale");
            int version = packInfo.versionCode;
            return version;
        }
        catch (NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    /**
     * 安装指定文件路径的apk文件
     *
     * @param filePath
     * @param context
     */
    public static void installApk(String filePath, Context context)
    {
        // 修改apk权限
        try
        {
            String command = "chmod " + "777" + " " + filePath;
            Runtime runtime = Runtime.getRuntime();
            runtime.exec(command);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        // install the apk.
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.parse("file://" + filePath),
                "application/vnd.android.package-archive");
        context.startActivity(intent);
    }
    
    /**
     * 从asset目录下获取apk
     * 
     * @param context
     * @param fileName
     * @param path
     * @return
     */
    public static boolean retrieveApkFromAssets(Context context,
            String fileName, String path)
    {
        boolean bRet = false;
        try
        {
            File file = new File(path);
            if (file.exists())
            {
                return true;
            }
            else
            {
                file.createNewFile();
                InputStream is = context.getAssets().open(fileName);
                FileOutputStream fos = new FileOutputStream(file);
                
                byte[] temp = new byte[1024];
                int i = 0;
                while ((i = is.read(temp)) != -1)
                {
                    fos.write(temp, 0, i);
                }
                fos.flush();
                fos.close();
                is.close();
                
                bRet = true;
            }
        }
        catch (IOException e)
        {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(e.getMessage());
            builder.show();
            e.printStackTrace();
        }
        return bRet;
    }
}
