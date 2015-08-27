package us.codecraft.webmagic.utils;

/**
 * @author yihua.huang@dianping.com
 */
public abstract class NumberUtils {

    public static int compareLong(long x, long y) {
	return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
}
