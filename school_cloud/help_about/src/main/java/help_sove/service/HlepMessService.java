package help_sove.service;

import help_sove.pojo.HlepMess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (HlepMess)表服务接口
 *
 * @author makejava
 * @since 2023-04-11 11:37:12
 */
public interface HlepMessService {

    /**
     * 通过ID查询单条数据
     *
     * @param hId 主键
     * @return 实例对象
     */
    HlepMess queryById(String hId);

    /**
     * 分页查询
     *
     * @param hlepMess    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<HlepMess> queryByPage(HlepMess hlepMess, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param hlepMess 实例对象
     * @return 实例对象
     */
    HlepMess insert(HlepMess hlepMess);

    /**
     * 修改数据
     *
     * @param hlepMess 实例对象
     * @return 实例对象
     */
    HlepMess update(HlepMess hlepMess);

    /**
     * 通过主键删除数据
     *
     * @param hId 主键
     * @return 是否成功
     */
    boolean deleteById(String hId);

}
