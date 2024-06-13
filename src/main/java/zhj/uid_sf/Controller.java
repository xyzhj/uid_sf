package zhj.uid_sf;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    //注入即可
    @Autowired
    public SnowFlake snowFlake;

    @RequestMapping("/getid")
    public Map getID(){
        //这里直接调用该方法 获取雪花算法生成ID
        long id = snowFlake.getID();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("ID",id);
        map.put("Binary",Long.toBinaryString(id));
        map.put("BinaryLength",Long.toBinaryString(id).length());
        return map;
    }
}