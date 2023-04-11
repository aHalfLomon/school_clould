package help_sove.controller;

import help_sove.pojo.HlepMess;
import help_sove.pojo.ResultData;
import help_sove.service.HlepMessService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (HlepMess)表控制层
 *
 * @author makejava
 * @since 2023-04-11 11:37:08
 */
@RestController
@RequestMapping("hlepMess")
public class HlepMessController {
    /**
     * 服务对象
     */
    @Resource
    private HlepMessService hlepMessService;

    /**
     * 分页查询
     *
     * @param hlepMess    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResultData queryByPage(HlepMess hlepMess, PageRequest pageRequest) {
        return null;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<HlepMess> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.hlepMessService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param hlepMess 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<HlepMess> add(HlepMess hlepMess) {
        return ResponseEntity.ok(this.hlepMessService.insert(hlepMess));
    }

    /**
     * 编辑数据
     *
     * @param hlepMess 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<HlepMess> edit(HlepMess hlepMess) {
        return ResponseEntity.ok(this.hlepMessService.update(hlepMess));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.hlepMessService.deleteById(id));
    }

}

