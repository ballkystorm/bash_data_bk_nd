package com.asti.bashdata.auth.resolver;

import com.asti.bashdata.auth.annotation.CurrentUser;
import com.asti.bashdata.auth.security.SecurityUser;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Resolves the authenticated user for parameters
 * annotated with {@link CurrentUser}.
 */
@Component
public class CurrentUserArgumentResolver
        implements HandlerMethodArgumentResolver {

    /**
     * Determines whether this resolver supports the parameter.
     *
     * @param parameter controller method parameter
     * @return true if supported
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        return parameter.hasParameterAnnotation(CurrentUser.class)
                && parameter.getParameterType().equals(SecurityUser.class);

    }

    /**
     * Resolves the authenticated user from the SecurityContext.
     *
     * @return authenticated SecurityUser
     */
    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        return authentication.getPrincipal();

    }

}