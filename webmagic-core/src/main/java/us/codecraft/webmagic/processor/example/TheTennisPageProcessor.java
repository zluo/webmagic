package us.codecraft.webmagic.processor.example;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.IPageProcessor;

import java.util.List;

/**
 * @author code4crafter@gmail.com <br>
 */
public class TheTennisPageProcessor implements IPageProcessor {

    private Site site = Site.create().setDomain("www.tennisplayer.net");

    @Override
    public void process(Page page) {
        List<String> links = page.getHtml().links().regex("http://www\\.tennisplayer\\.net/.+").all();
        page.addTargetRequests(links);
        String content =page.getHtml().toString();
        System.out.println(content);
        page.putField("content", content);
    }

    @Override
    public Site getSite() {
        return site;

    }

    public static void main(String[] args) {
        Spider.create(new TheTennisPageProcessor()).addUrl("http://www.tennisplayer.net").run();
    }
}
