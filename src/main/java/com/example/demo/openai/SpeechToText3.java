package com.example.demo.openai;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import java.util.stream.Collectors;

public class SpeechToText3 {
    final static ObjectMapper objectMapper = new ObjectMapper();
    private static Long maxSize = 95353207L;

    public static void main(String[] args) throws IOException, InterruptedException {
        String token = "TOKEN_REPLACE_ME";
        String model = "whisper-1";


        String postTarget = "https://api.openai.com/v1/audio/transcriptions";

        URL url = new URL(postTarget);

        String[] audioFilePaths = {
                //太大了
//                "E:\\audio\\recordings\\人人彩面试2月18日 下午1点51分.mp3",
//                "E:\\audio\\recordings\\通话录音@博彦面试1(18757143260)_20171222200305.mp3",
//                "E:\\audio\\recordings\\通话录音@聚思鸿interview_schedule(041139050508)_20180129140127.mp3",
//                "E:\\audio\\recordings\\玩具超人产品介绍2月26日 下午3点02分.mp3",
//                "E:\\audio\\recordings\\问众智能 2月22日 上午11点46分.mp3",
//                "E:\\audio\\recordings\\沃尔沃面试2月21日 下午2点25分.mp3",
//                "E:\\audio\\recordings\\联想2月22日 下午1点58分.mp3",
        };
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("C:\\TEMP\\non-trascribed-mp3-list.txt"));
            String audioFilePath = reader.readLine();
            while (audioFilePath != null) {
                System.out.println();
                System.out.println("Transcribing: " + audioFilePath);
                File file = new File(audioFilePath);
                boolean success = transcribeOne(token, model, file, url);
                if(success) {
                    System.out.println("Waiting 20s");
                    Thread.sleep(20 * 1000);
                }
                // read next line
                audioFilePath = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("final maxSize: " + maxSize);
        }
    }

    /**
     * @param token
     * @param model
     * @param file
     * @param url
     * @return 是否需要等20s
     * @throws IOException
     */
    private static boolean transcribeOne(String token, String model, File file, URL url) throws IOException {
        String resultText = null;
        String path = file.getAbsolutePath();
        String fileNameWithoutExt = path.substring(0, path.lastIndexOf("."));
        BufferedReader reader = null;
        Long sizeInBytes = null;
        String textFilePath = fileNameWithoutExt + ".txt";
        File textFile = new File(textFilePath);
        textFile.createNewFile();
        try (FileWriter myWriter = new FileWriter(textFilePath)) {
            sizeInBytes = file.length();
            if(sizeInBytes > maxSize) {
                String error = "大小过大! 文件大小: " + sizeInBytes + ", 最大:" + maxSize;
                writeError(myWriter, error);
                return false;
            }
            HttpURLConnection connection = null;
            int respCode = 0;

            connection = (HttpURLConnection) url.openConnection();

//        connection.setRequestProperty("Authorization", basicAuth);
            connection.setRequestProperty("Authorization", "Bearer " + token);

            String boundary = UUID.randomUUID().toString();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

            DataOutputStream request = new DataOutputStream(connection.getOutputStream());

            request.writeBytes("--" + boundary + "\r\n");
            //filename需要是英文
            request.writeBytes("Content-Disposition: form-data; name=\"file\"; filename=\"" + "test.mp3" + "\"\r\n\r\n");
            request.write(FileUtils.readFileToByteArray(file));
            request.writeBytes("\r\n");

            request.writeBytes("--" + boundary + "\r\n");
            request.writeBytes("Content-Disposition: form-data; name=\"model\"\r\n\r\n");
            request.writeBytes(model + "\r\n");

            request.writeBytes("--" + boundary + "\r\n");
            request.writeBytes("Content-Disposition: form-data; name=\"prompt\"\r\n\r\n");
            request.writeBytes("你好.\r\n");

            request.writeBytes("--" + boundary + "\r\n");
            request.writeBytes("Content-Disposition: form-data; name=\"language\"\r\n\r\n");
            request.writeBytes("zh\r\n");

            request.writeBytes("--" + boundary + "--\r\n");
            request.flush();
            respCode = connection.getResponseCode();
            if(respCode == 200) {
                //all went ok - read response
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                StringBuffer completeResponseStr = new StringBuffer();

                while ((line = reader.readLine()) != null) {
                    completeResponseStr.append(line);
                }
                reader.close();

                ResponseData responseData = objectMapper.readValue(completeResponseStr.toString(), ResponseData.class);
                resultText = responseData.getText();
                myWriter.write(resultText);
                return true;
            }else{
                if(respCode == 413 && maxSize > sizeInBytes) {
                    maxSize = sizeInBytes;
                }
                String error = new BufferedReader(new InputStreamReader(connection.getErrorStream()))
                        .lines().collect(Collectors.joining("\n"));
                writeError(myWriter, error);
                return true;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return true;
        } finally {
            if(reader != null) {
                reader.close();
            }
        }
    }

    private static void writeError(FileWriter myWriter, String error) throws IOException {
        String errorMsg = "Error: " + error;
        System.err.println(errorMsg);
        myWriter.write(errorMsg);
    }
}
