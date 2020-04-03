package cn.mo.javaSE.io;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * desc:
 *
 * @author mozhihang
 * date:2020/3/25 10:05
 */
public class FileTest {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\mozhihang.AD61V1\\Desktop\\a_dingtalk_approval_detail_record\\Yearning_Data - 副本.csv");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = "";
        String title = bufferedReader.readLine();
        int i = 0;
        int k = 1;
        StringBuilder content = null;
        while ((line = bufferedReader.readLine()) != null) {
            if(i == 0){
                content = new StringBuilder();
                content.append(title).append("\n");
            }
            String[] lineStringArray = line.split(",");
            content.append("(").append(lineStringArray[0]).append(", "); // id
            if(lineStringArray[1].contains("'s")){
                content.append("'").append(lineStringArray[1].replace("'s", "的")).append("'").append(", ");
            }else {
                content.append("'").append(lineStringArray[1]).append("'").append(", "); // title
            }
            if(StringUtils.isBlank(lineStringArray[2])){
                content.append("null").append(", ");
            }else {
                content.append("'").append(lineStringArray[2]).append("'").append(", "); // instance_create_time
            }
            if(StringUtils.isBlank(lineStringArray[3])){
                content.append("null").append(", ");
            }else {
                content.append("'").append(lineStringArray[3]).append("'").append(", "); // instance_finish_time
            }
            content.append("'").append(lineStringArray[4]).append("'").append(", "); // result
            content.append("'").append(lineStringArray[5]).append("'").append(", "); // status
            if(StringUtils.isBlank(lineStringArray[6] )){
                content.append("null").append(", ");
            }else {
                content.append(lineStringArray[6]).append(", "); // user_id
            }
            content.append(lineStringArray[7]).append(", "); // user_dingtalk_id
            if(StringUtils.isBlank(lineStringArray[8] )){
                content.append("null").append(", ");
            }else {
                content.append(lineStringArray[8]).append(", "); // department_id
            }
            content.append(lineStringArray[9]).append(", "); // department_dingtalk_id
            String updateTime = lineStringArray[lineStringArray.length - 1];
            String createTime = lineStringArray[lineStringArray.length - 2];
            String procInsId = lineStringArray[lineStringArray.length - 3];
            StringBuilder fromVaule = new StringBuilder();
            for (int j = 10; j < lineStringArray.length - 3; j++) {
                fromVaule.append(lineStringArray[j]).append(",");
            }
            content.append("'").append(fromVaule.substring(0, fromVaule.length() - 1)).append("'").append(",");
            content.append("'").append(procInsId).append("'").append(", ").append("'").append(createTime).append("'").append(", ").append("'").append(updateTime).append("'").append("),\n");
            i++;
            if(i == 1000){
                File file1 = new File("C:\\Users\\mozhihang.AD61V1\\Desktop\\a_dingtalk_approval_detail_record\\a"+k+".sql");
                FileWriter fileWriter = new FileWriter(file1);
                BufferedWriter bw = new BufferedWriter(fileWriter);
                bw.write(content.substring(0, content.length()-2)+";");
                bw.close();
                System.out.println("finish "+k);
                k++;
                i = 0;
            }
        }
        if(i != 0){
            File file1 = new File("C:\\Users\\mozhihang.AD61V1\\Desktop\\a_dingtalk_approval_detail_record\\a"+k+".sql");
            FileWriter fileWriter = new FileWriter(file1);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(content.substring(0, content.length()-2)+";");
            bw.close();
            System.out.println("finish "+k);
            k++;
            i = 0;
        }
        bufferedReader.close();
    }

}
