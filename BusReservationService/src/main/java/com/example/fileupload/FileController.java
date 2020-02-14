package com.example.fileupload;

import java.io.File;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Controller
public class FileController {

    @Autowired
    FileService fileService;
    
    private AmazonClient amazonClient;

    @Autowired
    FileController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }    
    
    @GetMapping("/upload")
    public static String index() {
		
        return "upload";
    }
  
    
    
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file,RedirectAttributes redirectAttributes) {
    	
    	
    	this.amazonClient.uploadFile(file);
    	
    	 redirectAttributes.addFlashAttribute("message",
    	            "You successfully uploaded " + file.getOriginalFilename() + "!");
    	 
    	return "redirect:/upload";
    }
    
    
   
    /*
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        fileService.uploadFile(file);

        redirectAttributes.addFlashAttribute("message",
            "You successfully uploaded " + file.getOriginalFilename() + "!");
       
                
        return "redirect:/upload";
    }
*/
}
