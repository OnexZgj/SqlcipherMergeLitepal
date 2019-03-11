package com.lnsoft.swidpdhclast.testlitepal;

import net.sqlcipher.database.SQLiteDatabase;

import org.litepal.LitePalApplication;

/**
 * des：
 * author：onexzgj
 * time：2019/3/11
 */
public class App extends LitePalApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        SQLiteDatabase.loadLibs(this);
    }
}
