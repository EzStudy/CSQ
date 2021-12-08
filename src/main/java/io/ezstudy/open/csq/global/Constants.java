package io.ezstudy.open.csq.global;

public class Constants {

  public enum PROVIDER {

    GOOGLE("PROVIDER_GOOGLE"),
    KAKAO("PROVIDER_KAKAO");

    private String title;

    PROVIDER(String title) {
      this.title = title;
    }

    public String getTitle() {
      return title;
    }
  }

  public enum ROLE {

    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String title;

    ROLE(String title) {
      this.title = title;
    }

    public String getTitle() {
      return title;
    }
  }

}
