package grzegorz;

import org.junit.Test;

public class AppTest {

  @Test
  public void testApp() {
    RemoteDataSource source = new RemoteDataSource("http", "bossa.pl",
        "/pub/metastock/mstock/");
    StockQuoteLoader downloader = new StockQuoteLoader(source);
    downloader.loadData("mstall.zip");
  }
}
