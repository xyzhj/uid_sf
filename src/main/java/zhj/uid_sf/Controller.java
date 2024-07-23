package zhj.uid_sf;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static zhj.uid_sf.Util.*;

@RestController

public class Controller {
    //注入即可
    @Autowired
    public SnowFlake snowFlake;

    @RequestMapping("/getuid")
    public Map getID() throws Exception {
        //这里直接调用该方法 获取雪花算法生成ID
        long bt = System.currentTimeMillis();
        long id = snowFlake.getID();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("ID",id);
        map.put("Binary",Long.toBinaryString(id));
        map.put("BinaryLength",Long.toBinaryString(id).length());
        map.put("IP", getNetInfo().getHostAddress()+":"+getPort());
        map.put("V",getVersion());
        long et = System.currentTimeMillis();
        map.put("MS",et-bt);
        return map;
    }
}