import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import net.semanticmetadata.lire.sampleapp.Searcher;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

@ManagedBean(name = "uploadBean")
@SessionScoped
public class UploadBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Part file;
	private String filePath;
	@SuppressWarnings("unused")
	private String fileContent;
	ArrayList<String> paths = new ArrayList<String>();

	private String imageId;

	@SuppressWarnings("resource")
	
	@PostConstruct
	public void init(){
		for (int i = 0 ; i < 12; i++){
			paths.add("C:/Users/Johannes/workspaceMDB/MMDB/WebContent/default.jpeg");
		}
	}

	public void upload() {
		try {
			fileContent = new Scanner(file.getInputStream()).useDelimiter("\\A").next();
		} catch (IOException e) {
			// Error handling
		}
		filePath = getFileName(file);
		paths = Main.test(filePath);

	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;

	}

	private String getFileName(final Part part) {
		@SuppressWarnings("unused")
		final String partHeader = part.getHeader("content-disposition");
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	public ArrayList<String> getPaths() {
		return paths;
	}

	public void setPaths(ArrayList<String> paths) {
		this.paths = paths;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

}
