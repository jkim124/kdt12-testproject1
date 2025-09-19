package practice.example.demo.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecondInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    System.out.println("SecondInterceptor preHandle()");

    // 만약 return false;이면 다음 순서의 인터셉터가 실행되지 않음
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    System.out.println("SecondInterceptor postHandle()");

    // 컨트롤러에서 세팅한 ModelAndView를 조회
    if (modelAndView != null) {
      ModelAndView mv = (ModelAndView) modelAndView.getModelMap().get("modelAndView");
      String query = (String) mv.getModel().get("query");


      // 응답 값을 대문자로 수정
      if (query != null) {
        String queryUpperCase = query.toUpperCase();
        System.out.println(query + " -> " + queryUpperCase);

        modelAndView.addObject("query", queryUpperCase);
      }
    }

    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    System.out.println("SecondInterceptor afterCompletion()");
  }
}