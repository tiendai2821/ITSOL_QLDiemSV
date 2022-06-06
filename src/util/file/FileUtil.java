package util.file;

import util.DataUtil;
import util.StringUtil;

import java.io.*;
// yêu cầu lưu mảng trong mỗi luồng thôi.
public class FileUtil implements DataWritable, DataReadable {
// kiểm tra đường dẫn file
    @Override
    public void writeDataToFile(Object[] data, String fileName) {
        if (StringUtil.isNullOrEmpty(fileName) || DataUtil.isNullOrEmpty(data)) {
            return;
        }
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));) {

            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Object readDataFromFile(String fileName) {
        // kiểm tra file trống
        if (StringUtil.isNullOrEmpty(fileName)) {
            return null;
        }


        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));)  {

            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
