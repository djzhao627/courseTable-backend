package cn.djzhao.model.mapper;

import cn.djzhao.model.entity.EngineRoom;
import cn.djzhao.model.entity.EngineRoomQuery;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface EngineRoomMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     */
    long countByExample(EngineRoomQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     */
    int deleteByExample(EngineRoomQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     */
    @Delete({
        "delete from engine_room",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     */
    @Insert({
        "insert into engine_room (room_name, room_space, ",
        "room_layer, room_sign, ",
        "statu, mark)",
        "values (#{roomName,jdbcType=VARCHAR}, #{roomSpace,jdbcType=INTEGER}, ",
        "#{roomLayer,jdbcType=INTEGER}, #{roomSign,jdbcType=INTEGER}, ",
        "#{statu,jdbcType=INTEGER}, #{mark,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(EngineRoom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     */
    int insertSelective(EngineRoom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     */
    List<EngineRoom> selectByExampleWithRowbounds(EngineRoomQuery example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    EngineRoom selectOneByExample(EngineRoomQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     */
    List<EngineRoom> selectByExample(EngineRoomQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, room_name, room_space, room_layer, room_sign, statu, mark",
        "from engine_room",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.djzhao.model.mapper.EngineRoomMapper.BaseResultMap")
    EngineRoom selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") EngineRoom record, @Param("example") EngineRoomQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") EngineRoom record, @Param("example") EngineRoomQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(EngineRoom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     */
    @Update({
        "update engine_room",
        "set room_name = #{roomName,jdbcType=VARCHAR},",
          "room_space = #{roomSpace,jdbcType=INTEGER},",
          "room_layer = #{roomLayer,jdbcType=INTEGER},",
          "room_sign = #{roomSign,jdbcType=INTEGER},",
          "statu = #{statu,jdbcType=INTEGER},",
          "mark = #{mark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(EngineRoom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     */
    int insertOrUpdate(EngineRoom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     */
    int insertOrUpdateSelective(EngineRoom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsert(@Param("list") List<EngineRoom> list);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EngineRoom
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsertSelective(@Param("list") List<EngineRoom> list, @Param("selective") EngineRoom.Column... selective);
}