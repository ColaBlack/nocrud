package ${packageName}.controller;

import ${packageName}.model.dto.${key}.${upperKey}UpdateRequest;
import ${packageName}.model.dto.${key}.${upperKey}QueryRequest;
import ${packageName}.model.dto.${key}.${upperKey}AddRequest;
import ${packageName}.common.constant.${upperKey}Constant;
import ${packageName}.common.exception.ThrowUtils;
import ${packageName}.common.DeleteRequest;
import ${packageName}.common.BaseResponse;
import ${packageName}.common.ResultUtils;
import ${packageName}.common.AuthCheck;
import ${packageName}.common.ErrorCode;
import ${packageName}.model.po.${upperKey};
import ${packageName}.model.vo.${upperKey}VO;
import ${packageName}.service.${upperKey}Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;

/**
 * ${name}接口
 *
 * @author ${author}
 */
@RestController
@RequestMapping("/${key}")
@Slf4j
public class ${upperKey}Controller {

    @Resource
    private ${upperKey}Service ${key}Service;

    // region 增删改查

    /**
     * 插入${name}（仅管理员）
     *
     * @param ${key}AddRequest ${name}添加请求体
     * @return 新增的${name}ID
     */
    @PostMapping("/insert")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Long> insert${upperKey}(@RequestBody ${upperKey}AddRequest ${key}AddRequest) {
        ThrowUtils.throwIf(${key}AddRequest == null, ErrorCode.PARAMS_ERROR, "参数不能为空");
        ThrowUtils.throwIf(${key}AddRequest.get${upperKey}Account() == null || ${key}AddRequest.get${upperKey}Account().isEmpty(), ErrorCode.PARAMS_ERROR, "账号不能为空");
        ${upperKey} ${key} = new ${upperKey}();
        BeanUtils.copyProperties(${key}AddRequest, ${key});
        int res = ${key}Service.getBaseMapper().insert(${key});
        ThrowUtils.throwIf(res <= 0, ErrorCode.OPERATION_ERROR, "数据库异常，增加${name}失败");
        return ResultUtils.success(${key}.getId());
    }

    /**
     * 删除${name}(仅管理员)
     *
     * @param deleteRequest 删除请求体
     * @return 删除的记录数
     */
    @PostMapping("/delete")
    @AuthCheck(mustRole = $UserConstant.ADMIN_ROLE)
    public BaseResponse<Integer> delete${upperKey}(@RequestBody DeleteRequest deleteRequest) {
        ThrowUtils.throwIf(deleteRequest == null, ErrorCode.PARAMS_ERROR, "参数不能为空");
        ThrowUtils.throwIf(deleteRequest.getId() <= 0, ErrorCode.PARAMS_ERROR, "参数错误");
        int res = ${key}Service.getBaseMapper().deleteById(deleteRequest.getId());
        ThrowUtils.throwIf(res <= 0, ErrorCode.OPERATION_ERROR, "数据库异常，删除${name}失败");
        return ResultUtils.success(res);
    }

    /**
     * 修改${name}(仅管理员)
     *
     * @param ${key}UpdateRequest ${name}更新请求体
     * @return 更新的记录数
     */
    @PostMapping("/update")
    @AuthCheck(mustRole = $UserConstant.ADMIN_ROLE)
    public BaseResponse<Integer> update${upperKey}(@RequestBody ${upperKey}UpdateRequest ${key}UpdateRequest) {
        ThrowUtils.throwIf(${key}UpdateRequest == null, ErrorCode.PARAMS_ERROR, "参数不能为空");
        ThrowUtils.throwIf(${key}UpdateRequest.getId() <= 0, ErrorCode.PARAMS_ERROR, "参数错误");
        ${upperKey} ${key} = new ${upperKey}();
        BeanUtils.copyProperties(${key}UpdateRequest, ${key});
        int res = ${key}Service.getBaseMapper().updateById(${key});
        ThrowUtils.throwIf(res <= 0, ErrorCode.OPERATION_ERROR);
        return ResultUtils.success(res);
    }

