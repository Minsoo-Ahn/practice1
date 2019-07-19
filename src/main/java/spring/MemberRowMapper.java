package spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper<Member>{

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member(rs.getString("email"),
				rs.getString("password"),
				rs.getString("name"),
				rs.getTimestamp("regdate"));
		member.setId(rs.getLong("id"));
		System.out.println(rs.getString("email"));
		System.out.println(rs.getString("password"));
		return member;
	}
}
