package us.codecraft.webmagic.utils;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;


public class FilePersistentBaseTest {

    @Test
    public void testAppendDefaultFileCase1(){
	String url="http://www.tennisplayer.net/public/avancedtennis/avancedtennis_public.html";
	FilePersistentBase base = new FilePersistentBase();
	assertEquals(url, base.appendDefaultFile(url));
    }
    @Test
    public void testAppendDefaultFileCase2(){
	String url="http://www.tennisplayer.net/public/avancedtennis";
	FilePersistentBase base = new FilePersistentBase();
	assertEquals(url + "/index.html", base.appendDefaultFile(url));
    }
    @Test
    public void testAppendDefaultFile3(){
	String url="http://www.tennisplayer.net/public/avancedtennis/";
	FilePersistentBase base = new FilePersistentBase();
	assertEquals(url +"index.html", base.appendDefaultFile(url));
    }
    
    @Test
    public void testAppendDefaultFileCase4(){
	String url="http://www.tennisplayer.net/";
	FilePersistentBase base = new FilePersistentBase();
	assertEquals(url +"index.html", base.appendDefaultFile(url));
    }
    @Test
    public void testAppendDefaultFileCase5(){
	String url="http://www.tennisplayer.net";
	FilePersistentBase base = new FilePersistentBase();
	assertEquals(url +"/index.html", base.appendDefaultFile(url));
    }
    
}
