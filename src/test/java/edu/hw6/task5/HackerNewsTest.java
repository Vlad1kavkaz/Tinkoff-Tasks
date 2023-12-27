package edu.hw6.task5;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HackerNewsTest {

    @Test
    void testThatHacerNewsReturnedNews() {
        HackerNews hackerNews = new HackerNews();
        long[] top = hackerNews.hackerNewsTopStories();

        assertEquals(500, top.length);
        System.out.println(Arrays.toString(hackerNews.hackerNewsTopStories()));

    }

    @Test
    void testThatHacerNewsReturnedTop() {
        HackerNews hackerNews = new HackerNews();

        String newsTitle = hackerNews.news(37570037);
        String newsTitle2 = hackerNews.news(38249214);

        System.out.println(newsTitle);
        System.out.println(newsTitle2);

        assertEquals("JDK 21 Release Notes", newsTitle);
        assertEquals("Ship Shape", newsTitle2);
    }
}
