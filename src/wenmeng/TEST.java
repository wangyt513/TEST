/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wenmeng;

import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Category;

/**
 *
 * @author wyt
 */
public class TEST {

    public static String RTK = "3ff941ef-54b5-425f-b1a1-515b785ee517";

    public static boolean hx(String order, String weimob_openId) {

        String[] ss = getFTok(RTK);
        if (ss == null) {
            return false;
        }
        String actk = ss[0];
        String s = "https://dopen.weimob.com/api/1_0/wangpu/order/Hx?accesstoken=" + actk;
        String body = "{\"order_no\":\"" + order + "\",\"weimob_openId\":\"" + weimob_openId + "\",\"hx_way\":\"旺铺核销\"}";
        String m = WXRT.getJSON1(s, body);
        JSONObject json = new JSONObject().fromObject(m);
        System.out.println("" + json);
        if (json.getJSONObject("code").getInt("errcode") == 0) {
            System.out.println("核销订单成功");
            return true;
        } else {
            System.out.println("核销订单失败:" + json.getString("code"));
        }
        return false;

    }

    public static void main2(String[] args) {
        String[] ss = getFTok(RTK);
        if (ss == null) {
            return;
        }
        String actk = ss[0];
        System.out.println("ref:" + ss[1]);

//        hx("6720012176125409524","oAvF9wtqHUbMmazlqQrTr_kRKn1o","九牛私家牧场（老军营店）【山西省太原市迎泽区老军营小区小环路3号(0351-4866714)】",actk);
//        hx("6709280865388354564","oAvF9wiA1Lw-nTwvfX4chJJAbqVw","九牛私家牧场（富力城店)【山西省太原市杏花岭区太原市杏花岭区富力城商6—2001(0351-2791305)】",actk);
        //hx("6709157695380459934","oAvF9wiA1Lw-nTwvfX4chJJAbqVw","九牛私家牧场（富力城店)【山西省太原市杏花岭区太原市杏花岭区富力城商6—2001(0351-2791305)】",actk);
        //hx("6709157695380459934","oAvF9wiA1Lw-nTwvfX4chJJAbqVw","旺铺核销",actk);
//          hx("6708705676030209125","oAvF9wgQyQa8mi2K3epurHpZ6sIg","测试点【山西省太原市小店区测试(13011110000)】",actk);
//        hx("6708736442041131835","oAvF9wgQyQa8mi2K3epurHpZ6sIg","九牛私家牧场（富力城店)【山西省太原市杏花岭区太原市杏花岭区富力城商6—2001(0351-2791305)】",actk);
//        hx("6717748070549118017","oAvF9wgQyQa8mi2K3epurHpZ6sIg","九牛私家牧场（秀水店)【山西省太原市杏花岭区太原市杏花岭区桃园二巷秀水商城底商M2(0351-4225667)】",actk);
//        hx("6719867901919682017","oAvF9wgQyQa8mi2K3epurHpZ6sIg","九牛私家牧场（秀水店)【山西省太原市杏花岭区太原市杏花岭区桃园二巷秀水商城底商M2(0351-4225667)】",actk);


    }

    public static void main8(String[] args) {
        String[] ss = getFTok("6b3f479b-3292-40e6-a318-9d37d0b0958f");
        if (ss == null) {
            return;
        }
        String actk = ss[0];
        System.out.println("ref:" + ss[1]);
        //getIt("6709280865388354564", actk);
    }

