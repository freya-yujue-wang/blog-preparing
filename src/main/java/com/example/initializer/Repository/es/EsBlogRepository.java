package com.example.initializer.Repository.es;

import com.example.initializer.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {
  /**
   * Search blog with pagenation
   * @param title
   * @param summary
   * @param content
   * @param pageable
   * @return
   */
  Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
}
