package help_sove.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lt.feign.clients.UserClient;
import com.lt.feign.pojo.UserUn;
import help_sove.config.SecurityUtil;
import help_sove.mapper.HelpMessMapper;
import help_sove.pojo.dto.HelpMessDto;
import help_sove.pojo.po.HelpMess;
import help_sove.pojo.vo.HelpMessVo;
import help_sove.pojo.vo.UpHelpMessVo;
import help_sove.service.HelpImgService;
import help_sove.service.HlepMessService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HlepMessServiceImpl implements HlepMessService {

    @Autowired
    HelpMessMapper helpMessMapper;

    @Autowired
    HelpImgService helpImgService;

    @Autowired
    UserClient userClient;

    @Override
    public boolean addHelp(HelpMessVo helpMessVo) {
        try {
            HelpMess helpMess=new HelpMess();
            helpMess.setHId(UUID.randomUUID().toString().replaceAll("-",""));
            helpMess.setHUid(SecurityUtil.getUser().getUserId());
            helpMess.setHSource(helpMessVo.getHsource());
            helpMess.setHLocation(helpMessVo.getHlocation());
            helpMess.setHState("0");
            helpMessMapper.insert(helpMess);

//            for (String u:helpMessVo.getUrl()){
//                helpImgService.addImg(u,helpMess.getHId());
//            }
            return true;
        }catch (Exception e){

            return false;
        }
    }

    @Override
    public boolean delMyHelp(String hid) {
        try {
            helpMessMapper.deleteById(hid);
            helpImgService.deImg(hid);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean upMyHelp(UpHelpMessVo upHelpMessVo) {

        try {
            HelpMess helpMess = helpMessMapper.selectById(upHelpMessVo.getHid());
            helpMess.setHLocation(upHelpMessVo.getHLocation());
            helpMess.setHSource(upHelpMessVo.getHSource());
            helpMessMapper.updateById(helpMess);
            //图片
            helpImgService.deImg(upHelpMessVo.getHid());
            for (String u:upHelpMessVo.getUrl()){
                helpImgService.addImg(u,upHelpMessVo.getHid());
            }
            return true;
        }catch (Exception e){

            return false;
        }
    }

    @Override
    public List<HelpMessDto> getMyHelp() {
        try {
            String uid=SecurityUtil.getUser().getUserId();
            LambdaQueryWrapper<HelpMess> queryWrapper=new LambdaQueryWrapper<>();
            queryWrapper.eq(HelpMess::getHUid,uid);
            List<HelpMess> helpMesses = helpMessMapper.selectList(queryWrapper);
            List<HelpMessDto> list=new ArrayList<>();
            UserUn userUn=userClient.findUserUn(uid);
            for (HelpMess helpMess:helpMesses){
                HelpMessDto helpMessDto=new HelpMessDto();
                BeanUtils.copyProperties(helpMess,helpMessDto);
                helpMessDto.setUserHead(userUn.getUserAvatar());
                helpMessDto.setUserName(userUn.getUserName());

                List<String> img = helpImgService.getImg(helpMess.getHId());
                helpMessDto.setUrlLists(img);
                list.add(helpMessDto);
            }
            return list;
        }catch (Exception e){

            return null;
        }
    }

    @Override
    public List<HelpMessDto> getAllHelp() {
        try {
            LambdaQueryWrapper<HelpMess> queryWrapper=new LambdaQueryWrapper<>();

            List<HelpMess> helpMesses = helpMessMapper.selectList(queryWrapper);
            List<HelpMessDto> list=new ArrayList<>();
            for (HelpMess helpMess:helpMesses){
                HelpMessDto helpMessDto=new HelpMessDto();
                BeanUtils.copyProperties(helpMess,helpMessDto);
                UserUn userUn=userClient.findUserUn(helpMess.getHUid());
                helpMessDto.setUserHead(userUn.getUserAvatar());
                helpMessDto.setUserName(userUn.getUserName());

                List<String> img = helpImgService.getImg(helpMess.getHId());
                helpMessDto.setUrlLists(img);
                list.add(helpMessDto);
            }
            return list;
        }catch (Exception e){

            return null;
        }
    }
}