    public static void main(String[] args) {
        String[] ss = getFTok(RTK);
        if (ss == null) {
            return;
        }
        String actk = ss[0];
        System.out.println("ref:" + ss[1]);

        //String s="https://dopen.weimob.com/api/1_0/wangpu/Order/Get?accesstoken="+actk;

        String s = "https://dopen.weimob.com/api/1_0/wangpu/Order/GetHighly?accesstoken=" + actk;
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.set(c.MINUTE, c.get(c.MINUTE) - 60*4);
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String s="https://dopen.weimob.com/api/1_0/wangpu/Order/FullInfoGetHighly?accesstoken="+actk;
        String body = "{\"order_status\":\"1\",\"pay_status\":null,\"delivery_status\":0,\"page_no\": 1 ,\"create_begin_time\": \"" + sdf.format(c.getTime()) + "\",\"page_size\":200}";
//        //body="{\"order_state\":0,\"order_fields\": \"*\",\"order_detail_fields\": \"*\",\"create_begin_time\": \"2014-01-01 10:00:00\",\"create_end_time\": \"2014-01-01 11:00:00\",\"update_begin_time\": \"2014-01-01 10:00:00\",\"update_end_time\": \"2014-01-01 11:00:00\",\"page_size\": 20,\"page_no\": 1,\"need_distribution_info\": false}";
//        body="{\"order_no\": \"6710949511845780446\",\"need_distribution_info\": false}";
//        System.out.println("" + body);
//        System.out.println("" + s);
        String m = WXRT.getJSON1(s, body);



//        String ss="https://dopen.weimob.com/fuwu/b/oauth2/token?code=nCYa5s&grant_type=authorization_code&client_id=FFCDDCCCDA93EA5ECC271BA6B575286B&client_secret=B38DB139F6F6AC54FAB11882D10911B5&redirect_uri=http://jiuniu.sx-xpay.com/WM/order.jsp&state=123";
//        String m=WXRT.getJSON(ss, "");
        //System.out.println("" + m);
        JSONObject json = new JSONObject().fromObject(m);
//        System.out.println("" + json.getString("code"));
//        System.out.println("" + json.getString("data"));


        if (json.getJSONObject("code").getInt("errcode") == 0) {
            JSONObject j_data = json.getJSONObject("data");
            System.out.println("条数：" + j_data.getString("row_count"));
            JSONArray jsona = j_data.getJSONArray("page_data");

            for (int i = 0; i < jsona.size(); i++) {
                System.out.println("================================================================================");
                JSONObject j_item = jsona.getJSONObject(i);
                for (Object object : j_item.keySet()) {
                    String key = (String) object;
                    //System.out.println(">>" + key + ":" + j_item.getString(key));
                }
                getIt(j_item.getString("order_no"), j_item, actk);
            }
        } else {
            System.out.println("获取订单列表失败:" + json.getString("code"));
        }

        //{"access_token":"03c5a303-96d8-4766-84d5-414a92740dc9","token_type":"bearer","refresh_token":"6b3f479b-3292-40e6-a318-9d37d0b0958f","refresh_token_expires_in":604799,"expires_in":7199,"scope":"default","public_account_id":"55993650","business_id":"57223957"}

    }

    private static Category log = Logger.getSysLogger();
    public static void main88(String[] args) {
        String[] ss = getFTok(RTK);
        if (ss == null) {
            return;
        }
        String actk = ss[0];
        System.out.println("ref:" + ss[1]);

        //String s="https://dopen.weimob.com/api/1_0/wangpu/Order/Get?accesstoken="+actk;

        String s = "https://dopen.weimob.com/api/1_0/wangpu/Order/GetHighly?accesstoken=" + actk;
//        java.util.Calendar c = java.util.Calendar.getInstance();
//        c.set(c.MINUTE, c.get(c.MINUTE) - 10);
//        java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String s="https://dopen.weimob.com/api/1_0/wangpu/Order/FullInfoGetHighly?accesstoken="+actk;
        //String body = "{\"order_status\":\"1\",\"pay_status\":null,\"delivery_status\":0,\"page_no\": 1 ,\"page_size\":200}";
        String body = "{\"order_status\":\"1\",\"pay_status\":\"1\",\"delivery_status\":null,\"page_no\": 1 ,\"page_size\":200}";

        //String body = "{\"order_status\":\"1\",\"pay_status\":null,\"delivery_status\":0,\"page_no\": 1 ,\"create_begin_time\": \"" + sdf.format(c.getTime()) + "\",\"page_size\":200}";
//        //body="{\"order_state\":0,\"order_fields\": \"*\",\"order_detail_fields\": \"*\",\"create_begin_time\": \"2014-01-01 10:00:00\",\"create_end_time\": \"2014-01-01 11:00:00\",\"update_begin_time\": \"2014-01-01 10:00:00\",\"update_end_time\": \"2014-01-01 11:00:00\",\"page_size\": 20,\"page_no\": 1,\"need_distribution_info\": false}";
//        body="{\"order_no\": \"6710949511845780446\",\"need_distribution_info\": false}";
//        System.out.println("" + body);
//        System.out.println("" + s);
        String m = WXRT.getJSON1(s, body);



//        String ss="https://dopen.weimob.com/fuwu/b/oauth2/token?code=nCYa5s&grant_type=authorization_code&client_id=FFCDDCCCDA93EA5ECC271BA6B575286B&client_secret=B38DB139F6F6AC54FAB11882D10911B5&redirect_uri=http://jiuniu.sx-xpay.com/WM/order.jsp&state=123";
//        String m=WXRT.getJSON(ss, "");
        //System.out.println(">>>>" + m);
        JSONObject json = new JSONObject().fromObject(m);
//        System.out.println("" + json.getString("code"));
//        System.out.println("" + json.getString("data"));


        if (json.getJSONObject("code").getInt("errcode") == 0) {
            JSONObject j_data = json.getJSONObject("data");
            System.out.println("条数：" + j_data.getString("row_count"));
            JSONArray jsona = j_data.getJSONArray("page_data");

            for (int i = 0; i < jsona.size(); i++) {
                System.out.println("================================================================================");
                JSONObject j_item = jsona.getJSONObject(i);
                for (Object object : j_item.keySet()) {
                    String key = (String) object;
                    //System.out.println(">>" + key + ":" + j_item.getString(key));
                }
                getIt(j_item.getString("order_no"), j_item, actk);
            }
        } else {
            System.out.println("获取订单列表失败:" + json.getString("code"));
        }

        //{"access_token":"03c5a303-96d8-4766-84d5-414a92740dc9","token_type":"bearer","refresh_token":"6b3f479b-3292-40e6-a318-9d37d0b0958f","refresh_token_expires_in":604799,"expires_in":7199,"scope":"default","public_account_id":"55993650","business_id":"57223957"}

    }

