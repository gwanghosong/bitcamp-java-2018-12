package com.eomcs.lms.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.eomcs.lms.domain.UploadFile;
import com.eomcs.lms.service.ImageService;
import com.eomcs.lms.util.MediaUtils;

@Controller
public class ImageController {
  
  private static final Logger logger = LogManager.getLogger(ImageController.class);
  
  @Autowired
  ImageService imageService;
  
  @PostMapping("/image")
  @ResponseBody
  public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
      try {
          String ofn = file.getOriginalFilename();
          logger.info("파일경로" + ofn);
          imageService.preparePath(ofn);
          UploadFile uploadedFile = imageService.store(file);
          ResponseEntity<String> callUrl = ResponseEntity.ok().body("../../../java-web-project/app/image/" + uploadedFile.getId());
          logger.info(callUrl);
          return callUrl;
      } catch (Exception e) { 
          e.printStackTrace();
          return ResponseEntity.badRequest().build();
      }
  }

  @GetMapping("/image/{fileId}")
  @ResponseBody
  public ResponseEntity<?> serveFile(@PathVariable int fileId) {
      try {
          UploadFile uploadedFile = imageService.load(fileId);
          HttpHeaders headers = new HttpHeaders();
          
          Resource resource = imageService.loadAsResource(uploadedFile.getSaveFileName());
          String fileName = uploadedFile.getFileName();
          logger.info(fileName);
          headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");

          if (MediaUtils.containsImageMediaType(uploadedFile.getContentType())) {
              headers.setContentType(MediaType.valueOf(uploadedFile.getContentType()));
          } else {
              headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
          }
          logger.info(resource);
          return ResponseEntity.ok().headers(headers).body(resource);
          
      } catch (Exception e) {
          e.printStackTrace();
          return ResponseEntity.badRequest().build();
      }
  }

  
}
