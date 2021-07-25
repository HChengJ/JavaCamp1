package org.hcj.spring;

import static org.junit.Assert.assertTrue;

import org.hcj.spring.Work.JDBC.DefaultStudentDao;
import org.hcj.spring.Work.JDBC.StudentDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }



        @Autowired
        private DefaultStudentDao studentDao;

        @Test
        public void testFindAll(){
            List<Map<String,Object>> list= studentDao.findAll();
            for(Map<String,Object> map:list){
                System.out.println(map);
            }
        }

}
