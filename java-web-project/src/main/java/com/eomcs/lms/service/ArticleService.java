package com.eomcs.lms.service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import com.eomcs.lms.domain.Article;
import com.eomcs.lms.domain.UploadFile;

public interface ArticleService {
  List<Article> list();
  Article get(int id);
  int add(String subject, String content, ArrayList<Object> addNo) throws Exception;
  
  

}
