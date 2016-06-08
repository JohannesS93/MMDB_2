import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleResultSet;
import oracle.sql.BFILE;

public class GetImages {

	public static ArrayList<String> getImages(Connection con) throws SQLException {
		ArrayList<String> result = new ArrayList<String>();
		PreparedStatement ps = con.prepareStatement("select * from IMAGE");
		ResultSet rs = ps.executeQuery();
		BFILE src_lob = null;
		while (rs.next()) {// now on 1st row
			src_lob = ((OracleResultSet) rs).getBFILE(2);
			result.add(src_lob.getDirAlias());
		}
		return result;
	}
}
