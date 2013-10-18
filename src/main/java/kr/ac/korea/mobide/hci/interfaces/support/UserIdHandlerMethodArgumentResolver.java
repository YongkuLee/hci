package kr.ac.korea.mobide.hci.interfaces.support;

import kr.ac.korea.mobide.hci.domain.model.user.UserId;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 9:48
 * To change this template use File | Settings | File Templates.
 */
public class UserIdHandlerMethodArgumentResolver implements WebArgumentResolver {

    @Override
    public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
        if (methodParameter.getParameterType().equals(UserId.class)) {
            UserId userId = new UserId(SecurityContextHolder.getContext().getAuthentication().getName());
            return userId;
        }

        return UNRESOLVED;
    }
}
