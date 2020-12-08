package test.project.util;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.tika.mime.MimeType;
//import org.apache.tika.mime.MimeTypes;
import org.springframework.stereotype.Component;

/**
 * @author Haadi
 * @date 16 Jul 2018
 */
@Component
public class ServerUtilImpl implements ServerUtil {

	@Override
	public String generateHash(String input) throws Exception {
		// TODO Auto-generated method stub
				String salt = "Il0k3n!@#";
				
				String msg = salt + input + salt;
				String md5Hex = DigestUtils.md5Hex(msg).toUpperCase();

				return md5Hex;
	}

	@Override
	public String rabdomizePassword() throws Exception {
		// TODO Auto-generated method stub
				//String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
//				String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~!@#$%^&*()-_=+[{]}\\|;:<>/?";
				String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";//!@#$%&?
				String pwd = RandomStringUtils.random( 12, characters );

				return pwd;
	}

	/* (non-Javadoc)
	 * @see net.ilokensystem.abid.util.ServerUtil#generateUid()
	 */
	@Override
	public String generateUid() throws Exception {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString();
	}

	
//	@Override
//	public String fileExtFromMimeType(String mimeType) throws Exception {
//		// TODO Auto-generated method stub
//		
//		MimeTypes allTypes = MimeTypes.getDefaultMimeTypes();
//		MimeType ext = allTypes.forName(mimeType);
//		String fileExt = ext.getExtension();
//		
//		return fileExt;
//	}

}
