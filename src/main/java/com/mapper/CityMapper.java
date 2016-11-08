package com.mapper;

import com.entity.City;
import org.apache.ibatis.annotations.*;

/**
 * Created by abdul on 11/7/2016.
 */

@Mapper
public interface CityMapper {
    @Select("select * from city where state = #{state}")
    City findByState(@Param("state") String state);

    @Insert("INSERT INTO CITY ( NAME,STATE, COUNTRY ) VALUES ( #{city.name}, #{city.state},#{city.country})")
   // @Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
    Integer insertCity(@Param("city") City city) throws Exception;
}
