package com.cloud.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.invoke.MethodHandles;
import java.nio.channels.FileChannel;

public class FileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    //从流中将文件写入目录
    public static void writeFile(String filePath, InputStream inputStream) throws Exception {
        OutputStream outputStream = null;
        try {
            File file = new File(filePath);
            outputStream = new FileOutputStream(file);
            int bytesWritten = 0;
            int byteCount = 0;
            byte[] bytes = new byte[1024];
            while ((byteCount = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, bytesWritten, byteCount);
                bytesWritten += byteCount;
            }
        } catch (Exception ex) {
            LOGGER.error("write file to filePath,{} occur exception", filePath);
            throw new RuntimeException(ex);
        } finally {
            inputStream.close();
            outputStream.close();
        }

    }

    public static InputStream readFile(String filePath) {
        try {
            return new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            LOGGER.error("read file from path {} occur exception", filePath);
            throw new RuntimeException(e);
        }
    }

    public static boolean existFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            return true;
        }
        return false;
    }

    //备份文件
    public static void backupFile(String sourceFilePath, String destFilePath) throws Exception {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(new File(sourceFilePath)).getChannel();
            outputChannel = new FileOutputStream(new File(destFilePath)).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } catch (Exception ex) {
            LOGGER.error("copy file from {} to {} occur exception",sourceFilePath,destFilePath);
            throw new RuntimeException(ex);
        }
        finally {
            inputChannel.close();
            outputChannel.close();
        }
    }

}

