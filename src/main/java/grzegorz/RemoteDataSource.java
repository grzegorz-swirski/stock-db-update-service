package grzegorz;

import com.google.common.base.Preconditions;

public class RemoteDataSource {

  private String protocol;
  private String host;
  private String path;

  public RemoteDataSource(String protocol, String host, String path) {
    Preconditions.checkArgument(protocol != null && !protocol.isEmpty(), "Protocol cannot be null or empty.");
    Preconditions.checkArgument(host != null && !host.isEmpty(), "Host cannot be null or empty.");
    Preconditions.checkArgument(path != null && !path.isEmpty(), "Path cannot be null or empty.");
    this.protocol = protocol;
    this.host = host;
    this.path = path;
  }

  public String getProtocol() {
    return protocol;
  }

  public String getHost() {
    return host;
  }

  public String getPath() {
    return path;
  }
}
