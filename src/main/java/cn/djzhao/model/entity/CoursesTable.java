package cn.djzhao.model.entity;

/**
 * 课程表实体类
 *
 * @author djzhao
 * @date 20/04/25 12:42
 * @email djzhao627@gmail.com
 */
public class CoursesTable {

    /**
     * 主键
     */
    private int id;

    /**
     * 课程类型
     */
    private String type;

    /**
     * 类型中的ID
     */
    private int typeId;

    /**
     * 课程数据
     */
    private String courses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }
}
