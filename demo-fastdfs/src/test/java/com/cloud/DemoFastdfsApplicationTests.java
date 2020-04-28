package com.cloud;

import com.google.common.io.Files;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoFastdfsApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoFastdfsApplicationTests.class);

    private static StorageClient1 storageClient1;
    private static String trackerServerUrl;

    static {
        try {
            ClientGlobal.init("src/main/resources/fdfs_client.conf");
            TrackerClient trackerClient = new TrackerClient(ClientGlobal.g_tracker_group);
            TrackerServer trackerServer = trackerClient.getConnection();
            trackerServerUrl = trackerServer.getInetSocketAddress().getHostString();
            LOGGER.info("trackerServerUrl={}", trackerServerUrl);
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);

            storageClient1 = new StorageClient1(trackerServer, storageServer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void upload () {
        Map<String,String> map = new HashMap<>();
        map.put("certificate","certificate");
        String result = uploadFile("D:\\Download\\certificate.jpg",map);
        System.out.println(result);
        //http://192.168.56.100:81/group1/M00/00/00/wKg4ZF6nleOAQHF9AAl_sA2A3fQ495.jpg
        //group1/M00/00/00/wKg4ZF6nlw2ARaniAAl_sA2A3fQ480.jpg
        //group1/M00/00/00/wKg4ZF6nl2SAc-DPAAl_sA2A3fQ255.jpg
    }

    @Test
    public void download() {

    }


    public static String uploadFile(String filepath , Map<String, String> meta) {
        try {
            File file = new File(filepath);
            byte[] buff = readFromFile(file);
            NameValuePair[] nameValuePairs = null;
            if (meta != null) {
                nameValuePairs = new NameValuePair[meta.size()];
                int index = 0;
                for (Map.Entry<String, String> entry : meta.entrySet()) {
                    String name = entry.getKey();
                    String value = entry.getValue();
                    nameValuePairs[index++] = new NameValuePair(name, value);
                }
            }
            String fileExt = Files.getFileExtension(file.getName()) ;
            return storageClient1.upload_file1(buff, fileExt, nameValuePairs);
        } catch (Exception e) {
            LOGGER.error("上传失败，原因：{}",e);
        }
        return null;
    }

    public static int downloadFile(String fileId, String filePath) {
        FileOutputStream fos = null;
        try {
            byte[] content = storageClient1.download_file1(fileId);
            writeToFile(content, filePath);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }

    private static byte[] readFromFile(File file) throws Exception {
        try (FileInputStream inputStream = new FileInputStream(file)) {

            FileChannel fileChannel=inputStream.getChannel();
            int fileSize = (int)fileChannel.size() ;
            ByteBuffer buffer = ByteBuffer.allocate(fileSize);
            fileChannel.read(buffer);
            return buffer.array();
        }
    }

    public static void writeToFile(byte[] content, String filePath) throws Exception {
        FileOutputStream outputStream = new FileOutputStream(filePath);
        outputStream.write(content);
    }

}
