package com.example.initializer.domain.es;

import java.io.Serializable;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;


@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(indexName = "blog", type = "blog")
public class EsBlog implements Serializable {

  @Id
  private String id;
  private String title;
  private String summary;
  private String content;

  public EsBlog(String title, String summary, String content) {
    this.title = title;
    this.summary = summary;
    this.content = content;
  }
}
