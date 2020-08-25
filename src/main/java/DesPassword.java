
import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.util.DruidPasswordCallback;



public class DesPassword extends DruidPasswordCallback {

    public static void main(String[] args) throws Exception{
        String publickey = "填入公钥";
        String password = "填入密码";
        String pwd = ConfigTools.decrypt(publickey, password);

        System.out.println(pwd);
    }
}