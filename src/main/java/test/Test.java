package test;

import com.azazar.bitcoin.jsonrpcclient.Bitcoin;
import com.azazar.bitcoin.jsonrpcclient.BitcoinException;
import com.azazar.bitcoin.jsonrpcclient.BitcoinJSONRPCClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Qiao on 2016/9/29.
 */
public class Test {

    BitcoinJSONRPCClient client = new BitcoinJSONRPCClient();
    //获取余额  ok  返回余额  如果没有指定账户<account>，返回钱包的总余额。如果指定账户<account>，返回账户余额
    public void getBalance(){
        try {
            System.out.println(client.getBalance());
        } catch (BitcoinException e) {
            e.printStackTrace();
        }
    }


   /*
   不支持    增加节点
   public void addNode(){
        try {
        client.addNode("127.0.0.1", Bitcoin.AddNoteCmd.add);
        } catch (BitcoinException e) {
            e.printStackTrace();
        }
    }*/


    //拷贝钱包的wallet.dat文件到指定目录  ok
    // 安全地复制wallet.dat到一个目标地址<destination>，目标地址可以是一个目录或带路径的文件名。
    /*public void backupwallet(){
        try {
            client.backupwallet("C:\\Users\\Qiao\\Desktop\\win");
        } catch (BitcoinException e) {
            e.printStackTrace();
        }
    }*/

    //查询所有账户  返回账户名 和对应余额
    public Map<String, Number> listAccounts() {
        Map<String, Number> map = new HashMap<String, Number>();
        try {
            map  =client.listAccounts();
        } catch (BitcoinException e) {
            e.printStackTrace();
        }
        return map;
    }

    //获取账户下所有地址
    public List<String> getAddressesByAccount(String account) {
        List list= new ArrayList();
        try {
            list  =client.getAddressesByAccount(account);
        } catch (BitcoinException e) {
            e.printStackTrace();
        }
        return list;
    }


    public void getBlock(String blockHash){
        try {
            Bitcoin.Block b =client.getBlock(blockHash);
        } catch (BitcoinException e) {
            e.printStackTrace();
        }
    }

    public String getAccountAddress(String account){
        try {
            return client.getAccountAddress(account);
        } catch (BitcoinException e) {
            e.printStackTrace();
        }
        return "-1";
    }
    public static void main(String args[]) {
        Test test = new Test();
        //test.getBalance();
       //不支持 test.addNode();
      //  test.backupwallet();
        //   test.listAccounts();
        //test.getAddressesByAccount("18768897556");
       // test.getBlock("SP8eoAh3TuECHkzKPvEeo6TLmvMUsewG6f");
        long nw = System.currentTimeMillis();
        System.out.println(test.getAccountAddress("2"));
        System.out.println(nw-System.currentTimeMillis());

        /*
         mvn install:install-file -Dfile=F:/111111/corelib/bitcoin-json-rpc-client-1.0.jar -DgroupId=bitcoin -DartifactId=bitcoin-json-rpc-client-1.0.jar -Dversion=1.0 -Dpackaging=jar


        * */
    }

}
