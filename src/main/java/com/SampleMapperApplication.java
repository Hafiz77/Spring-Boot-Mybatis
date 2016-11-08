package com;

import com.entity.City;
import com.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by abdul on 11/7/2016.
 */

@SpringBootApplication
public class SampleMapperApplication implements CommandLineRunner {
    @Autowired
    private CityMapper cityMapper;

    public static void main(String[] args) {
        SpringApplication.run(SampleMapperApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(cityMapper.findByState("CA"));
        City city = new City();
        city.setName("MKKMM");
        city.setState("DT");
        city.setCountry("BD");
        System.out.println(cityMapper.insertCity(city));

    }
}
