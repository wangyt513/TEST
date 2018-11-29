/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wenmeng;

import java.util.Date;

/**
 *
 * @author wyt
 */
public class KANGOU {
    public static void main(String[] args) {
        
        String urls="https://passport.kangou.cn/service/TaiYuanJiuMuDanGao/kangojnmy.ashx";
        java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
        String userId="895d4415-bb70-4fd8-b755-0e186bd3b50c";
        String timestamp=sdf.format(new Date());
        String jmId="08046";
        String dateStart="2018-11-1";
        String dateEnd="2018-11-30";

        String key="kango19221";
        String sign="dateEnd"+dateEnd+"dateStart"+dateStart+"jmId"+jmId+"timestamp"+timestamp+"userId"+userId+""+key;
        //String key="kango19221";
        //sign+= "" + key;
        String keys=Sign.getMD5Str(sign);
        System.out.println(""+keys);
        String paras="?id=KG_OrderQuery&userid="+userId+"&timestamp="+timestamp+"&jmId="+jmId+"&dateStart="+dateStart+"&dateEnd="+dateEnd+"&sign="+keys;
        String rs=WXRT.getJSON(urls+paras);
        System.out.println(""+rs);

    }


}
