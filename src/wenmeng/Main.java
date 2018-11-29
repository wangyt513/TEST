/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wenmeng;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.apache.log4j.Category;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author wyt
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static HashMap<String, String> MMM = new HashMap<String, String>();
    public static HashMap<String, String[]> MMM1 = new HashMap<String, String[]>();
    private static Category log = Logger.getSysLogger();
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(""+System.getProperty("user.dir"));
         String ss=Main.class.getResource("").getPath()+"LoggerConfiguration.properties";
         PropertyConfigurator.configure("LoggerConfiguration.properties");

//        {
//            String s = lxkdemo1.Main.member("lbxlxk", "123456", "2018-03-15 15:00:00", "2018-03-16");
//            System.out.println("" + s);
//
//            s = lxkdemo1.Main.sku("lbxlxk", "123456", "2018-03-15 15:00:00", "2018-03-16");
//            System.out.println("" + s);
//
//
//            s = lxkdemo1.Main.consume("lbxlxk", "123456", "2018-03-15 15:00:00", "2018-03-16");
//            System.out.println("" + s);
//        }


        try {
            String sql = "select mc,id from md where mc is not null";
            ArrayList<HashMap<Integer, String>> al = MysqlDB.getMultQuery(sql);
            for (HashMap<Integer, String> hashMap : al) {
                log.info(""+hashMap.get(1)+":"+hashMap.get(2));
                MMM.put(hashMap.get(1), hashMap.get(2));
            }
            sql = "select id,x,y from md where x is not null";
            ArrayList<HashMap<Integer, String>> al1 = MysqlDB.getMultQuery(sql);
            for (HashMap<Integer, String> hashMap : al1) {
                log.info(""+hashMap.get(1)+":"+hashMap.get(2));
                String ssv[]=new String[2];
                ssv[0]=hashMap.get(2);
                ssv[1]=hashMap.get(3);
                MMM1.put(hashMap.get(1), ssv);
            }

        } catch (Exception e) {
        }
        try {
            //TEST.main88(args);
        } catch (Exception em) {
            em.printStackTrace();
        }

        while (true) {
            try {
                System.out.println("start");
                try {
                    TEST.main(args);
                } catch (Exception em) {
                    em.printStackTrace();
                }

                System.out.println("end");


                String sql = "select order_no,weimob_openId from ddzb where order_status='5'";
                System.out.println("" + new Date() + ":" + sql);
                ArrayList<HashMap<Integer, String>> al = MysqlDB.getMultQuery(sql);
                if (al != null && al.size() > 0) {
                    for (int i = 0; i < al.size(); i++) {
                        HashMap<Integer, String> hm = al.get(i);


                        if (TEST.hx(hm.get(1), hm.get(2))) {
                            MysqlDB.upDdateSingle("update ddzb set order_status='8' where order_no='" + hm.get(1) + "'");
                        }
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
            }

        }
    }
}
