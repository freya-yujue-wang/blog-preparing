package com.example.initializer.Controller;

import com.example.initializer.Repository.es.EsBlogRepository;
import com.example.initializer.domain.es.EsBlog;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/blogs")
@RestController
public class BlogController {

  @Autowired
  private EsBlogRepository _esBlogRepository;

  @GetMapping
  public List<EsBlog> list(@RequestParam("title") String title, @RequestParam("summary") String summary,
      @RequestParam("content") String content, @RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

    Pageable pageable = PageRequest.of(pageIndex, pageSize);
    Page<EsBlog> esBlogs =
        _esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary,
            content, pageable);

    return esBlogs.getContent();
  }
}
