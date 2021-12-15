package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " object = " + bean);
//            name = org.springframework.context.annotation.internalConfigurationAnnotationProcessor object = org.springframework.context.annotation.ConfigurationClassPostProcessor@1a9c38eb
//            name = org.springframework.context.annotation.internalAutowiredAnnotationProcessor object = org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor@319bc845
//            name = org.springframework.context.annotation.internalCommonAnnotationProcessor object = org.springframework.context.annotation.CommonAnnotationBeanPostProcessor@4c5474f5
//            name = org.springframework.context.event.internalEventListenerProcessor object = org.springframework.context.event.EventListenerMethodProcessor@2f4205be
//            name = org.springframework.context.event.internalEventListenerFactory object = org.springframework.context.event.DefaultEventListenerFactory@54e22bdd
//            name = appConfig object = hello.core.AppConfig$$EnhancerBySpringCGLIB$$2cd7a939@3bd418e4
//            name = memberRepository object = hello.core.member.MemoryMemberRepository@544820b7
//            name = discountPolicy object = hello.core.dicount.FixDiscountPolicy@6b98a075
//            name = memberService object = hello.core.member.MemberServiceImpl@2e61d218
//            name = orderService object = hello.core.order.OrderServiceImpl@3569fc08
        }
    }

    @Test
    @DisplayName("모든 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);// Bean에 대한 메타데이터

            // 스프링 내부에서 등록한 Bean이 아닌 애플리케이션 개발을 위해 추가로 등록한 Bean
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
//          if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " object = " + bean);
//                name = appConfig object = hello.core.AppConfig$$EnhancerBySpringCGLIB$$2cd7a939@1a9c38eb
//                name = memberRepository object = hello.core.member.MemoryMemberRepository@319bc845
//                name = discountPolicy object = hello.core.dicount.FixDiscountPolicy@4c5474f5
//                name = memberService object = hello.core.member.MemberServiceImpl@2f4205be
//                name = orderService object = hello.core.order.OrderServiceImpl@54e22bdd
            }
        }
    }
}
