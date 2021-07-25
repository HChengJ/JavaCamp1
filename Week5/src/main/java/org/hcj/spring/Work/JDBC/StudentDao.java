package org.hcj.spring.Work.JDBC;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    List<Map<String,Object>> findAll();
}
