package help_sove.service.impl;

import help_sove.entity.HlepMess;
import help_sove.dao.HlepMessDao;
import help_sove.service.HlepMessService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (HlepMess)表服务实现类
 *
 * @author makejava
 * @since 2023-04-11 11:40:19
 */
@Service("hlepMessService")
public class HlepMessServiceImpl implements HlepMessService {
    @Resource
    private HlepMessDao hlepMessDao;

    /**
     * 通过ID查询单条数据
     *
     * @param hId 主键
     * @return 实例对象
     */
    @Override
    public HlepMess queryById(String hId) {
        return this.hlepMessDao.queryById(hId);
    }

    /**
     * 分页查询
     *
     * @param hlepMess 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<HlepMess> queryByPage(HlepMess hlepMess, PageRequest pageRequest) {
        long total = this.hlepMessDao.count(hlepMess);
        return new PageImpl<>(this.hlepMessDao.queryAllByLimit(hlepMess, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param hlepMess 实例对象
     * @return 实例对象
     */
    @Override
    public HlepMess insert(HlepMess hlepMess) {
        this.hlepMessDao.insert(hlepMess);
        return hlepMess;
    }

    /**
     * 修改数据
     *
     * @param hlepMess 实例对象
     * @return 实例对象
     */
    @Override
    public HlepMess update(HlepMess hlepMess) {
        this.hlepMessDao.update(hlepMess);
        return this.queryById(hlepMess.getHId());
    }

    /**
     * 通过主键删除数据
     *
     * @param hId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String hId) {
        return this.hlepMessDao.deleteById(hId) > 0;
    }
}
