package com.ignore.validator;

/**
 * @Author renzhiqiang
 * @Description
 * @Date 2019-08-08
 **/
public class Request {
    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Request(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String name;

        private Integer age;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Request build() {
            return new Request(this.name, this.age);
        }
    }
}
