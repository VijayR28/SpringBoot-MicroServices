package LoginController;

import LoginService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginservice;
    @GetMapping(value = "/login")
        public String viewLoginPage(ModelMap modelmap) {
          return "login";
        }
    @PostMapping(value ="/login")
    public String showWelcomePage(ModelMap modelmap, @RequestParam String userid,@RequestParam String password)
    {
        boolean validate = loginservice.validateUser(userid,password);

        if(!validate)
        {
            modelmap.put("error message","Access denied,invalid credentials");
            return "login";
        }

        modelmap.put("name",userid);
        modelmap.put("password",password);

        return "welcome to flipkart";
    }

}
