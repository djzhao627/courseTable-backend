package cn.djzhao.model.mapper;

import cn.djzhao.model.entity.Speciality;
import cn.djzhao.model.entity.SpecialityQuery;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface SpecialityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     */
    long countByExample(SpecialityQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     */
    int deleteByExample(SpecialityQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     */
    @Delete({
        "delete from speciality",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     */
    @Insert({
        "insert into speciality (spe_name, spe_describe, ",
        "statu, mark)",
        "values (#{speName,jdbcType=VARCHAR}, #{speDescribe,jdbcType=VARCHAR}, ",
        "#{statu,jdbcType=INTEGER}, #{mark,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Speciality record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     */
    int insertSelective(Speciality record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     */
    List<Speciality> selectByExampleWithRowbounds(SpecialityQuery example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    Speciality selectOneByExample(SpecialityQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     */
    List<Speciality> selectByExample(SpecialityQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, spe_name, spe_describe, statu, mark",
        "from speciality",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.djzhao.model.mapper.SpecialityMapper.BaseResultMap")
    Speciality selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Speciality record, @Param("example") SpecialityQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Speciality record, @Param("example") SpecialityQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Speciality record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     */
    @Update({
        "update speciality",
        "set spe_name = #{speName,jdbcType=VARCHAR},",
          "spe_describe = #{speDescribe,jdbcType=VARCHAR},",
          "statu = #{statu,jdbcType=INTEGER},",
          "mark = #{mark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Speciality record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     */
    int insertOrUpdate(Speciality record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     */
    int insertOrUpdateSelective(Speciality record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsert(@Param("list") List<Speciality> list);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table speciality
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsertSelective(@Param("list") List<Speciality> list, @Param("selective") Speciality.Column ... selective);
}