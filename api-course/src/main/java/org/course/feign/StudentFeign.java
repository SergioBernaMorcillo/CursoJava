package org.course.feign;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "student")
@LoadBalancerClient(value = "api-student", configuration = org.course.config.LoadBalancerConfig.class)
public interface StudentFeign {

    @GetMapping("/api/v1/students/getById")
    Student getById(@RequestParam Long id);

    @PostMapping("/api/v1/students/save")
    Long create(@RequestBody Student student);

    @Getter
    @Setter
    class Student {
        private Long studentId;
        private String name;
        private String lastName;
    }
}
