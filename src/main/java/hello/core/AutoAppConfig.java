package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        // 검색할 시작 패키지 위치를 지정한다.
        // basePackages = {"hello.core.member", "hello.service"},
        // 기본값은 이 클래스가 속한 패키지부터 시작한다. 따라서 hello.core부터
        basePackageClasses = AutoAppConfig.class,

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 다른 Configuration이 등록되면 안되기 때문에 등록 (@Configuration일 경우 자동 스캔)

)
public class AutoAppConfig {
}