    /**
     * 分页查询${name}列表（仅管理员）
     *
     * @param ${key}QueryRequest 条件查询请求体
     * @return ${name}列表
     */
    @PostMapping("/select/page")
    @AuthCheck(mustRole = $UserConstant.ADMIN_ROLE)
    public BaseResponse<Page<${upperKey}>> select${upperKey}ByPage(@RequestBody ${upperKey}QueryRequest ${key}QueryRequest) {
        long current = ${key}QueryRequest.getCurrent();
        long size = ${key}QueryRequest.getPageSize();
        ThrowUtils.throwIf(current <= 0 || size <= 0 || size > 100, ErrorCode.PARAMS_ERROR, "参数错误");
        Page<${upperKey}> page = new Page<>(current, size);
        QueryWrapper<${upperKey}> queryWrapper = ${key}Service.getQueryWrapper(${key}QueryRequest);
        Page<${upperKey}> res = ${key}Service.getBaseMapper().selectPage(page, queryWrapper);
        return ResultUtils.success(res);
    }

    /**
     * 根据ID查询${name}信息（仅管理员）
     *
     * @param ${key}QueryRequest 条件查询请求体
     * @return ${name}信息
     */
    @PostMapping("/select/id")
    @AuthCheck(mustRole = $UserConstant.ADMIN_ROLE)
    public BaseResponse<${upperKey}> select${upperKey}ById(@RequestBody ${upperKey}QueryRequest ${key}QueryRequest) {
        ThrowUtils.throwIf(${key}QueryRequest == null, ErrorCode.PARAMS_ERROR, "参数不能为空");
        ThrowUtils.throwIf(${key}QueryRequest.getId() <= 0, ErrorCode.PARAMS_ERROR, "参数错误");
        ${upperKey} ${key} = ${key}Service.getBaseMapper().selectById(${key}QueryRequest.getId());
        return ResultUtils.success(${key});
    }

    /**
     * 根据ID查询${name}信息（全体用户）
     */
    @GetMapping("/get/id")
    public BaseResponse<${upperKey}VO> get${upperKey}ById(@RequestParam("id") long id) {
        ThrowUtils.throwIf(id <= 0, ErrorCode.PARAMS_ERROR, "参数错误");
        ${upperKey} ${key} = ${key}Service.getBaseMapper().selectById(id);
        ${upperKey}VO ${key}VO = new ${upperKey}VO();
        BeanUtils.copyProperties(${key}, ${key}VO);
        return ResultUtils.success(${key}VO);
    }

    /**
     * 分页查询${name}信息（全体用户）
     */
    @PostMapping("/get/page")
    public BaseResponse<Page<${upperKey}VO>> get${upperKey}ByPage(@RequestBody ${upperKey}QueryRequest ${key}QueryRequest) {
        long current = ${key}QueryRequest.getCurrent();
        long size = ${key}QueryRequest.getPageSize();
        ThrowUtils.throwIf(current <= 0 || size <= 0 || size > 20, ErrorCode.PARAMS_ERROR, "参数错误");
        Page<${upperKey}> page = new Page<>(current, size);
        QueryWrapper<${upperKey}> queryWrapper = ${key}Service.getQueryWrapper(${key}QueryRequest);
        Page<${upperKey}> res = ${key}Service.getBaseMapper().selectPage(page, queryWrapper);
        Page<${upperKey}VO> ${key}VoPage = new Page<>();
        BeanUtils.copyProperties(res, ${key}VoPage);
        List<${upperKey}VO> records = ${key}VoPage.getRecords();
        records.clear();
        for (${upperKey} ${key} : res.getRecords()) {
            ${upperKey}VO ${key}VO = new ${upperKey}VO();
            BeanUtils.copyProperties(${key}, ${key}VO);
            records.add(${key}VO);
        }
        return ResultUtils.success(${key}VoPage);
    }
    // endregion

    // region 其他接口

    // todo: 此处补充其他接口

    // endregion
}
