package com.zy.coolbicycle.entity;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/24
 */
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 读写文件的类
 */

public class FileTransfer {
    private Context context;
    public FileTransfer(Context context) {
        this.context=context;
    }
    public void exportFile(String filename,String str){
        File files = context.getExternalFilesDir("");
        if(files==null){
            Log.e("error","Android/data/sonydafa/files获取失败");
            Toast.makeText(context,"Android/data/sonydafa/files获取失败",Toast.LENGTH_SHORT).show();
            return;
        }
        String path=files.getAbsolutePath()+"/"+filename;
        File file = new File(path);
        Log.i("info","导出的文件目录为:"+path);
        try(FileWriter fileWriter = new FileWriter(file, true)){
            fileWriter.append(str);
        }catch (IOException e){
            Toast.makeText(context,"Android/data/sonydafa/file导出文件失败",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
