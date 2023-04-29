package shop.service;

import java.util.List;

public interface ImageService {

    void addImg(String url,String shopId,int f);

    List<String> getList(String shopId);
}
