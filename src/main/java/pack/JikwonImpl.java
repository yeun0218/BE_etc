package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonImpl extends JdbcDaoSupport implements JikwonInter{

    @Autowired
    public JikwonImpl (DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public List<JikwonDto> selectList(){

        RowMapper mapper = new MyMapper();

        return getJdbcTemplate().query("SELECT jikwonno, jikwonname, busername, jikwonjik FROM jikwon INNER JOIN buser ON buserno = busernum", mapper);
    }

    class MyMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            JikwonDto dto = new JikwonDto();
            dto.setJikwonno(rs.getString("jikwonno"));
            dto.setJikwonname(rs.getString("jikwonname"));
            dto.setBusername(rs.getString("busername"));
            dto.setJikwonjik(rs.getString("jikwonjik"));
           
            return dto;
        }
    }
}
