package com.lnsoft.swidpdhclast.testlitepal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import net.sqlcipher.database.SQLiteDatabase;

import org.litepal.LitePal;
import org.litepal.LitePalDB;
import org.litepal.crud.LitePalSupport;

import java.io.File;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private final String SDcardPath = "/mnt/sdcard/databases/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Student student = new Student("onex", "12", "man");
//        student.save();
//        Student student1 = new Student("onex1", "12", "man");
//        student1.save();
//        Student student2 = new Student("onex2", "12", "man");
//        student2.save();
//        Student student3 = new Student("jaima", "12", "man");
//        student3.save();


        findViewById(R.id.jm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                decrypt("fuck.db","2.db","lnsoft");


            }
        });

        List<Student> all = LitePal.findAll(Student.class);
        Toast.makeText(this, all.size()+all.get(0).getName(), Toast.LENGTH_SHORT).show();
    }


    private void decrypt(String encryptedName,String decFile,String key) {
        try {
            File databaseFile = getDatabasePath(SDcardPath + encryptedName);
//            SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(databaseFile, key, null);
//
//            File decrypteddatabaseFile = getDatabasePath(SDcardPath + decryptedName);
//            //deleteDatabase(SDcardPath + decryptedName);
//
//            //连接到解密后的数据库，并设置密码为空
//            database.rawExecSQL(String.format("ATTACH DATABASE '%s' as " + decryptedName.split("\\.")[0] + " KEY '';", decrypteddatabaseFile.getAbsolutePath()));
//            database.rawExecSQL("SELECT sqlcipher_export('" + decryptedName.split("\\.")[0] + "');");
//            database.rawExecSQL("DETACH DATABASE " + decryptedName.split("\\.")[0] + ";");
//
//            SQLiteDatabase decrypteddatabase = SQLiteDatabase.openOrCreateDatabase(decrypteddatabaseFile, "", null);
//            //decrypteddatabase.setVersion(database.getVersion());
//            decrypteddatabase.close();
//
//            database.close();


            File decrypteddatabaseFile = getDatabasePath(SDcardPath + decFile);
            SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(databaseFile, key, null);

            if (database.isOpen()) {
                database.rawExecSQL(String.format("ATTACH DATABASE '%s' as plaintext KEY '';", decrypteddatabaseFile.getAbsolutePath()));
                database.rawExecSQL("SELECT sqlcipher_export('plaintext');");
                database.rawExecSQL("DETACH DATABASE plaintext;");
                SQLiteDatabase sqlDB = SQLiteDatabase.openDatabase(decFile,"",null,0);

                sqlDB.close();
                database.close();
            }






        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
