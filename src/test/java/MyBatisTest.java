import com.ylw.springboot.App;
import com.ylw.springboot.bean.User;
import com.ylw.springboot.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class MyBatisTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testInsert() {
        int effectCount = userMapper.insert(UUID.randomUUID().toString(), "Dumas", 26);
        System.out.println("插入条数 -> " + effectCount);
    }

    @Test
    public void testQuery() {
        User user = userMapper.findByName("Dumas");
        if (user != null) {
            System.out.println(user.toString());
        }else{
            System.out.println("没有查询到内容！");
        }
    }
}
