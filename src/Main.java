import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import net.semanticmetadata.lire.sampleapp.Indexer;
import net.semanticmetadata.lire.sampleapp.Searcher;

public class Main {

	public static void main(String[] args) {
		
		
		ArrayList<String> images = new ArrayList <String>();
		File f = new File("C:/Users/Johannes/workspaceMDB/MMDB/WebContent/Data/Pictures/27482938266_b95af6d77c_b.jpg");
		Connection con;
		try {
			con = ConnectionCreator.getConnection();
			images = GetImages.getImages(con);
			//Indexer.indexing(images);
			Searcher.indexResult(f);
		} catch (SQLException | ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static ArrayList<String> test(String path) {
		 ArrayList<String> paths = new ArrayList<String>();
		File f1 = new File(path);
		System.out.println(f1.getAbsolutePath());
		try {
			paths = Searcher.indexResult(f1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paths;
		
	}

}
