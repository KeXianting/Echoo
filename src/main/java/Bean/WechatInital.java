package Bean;

import Util.AccessToken;
import Util.WechatUtil;
import net.sf.json.JSONObject;

/**
 * Created by lee on 4/9/17.
 */
public class WechatInital {
    public static void main(String[] args){
        try{
            WechatUtil wechatUtil=new WechatUtil();
            AccessToken token=wechatUtil.getAcessToken();
            String access_token=token.getAccess_token();
            int expires_in=token.getExpires_in();
            System.out.println(access_token);
            String menu= JSONObject.fromObject(wechatUtil.initMenu()).toString();
            int errcode=wechatUtil.creatMenu(menu,access_token);
            if (errcode==0){
                System.out.println("创建菜单成功");
            }else {
                System.out.println("创建菜单失败"+errcode);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
