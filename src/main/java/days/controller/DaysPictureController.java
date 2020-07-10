package days.controller;

import days.model.Picture;
import days.service.impl.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/pictures")
public class DaysPictureController {
    @Autowired
    IPictureService pictureService;

    @GetMapping
    public ModelAndView showPicture(){
        ModelAndView modelAndView = new ModelAndView("daysPicture");
        List<Picture> comment = pictureService.findAll();
        modelAndView.addObject("comment",comment);
        modelAndView.addObject("picture",new Picture());
        return modelAndView;
    }

    @PostMapping("/save")
    public String savePicture(Picture picture, RedirectAttributes redirectAttributes){
        pictureService.save(picture);
        redirectAttributes.addFlashAttribute("success","Add comment successfully!");
        return "redirect:/pictures";
    }

    @PostMapping("/like/{id}")
    public ModelAndView likePicture(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/pictures");
        pictureService.updateLike(id);
        return modelAndView;
    }
}
