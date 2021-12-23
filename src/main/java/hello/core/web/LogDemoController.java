package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor // 자동 생성자 주입
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURI().toString();

        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
//        [b0969b6e-1287-42b1-bc5b-688715830a78] request scope bean create: hello.core.common.MyLogger@1f7962b6
//        [b0969b6e-1287-42b1-bc5b-688715830a78] [/log-demo]controller test
//        [b0969b6e-1287-42b1-bc5b-688715830a78] [/log-demo]service id: testId
//        [b0969b6e-1287-42b1-bc5b-688715830a78] request scope bean close: hello.core.common.MyLogger@1f7962b6

    }
}
