package us.codecraft.webmagic.utils;

import java.io.File;

/**
 * Base object of file persistence.
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.2.0
 */
public class FilePersistentBase {

    protected String path;

    public static String PATH_SEPERATOR = "/";

    static {
/*        String property = System.getProperties().getProperty("file.separator");
        if (property != null) {
            PATH_SEPERATOR = property;
        }*/
    }

    public void setPath(String path) {
        if (!path.endsWith(PATH_SEPERATOR)) {
            path += PATH_SEPERATOR;
        }
        this.path = path;
    }

    public File getFile(String fullName) {
        checkAndMakeParentDirecotry(fullName);
        return new File(fullName);
    }

    public void checkAndMakeParentDirecotry(String fullName) {
        int index = fullName.lastIndexOf(PATH_SEPERATOR);
        if (index > 0) {
            String path = fullName.substring(0, index);
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }

    public String getPath() {
        return path;
    }
    
    public static String appendDefaultFileName(String url){
	String domain=UrlUtils.getDomain(url);
	int index=url.lastIndexOf("/");
	String fileName = url.substring(index);
	if (fileName.contains(".")&& !fileName.contains(domain)){
	    return url;
	}else{
	    if (url.charAt(url.length()-1)!='/'){
		url =url + "/";
	    }
	    return url + "index.html";
	}
    }
}