    private static String[] getFTok(String ftok) {
        String s = "https://dopen.weimob.com/fuwu/b/oauth2/token?grant_type=refresh_token&client_id=FFCDDCCCDA93EA5ECC271BA6B575286B&client_secret=B38DB139F6F6AC54FAB11882D10911B5&refresh_token=" + ftok;
        String m = WXRT.getJSON(s, "");
        System.out.println("" + m);
        JSONObject json = new JSONObject().fromObject(m);
        if (json.containsKey("access_token")) {
            String[] rs = new String[2];
            rs[0] = json.getString("access_token");
            rs[1] = json.getString("refresh_token");
            return rs;
        }
        return null;
    }

    public static String getVal(JSONObject jitems, String key) {
        if (jitems.containsKey(key)) {
            return jitems.getString(key);
        }
        return "";
    }

    public static void getIt(String order, JSONObject j_items, String actk) {



        String s = "https://dopen.weimob.com/api/1_0/wangpu/Order/FullInfoGetHighly?accesstoken=" + actk;
        String body = "{\"order_no\": \"" + order + "\",\"need_distribution_info\": false}";


        String m = WXRT.getJSON1(s, body);
        log.info(m);
        JSONObject json = new JSONObject().fromObject(m);
        //System.out.println(">" + json + "<>");
//        System.out.println("" + json.getString("code"));
//        System.out.println("" + json.getString("data"));
        if (json.getJSONObject("code").getInt("errcode") == 0) {
            JSONObject j_data = json.getJSONObject("data");
            JSONArray json_order_details = j_data.getJSONArray("order_details");

            String sj = getVal(j_data, "create_time");
            String order_no = getVal(j_data, "order_no");

            String sql = "select * from ddzb where  order_no='" + order_no + "' ";
            String mechant_deliveryTime1 = "";
            if (MysqlDB.isHave(sql)) {


                {
                    for (Object object : j_data.keySet()) {
                        String key = (String) object;
                        //System.out.println(">>>" + key + ":" + j_data.getString(key));

                    }
                    
                    for (Object object : j_items.keySet()) {
                        String key = (String) object;
                        //System.out.println(">>" + key + ":" + j_items.getString(key));
                    }
                    String order_id = getVal(j_data, "order_id");
                    ArrayList<String> sqls = new ArrayList<String>();
                    for (int i = 0; i < json_order_details.size(); i++) {
                        JSONObject j_item = json_order_details.getJSONObject(i);
                        System.out.println("spu_code:" + j_item.getString("spu_code"));
                        System.out.println("sku_id:" + j_item.getString("sku_id"));
                        System.out.println("sku_name:" + j_item.getString("sku_name"));
                        System.out.println("qty:" + j_item.getString("qty"));
                        System.out.println("price:" + j_item.getString("price"));
                        System.out.println("amount:" + j_item.getString("amount"));

                        String sqlm = "insert into ddmx(order_id,spu_code,qty,sku_name,price,amount) values('" + order_id + "','" + j_item.getString("spu_code") + "','" + j_item.getString("qty") + "','" + j_item.getString("sku_name") + "','" + j_item.getString("price") + "','" + j_item.getString("amount") + "')";

                        System.out.println("" + sqlm);

                    }
//            System.out.println(""+json);
                    if (j_items.getString("delivery_type").equals("包邮")) {
                        JSONObject user_ztInfo = j_data.getJSONObject("user_ztInfo");
                        //System.out.println("" + user_ztInfo);
                        if (user_ztInfo.containsKey("自提人")) {
                            String person = user_ztInfo.getJSONObject("自提人").getString("objectValue");
                            String phone = user_ztInfo.getJSONObject("联系电话").getString("objectValue");
                            String wd = user_ztInfo.getJSONObject("自提点").getString("objectValue");
                            sj = user_ztInfo.getJSONObject("自提时间").getString("objectValue");
                            System.out.println("per：" + person);
                            System.out.println("phone：" + phone);
                            System.out.println("wd：" + wd);
                            System.out.println("sj：" + sj);
                            System.out.println("weimob_open_id:" + j_data.getString("weimob_open_id"));
                        }
                        if (user_ztInfo.containsKey("预约人")) {
                            String person = user_ztInfo.getJSONObject("预约人").getString("objectValue");
                            String phone = user_ztInfo.getJSONObject("联系电话").getString("objectValue");
                            String wd = user_ztInfo.getJSONObject("就餐门店").getString("objectValue");
                            System.out.println("per：" + person);
                            System.out.println("phone：" + phone);
                            System.out.println("wd：" + wd);
                            System.out.println("sj：" + sj);
                            System.out.println("weimob_open_id:" + j_data.getString("weimob_open_id"));
                        }
                    } else {
//                System.out.println("=============================================================");
//                System.out.println(""+json);
//                System.out.println("=============================================================");
                    }
                }
                return;
            }
            String x=null;
            String y=null;

            for (Object object : j_data.keySet()) {
                String key = (String) object;
                System.out.println(">>><<" + key + ":" + j_data.getString(key));

                if(key.equals("mechant_deliveryTime")){
                    mechant_deliveryTime1=j_data.getString(key);
                }
                
                if(key.equals("receiver_region")){
                    JSONObject receiver_region = j_data.getJSONObject("receiver_region");
                    x=receiver_region.getString("longitude");
                    y=receiver_region.getString("latitude");
                    
                }


            }
            System.out.println("x:>>"+x);
            System.out.println("y:>>"+y);
            String jsmd="9990";
            if(x!=null&&x.length()>0){
                double jl=999999999;
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                for (String keyvs : Main.MMM1.keySet()) {
                    String[] xy=Main.MMM1.get(keyvs);
                    System.out.println("x:"+x+"  x1:"+xy[0]);
                    System.out.println("y:"+y+"  y1:"+xy[1]);
                    double mmx1=Double.parseDouble(x)-Double.parseDouble(xy[0]);
                    double mmx2=Double.parseDouble(y)-Double.parseDouble(xy[1]);
                    double jlxx=Math.sqrt(mmx1*mmx1+mmx2*mmx2);
                    System.out.println(">>>>>>>>>>>"+ keyvs +">>>>>>>>>>>>>>>>>>>>>>"+jlxx);
                    if(jlxx<jl){
                        jl=jlxx;
                        jsmd=keyvs;
                    }


                }
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            }
            
            for (Object object : j_items.keySet()) {
                String key = (String) object;
                //System.out.println(">>" + key + ":" + j_items.getString(key));
            }
            String order_id = getVal(j_data, "order_id");
            ArrayList<String> sqls = new ArrayList<String>();
            for (int i = 0; i < json_order_details.size(); i++) {
                JSONObject j_item = json_order_details.getJSONObject(i);
                System.out.println("sku_code:" + j_item.getString("sku_code"));
                System.out.println("sku_id:" + j_item.getString("sku_id"));
                System.out.println("sku_name:" + j_item.getString("sku_name"));
                System.out.println("qty:" + j_item.getString("qty"));
                System.out.println("price:" + j_item.getString("price"));
                System.out.println("amount:" + j_item.getString("amount"));

                String sqlm = "insert into ddmx(order_id,spu_code,qty,sku_name,price,amount) values('" + order_id + "','" + j_item.getString("sku_code") + "','" + j_item.getString("qty") + "','" + j_item.getString("sku_name") + "','" + j_item.getString("price") + "','" + j_item.getString("amount") + "')";
                sqls.add(sqlm);
            }
//            System.out.println(""+json);


            String wd = getVal(j_data, "receiver_address");
            String odtype="1";
            
            String xm = getVal(j_data, "receiver_name");
            String dh = getVal(j_data, "receiver_tel");
            String sl = getVal(j_data, "sku_qty");
            String je = getVal(j_data, "goods_amount");
            String zt_code=getVal(j_data, "zt_code");
            String tqmd=null;
            if (j_items.getString("delivery_type").equals("包邮")) {
                JSONObject user_ztInfo = j_data.getJSONObject("user_ztInfo");
                System.out.println("" + user_ztInfo);
                if (user_ztInfo.containsKey("自提人")) {
                    String person = user_ztInfo.getJSONObject("自提人").getString("objectValue");
                    String phone = user_ztInfo.getJSONObject("联系电话").getString("objectValue");
                    wd = user_ztInfo.getJSONObject("自提点").getString("objectValue");
                    sj = user_ztInfo.getJSONObject("自提时间").getString("objectValue");

                    if(Main.MMM.containsKey(wd)){
                        wd=Main.MMM.get(wd);
                    }
                    dh=phone;

                    System.out.println("per：" + person);
                    System.out.println("phone：" + phone);
                    System.out.println("wd：" + wd);
                    System.out.println("sj：" + sj);
                    System.out.println("weimob_open_id:" + j_data.getString("weimob_open_id"));
                }

                if (user_ztInfo.containsKey("预约人")) {
                    String person = user_ztInfo.getJSONObject("预约人").getString("objectValue");
                    String phone = user_ztInfo.getJSONObject("联系电话").getString("objectValue");
                    wd = user_ztInfo.getJSONObject("就餐门店").getString("objectValue");

                    if(Main.MMM.containsKey(wd)){
                        wd=Main.MMM.get(wd);
                        tqmd=wd;
                    }
                    dh=phone;

                    System.out.println("per：" + person);
                    System.out.println("phone：" + phone);
                    System.out.println("wd：" + wd);
                    System.out.println("sj：" + sj);
                    System.out.println("weimob_open_id:" + j_data.getString("weimob_open_id"));
                }

                if (user_ztInfo.containsKey("zt_code")) {
                    zt_code = user_ztInfo.getString("zt_code");

                    System.out.println("zt_code>>>>>>>>>>>>>>>>>>>>>>>>：" + zt_code);
                    System.out.println("weimob_open_id:" + j_data.getString("weimob_open_id"));
                }
            } else {
//                System.out.println("=============================================================");
//                System.out.println(""+json);
//                System.out.println("=============================================================");
            }

            String order_status = getVal(j_data, "order_status");
            String create_time = getVal(j_data, "create_time");
            String pay_status = getVal(j_data, "pay_status");

            String weimob_open_id = getVal(j_data, "weimob_open_id");
            String delivery_type = getVal(j_data, "delivery_type");
            


            if(delivery_type!=null&&delivery_type.length()>0&&delivery_type.contains("配送")){
                odtype="8";
            }

            String sql1 = "insert into ddzb(order_id,order_no,order_type,order_status,pay_status,create_time,qty,xm,dh,wd,sj,je,weimob_openId,zzm,bz,md) values('" + order_id + "','" + order_no + "','"+odtype+"','" + order_status + "','" + pay_status + "','" + create_time + "','" + sl + "','" + xm + "','" + dh + "','" + wd + "','" + sj + "','" + je + "','" + weimob_open_id + "','"+zt_code+"','"+mechant_deliveryTime1+"','"+jsmd+"')";
            if(tqmd!=null){
                sql1 = "insert into ddzb(order_id,order_no,order_type,order_status,pay_status,create_time,qty,xm,dh,wd,sj,je,weimob_openId,md,zzm) values('" + order_id + "','" + order_no + "','"+odtype+"','" + order_status + "','" + pay_status + "','" + create_time + "','" + sl + "','" + xm + "','" + dh + "','" + wd + "','" + sj + "','" + je + "','" + weimob_open_id + "','"+tqmd+"','"+zt_code+"')";
            
            }
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(">>"+sql1);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            sqls.add(0, sql1);

            for (int i = 0; i < sqls.size(); i++) {
                System.out.println("sql1:" + sqls.get(i));

            }
            MysqlDB.upDdate(sqls);

        } else {
            System.out.println("获取订单" + order + "失败:" + json.getString("code"));
        }

    }
}
