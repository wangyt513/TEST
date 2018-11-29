/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wenmeng;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale.Category;
import java.util.Properties;

/**
 *
 * @author wyt
 */
public class MysqlDB {


    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/weimeng?user=root&password=bxyf&useUnicode=true&characterEncoding=gbk");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }

    public static boolean upDdate(ArrayList<String> sqls) {
        Connection con = null;
        Statement stmt = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            for (int i = 0; i < sqls.size(); i++) {
                String sql = sqls.get(i);
                stmt = con.createStatement();
                stmt.executeUpdate(sql);
                stmt.close();
            }

            con.commit();


        } catch (Exception ex) {

            ex.printStackTrace();
            return false;
        } finally {


            try {
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return true;
    }

    public static boolean upDdateSingle(String sql) {
        Connection con = null;
        Statement stmt = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(sql);

            con.commit();


        } catch (Exception ex) {

            ex.printStackTrace();
            return false;
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            try {
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return true;
    }

    public static ArrayList<HashMap<Integer, String>> getMultQuery(String sql) {
        Connection con = null;
        ;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<HashMap<Integer, String>> al = new ArrayList<HashMap<Integer, String>>();

        try {
            con = getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HashMap<Integer, String> hm = new HashMap<Integer, String>();
                int col = rs.getMetaData().getColumnCount();
                for (int i = 1; i < col + 1; i++) {
                    hm.put(i, rs.getString(i));

                }
                al.add(hm);
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return al;
    }

    public static HashMap<Integer, String> getSingleQuery(String sql) {
        Connection con = null;
        try {
            con = getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Statement stmt = null;
        ResultSet rs = null;

        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                System.out.println("---" + sql);
                int col = rs.getMetaData().getColumnCount();
                for (int i = 1; i < col + 1; i++) {
                    hm.put(i, rs.getString(i));

                }
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                stmt.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return hm;
    }

    public static boolean isHave(String sql) {

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String result = "";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            int m = 0;
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            try {
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return false;
    }

    public static boolean isFW(int sx) {
        Connection con = getConnection();
        String sql = "select count(*) from hbff";
        Statement stmt = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            stmt = con.createStatement();

            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                if (rs.getInt(1) >= sx) {
                    result = true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            try {
                stmt.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static boolean hbff(String opid) {
        Connection con = getConnection();
        String sql = "insert into hbff(openid) values('" + opid + "')";
        Statement stmt = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            stmt = con.createStatement();

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {


            try {
                stmt.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static boolean isFG(String opid) {
        Connection con = getConnection();
        String sql = "select * from hbff where openid=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, opid);
            rs = stmt.executeQuery();
            if (rs.next()) {
                result = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            try {
                stmt.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static boolean isHaveUser(String opid) {

        Connection con = getConnection();
        String sql = "select * from msusers where openid=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, opid);
            rs = stmt.executeQuery();
            if (rs.next()) {
                result = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            try {
                stmt.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;

    }

    public static boolean upDDS(String ids, String code) {
        String sql = "update orders set status='2' where  md='" + code + "' and id in(" + ids + ")";
        System.out.println("" + sql);
        return upDdateSingle(sql);
    }

    public static boolean hxDDS(String id, String code, String lsh) {
        String sql = "update orders set status='5',leaveMessage='" + lsh + "' where  md='" + code + "' and id=" + id;
        System.out.println("" + sql);
        return upDdateSingle(sql);
    }

    public static String getDZQ(String dzq) {
        String sql1 = "select type from shccard.wxdzq where dzq='"+dzq+"' and zt='0'";
        System.out.println("" + sql1);
        StringBuffer sb = new StringBuffer();
        String retext="";
        ArrayList<HashMap<Integer, String>> hyk = getMultQuery(sql1);
        for (int i = 0; i < hyk.size(); i++) {
           retext= hyk.get(i).get(1);
        }
        return retext;
    }

    public static boolean hxDZQ(String dzq, String code, String lsh) {
        String sql = "update shccard.wxdzq set zt='1',md='" + code + "',hxsj=now() where  dzq='"+dzq+"'";
        System.out.println("" + sql);
        return upDdateSingle(sql);
    }

    public static String getDDSFK(String code) {
        String sql1 = "select id,ddh,payDate,pickTime,money,SUBSTR(productName,1,POSITION('H' IN productName)-1) pname,guige,p1,payMethod,birthdayCard,no,getMethod,useraddr from orders where status='1' and md='" + code + "' order by id";
        System.out.println("" + sql1);
        StringBuffer sb = new StringBuffer();
        ArrayList<HashMap<Integer, String>> hyk = getMultQuery(sql1);
        for (int i = 0; i < hyk.size(); i++) {
            HashMap<Integer, String> hm = hyk.get(i);
            String id = hm.get(1);
            String ddh = hm.get(2);
            String payDate = hm.get(3);
            String pickTime = hm.get(4);
            String money = hm.get(5);
            String pname = hm.get(6);
            String guige = hm.get(7);
            String p1 = hm.get(8);
            String payMethod = hm.get(9);
            String ly = hm.get(10);
            String no = hm.get(11);
            String getM = hm.get(12);
            if(getM==null){
                getM="0";
            }
            String addr = hm.get(13);
            if(addr==null){
                addr="0";
            }
            String zt = "00";

            sb.append("|");
            sb.append(id);
            sb.append(",");
            sb.append(ddh);
            sb.append(",");
            sb.append(payDate);
            sb.append(",");
            sb.append(pickTime);
            sb.append(",");
            sb.append(money);
            sb.append(",");
            sb.append(pname);
            sb.append(",");
            sb.append(guige);
            sb.append(",");
            sb.append(p1);
            sb.append(",");
            sb.append(payMethod);
            sb.append(",");
            sb.append(ly);
            sb.append(",");
            sb.append(no);
            sb.append(",");
            sb.append(getM);
            sb.append(",");
            sb.append(addr);

        }

        String retext = sb.toString();
        if (retext.length() > 0) {
            retext = retext.substring(1);
        }
        return retext;
    }

    public static String getDDS(String code, String ddhr,String rq) {
        String sql1 = "select id,ddh,payDate,pickTime,money,SUBSTR(productName,1,POSITION('H' IN productName)-1) pname,guige,p1,payMethod,birthdayCard,status,getMethod,useraddr from orders where status<>'0' and md='" + code + "' order by id";
        if (ddhr != null) {
            sql1 = "select id,ddh,payDate,pickTime,money,SUBSTR(productName,1,POSITION('H' IN productName)-1) pname,guige,p1,payMethod,birthdayCard,status,getMethod,useraddr from orders where status in('1','2') and md='" + code + "' and ddh='" + ddhr + "' order by id";
        }

        if(rq!=null){
            sql1 = "select id,ddh,payDate,pickTime,money,SUBSTR(productName,1,POSITION('H' IN productName)-1) pname,guige,p1,payMethod,birthdayCard,status,getMethod,useraddr from orders where status<>'0' and payDate like '"+rq+"%' and md='" + code + "' order by id";

        }
        System.out.println("" + sql1);
        StringBuffer sb = new StringBuffer();
        ArrayList<HashMap<Integer, String>> hyk = getMultQuery(sql1);
        for (int i = 0; i < hyk.size(); i++) {
            HashMap<Integer, String> hm = hyk.get(i);
            String id = hm.get(1);
            String ddh = hm.get(2);
            String payDate = hm.get(3);
            String pickTime = hm.get(4);
            String money = hm.get(5);
            String pname = hm.get(6);
            String guige = hm.get(7);
            String p1 = hm.get(8);
            String payMethod = hm.get(9);
            String ly = hm.get(10);
            String no = hm.get(11);
            String getM = hm.get(12);
            if(getM==null){
                getM="0";
            }
            String addr = hm.get(13);
            if(addr==null){
                addr="0";
            }
            String zt = "00";

            sb.append("|");
            sb.append(id);
            sb.append(",");
            sb.append(ddh);
            sb.append(",");
            sb.append(payDate);
            sb.append(",");
            sb.append(pickTime);
            sb.append(",");
            sb.append(money);
            sb.append(",");
            sb.append(pname);
            sb.append(",");
            sb.append(guige);
            sb.append(",");
            sb.append(p1);
            sb.append(",");
            sb.append(payMethod);
            sb.append(",");
            sb.append(ly);
            sb.append(",");
            sb.append(no);
            sb.append(",");
            sb.append(getM);
            sb.append(",");
            sb.append(addr);

        }

        String retext = sb.toString();
        if (retext.length() > 0) {
            retext = retext.substring(1);
        }
        return retext;
    }
}
