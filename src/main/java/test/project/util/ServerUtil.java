package test.project.util;

/**
 * @author Haadi
 * @date 16 Jul 2018
 */
public interface ServerUtil {

	
	public String generateHash(String input) throws Exception;
	
	public String rabdomizePassword() throws Exception;
	
	public String generateUid() throws Exception;
	
//	public String fileExtFromMimeType(String mimeType) throws Exception;
}
