package com.example.initializer.Repository.es;

import com.example.initializer.domain.es.EsBlog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class EsBlogRepositoryTest {

  @Autowired
  private EsBlogRepository esBlogRepository;

  @BeforeEach
  public void init() {
    esBlogRepository.deleteAll();
    esBlogRepository.save(new EsBlog("登鹳雀楼","王之涣的登鹳雀楼",
        "白日依山尽，黄河入海流。欲穷千里目，更上一层楼。"));
    esBlogRepository.save(new EsBlog("相思","王维的相思",
        "红豆生南国，春来发几枝。愿君多采撷，此物最相思。"));
    esBlogRepository.save(new EsBlog("静夜思","李白的静夜思",
        "床前明月光，疑是地上霜。举头望明月，低头思故乡"));
  }

  @Test
  void findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
    Pageable pageable = PageRequest.of(0, 20);
    String title = "思";
    String summary = "相思";
    String content = "相思";
    Page<EsBlog> esBlogs =
        esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary,
            content, pageable);

    assertThat(esBlogs.getTotalElements()).isEqualTo(2);

    for(EsBlog esBlog : esBlogs) {
      System.out.println(esBlog);
    }
  }
}