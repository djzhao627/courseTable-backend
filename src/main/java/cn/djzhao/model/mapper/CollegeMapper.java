package cn.djzhao.model.mapper;

import cn.djzhao.model.entity.College;
import cn.djzhao.model.entity.CollegeQuery;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface CollegeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     */
    long countByExample(CollegeQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     */
    int deleteByExample(CollegeQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     */
    @Delete({
        "delete from college",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     */
    @Insert({
        "insert into college (college_name, college_describe, ",
        "statu, mark)",
        "values (#{collegeName,jdbcType=VARCHAR}, #{collegeDescribe,jdbcType=INTEGER}, ",
        "#{statu,jdbcType=INTEGER}, #{mark,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(College record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     */
    int insertSelective(College record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     */
    List<College> selectByExampleWithRowbounds(CollegeQuery example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    College selectOneByExample(CollegeQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     */
    List<College> selectByExample(CollegeQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, college_name, college_describe, statu, mark",
        "from college",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.djzhao.model.mapper.CollegeMapper.BaseResultMap")
    College selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") College record, @Param("example") CollegeQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(College record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     */
    @Update({
        "update college",
        "set college_name = #{collegeName,jdbcType=VARCHAR},",
          "college_describe = #{collegeDescribe,jdbcType=INTEGER},",
          "statu = #{statu,jdbcType=INTEGER},",
          "mark = #{mark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(College record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     */
    int insertOrUpdate(College record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     */
    int insertOrUpdateSelective(College record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsert(@Param("list") List<College> list);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsertSelective(@Param("list") List<College> list, @Param("selective") College.Column ... selective);
}