package grzegorz;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class StockQuoteLoader {

  private RemoteDataSource source;

  public StockQuoteLoader(RemoteDataSource source) {
    this.source = source;
  }

  public void loadData(String zippedFileName) {

    URL fileUrl;
    try {
      fileUrl = new URL(this.source.getProtocol(), this.source.getHost(),
          this.source.getPath() + zippedFileName);
    } catch (MalformedURLException e) {
      throw new IllegalArgumentException("URL is invalid.", e);
    }

    try {
      InputStream inputStream = fileUrl.openStream();
      ZipInputStream zipInputStream = new ZipInputStream(inputStream);
      Scanner scanner;

//     Reads the next ZIP file entry and positions the stream at the
//     beginning of the entry data.
      ZipEntry zipFileEntry = zipInputStream.getNextEntry();
      while (zipFileEntry != null) {
        scanner = new Scanner(zipInputStream);
        while (scanner.hasNext()) {
          scanner.nextLine();
        }
        zipFileEntry = zipInputStream.getNextEntry();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
