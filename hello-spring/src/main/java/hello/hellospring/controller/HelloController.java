package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hi")//정적컨테츠
    public String hi1(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")  //mvc와 템플릿 엔진(렌더링 된 html를 반환)
    public String helloMvc(@RequestParam("name") String name1, Model model) {
        model.addAttribute("name", name1);  //"name"은 key, name value??
        return "hello-template";
    }

    @GetMapping("hello-string")  //API(뷰리졸버 없음)
    @ResponseBody  //반환값 바로 반환(StringConverter)
    public String helloString(@RequestParam("name") String name1) {
        return "hello(API) " + name1;  //문자 반환
    }

    @GetMapping("hello-api")
    @ResponseBody //반환값이 객체이면 jason 방식으로 반환(JasonConverter)
    public Hello helloAPI(@RequestParam("name") String name1) {
        Hello hello = new Hello();
        hello.setName(name1);
        return hello;    //객체 반환
    }

    static class Hello {
        private String name;

        //getter and setter 단축키: alt+insert
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
