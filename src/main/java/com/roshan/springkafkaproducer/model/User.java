package com.roshan.springkafkaproducer.model;

/**
 * @author ali akbar azizkhani
 */
public class User {

    private String username;
    private String dep;
    private Long salary;


    public User(String username, String dep, Long salary) {
        this.username = username;
        this.dep = dep;
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
